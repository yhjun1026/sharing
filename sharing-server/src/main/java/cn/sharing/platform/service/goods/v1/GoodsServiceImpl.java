package cn.sharing.platform.service.goods.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.goods.v1.*;
import cn.sharing.platform.store.StoreDao;
import com.sharing.dao.entity.Goods;
import com.sharing.dao.entity.GoodsBorrowDtl;
import com.sharing.dao.entity.GoodsBorrowMst;
import com.sharing.dao.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 物品服务实现
 *
 * Created by guotao on 2018.01.19.
 */
public class GoodsServiceImpl extends BaseImpl implements GoodsService {
  @Autowired
  GoodsDao goodsDao;
  StoreDao storeDao;
  /**
   * 物品更新
   *
   * @param sGoods
   *         物品信息对象
   * @return 是否更新成功
   */
  @Override
  public ResponseResult<Void> save(@RequestBody SGoods sGoods) {
    if (sGoods.getStoreuuid() == null || sGoods.getStoreuuid().equals("")) {
      return ResponseResult.failed("组织UUID为空.");
    }
    if (sGoods.getCode() == null || sGoods.getCode().equals("")) {
      return ResponseResult.failed("物品代码为空.");
    }
    if (sGoods.getUuid() == null || sGoods.getUuid().equals("")) {
      return ResponseResult.failed("物品uuid为空.");
    }
    if (sGoods.getName() == null || sGoods.getName().equals("")) {
      return ResponseResult.failed("物品名称为空.");
    }
    if (sGoods.getStat() == null || sGoods.getStat().equals("")) {
      return ResponseResult.failed("物品状态为空.");
    }
    if (!Arrays.asList(0,1,2,3).contains(sGoods.getStat())) {
      return ResponseResult.failed("物品状态不正确.");
    }
    if (sGoods.getPrice() != null || sGoods.getPrice().compareTo(BigDecimal.valueOf(0)) < 0) {
      return ResponseResult.failed("物品借用单价不正确.");
    }
    if (sGoods.getDepositamt() != null || sGoods.getDepositamt().compareTo(BigDecimal.valueOf(0)) < 0) {
      return ResponseResult.failed("物品押金金额不正确.");
    }
    if (sGoods.getRepayamt() != null || sGoods.getRepayamt().compareTo(BigDecimal.valueOf(0)) < 0) {
      return ResponseResult.failed("物品偿还金额不正确.");
    }
    try{
      /** 判断物品组织信息是否存在 */
      if (!storeDao.isExistStoreByUuid(sGoods.getStoreuuid())){
        return ResponseResult.failed("物品组织UUID不正确.");
      }
      /** 获更新物品信息*/
      if (!goodsDao.saveGoods(converSGoods(sGoods))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update Goods error, getCode=" + sGoods.getCode()  + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 物品查询
   *
   * @param goodsUuid
   *         物品uuid
   * @return 物品信息
   */
  @Override
  public ResponseResult<SGoods> query(@RequestBody String goodsUuid) {
    ResponseResult<SGoods> response;
    if (goodsUuid == null || goodsUuid.equals("")) {
      return ResponseResult.failed("物品UUID为空.");
    }
    try{
      /** 判断物品信息是否存在 */
      if (!goodsDao.isExistGoodsByUuid(goodsUuid)){
        return ResponseResult.failed("物品UUID不正确.");
      }
      /** 获取物品信息*/
      Goods goods = goodsDao.getGoodsByUuid(goodsUuid);
      response = ResponseResult.failed("更新成功.");
      response.setData(converSGoods(goods));
      return response;
    } catch (Exception e) {
      logger.info("query Goods error, goodsuuid=" + goodsUuid + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 物品库存调整
   *
   * @param sGoodsStock
   *         物品信息对象
   * @return 物品信息
   */
  @Override
  public ResponseResult<Void> add(@RequestBody SGoodsStock sGoodsStock) {
    if (sGoodsStock.getUuid() == null || sGoodsStock.getUuid().equals("")) {
      return ResponseResult.failed("物品UUID为空.");
    }
    if (sGoodsStock.getDirection() == null || sGoodsStock.getDirection().equals("")) {
      return ResponseResult.failed("物品调整方向为空.");
    }
    if (sGoodsStock.getQty() == null || sGoodsStock.getQty().equals("")) {
      return ResponseResult.failed("物品调整库存为空.");
    }
    if (!Arrays.asList(-1,1).contains(sGoodsStock.getDirection())) {
      return ResponseResult.failed("物品调整方向不正确,增加库存传1,减少库存传-1.");
    }
    if (sGoodsStock.getQty().compareTo(BigDecimal.valueOf(0)) <= 0) {
      return ResponseResult.failed("物品调整库存不正确,必须大于0.");
    }
    try{
      /** 判断物品信息是否存在 */
      if (!goodsDao.isExistGoodsByUuid(sGoodsStock.getUuid())){
        return ResponseResult.failed("物品UUID不正确.");
      }
      /** 获更新物品信息*/
      if (!goodsDao.saveGoodsStock(converSGoodsStock(sGoodsStock))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update GoodsStock error, GoodsStock=" + sGoodsStock.getUuid()  + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 物品使用
   *
   * @param sGoodsBorrow
   *         物品借用信息对象
   * @return 物品信息
   */
  @Override
  public ResponseResult<Void> borrow(@RequestBody SGoodsBorrow sGoodsBorrow) {
    if (sGoodsBorrow.getUuid() == null || sGoodsBorrow.getUuid().equals("")) {
      return ResponseResult.failed("物品借用UUID为空.");
    }
    if (sGoodsBorrow.getBillnumber() == null || sGoodsBorrow.getBillnumber().equals("")) {
      return ResponseResult.failed("物品借用单号为空.");
    }
    if (sGoodsBorrow.getStat() == null || sGoodsBorrow.getStat().equals("")) {
      return ResponseResult.failed("物品借用单状态为空.");
    }
    if (sGoodsBorrow.getStoreuuid() == null || sGoodsBorrow.getStoreuuid().equals("")) {
      return ResponseResult.failed("物品借用单组织UUID为空.");
    }
    try{
      /** 判断物品组织信息是否存在 */
      if (!storeDao.isExistStoreByUuid(sGoodsBorrow.getStoreuuid())){
        return ResponseResult.failed("物品借用单组织UUID不正确.");
      }
      /** 生成物品借用单*/
      if (!goodsDao.saveGoodsBorrow(converSGoodsBorrow(sGoodsBorrow),converSGoodsBorrowDtl(sGoodsBorrow))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update GoodsBorrow error, GoodsBorrow=" + sGoodsBorrow.getUuid()  + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 物品归还
   *
   * @param sGoodsBorrow
   *         物品借用信息对象
   * @return 物品信息
   */
  @Override
  public ResponseResult<Void> back(@RequestBody SGoodsBorrow sGoodsBorrow) {
    if (sGoodsBorrow.getUuid() == null || sGoodsBorrow.getUuid().equals("")) {
      return ResponseResult.failed("物品借用UUID为空.");
    }
    if (sGoodsBorrow.getBillnumber() == null || sGoodsBorrow.getBillnumber().equals("")) {
      return ResponseResult.failed("物品借用单号为空.");
    }
    if (sGoodsBorrow.getStat() == null || sGoodsBorrow.getStat().equals("")) {
      return ResponseResult.failed("物品借用单状态为空.");
    }
    if (sGoodsBorrow.getStoreuuid() == null || sGoodsBorrow.getStoreuuid().equals("")) {
      return ResponseResult.failed("物品借用单组织UUID为空.");
    }
    try{
      if (sGoodsBorrow.getStat().equals("finished")){
        return ResponseResult.failed("物品借用单状态不正确,必须为finished.");
      }
      /** 判断物品组织信息是否存在 */
      if (!storeDao.isExistStoreByUuid(sGoodsBorrow.getStoreuuid())){
        return ResponseResult.failed("物品借用单组织UUID不正确.");
      }
      /** 生成物品借用单*/
      if (!goodsDao.backGoodsBorrow(converSGoodsBorrow(sGoodsBorrow),converSGoodsBorrowDtl(sGoodsBorrow))){
        return ResponseResult.failed("更新失败.");
      }
      return ResponseResult.failed("更新成功.");
    } catch (Exception e) {
      logger.info("update GoodsBorrow error, GoodsBorrow=" + sGoodsBorrow.getUuid()  + e.getMessage(), e);
      return ResponseResult.failed("更新异常.");
    }
  }

  /**
   * 物品对象转换 P对象转换为S对象
   *
   * @param   goods 物品信息
   * @return  物品对象
   */
  private SGoods converSGoods(Goods goods){
    SGoods sSGoods = new SGoods();
    sSGoods.setUuid(goods.getUuid());
    sSGoods.setCode(goods.getCode());
    sSGoods.setName(goods.getName());
    sSGoods.setType(goods.getType());
    sSGoods.setStat(goods.getStat());
    sSGoods.setPicture(goods.getPicture());
    sSGoods.setDescription(goods.getDescription());
    sSGoods.setPrice(goods.getPrice());
    sSGoods.setDepositamt(goods.getDepositamt());
    sSGoods.setRepayamt(goods.getRepayamt());
    sSGoods.setLaster(goods.getLaster());
    sSGoods.setLastupdtime(goods.getLastupdtime());
    sSGoods.setMemo(goods.getMemo());
    sSGoods.setStoreuuid(goods.getStoreuuid());
    return sSGoods;
  }
  /**
   * 物品对象转换 S对象转换为P对象
   *
   * @param   sGoods 物品信息
   * @return  物品对象
   */
  private Goods converSGoods(SGoods sGoods){
    Goods goods = new Goods();
    goods.setUuid(sGoods.getUuid());
    goods.setCode(sGoods.getCode());
    goods.setName(sGoods.getName());
    goods.setType(sGoods.getType());
    goods.setStat(sGoods.getStat());
    goods.setPicture(sGoods.getPicture());
    goods.setDescription(sGoods.getDescription());
    if (sGoods.getPrice() == null) {
      goods.setPrice(BigDecimal.valueOf(0));
    }else{
      goods.setPrice(sGoods.getPrice());
    }
    if (sGoods.getDepositamt() == null) {
      sGoods.setDepositamt(BigDecimal.valueOf(0));
    }else{
      goods.setDepositamt(sGoods.getDepositamt());
    }
    if (sGoods.getRepayamt() == null) {
      goods.setRepayamt(BigDecimal.valueOf(0));
    }else{
      goods.setRepayamt(sGoods.getRepayamt());
    }
    goods.setLaster(sGoods.getLaster());
    goods.setLastupdtime(sGoods.getLastupdtime());
    goods.setMemo(sGoods.getMemo());
    goods.setStoreuuid(sGoods.getStoreuuid());
    return goods;
  }
  /**
   * 物品库存对象转换 S对象转换为P对象
   *
   * @param   sGoodsStock 物品库存信息
   * @return  物品库存对象
   */
  private Stock converSGoodsStock(SGoodsStock sGoodsStock){
    Stock stock = new Stock();
    stock.setUuid(sGoodsStock.getUuid());
    stock.setQty(sGoodsStock.getQty().multiply(BigDecimal.valueOf(sGoodsStock.getDirection())));
    stock.setMemo(sGoodsStock.getMemo());
    return stock;
  }
  /**
   * 物品借用单对象转换 S对象转换为P对象
   *
   * @param   sGoodsBorrow 物品借用单信息
   * @return  物品借用单对象
   */
  private GoodsBorrowMst converSGoodsBorrow(SGoodsBorrow sGoodsBorrow){
    GoodsBorrowMst goodsBorrowMst = new GoodsBorrowMst();
    goodsBorrowMst.setUuid(sGoodsBorrow.getUuid());
    goodsBorrowMst.setBillnumber(sGoodsBorrow.getBillnumber());
    goodsBorrowMst.setStat(sGoodsBorrow.getStat());
    goodsBorrowMst.setBorrower(sGoodsBorrow.getBorrower());
    goodsBorrowMst.setBorrowertype(sGoodsBorrow.getBorrowertype());
    goodsBorrowMst.setMobile(sGoodsBorrow.getBorrower());
    goodsBorrowMst.setAddress(sGoodsBorrow.getAddress());
    goodsBorrowMst.setReturntime(sGoodsBorrow.getReturntime());
    goodsBorrowMst.setRealreturntime(sGoodsBorrow.getRealreturntime());
    goodsBorrowMst.setFiller(sGoodsBorrow.getFiller());
    goodsBorrowMst.setFildate(sGoodsBorrow.getFildate());
    goodsBorrowMst.setLaster(sGoodsBorrow.getLaster());
    goodsBorrowMst.setLastupdtime(sGoodsBorrow.getLastupdtime());
    goodsBorrowMst.setMobile(sGoodsBorrow.getMemo());
    goodsBorrowMst.setStoreuuid(sGoodsBorrow.getStoreuuid());
    return goodsBorrowMst;
  }
  /**
   * 物品借用单对象转换 S对象转换为P对象
   *
   * @param   sGoodsBorrow 物品借用单信息
   * @return  物品借用单对象明细
   */
  private List<GoodsBorrowDtl> converSGoodsBorrowDtl(SGoodsBorrow sGoodsBorrow){
    List<GoodsBorrowDtl> goodsBorrowDtls = new ArrayList<>();
    List<SGoodsBorrowDtl> sGoodsBorrowDtls = sGoodsBorrow.getsGoodsBorrowDtl();
    for (SGoodsBorrowDtl sGoodsBorrowDtl: sGoodsBorrowDtls){
      GoodsBorrowDtl goodsBorrowDtl = new GoodsBorrowDtl();
      goodsBorrowDtl.setUuid(sGoodsBorrowDtl.getUuid());
      goodsBorrowDtl.setGoodsuuid(sGoodsBorrowDtl.getGoodsuuid());
      goodsBorrowDtl.setGoodscode(sGoodsBorrowDtl.getGoodsname());
      goodsBorrowDtl.setGoodsname(sGoodsBorrowDtl.getGoodsname());
      goodsBorrowDtl.setBorrowdescrip(sGoodsBorrowDtl.getBorrowdescrip());
      goodsBorrowDtl.setDepositamt(sGoodsBorrowDtl.getDepositamt());
      goodsBorrowDtl.setDamaged(sGoodsBorrowDtl.getDamaged());
      goodsBorrowDtl.setReturndescrip(sGoodsBorrowDtl.getReturndescrip());
      goodsBorrowDtl.setPayamt(sGoodsBorrowDtl.getPayamt());
      goodsBorrowDtl.setBorrowqty(sGoodsBorrowDtl.getBorrowqty());
      goodsBorrowDtl.setBackqty(sGoodsBorrowDtl.getBackqty());
      goodsBorrowDtl.setBackdepositamt(sGoodsBorrowDtl.getBackdepositamt());
      goodsBorrowDtl.setMemo(sGoodsBorrowDtl.getMemo());
      goodsBorrowDtl.setBorrowuuid(sGoodsBorrow.getUuid());
      goodsBorrowDtls.add(goodsBorrowDtl);
    }
    return goodsBorrowDtls;
  }
}
