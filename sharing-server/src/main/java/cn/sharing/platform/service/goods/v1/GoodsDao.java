package cn.sharing.platform.service.goods.v1;

import cn.sharing.dao.entity.Goods;
import cn.sharing.dao.entity.GoodsBorrowDtl;
import cn.sharing.dao.entity.GoodsBorrowDtlExample;
import cn.sharing.dao.entity.GoodsBorrowMst;
import cn.sharing.dao.entity.GoodsBorrowMstExample;
import cn.sharing.dao.entity.GoodsExample;
import cn.sharing.dao.entity.Stock;
import cn.sharing.dao.entity.StockExample;
import cn.sharing.dao.mapper.GoodsBorrowDtlMapper;
import cn.sharing.dao.mapper.GoodsBorrowMstMapper;
import cn.sharing.dao.mapper.GoodsMapper;
import cn.sharing.dao.mapper.StockMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 物品信息操作
 *
 * Created by guotao on 2018.01.19.
 */
@Component
public class GoodsDao {
  protected Logger logger = LoggerFactory.getLogger(this.getClass());
  private String sMessage;
  @Autowired
  GoodsMapper goodsMapper;
  @Autowired
  StockMapper stockMapper;
  @Autowired
  GoodsBorrowMstMapper goodsBorrowMstMapper;
  @Autowired
  GoodsBorrowDtlMapper goodsBorrowDtlMapper;
  /**
   * 根据代码判断物品是否存在
   *
   * @param uuid 物品uuid
   * @return 存在返回True 否则返回false
   */
  public Boolean isExistGoodsByUuid(String uuid){
    if (uuid == null || uuid.equals(""))
      return false;
    GoodsExample example = new GoodsExample();
    GoodsExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    long count = goodsMapper.countByExample(example);
    return count > 0;
  }
  /**
   * 根据uuid获取物品信息
   * @param uuid 物品uuid
   * @return 返回物品信息
   */
  public Goods getGoodsByUuid(String uuid){
    GoodsExample example = new GoodsExample();
    GoodsExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    List<Goods> goodss = goodsMapper.selectByExample(example);
    return (goodss == null || goodss.isEmpty()) ? null : goodss.get(0);
  }
  /**
   * 根据uuid获取物品信息
   * @param code 物品code
   * @return 返回物品信息
   */
  public Goods getGoodsByCode(String code){
    GoodsExample example = new GoodsExample();
    GoodsExample.Criteria criteria= example.createCriteria();
    criteria.andCodeEqualTo(code);
    List<Goods> goodss = goodsMapper.selectByExample(example);
    return (goodss == null || goodss.isEmpty()) ? null : goodss.get(0);
  }
  /**
   * 更新物品数据
   * @param goods  物品
   * @return 插入是否成功
   */

  public Boolean saveGoods(Goods goods){
    try {
      /** 判断物品是否存在 */
      if (getGoodsByUuid(goods.getUuid()) == null){
        /** 不存在 */
        int count = goodsMapper.insertSelective(goods);
        return count > 0;
      } else{
        /** 存在 按主键更新*/
        int count = goodsMapper.updateByPrimaryKey(goods);
        return count > 0;
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoods error",e);
      return false;
    }
  }
  /**
   * 根据uuid获取物品信息
   * @param uuid 物品uuid
   * @return 返回物品信息
   */
  public Stock getGoodsStockByUuid(String uuid){
    StockExample example = new StockExample();
    StockExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    List<Stock> stocks = stockMapper.selectByExample(example);
    return (stocks == null || stocks.isEmpty()) ? null : stocks.get(0);
  }
  /**
   * 更新物品库存数据
   * @param stock  物品
   * @return       插入是否成功
   */
  public Boolean saveGoodsStock(Stock stock){
    /** 判断物品库存记录是否存在 */
    try {
      Stock oldStock= getGoodsStockByUuid(stock.getUuid());
      if (oldStock == null){
        /** 不存在 */
        stock.setInv(stock.getQty());
        stock.setLastupdtime(new Date());
        stock.setUseqty(BigDecimal.valueOf(0));
        int count = stockMapper.insertSelective(stock);
        return count > 0;
      } else{
        /** 存在 按主键更新*/
        if (oldStock.getUseqty().compareTo(stock.getQty()) < 0){
          sMessage = "库存不足.";
          return false;
        }
        stock.setInv(oldStock.getInv().add(stock.getQty()));
        stock.setQty(oldStock.getQty().add(stock.getQty()));
        stock.setUseqty(oldStock.getUseqty().add(stock.getQty()));
        int count = stockMapper.updateByPrimaryKey(stock);
        return count > 0;
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoodsStock error", e);
      return false;
    }
  }

  /**物品借用库存数据
   *
   * @param goodsBorrowDtl  物品借用明细
   * @return       插入是否成功
   */
  public Boolean borrowStock(GoodsBorrowDtl goodsBorrowDtl){
    /** 判断物品库存记录是否存在 */
    try {
      Stock oldStock= getGoodsStockByUuid(goodsBorrowDtl.getGoodsUuid());
      if (oldStock == null){
        /** 不存在 */
        return false;
      } else{
        /** 存在 按主键更新*/
        if (oldStock.getUseqty().compareTo(new BigDecimal(1)) < 0){
          sMessage = "库存不足.";
          return false;
        }
        Stock stock = new Stock();
        stock.setUuid(oldStock.getUuid());
        stock.setInv(oldStock.getInv());
        stock.setUseqty(oldStock.getUseqty().subtract(new BigDecimal(1)));
        stock.setQty(oldStock.getQty().add(new BigDecimal(1)));
        stock.setMemo(oldStock.getMemo());
        stock.setLastupdtime(new Date());
        int count = stockMapper.updateByPrimaryKey(stock);
        return count > 0;
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoodsStock error", e);
      return false;
    }
  }
  /** 物品归还库存数据
   *
   * @param goodsBorrowDtl  物品借用明细
   * @return       插入是否成功
   */
  public Boolean backStock(GoodsBorrowDtl goodsBorrowDtl){
    /** 判断物品库存记录是否存在 */
    try {
      Stock oldStock= getGoodsStockByUuid(goodsBorrowDtl.getGoodsUuid());
      if (oldStock == null){
        /** 不存在 */
        return false;
      } else{
        /** 存在 按主键更新*/
        Stock stock = new Stock();
        stock.setUuid(oldStock.getUuid());
        stock.setInv(oldStock.getInv());
        stock.setUseqty(oldStock.getUseqty().add(new BigDecimal(1)));
        stock.setQty(oldStock.getQty().subtract(new BigDecimal(1)));
        stock.setMemo(oldStock.getMemo());
        stock.setLastupdtime(new Date());
        int count = stockMapper.updateByPrimaryKey(stock);
        return count > 0;
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoodsStock error", e);
      return false;
    }
  }
  /**
   * 根据uuid获取物品借用单信息
   * @param uuid 物品借用单uuid
   * @return 返回物品信息
   */
  public GoodsBorrowMst getBorrowMstByUuid(String uuid){
    GoodsBorrowMstExample example = new GoodsBorrowMstExample();
    GoodsBorrowMstExample.Criteria criteria= example.createCriteria();
    criteria.andUuidEqualTo(uuid);
    List<GoodsBorrowMst> goodsBorrowMsts = goodsBorrowMstMapper.selectByExample(example);
    return (goodsBorrowMsts == null || goodsBorrowMsts.isEmpty()) ? null : goodsBorrowMsts.get(0);
  }
  /**
   * 保存物品借用单信息
   *
   * @param goodsBorrowMst  物品借用主信息
   * @param goodsBorrowDtls  物品借用明细信息
   * @return 返回更新结果
   */
  public Boolean saveGoodsBorrow(GoodsBorrowMst goodsBorrowMst, List<GoodsBorrowDtl> goodsBorrowDtls){
    try {
      /** 判断物品借用记录是否存在 */
      GoodsBorrowMst oldGoodsBorrowMst = getBorrowMstByUuid(goodsBorrowMst.getUuid());
      if (oldGoodsBorrowMst == null){
        /** 不存在 */
        if (goodsBorrowMstMapper.insertSelective(goodsBorrowMst)>0 ){
          for (GoodsBorrowDtl goodsBorrowDtl : goodsBorrowDtls){
            /** 保存明细 */
            goodsBorrowDtlMapper.insert(goodsBorrowDtl);
            if (goodsBorrowMst.getStat().equals("using")) {
              /** 处理库存 */
              borrowStock(goodsBorrowDtl);
            }
          }
          goodsBorrowDtlMapper.batchInsert(goodsBorrowDtls);
          return true;
        }
      } else{
        /** 存在 按主键更新*/
        if (goodsBorrowMstMapper.updateByPrimaryKey(goodsBorrowMst)>0 ){
          /** 删除后更新 */
          GoodsBorrowDtlExample example = new GoodsBorrowDtlExample();
          GoodsBorrowDtlExample.Criteria criteria= example.createCriteria();
          criteria.andBorrowUuidEqualTo(goodsBorrowMst.getUuid());
          if (goodsBorrowDtlMapper.deleteByExample(example) > 0) {
            for (GoodsBorrowDtl goodsBorrowDtl : goodsBorrowDtls) {
              /** 保存明细 */
              goodsBorrowDtlMapper.insert(goodsBorrowDtl);
              if (goodsBorrowMst.getStat().equals("using")) {
                /** 处理库存 */
                borrowStock(goodsBorrowDtl);
              }
            }
            return true;
          }
        }
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoodsBorrow error", e);
      return false;
    }
    return false;
  }
  /**
   * 归还物品借用单信息
   *
   * @param goodsBorrowMst  物品借用主信息
   * @param goodsBorrowDtls  物品借用明细信息
   * @return 返回更新结果
   */
  public Boolean backGoodsBorrow(GoodsBorrowMst goodsBorrowMst, List<GoodsBorrowDtl> goodsBorrowDtls){
    try {
      /** 判断物品借用记录是否存在 */
      GoodsBorrowMst oldGoodsBorrowMst = getBorrowMstByUuid(goodsBorrowMst.getUuid());
      if (oldGoodsBorrowMst == null){
        sMessage = "物品借用单不存在.";
        return false;
      } else{
        /** 存在 按主键更新*/
        if (goodsBorrowMstMapper.updateByPrimaryKey(goodsBorrowMst)>0 ){
          /** 删除后更新 */
          GoodsBorrowDtlExample example = new GoodsBorrowDtlExample();
          GoodsBorrowDtlExample.Criteria criteria= example.createCriteria();
          criteria.andBorrowUuidEqualTo(goodsBorrowMst.getUuid());
          if (goodsBorrowDtlMapper.deleteByExample(example) > 0) {
            for (GoodsBorrowDtl goodsBorrowDtl : goodsBorrowDtls) {
              /** 保存明细 */
              goodsBorrowDtlMapper.insert(goodsBorrowDtl);
              /** 处理库存 */
              backStock(goodsBorrowDtl);
            }
            return true;
          }
        }
      }
    } catch (Exception e) {
      sMessage = "保存失败.";
      logger.error("saveGoodsBorrow error", e);
      return false;
    }
    return false;
  }

  public String getsMessage() {
    return sMessage;
  }

  public void setsMessage(String sMessage) {
    this.sMessage = sMessage;
  }
}
