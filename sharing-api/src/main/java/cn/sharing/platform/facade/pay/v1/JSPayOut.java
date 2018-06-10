package cn.sharing.platform.facade.pay.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by MSI on 2018/6/10.
 */
@Data
@ApiModel(description = "JSPay返回对象")
public class JSPayOut {
    /** 预付单信息 */
    @ApiModelProperty(value = "预付单信息")
    private String prpay_id;

    /** 随机字符串 */
    @ApiModelProperty(value = "随机字符串")
    private String nonceStr;

    /** 时间戳 */
    @ApiModelProperty(value = "时间戳")
    private String timeStamp;

    /** 签名（小程序支付提交使用）*/
    @ApiModelProperty(value = "签名（小程序支付提交使用）")
    private String paySign;

    /** 小程序appid */
    @ApiModelProperty(value = "小程序appid")
    private String appid;
}
