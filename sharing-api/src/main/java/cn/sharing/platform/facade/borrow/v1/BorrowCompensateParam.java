package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "租用单赔偿对象")
public class BorrowCompensateParam {
  @ApiModelProperty(value = "租用单id", required = true)
  private String borrowId;
  @ApiModelProperty(value = "赔偿付款信息")
  private PayInfoParam payInfoParam;
}
