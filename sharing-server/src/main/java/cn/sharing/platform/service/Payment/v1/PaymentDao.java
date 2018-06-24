package cn.sharing.platform.service.Payment.v1;

import cn.sharing.platform.dao.entity.PayInfo;
import cn.sharing.platform.dao.entity.PayInfoExample;
import cn.sharing.platform.dao.mapper.PayInfoMapper;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.utils.DateUtil;
import cn.sharing.platform.utils.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zenglin on 2018/5/15.
 */
@Component
@Slf4j
public class PaymentDao {

  @Autowired
  private PayInfoMapper payInfoMapper;

  @Transactional
  public String save(PayInfoParam payInfoParam) {
    String uuid = UUIDGenerator.getUUID();
    PayInfo payInfo = convertFromPayInfoParam(payInfoParam);
    payInfo.setUuid(uuid);
    payInfoMapper.insert(payInfo);
    return uuid;
  }

  public PayInfoParam get(String payId) {
    PayInfoExample example = new PayInfoExample();
    PayInfoExample.Criteria criteria = example.createCriteria();
    criteria.andPayIdEqualTo(payId);
    List<PayInfo> payInfos = payInfoMapper.selectByExample(example);
    if (payInfos == null || payInfos.size() == 0) {
      return null;
    } else {
      return converPayInfoParamFromPayInfo(payInfos.get(0));
    }
  }

  //将参数的付款信息转化成数据库对象
  private PayInfo convertFromPayInfoParam(PayInfoParam payInfoParam) {
    if (payInfoParam == null) {
      return null;
    }

    PayInfo payInfo = new PayInfo();
    BeanUtils.copyProperties(payInfoParam, payInfo);
    payInfo.setPayTime(DateUtil.getDateByPattern(payInfoParam.getPayTime(), DateUtil.DEFAULT_FORMAT));

    return payInfo;
  }

  //将数据库的付款对象转换成输出对象
  private PayInfoParam converPayInfoParamFromPayInfo(PayInfo payInfo) {
    if (payInfo == null) {
      return null;
    }

    PayInfoParam payInfoParam = new PayInfoParam();
    BeanUtils.copyProperties(payInfo, payInfoParam);
    if (payInfo.getPayTime() != null) {
      payInfoParam.setPayTime(DateUtil.dateToString(payInfo.getPayTime(), DateUtil.DEFAULT_FORMAT));
    }

    return payInfoParam;
  }
}
