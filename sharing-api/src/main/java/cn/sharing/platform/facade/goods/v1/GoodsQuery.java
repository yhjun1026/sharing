package cn.sharing.platform.facade.goods.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "物品查询参数")
public class GoodsQuery {
  /** 项目代码 */
  @ApiModelProperty(value = "项目Id", required = false)
  private String storeId;
  /** 物品代码 */
  @ApiModelProperty(value = "物品代码", required = false)
  private String code;
  /** 物品名称 */
  @ApiModelProperty(value = "物品名称", required = false)
  private String name;
  /** 查询类型 */
  @ApiModelProperty(value = "查询类型（all 查询所有，available 查询可租用的，默认查询所有）", required = false)
  private String queryType;
  /** 当前页 */
  @ApiModelProperty(value = "当前页号，默认1", required = false)
  private int page = 1;
  /** 每页记录数 */
  @ApiModelProperty(value = "每页大小，默认20，不超过200", required = false)
  private int pageSize = 50;
}
