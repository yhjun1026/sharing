package cn.sharing.platform.service.goods.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.goods.v1.GoodsQuery;
import cn.sharing.platform.facade.goods.v1.GoodsService;
import cn.sharing.platform.facade.goods.v1.SGoods;
import cn.sharing.platform.facade.goods.v1.SGoodsStock;
import cn.sharing.platform.utils.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 物品服务实现
 * <p>
 * Created by guotao on 2018.01.19.
 */
@RestController
@Slf4j
public class GoodsServiceImpl extends BaseImpl implements GoodsService {

  @Autowired
  private GoodsDao goodsDao;

  /**
   * 物品查询，查询信息包含物品的库存信息
   *
   * @param goodsId
   *         物品uuid
   * @return 物品信息
   */
  @Override
  public ResponseResult<SGoods> get(@PathVariable String goodsId) {
    return new ResponseResult<SGoods>(goodsDao.getGoodsByCondition(goodsId));
  }

  /**
   * 分页查询可租用的物品信息
   *
   * @param param
   *         查询参数，包括分页参数
   * @return
   */
  @Override
  public ResponseResult<QueryResult<SGoods>> getRentGoods(@RequestBody GoodsQuery param) {
    SGoods sGoods = new SGoods();
    sGoods.setStoreuuid(param.getStoreId());
    sGoods.setCode(param.getCode());
    sGoods.setName(param.getName());
    List<SGoods> sGoodsList = goodsDao.getAllRentGoods(sGoods, param);
    int count = goodsDao.getAllRentGoodsCount(sGoods);
    QueryResult<SGoods> queryResult = new QueryResult<SGoods>();
    queryResult.setItem(sGoodsList);
    queryResult.setPage(param.getPage());
    //计算pagesize
    int pageCount = (count + param.getPageSize() - 1) / param.getPageSize();
    queryResult.setPageSize(pageCount);
    queryResult.setTotalCount(count);
    return new ResponseResult<QueryResult<SGoods>>(queryResult);
  }

  /**
   * 物品新增，用于新增物品或者增加物品的库存数量
   *
   * @param sGoods
   *         物品信息
   * @return 新增成功或者失败
   */
  @Override
  public ResponseResult<Void> add(@RequestBody SGoods sGoods) {
    if (sGoods == null){
      return ResponseResult.failed("没有需要保存的数据");
    }
    if(StringUtils.isEmpty(sGoods.getCode())){
      return ResponseResult.failed("物品信息代码不能为空");
    }
    if(StringUtils.isEmpty(sGoods.getName())){
      return ResponseResult.failed("物品信息名称不能为空");
    }
    List<SGoodsStock> list = new ArrayList<>();
    int beginNo = 0;
    /*新增物品时，物品库存编码从0开始
      增加库存数量时，库存编号从已有库存最大值编号加1开始*/
    if (!StringUtils.isEmpty(sGoods.getUuid())){ //UUID存在表示增加库存
      //获取库存数量的最大NO值
      int maxNo = goodsDao.getMaxNoFromStock(sGoods.getUuid());
      beginNo = maxNo + 1;
    }
    for(int i = beginNo; i < sGoods.getQuantity(); i++){
      SGoodsStock sGoodsStock = new SGoodsStock();
      sGoodsStock.setGoodsUuid(sGoods.getUuid());
      sGoodsStock.setNo(i);
      sGoodsStock.setState(0); //初始值为0
      sGoodsStock.setUuid(UUIDGenerator.getUUID());
      list.add(sGoodsStock);
    }
    sGoods.setSGoodsStockList(list);
    try {
      goodsDao.saveGoods(sGoods);
      return ResponseResult.success();
    } catch (Exception e) {
      logger.error("新增物品失败，原因：" + e.getMessage());
      return ResponseResult.failed("物品新增失败");
    }
  }

  /**
   * 预定或者租用可以被租用的物品，一次只能租用一个物品，
   * 不需要传库存信息，系统随机选取一个可以租用的库存物品
   *
   * @param sGoods
   *         租用的物品信息
   * @return 租用的物品
   */
  @Override
  public ResponseResult<SGoods> borrow(@RequestBody SGoods sGoods) {
    //根据商品代码查询可以租用的
    SGoodsStock sGoodsStock = goodsDao.getCanRentGoods(sGoods.getUuid());

    return null;
  }

  /**
   * 更新物品的状态
   *
   * @param sGoodsStock
   *         物品库存状态
   * @return 修改成功或者失败
   */
  @Override
  public ResponseResult<Void> updateState(@RequestBody  SGoodsStock sGoodsStock) {
    try{
      goodsDao.updateStockState(sGoodsStock);
      return ResponseResult.success();
    }catch (Exception e){
      logger.error("更新物品状态失败，原因" + e.getMessage());
      return ResponseResult.failed("删除物品信息失败");
    }
  }


  /**
   * 删除物品
   *
   * @param sGoods
   *         物品信息
   * @return 删除成功或者失败
   */
  @Override
  public ResponseResult<Void> delete(@RequestBody SGoods sGoods) {
    try{
      goodsDao.deleteGoods(sGoods);
      return ResponseResult.success();
    }catch (Exception e){
      logger.error("删除物品失败，原因" + e.getMessage());
      return ResponseResult.failed("删除物品信息失败");
    }
  }

  /**
   * 修改物品信息，不修改物品库存信息
   *
   * @param sGoods
   *         物品信息
   * @return
   */
  @Override
  public ResponseResult<Void> update(@RequestBody SGoods sGoods) {
    if (StringUtils.isEmpty(sGoods.getUuid())){
      return ResponseResult.failed("商品信息传入错误");
    }
    try {
      goodsDao.updateGoods(sGoods);
      return ResponseResult.success();
    }catch(Exception e){
      logger.error("更新数据失败:,原因：" + e.getMessage());
      return ResponseResult.failed("更新物品信息失败");
    }

  }
}
