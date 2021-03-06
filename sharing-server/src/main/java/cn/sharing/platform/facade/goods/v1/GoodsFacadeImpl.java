package cn.sharing.platform.facade.goods.v1;

import cn.sharing.platform.BaseImpl;
import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.service.goods.GoodsServiceImpl;
import cn.sharing.platform.utils.DateUtil;
import cn.sharing.platform.utils.StringUtils;
import cn.sharing.platform.utils.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.sharing.platform.utils.DateUtil.DEFAULT_FORMAT;

/**
 * 物品服务实现
 * <p>
 * Created by guotao on 2018.01.19.
 */
@RestController
@Slf4j
public class GoodsFacadeImpl extends BaseImpl implements GoodsFacade {

  @Autowired
  private GoodsServiceImpl goodsDao;

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
    int type = 0;
    if ("available".equals(param.getQueryType())) {
      type = 1;
    }
    List<SGoods> sGoodsList = goodsDao.getAllRentGoods(param, type);
    int count = goodsDao.getAllRentGoodsCount(param, type);
    QueryResult<SGoods> queryResult = new QueryResult<SGoods>();
    queryResult.setItem(sGoodsList);
    queryResult.setPage(param.getPage());
    //计算pagesize
//    int pageCount = (count + param.getPageSize() - 1) / param.getPageSize();
    queryResult.setPageSize(param.getPageSize());
    queryResult.setTotalCount(count);
    return new ResponseResult<QueryResult<SGoods>>(queryResult);
  }

  /**
   * 物品新增，用于新增物品或者增加物品的库存数量
   *
   * @param nGoods
   *         物品信息
   * @return 新增成功或者失败
   */
  @Override
  public ResponseResult<Void> add(@RequestBody NewGoods nGoods) {
    if (nGoods == null){
      return ResponseResult.failed("没有需要保存的数据");
    }
    if(StringUtils.isEmpty(nGoods.getCode())){
      return ResponseResult.failed("物品信息代码不能为空");
    }
    if(StringUtils.isEmpty(nGoods.getName())){
      return ResponseResult.failed("物品信息名称不能为空");
    }
    SGoods sGoods = new SGoods();
    List<SGoodsStock> list = new ArrayList<>();
    int beginNo = 0;
    boolean isUpdate = false;
    /*新增物品时，物品库存编码从0开始
      增加库存数量时，库存编号从已有库存最大值编号加1开始*/
    if (StringUtils.isEmpty(nGoods.getUuid())){
      nGoods.setUuid(UUIDGenerator.getUUID());
    }else{
      //获取库存数量的最大NO值
      int maxNo = 0;

      //UUID存在表示增加库存
      SGoods sGoods1 = goodsDao.getGoodsByUuid(nGoods.getUuid());
      if(sGoods1 == null){
        nGoods.setUuid(UUIDGenerator.getUUID());
      }else{
        isUpdate = true;
        maxNo = goodsDao.getMaxNoFromStock(nGoods.getUuid());
        beginNo = maxNo + 1;
      }
    }

    for(int i = beginNo; i < nGoods.getQuantity(); i++){
      SGoodsStock sGoodsStock = new SGoodsStock();
      sGoodsStock.setGoodsUuid(nGoods.getUuid());
      sGoodsStock.setNo(i);
      sGoodsStock.setState(0); //初始值为0
      sGoodsStock.setUuid(UUIDGenerator.getUUID());
      sGoodsStock.setLockVersion(0);
      list.add(sGoodsStock);
    }
    sGoods.setUuid(nGoods.getUuid());
    sGoods.setCode(nGoods.getCode());
    sGoods.setName(nGoods.getName());
    sGoods.setLastupdtime(DateUtil.format(DateUtil.dateToString(new Date(), DEFAULT_FORMAT), null));
    sGoods.setCostPrice(nGoods.getCostPrice());
    sGoods.setCurrentQuantity(nGoods.getCurrentQuantity());
    sGoods.setDepositamt(nGoods.getDepositamt());
    sGoods.setDescription(nGoods.getDescription());
    sGoods.setMemo(nGoods.getMemo());
    sGoods.setLaster(nGoods.getLaster());
    sGoods.setPicture(nGoods.getPicture());
    sGoods.setPrice(nGoods.getPrice());
    sGoods.setQuantity(nGoods.getQuantity());
    sGoods.setRentPrice(nGoods.getRentPrice());
    sGoods.setRepayamt(nGoods.getRepayamt());
    sGoods.setState(nGoods.getState());
    sGoods.setStoreUuid(nGoods.getStoreUuid());
    sGoods.setType(nGoods.getType());
    sGoods.setSGoodsStockList(list);
    try {
      if (isUpdate == false){
        goodsDao.saveGoods(sGoods);
      }else{
        goodsDao.updateGoods(sGoods);
      }

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
   * @param borrowParam
   *         租用的物品信息
   * @return 租用的物品
   */
  @Override
  public ResponseResult<SGoodsStock> borrow(@RequestBody GoodsBorrowParam borrowParam) {
    //根据商品代码查询可以租用的
    ResponseResult<SGoodsStock> response;
    try {
      SGoodsStock sGoodsStock = goodsDao.getCanRentGoods(borrowParam.getUuid());
      if (sGoodsStock == null) {
        response = ResponseResult.failed("锁定物品失败.");
        return response;
      }

      response = ResponseResult.success();
      response.setData(sGoodsStock);
      return response;
    } catch (Exception e) {
      logger.error("锁定物品失败, " + e.getMessage());
      response = ResponseResult.failed("锁定物品失败, " + e.getMessage());
      return response;
    }
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
      return ResponseResult.failed("更新物品信息失败");
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
