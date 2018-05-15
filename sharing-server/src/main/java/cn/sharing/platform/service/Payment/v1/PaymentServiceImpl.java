package cn.sharing.platform.service.Payment.v1;

import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.facade.payment.v1.PaymentService;
import cn.sharing.platform.utils.StringUtils;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MSI on 2018/4/24.
 */
@RestController
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public ResponseResult<String> save(@RequestBody PayInfoParam payInfo) {

        ResponseResult<String> response;
        if (payInfo == null) {
            response = ResponseResult.failed("参数解析错误.");
            return response;
        }
        if (StringUtils.isEmpty(payInfo.getPayId())) {
            response = ResponseResult.failed("支付记录id未填写.");
            return response;
        }
        if (StringUtils.isEmpty(payInfo.getTradeNo())) {
            response = ResponseResult.failed("支付单号（支付平台）未填写.");
            return response;
        }
        if (StringUtils.isEmpty(payInfo.getOutTradeNo())) {
            response = ResponseResult.failed("支付单号（商户）未填写.");
            return response;
        }
        if (payInfo.getPayAmt() == null) {
            response = ResponseResult.failed("支付金额未填写.");
            return response;
        }
        if (StringUtils.isEmpty(payInfo.getPayUser())) {
            response = ResponseResult.failed("支付人未填写.");
            return response;
        }
        if (StringUtils.isEmpty(payInfo.getPayTime()) || payInfo.getPayTime().length() != 19) {
            response = ResponseResult.failed("计划归还时间未填写或格式不正确.");
            return response;
        }
        if (payInfo.getTransType().intValue() != 1 && payInfo.getTransType().intValue() != -1) {
            response = ResponseResult.failed("交易类型取值不正确.");
            return response;
        }
        if (payInfo.getTransType().intValue() == -1) {
            if (StringUtils.isEmpty(payInfo.getOriTradeNo())) {
                response = ResponseResult.failed("原支付单号（支付平台）未填写.");
                return response;
            }
            if (StringUtils.isEmpty(payInfo.getOriOutTradeNo())) {
                response = ResponseResult.failed("原支付单号（商户）未填写.");
                return response;
            }
        }

        try {
            String uuid = paymentDao.save(payInfo);
            response = ResponseResult.success();
            response.setData(uuid);
            return response;
        } catch (Exception e) {
            log.error("【保存支付信息】异常，" + e.getMessage());
            response = ResponseResult.failed("保存支付信息发生异常，" + e.getMessage());
            return response;
        }
    }

    @Override
    public ResponseResult<PayInfoParam> get(@PathVariable(value = "payid") @ApiParam(name = "payid",
            value = "支付id") String payid) {

        ResponseResult<PayInfoParam> response;
        try {
            PayInfoParam payInfoParam = paymentDao.get(payid);
            if (payInfoParam == null) {
                response = ResponseResult.failed("支付信息不存在.");
                return response;
            }
            response = ResponseResult.success();
            response.setData(payInfoParam);
            return response;
        } catch (Exception e) {
            log.error("【查询支付信息】异常，" + e.getMessage());
            response = ResponseResult.failed("查询支付信息发生异常，" + e.getMessage());
            return response;
        }
    }
}
