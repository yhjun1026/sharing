package cn.sharing.platform.facade.goods.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel(description = "物品查询参数")
public class GoodsQuery {
  @ApiModelProperty(value = "项目Id(必须)", required = true)
  @NotBlank(message ="项目Id[storeId]不能为空")
  private String storeId;
  @ApiModelProperty(value = "当前页号，默认1", required = false)
  private int page = 1;
  @ApiModelProperty(value = "每页大小，默认50，不超过200", required = false)
  private int pageSize = 50;
}
