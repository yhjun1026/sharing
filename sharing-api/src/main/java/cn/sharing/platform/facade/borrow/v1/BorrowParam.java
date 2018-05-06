package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/6.
 */
@Data
@ApiModel(description = "租用单保存")
public class BorrowParam {
  @ApiModelProperty(value = "租借用户信息", required = true)
  private Custom custom;
  @ApiModelProperty(value = "计划归还时间(yyyy-MM-dd hh:mm:ss)", required = true)
  private String returntime;
  @ApiModelProperty(value = "填单人", required = true)
  private String filler;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "组织id（暂时无用）")
  private String storeuuid;
  @ApiModelProperty(value = "租用商品明细")
  private List<BorrowDtlParam> borrowDtls;
}
