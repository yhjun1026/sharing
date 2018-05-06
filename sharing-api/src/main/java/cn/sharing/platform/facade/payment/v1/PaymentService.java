package cn.sharing.platform.facade.payment.v1;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MSI on 2018/4/23.
 */
@RequestMapping("/api/v1/payment")
@Api(tags = "支付接口")
public interface PaymentService {
    /**
     * 支付保存
     * @param payInfo
     * @return
     */
    @RequestMapping(value = "/save" +
            "", method = RequestMethod.POST)
    @ApiOperation(value = "支付保存")
    public ResponseResult<Void> save (@RequestBody PayInfoParam payInfo);


    @RequestMapping(value = "/{payid}", method = RequestMethod.GET)
    @ApiOperation(value = "获取支付详情")
    public ResponseResult<PayInfoParam> get(@PathVariable(value = "payid") @ApiParam(name = "payid",
            value = "支付id")String payid);

}
