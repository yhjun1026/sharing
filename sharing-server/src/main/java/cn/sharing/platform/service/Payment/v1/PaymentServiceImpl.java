package cn.sharing.platform.service.Payment.v1;

import cn.sharing.platform.common.ResponseResult;
import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import cn.sharing.platform.facade.payment.v1.PaymentService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MSI on 2018/4/24.
 */
@RestController
@Slf4j
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
