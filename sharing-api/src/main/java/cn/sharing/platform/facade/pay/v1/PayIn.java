package cn.sharing.platform.facade.pay.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@ApiModel(description = "支付请求对象")
public class PayIn implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 支付订单信息
     */
    @ApiModelProperty(value = "支付订单信息")
    private String out_trade_no;

    /**
     * 原支付订单信息
     */
    @ApiModelProperty(value = "原支付订单信息（退货使用）")
    private String ori_out_no;

    private String auth_code;

    /**
     * 原支付金额
     */
    @ApiModelProperty(value = "原支付订单金额（退货使用）")
    private double ori_total_fee;
    /**
     * 订单标题
     */
    @ApiModelProperty(value = "订单标题")
    private String subject;
    /**
     * 订单金额
     */
    @ApiModelProperty(value = "订单金额")
    private double total_fee;
    /**
     * 订单内容
     */
    @ApiModelProperty(value = "订单内容")
    private String body;

    /**
     * 操作人
     */
    @ApiModelProperty(value = "操作人")
    private String emp;

    /**
     * 扩展参数
     */
    @ApiModelProperty(value = "扩展参数")
    private String extend_params;

    /**
     * 小程序用户
     */
    @ApiModelProperty(value = "用户openid")
    private String openid;
}
