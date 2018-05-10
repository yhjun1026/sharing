package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "租用单物品归还对象")
public class BorrowBackParam {
  @ApiModelProperty(value = "租用单id", required = true)
  private String borrowId;
  @ApiModelProperty(value = "归还受理人", required = true)
  private String backDealer;
  @ApiModelProperty(value = "押金退还付款信息")
  private PayInfoParam payInfoParam;
}
