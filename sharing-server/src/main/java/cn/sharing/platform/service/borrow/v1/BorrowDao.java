package cn.sharing.platform.service.borrow.v1;

import cn.sharing.platform.common.BorrowStatEnum;
import cn.sharing.platform.facade.borrow.v1.BorrowDtlParam;
import cn.sharing.platform.facade.borrow.v1.BorrowParam;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.utils.DateUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

  @Transactional
  public String saveBorrow(BorrowParam param) {
    //1.更新物品状态
    //2.记录支付信息
    //3.记录借用单表
    String mstUuid = UUIDGenerator.getUUID();
    for (BorrowDtlParam dtl : param.getBorrowDtls()) {
      Goods goods = goodsMapper.selectByPrimaryKey(dtl.getGoodsuuid());
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
      borrowDtl.setGoodscode(goods.getCode());
      borrowDtl.setGoodsname(goods.getName());
      borrowDtl.setBorrowuuid(mstUuid);
      borrowDtl.setBorrowpayuuid(payUuid);

      goodsBorrowDtlMapper.insert(borrowDtl);
    }

    GoodsBorrowMst borrowMst = convertFromBorrowParam(param);
    borrowMst.setUuid(mstUuid);
    goodsBorrowMstMapper.insert(borrowMst);

    return mstUuid;
  }

  private PayInfo convertFromPayInfoParam(PayInfoParam payInfoParam) {
    if (payInfoParam == null) {
      return null;
    }

    PayInfo payInfo = new PayInfo();
    payInfo.setPayid(payInfoParam.getPayid());
    payInfo.setTranstype(payInfoParam.getTranType());
    payInfo.setPaytype(payInfoParam.getPayType());
    payInfo.setTradeno(payInfoParam.getTradeNo());
    payInfo.setOuttradeno(payInfoParam.getOutTradeNo());
    payInfo.setPayamt(payInfoParam.getPayAmt());
    payInfo.setPayuser(payInfoParam.getPayUser());
    payInfo.setPaytime(DateUtil.getDateByPattern(payInfoParam.getPayTime(), DateUtil.DEFAULT_FORMAT));
    payInfo.setOritradeno(payInfoParam.getOriTradeNo());
    payInfo.setOriouttradeno(payInfoParam.getOriOutTradeNo());

    return payInfo;
  }

  private GoodsBorrowDtl convertFromBorrowDtlParam(BorrowDtlParam dtlParam) {
    if (dtlParam == null) {
      return null;
    }

    GoodsBorrowDtl borrowDtl = new GoodsBorrowDtl();
    borrowDtl.setUuid(UUIDGenerator.getUUID());
    borrowDtl.setGoodsuuid(dtlParam.getGoodsuuid());
    borrowDtl.setBorrowqty(dtlParam.getBorrowqty());
    borrowDtl.setBorrowdescrip(dtlParam.getBorrowdescrip());
    borrowDtl.setDepositamt(dtlParam.getDepositamt());
    borrowDtl.setMemo(dtlParam.getMemo());

    return borrowDtl;
  }

  private GoodsBorrowMst convertFromBorrowParam(BorrowParam borrowParam) {
    if (borrowParam == null) {
      return null;
    }
    GoodsBorrowMst borrowMst = new GoodsBorrowMst();
    borrowMst.setBillnumber("");  //todo  单号生成
    borrowMst.setStat(BorrowStatEnum.NEW.getCode());
    borrowMst.setMobile(borrowParam.getCustom().getPhoneNumber());
    borrowMst.setAddress(borrowParam.getCustom().getAddress());
    borrowMst.setReturntime(DateUtil.getDateByPattern(borrowParam.getReturntime(), DateUtil.DEFAULT_FORMAT));
    borrowMst.setFiller(borrowParam.getFiller());
    borrowMst.setFildate(new Date());
    borrowMst.setLaster(borrowParam.getFiller());
    borrowMst.setLastupdtime(new Date());
    borrowMst.setMemo(borrowParam.getMemo());

    return borrowMst;
  }
}
