package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "租用单预赔偿对象")
public class BorrowPreCompensateParam {
  @ApiModelProperty(value = "租用单id", required = true)
  private String borrowId;
  @ApiModelProperty(value = "赔偿款（不传或者为0的情况下使用商品单价）")
  private BigDecimal compensateAmt;
}
