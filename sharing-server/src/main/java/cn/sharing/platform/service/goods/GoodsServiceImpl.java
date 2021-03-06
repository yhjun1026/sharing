package cn.sharing.platform.service.goods;

import cn.sharing.platform.dao.entity.Stock;
import cn.sharing.platform.dao.mapper.GoodsMapper;
import cn.sharing.platform.dao.mapper.StockMapper;
import cn.sharing.platform.facade.goods.v1.GoodsQuery;
import cn.sharing.platform.facade.goods.v1.SGoods;
import cn.sharing.platform.facade.goods.v1.SGoodsStock;
import cn.sharing.platform.utils.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 物品信息操作
 * <p>
 * Created by guotao on 2018.01.19.
 */
@Component
public class GoodsServiceImpl {
  protected Logger logger = LoggerFactory.getLogger(this.getClass());
  private String sMessage;
  @Autowired
  GoodsMapper goodsMapper;
  @Autowired
  StockMapper stockMapper;


  /**
   * 判断物品库存是否存在
   *
   * @param uuid
   *         uuid
   * @return true表示存在，false表示不存在
   */
  public boolean isExistsStockByUuid(String uuid) {
    if (StringUtils.isEmpty(uuid)) {
      return false;
    }

    return stockMapper.getByPrimaryKey(uuid) == null ? false : true;
  }

  /**
   * 根据条件查询所有可租用的物品
   * @param goodsQuery 分页参数
   * @return
   */
  public List<SGoods> getAllRentGoods(GoodsQuery goodsQuery, int type) {
    int offset = (goodsQuery.getPage() - 1) * goodsQuery.getPageSize();
    return SGoodsConvert.perzConvertList(goodsMapper.getAllRentGoods(goodsQuery.getStoreId(), goodsQuery.getCode(), goodsQuery.getName(), type,
            new RowBounds(offset, goodsQuery.getPageSize())));
  }

  /**
   * 查询科可租用的数量
   * @return
   */
  public int getAllRentGoodsCount(GoodsQuery goodsQuery, int type){
    return goodsMapper.getAllRentGoodsCount(goodsQuery.getStoreId(), goodsQuery.getCode(), goodsQuery.getName(), type);
  }

  /**
   * 根据主键查询
   * @param uuid uuid
   * @return
   */
  public SGoods getGoodsByUuid(String uuid){
    List<Map<String, Object>> resultMap = goodsMapper.getByPrimaryKey(uuid);
    if (resultMap == null || resultMap.size() <= 0){
      return null;
    }
    SGoods sGoods = SGoodsConvert.perzConvertFromMap(resultMap.get(0));
    List<SGoodsStock> sGoodsStockList = new ArrayList<SGoodsStock>();
    for(Map<String, Object> map: resultMap){
      SGoodsStock sGoodsStock = SGoodsStockConvert.perzConvertFromMap(map);
      sGoodsStockList.add(sGoodsStock);
    }
    sGoods.setSGoodsStockList(sGoodsStockList);
    return sGoods;
  }

  /**
   * 获取库存表中最大的库存标号
   * @param goodsUuid 商品UUID
   * @return
   */
  public int getMaxNoFromStock(String goodsUuid){
    return stockMapper.getMaxNo(goodsUuid);
  }

  /**
   * 新增物品信息或者新增物品库存
   * @param sGoods 物品信息，需要包含物品库存数据
   */
  @Transactional
  public void saveGoods(SGoods sGoods) throws Exception{
//    if(stockMapper.getByCondition(sGoods.getCode()) != null){
//      throw RuntimeException("对应的物品代码已存在");
//    }
    SGoods sGoodsCheck = new SGoods();
    sGoodsCheck.setCode(sGoods.getCode());
    List<SGoods> list = SGoodsConvert.perzConvertList(goodsMapper.getByCondition(GoodsConvert.perzConvert(sGoodsCheck)));
    if (list != null && list.size() > 0){
      throw new RuntimeException("物品代码已存在:" + sGoods.getCode());
    }
    //先保存物品表数据
    goodsMapper.insert(GoodsConvert.perzConvert(sGoods));
    //保存物品库存数据
    stockMapper.batchInsert(StockConvert.perzConvertList(sGoods.getSGoodsStockList()));
  }

  /**
   * 只修改物品库存信息，不修改物品库存数据
   * @param sGoods 物品信息
   * @return
   */
  @Transactional
  public void updateGoods(SGoods sGoods) throws Exception{
    if(StringUtils.isEmpty(sGoods.getUuid())){
      throw new Exception("物品信息不正确");
    }
    goodsMapper.update(GoodsConvert.perzConvert(sGoods));
  }

  /**
   * 删除物品信息，包括物品库存
   * @param sGoods 物品信息
   * @throws Exception
   */
  @Transactional
  public void deleteGoods(SGoods sGoods) throws Exception{
    if(StringUtils.isEmpty(sGoods.getUuid())){
      throw new Exception("物品信息不正确");
    }
    //删除物品表信息
    goodsMapper.deleteByPrimaryKey(sGoods.getUuid());
    //删除物品库存表信息
    SGoodsStock sGoodsStock = new SGoodsStock();
    sGoodsStock.setGoodsUuid(sGoods.getUuid());
    stockMapper.delete(StockConvert.perzConvert(sGoodsStock));
  }

  /**
   * 更新物品库存状态
   * @param sGoodsStock 物品库存
   * @throws Exception
   */
  @Transactional
  public void updateStockState(SGoodsStock sGoodsStock) throws Exception{
    Stock stock = stockMapper.getByPrimaryKey(sGoodsStock.getUuid());
    if(stock == null){
      throw new Exception("物品库存信息不正确");
    }
    //物品损坏时，先调用赔偿接口，然后再调用归还接口，这种情况下不能将物品状态改成可用
    if ((stock.getState() == 3 || stock.getState() == 4) && sGoodsStock.getState() == 0) {
      //不做操作
    } else {
      stockMapper.update(StockConvert.perzConvert(sGoodsStock));
      //更新库存
      if (sGoodsStock.getState() == 0 || sGoodsStock.getState() == 1) {
        //预定时减库存，归还时加库存
        goodsMapper.updateStockQty(stock.getGoodsUuid(), sGoodsStock.getState());
      }
    }
  }

  /**
   * 根据商品代码查询商品
   * @param goodsId
   * @return
   */
  public SGoods getGoodsByCondition(String goodsId){
    SGoods sGoods = new SGoods();
    sGoods.setCode(goodsId);
    List<SGoods> list = SGoodsConvert.perzConvertList(goodsMapper.getByCondition(GoodsConvert.perzConvert(sGoods)));
    if (list == null || list.size() == 0){
      sGoods.setCode(null);
      sGoods.setUuid(goodsId);
      list = SGoodsConvert.perzConvertList(goodsMapper.getByCondition(GoodsConvert.perzConvert(sGoods)));
      if (list == null || list.size() == 0){
        return null;
      }
    }
    return list.get(0);
  }

  /**
   * 从物品库存表中获取一条可以租用的物品
   * @param goodsUuid 物品代码
   * @return
   */
  public SGoodsStock getCanRentGoods(String goodsUuid){
    SGoodsStock sGoodsStock =  new SGoodsStock();
    sGoodsStock.setGoodsUuid(goodsUuid);
    sGoodsStock.setState(0); //0表示可租用
    List<SGoodsStock> sGoodsStockList = SGoodsStockConvert.perzConvertList(stockMapper.getByCondition(StockConvert.perzConvert(sGoodsStock)));
    if(sGoodsStockList == null || sGoodsStockList.size() ==0){
      return null;
    }
    return sGoodsStockList.get(0);
  }
}
