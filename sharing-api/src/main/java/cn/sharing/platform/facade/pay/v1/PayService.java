/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，1995-2016，所有权利保留。
 * 项目名：sharing
 * 文件名：PayService
 * 模块说明：
 * 修改历史：
 * 2018/5/22 - yanghongjun - 创建
 */
package cn.sharing.platform.facade.pay.v1;

import cn.sharing.platform.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yanghongjun
 * @version 1.0
 */

@Api(tags = "付款服务")
public interface PayService {

    @RequestMapping(value = "/prepay", method = RequestMethod.POST)
    @ApiOperation(value = "(当面付)支付二维码申请")
    public PayOut PreparePay(@RequestBody  PayIn preorder);


    @RequestMapping(value = "/scanpay", method = RequestMethod.POST)
    @ApiOperation(value = "(当面付)付款码直接支付")
    public ResponseResult<PayOut> ScanPay(@RequestBody PayIn preorder);


    @RequestMapping(value = "/unifiedpay", method = RequestMethod.POST)
    @ApiOperation(value = "线上统一下单支付")
    public ResponseResult<JSPayOut> UnifiedPay(@RequestBody PayIn preorder);

    @RequestMapping(value = "/get/{payId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取单个租用单信息")
    public PayOut Query(@PathVariable(value = "payId") @ApiParam(name = "payId", value = "支付代码") String
                                    payId);


    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @ApiOperation(value = "退款")
    public PayOut Refund(@RequestBody  PayIn preorder);


    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    @ApiOperation(value = "撤销")
    public PayOut Cancel(@RequestParam("out_trade_no") String out_trade_no);

    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "支付回调（给支付平台调用）")
    public void Notify(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
