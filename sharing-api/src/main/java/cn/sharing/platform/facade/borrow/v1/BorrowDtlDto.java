package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by zenglin on 2018/5/8.
 */
public class BorrowDtlDto {
  @ApiModelProperty(value = "商品id")
  private String goodsUuid;
  @ApiModelProperty(value = "商品代码")
  private String goodsCode;
  @ApiModelProperty(value = "商品名称")
  private String goodsName;
  @ApiModelProperty(value = "借出物品情况描述")
  private String borrowDescrip;
  @ApiModelProperty(value = "借用时缴纳押金")
  private BigDecimal depositAmt;
  @ApiModelProperty(value = "物品归还时情况描述")
  private String returnDescrip;
  @ApiModelProperty(value = "使用费用金额")
  private BigDecimal payAmt;  //该怎么计算？
  @ApiModelProperty(value = "归还押金")
  private BigDecimal returnDepositAmt;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "租用付款信息")
  private PayInfoParam borrowPayInfo;
  @ApiModelProperty(value = "退还押金付款信息")
  private PayInfoParam returnPayInfo;
  @ApiModelProperty(value = "赔偿付款信息")
  private PayInfoParam compensatePayInfo;
}
