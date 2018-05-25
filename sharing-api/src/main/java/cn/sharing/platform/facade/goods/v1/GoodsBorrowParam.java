package cn.sharing.platform.facade.goods.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by zenglin on 2018/5/25.
 */
@Data
@ApiModel(description = "锁物品")
public class GoodsBorrowParam {
  @ApiModelProperty(value = "物品uuid", required = true)
  private String uuid;
}
