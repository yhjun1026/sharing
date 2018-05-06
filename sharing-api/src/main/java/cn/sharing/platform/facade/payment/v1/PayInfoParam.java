package cn.sharing.platform.facade.payment.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by MSI on 2018/4/23.
 */
@Data
@ApiModel(value="支付信息对象",description="支付信息对象")
public class PayInfoParam {
    @ApiModelProperty(value="支付记录id",name="id",required=true)
    private String id;
    @ApiModelProperty(value="交易类型",name="tranType",required=true)
    private int tranType;   //1 支付， -1 退款
    @ApiModelProperty(value="支付方式",name="payType",required=false)
    private int payType;   //1 微信， 2 支付宝
    @ApiModelProperty(value="支付单号（支付平台）",name="tradeNo",required=true)
    private String tradeNo;
    @ApiModelProperty(value="支付单号（商户）",name="outTradeNo",required=true)
    private String outTradeNo;
    @ApiModelProperty(value="支付金额",name="payAmt",required=true)
    private BigDecimal payAmt;
    @ApiModelProperty(value="支付人",name="payUser",required=true)
    private String payUser;
    @ApiModelProperty(value="支付时间/退款时间",name="payTime",required=true)
    private Date payTime;
    @ApiModelProperty(value="原支付单号（支付平台，退款时使用）",name="oriTradeNo",required=false)
    private String oriTradeNo;
    @ApiModelProperty(value="原支付单号（商户，退款时使用）",name="oriOutTradeNo",required=false)
    private String oriOutTradeNo;

}
