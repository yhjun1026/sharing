package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/6.
 */
@Data
@ApiModel(description = "租用单保存")
public class BorrowParam extends SBorrow {
  @ApiModelProperty(value = "租用付款信息", required = true)
  private PayInfoParam payInfo;
}
