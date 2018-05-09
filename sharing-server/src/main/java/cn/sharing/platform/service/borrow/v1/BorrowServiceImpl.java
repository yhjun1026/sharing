package cn.sharing.platform.service.borrow.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.borrow.v1.BorrowBackParam;
import cn.sharing.platform.facade.borrow.v1.BorrowCollarParam;
import cn.sharing.platform.facade.borrow.v1.BorrowCompensateParam;
import cn.sharing.platform.facade.borrow.v1.BorrowDetailInfoDto;
import cn.sharing.platform.facade.borrow.v1.BorrowParam;
import cn.sharing.platform.facade.borrow.v1.BorrowQuery;
import cn.sharing.platform.facade.borrow.v1.BorrowService;
import cn.sharing.platform.facade.borrow.v1.BorrowSummaryDto;
import cn.sharing.platform.facade.borrow.v1.PreCompensateParam;
import cn.sharing.platform.facade.borrow.v1.SBorrowDtl;
import cn.sharing.platform.service.goods.v1.GoodsDao;
import cn.sharing.platform.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by zenglin on 2018/5/6.
 */
@RestController
@Slf4j
public class BorrowServiceImpl implements BorrowService {

  @Autowired
  private GoodsDao goodsDao;

  @Autowired
  private BorrowDao borrowDao;

  @Override
  public ResponseResult<String> borrow(@RequestBody BorrowParam borrowParam) {
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
    if (StringUtils.isEmpty(borrowParam.getPlanBackTime())) {
      response = ResponseResult.failed("计划归还时间未填写.");
      return response;
    }
    if (borrowParam.getSGoodsBorrowDtl() == null || borrowParam.getSGoodsBorrowDtl().size() == 0) {
      response = ResponseResult.failed("租用物品未指定.");
      return response;
    }
    for (SBorrowDtl dtl : borrowParam.getSGoodsBorrowDtl()) {
      if (!goodsDao.isExistGoodsByUuid(dtl.getGoodsUuid())) {
        response = ResponseResult.failed("租用的物品不存在.");
        return response;
      }
    }

    try {
      String uuid = borrowDao.saveBorrow(borrowParam);
      response = ResponseResult.success();
      response.setData(uuid);
      return response;
    } catch (Exception e) {
      log.error("【新增物品借用单】异常，" + e.getMessage());
      response = ResponseResult.failed("租用发生异常，" + e.getMessage());
      return response;
    }

  }

  @Override
  public ResponseResult<Void> collar(@RequestBody BorrowCollarParam collarParam) {
    return null;
  }

  @Override
  public ResponseResult<Void> back(@RequestBody BorrowBackParam backParam) {
    return null;
  }

  @Override
  public ResponseResult<Void> compensate(@RequestBody BorrowCompensateParam compensateParam) {
    return null;
  }

  @Override
  public ResponseResult<QueryResult<BorrowSummaryDto>> query(@RequestBody BorrowQuery param) {
    return null;
  }

  @Override
  public ResponseResult<BorrowDetailInfoDto> get(@PathVariable String uuid) {
    return null;
  }

  @Override
  public ResponseResult<Void> preCompensate(@RequestBody PreCompensateParam compensateParam) {
    return null;
  }
}
