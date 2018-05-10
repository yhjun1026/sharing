package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "租用单详情")
public class BorrowDetailInfoDto extends BorrowSummaryDto{
  @ApiModelProperty(value = "租用付款信息")
  private PayInfoParam borrowPayInfo;
  @ApiModelProperty(value = "押金退还付款信息")
  private PayInfoParam backPayInfo;
  @ApiModelProperty(value = "赔偿付款信息")
  private PayInfoParam compensatePayInfo;
}
