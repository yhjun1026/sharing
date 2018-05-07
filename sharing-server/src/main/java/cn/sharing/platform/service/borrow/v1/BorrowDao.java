package cn.sharing.platform.service.borrow.v1;

import cn.sharing.platform.common.BorrowStatEnum;
import cn.sharing.platform.facade.borrow.v1.BorrowDtlParam;
import cn.sharing.platform.facade.borrow.v1.BorrowParam;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.utils.DateUtil;
import cn.sharing.platform.utils.SerialNumberUtil;
import cn.sharing.platform.utils.UUIDGenerator;
import com.sharing.dao.entity.Goods;
import com.sharing.dao.entity.GoodsBorrowDtl;
import com.sharing.dao.entity.GoodsBorrowMst;
import com.sharing.dao.entity.PayInfo;
import com.sharing.dao.mapper.GoodsBorrowDtlMapper;
import com.sharing.dao.mapper.GoodsBorrowMstMapper;
import com.sharing.dao.mapper.GoodsMapper;
import com.sharing.dao.mapper.PayInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zenglin on 2018/5/6.
 */
@Component
@Slf4j
public class BorrowDao {

  @Autowired
  private GoodsMapper goodsMapper;

  @Autowired
  private PayInfoMapper payInfoMapper;

  @Autowired
  private GoodsBorrowDtlMapper goodsBorrowDtlMapper;

  @Autowired
  private GoodsBorrowMstMapper goodsBorrowMstMapper;

  @Autowired
  private SerialNumberUtil serialNumberUtil;

  @Transactional
  public String saveBorrow(BorrowParam param) {
    //1.更新物品状态
    //2.记录支付信息
    //3.记录借用单表
    String mstUuid = UUIDGenerator.getUUID();
    for (BorrowDtlParam dtl : param.getBorrowDtls()) {
      Goods goods = goodsMapper.selectByPrimaryKey(dtl.getGoodsUuid());
      goods.setStat(1);
      goodsMapper.updateByPrimaryKeySelective(goods);
      //记录支付信息
      String payUuid = null;
      if (dtl.getPayInfoParam() != null) {
        payUuid = UUIDGenerator.getUUID();
        PayInfo payInfo = convertFromPayInfoParam(dtl.getPayInfoParam());
        payInfo.setUuid(payUuid);
        payInfoMapper.insert(payInfo);
      }
      GoodsBorrowDtl borrowDtl = convertFromBorrowDtlParam(dtl);
      borrowDtl.setGoodsCode(goods.getCode());
      borrowDtl.setGoodsName(goods.getName());
      borrowDtl.setBorrowUuid(mstUuid);
      borrowDtl.setBorrowPayUuid(payUuid);

      goodsBorrowDtlMapper.insert(borrowDtl);
    }

    List<String> billNumbers = null;
    try {
      billNumbers = serialNumberUtil.generateNumber("JY", 6, 1);
    } catch (Exception e) {
      log.error("【新增租用单】生成单据号异常，" + e.getMessage());
      throw new RuntimeException("生成单据号异常，" + e.getMessage());
    }
    if (billNumbers == null || billNumbers.size() == 0) {
      throw new RuntimeException("生成单据号失败");
    }

    GoodsBorrowMst borrowMst = convertFromBorrowParam(param);
    borrowMst.setUuid(mstUuid);
    borrowMst.setBillNumber(billNumbers.get(0));
    borrowMst.setLstUpdTime(new Date());
    goodsBorrowMstMapper.insert(borrowMst);

    return mstUuid;
  }

  private PayInfo convertFromPayInfoParam(PayInfoParam payInfoParam) {
    if (payInfoParam == null) {
      return null;
    }

    PayInfo payInfo = new PayInfo();
    BeanUtils.copyProperties(payInfoParam, payInfo);
    payInfo.setPayTime(DateUtil.getDateByPattern(payInfoParam.getPayTime(), DateUtil.DEFAULT_FORMAT));

    return payInfo;
  }

  private GoodsBorrowDtl convertFromBorrowDtlParam(BorrowDtlParam dtlParam) {
    if (dtlParam == null) {
      return null;
    }

    GoodsBorrowDtl borrowDtl = new GoodsBorrowDtl();
    borrowDtl.setUuid(UUIDGenerator.getUUID());
    BeanUtils.copyProperties(dtlParam, borrowDtl);

    return borrowDtl;
  }

  private GoodsBorrowMst convertFromBorrowParam(BorrowParam borrowParam) {
    if (borrowParam == null) {
      return null;
    }
    GoodsBorrowMst borrowMst = new GoodsBorrowMst();
    borrowMst.setStat(BorrowStatEnum.NEW.getCode());
    borrowMst.setBorrower(borrowParam.getCustom().getNick());
    borrowMst.setMobile(borrowParam.getCustom().getPhoneNumber());
    borrowMst.setAddress(borrowParam.getCustom().getAddress());
    borrowMst.setPlanReturnTime(DateUtil.getDateByPattern(borrowParam.getReturnTime(), DateUtil.DEFAULT_FORMAT));
    borrowMst.setCreateTime(new Date());
    borrowMst.setLstUpdTime(new Date());
    borrowMst.setMemo(borrowParam.getMemo());

    return borrowMst;
  }
}
