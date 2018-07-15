package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.service.borrow.BorrowServiceImpl;
import cn.sharing.platform.service.goods.GoodsServiceImpl;
import cn.sharing.platform.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zenglin on 2018/5/6.
 */
@RestController
@Slf4j
public class BorrowFacadeImpl implements BorrowFacade {

  @Autowired
  private GoodsServiceImpl goodsServiceImpl;

  @Autowired
  private BorrowServiceImpl borrowServiceImpl;

  @Override
  public ResponseResult<String> borrow(@RequestBody SBorrow borrowParam) {
    //1. 验证参数
    //2. 调用dao层进行操作（更新物品状态，插入数据）
    //3. 返回单据id
    ResponseResult<String> response;
    if (borrowParam == null) {
      response = ResponseResult.failed("参数解析错误.");
      return response;
    }
    if (borrowParam.getCustom() == null) {
      response = ResponseResult.failed("租借用户信息未填写.");
      return response;
    }
    if (StringUtils.isEmpty(borrowParam.getPlanBackTime()) || borrowParam.getPlanBackTime().length() != 19) {
      response = ResponseResult.failed("计划归还时间未填写或格式不正确.");
      return response;
    }
    if (StringUtils.isEmpty(borrowParam.getCustom().getMobile())) {
      response = ResponseResult.failed("租用人联系方式未填写.");
      return response;
    }
    if (borrowParam.getGoodsDtl() == null || borrowParam.getGoodsDtl().size() == 0) {
      response = ResponseResult.failed("租用物品未指定.");
      return response;
    }

//    for (SBorrowDtl dtl : borrowParam.getGoodsDtl()) {
//      if (!goodsDao.isExistsStockByUuid(dtl.getGoodsUuid())) {
//        response = ResponseResult.failed("租用的物品不存在.");
//        return response;
//      }
//    }

    try {
      String uuid = borrowServiceImpl.saveBorrow(borrowParam);
      response = ResponseResult.success();
      response.setData(uuid);
      return response;
    } catch (Exception e) {
      log.error("【新增物品借用单】异常，" + e.getMessage());
      response = ResponseResult.failed("租用失败，" + e.getMessage());
      return response;
    }

  }

  @Override
  public ResponseResult<Void> collar(@RequestBody BorrowCollarParam collarParam) {
    ResponseResult<Void> response;
    if (StringUtils.isEmpty(collarParam.getBorrowId())) {
      response = ResponseResult.failed("租用单id未填写.");
      return response;
    }
    if (StringUtils.isEmpty(collarParam.getBorrowDealer())) {
      response = ResponseResult.failed("领用受理人未填写.");
      return response;
    }
    try {
      borrowServiceImpl.collar(collarParam.getBorrowId(), collarParam.getBorrowDealer());
      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【物品领用】异常，" + e.getMessage());
      response = ResponseResult.failed("物品领用发生异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<Void> back(@RequestBody BorrowBackParam backParam) {
    ResponseResult<Void> response;
    if (StringUtils.isEmpty(backParam.getBorrowId())) {
      response = ResponseResult.failed("租用单id未填写.");
      return response;
    }
    if (StringUtils.isEmpty(backParam.getBackDealer())) {
      response = ResponseResult.failed("归还受理人未填写.");
      return response;
    }
    try {
      borrowServiceImpl.back(backParam.getBorrowId(), backParam.getBackDealer(), backParam.getPayInfoParam());
      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【物品归还】异常，" + e.getMessage());
      response = ResponseResult.failed("物品归还发生异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<Void> compensate(@RequestBody BorrowCompensateParam compensateParam) {
    ResponseResult<Void> response;
    if (StringUtils.isEmpty(compensateParam.getBorrowId())) {
      response = ResponseResult.failed("租用单id未填写.");
      return response;
    }
    if (compensateParam.getPayInfoParam() == null) {
      response = ResponseResult.failed("赔偿付款信息为填写.");
      return response;
    }

    try {
      borrowServiceImpl.compensate(compensateParam.getBorrowId(), compensateParam.getPayInfoParam());
      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【物品赔偿】异常，" + e.getMessage());
      response = ResponseResult.failed("物品赔偿发生异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<QueryResult<BorrowSummaryDto>> query(@RequestBody BorrowQuery param) {
    ResponseResult<QueryResult<BorrowSummaryDto>> response;
    if (!StringUtils.isEmpty(param.getBeginTime()) && param.getBeginTime().length() != 19) {
      response = ResponseResult.failed("查询开始时间格式不正确.");
      return response;
    }
    if (!StringUtils.isEmpty(param.getEndTime()) && param.getEndTime().length() != 19) {
      response = ResponseResult.failed("查询结束时间格式不正确.");
      return response;
    }
    try {
      QueryResult<BorrowSummaryDto> result = borrowServiceImpl.query(param);
      response = ResponseResult.success();
      response.setData(result);

      return response;
    } catch (Exception e) {
      log.error("【查询租用单】异常，" + e.getMessage());
      response = ResponseResult.failed("查询租用单发生异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<BorrowDetailInfoDto> get(@PathVariable String uuid) {
    try {
      ResponseResult<BorrowDetailInfoDto> response = new ResponseResult<>();
      BorrowDetailInfoDto detailInfoDto = borrowServiceImpl.get(uuid);
      if (detailInfoDto == null) {
        response.setStatus(ResponseResult.FAILED);
        response.setMessage("租用单不存在.");
      } else {
        response.setData(detailInfoDto);
      }

      return response;
    } catch (Exception e) {
      log.error("【查询租用单详情】异常，" + e.getMessage());
      ResponseResult<BorrowDetailInfoDto> response = ResponseResult.failed("查询租用单详情发生异常，" + e.getMessage());
      return response;
    }
  }

  @Override
  public ResponseResult<Void> preCompensate(@RequestBody PreCompensateParam compensateParam) {
    ResponseResult<Void> response;
    if (StringUtils.isEmpty(compensateParam.getBorrowId())) {
      response = ResponseResult.failed("租用单id未填写.");
      return response;
    }
    if (compensateParam.getCompensateGoods() == null || compensateParam.getCompensateGoods().size() == 0) {
      response = ResponseResult.failed("物品赔偿信息未填写.");
      return response;
    }

    try {
      borrowServiceImpl.preCompensate(compensateParam);
      response = ResponseResult.success();
      return response;
    } catch (Exception e) {
      log.error("【发起预赔偿】异常，" + e.getMessage());
      response = ResponseResult.failed("发起预赔偿异常，" + e.getMessage());
      return response;
    }
  }
}
