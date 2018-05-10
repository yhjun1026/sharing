package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zenglin on 2018/5/10.
 */
@Data
@ApiModel(description = "租用单预赔偿商品对象")
public class PreCompensateGoodsParam {
  @ApiModelProperty(value = "物品id", required = true)
  private String goodsUuid;
  @ApiModelProperty(value = "赔偿金额", required = true)
  private BigDecimal amt;
}
