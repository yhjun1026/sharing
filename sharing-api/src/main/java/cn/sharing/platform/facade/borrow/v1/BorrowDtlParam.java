package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zenglin on 2018/5/6.
 */
@Data
@ApiModel(description = "租用单保存明细")
public class BorrowDtlParam {
  @ApiModelProperty(value = "商品id", required = true)
  private String goodsUuid;
  @ApiModelProperty(value = "租用数量（到单品，暂时不需要）")
  private BigDecimal borrowQty;
  @ApiModelProperty(value = "借出物品情况描述")
  private String borrowDescrip;
  @ApiModelProperty(value = "借用时缴纳押金")
  private BigDecimal depositAmt;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "支付信息")
  private PayInfoParam payInfoParam;
}
