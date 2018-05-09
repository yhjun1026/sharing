package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zenglin on 2018/5/8.
 */
public class BorrowDetailInfoDto {
  @ApiModelProperty(value = "租用单id")
  private String uuid;
  @ApiModelProperty(value = "租用单单号")
  private String billNumber;
  @ApiModelProperty(value = "单据状态 new 新增; 已领取 using; 已归还 backed; 已赔偿 compensated")
  private String stat;
  @ApiModelProperty(value = "租用人信息")
  private Custom custom;
  @ApiModelProperty(value = "计划归还时间")
  private String planReturnTime;
  @ApiModelProperty(value = "实际归还时间")
  private String realReturnTime;
  @ApiModelProperty(value = "领用受理人")
  private String borrowOperator;
  @ApiModelProperty(value = "领用受理时间")
  private String getBorrowOperateTime;
  @ApiModelProperty(value = "归还受理人")
  private String returnOperator;
  @ApiModelProperty(value = "归还受理时间")
  private String returnOperateTime;
  @ApiModelProperty(value = "创建时间")
  private String createTime;
  @ApiModelProperty(value = "最后更新时间")
  private String lstUpdTime;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "租用单明细信息")
  private List<BorrowDtlParam> dtls;
}
