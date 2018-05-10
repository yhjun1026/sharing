package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "租用单物品领用对象")
public class BorrowCollarParam {
  @ApiModelProperty(value = "租用单id", required = true)
  private String borrowId;
  @ApiModelProperty(value = "领用受理人", required = true)
  private String borrowDealer;
}
