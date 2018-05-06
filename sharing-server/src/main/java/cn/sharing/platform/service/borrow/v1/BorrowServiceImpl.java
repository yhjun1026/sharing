package cn.sharing.platform.service.borrow.v1;

import cn.sharing.platform.common.QueryResult;
import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.borrow.v1.BorrowDtlParam;
import cn.sharing.platform.facade.borrow.v1.BorrowParam;
import cn.sharing.platform.facade.borrow.v1.BorrowQuery;
import cn.sharing.platform.facade.borrow.v1.BorrowService;
import cn.sharing.platform.facade.borrow.v1.SBorrow;
import cn.sharing.platform.service.goods.v1.GoodsDao;
import cn.sharing.platform.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    if (StringUtils.isEmpty(borrowParam.getReturntime())) {
      response = ResponseResult.failed("计划归还时间未填写.");
      return response;
    }
    if (StringUtils.isEmpty(borrowParam.getFiller())) {
      response = ResponseResult.failed("填单人未填写.");
      return response;
    }
    if (borrowParam.getBorrowDtls() == null || borrowParam.getBorrowDtls().size() == 0) {
      response = ResponseResult.failed("租用物品未指定.");
      return response;
    }
    for (BorrowDtlParam dtl : borrowParam.getBorrowDtls()) {
      if (!goodsDao.isExistGoodsByUuid(dtl.getGoodsuuid())) {
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
  public ResponseResult<QueryResult<SBorrow>> query(@RequestBody @Valid BorrowQuery param) {
    return null;
  }

  @Override
  public ResponseResult<Void> back(@RequestBody @Valid SBorrow sGoodsBorrow) {
    return null;
  }

  @Override
  public ResponseResult<Void> compensate(@RequestBody @Valid SBorrow sGoodsBorrow) {
    return null;
  }
}
