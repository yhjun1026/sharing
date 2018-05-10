package cn.sharing.platform.service.Payment.v1;

import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.facade.payment.v1.PaymentService;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by MSI on 2018/4/24.
 */
public class PaymentServiceImpl implements PaymentService {
    @Override
    public ResponseResult<Void> save(@RequestBody PayInfoParam payInfo) {
        return null;
    }

    @Override
    public ResponseResult<PayInfoParam> get(@PathVariable(value = "payid") @ApiParam(name = "payid",
            value = "支付id") String payid) {
        return null;
    }
}
