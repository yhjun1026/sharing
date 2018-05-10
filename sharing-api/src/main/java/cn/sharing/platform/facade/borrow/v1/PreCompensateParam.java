package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/10.
 */
@Data
@ApiModel(description = "租用单预赔偿对象")
public class PreCompensateParam {
  @ApiModelProperty(value = "租用单id", required = true)
  private String borrowId;
  @ApiModelProperty(value = "赔偿物品信息", required = true)
  private List<PreCompensateGoodsParam> compensateGoods;

}
