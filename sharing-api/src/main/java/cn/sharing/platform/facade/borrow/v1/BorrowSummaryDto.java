package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.common.UCN;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

/**
 * Created by zenglin on 2018/5/8.
 */
@Data
@ApiModel(description = "查询租用单列表返回对象")
public class BorrowSummaryDto extends SBorrow{
  @ApiModelProperty(value = "租用单id")
  private String uuid;
  @ApiModelProperty(value = "租用单单号")
  private String billNumber;
  @ApiModelProperty(value = "单据状态 new 新增; 已领取 using; 已归还 backed; 已赔偿 compensated")
  private String stat;
  @ApiModelProperty(value = "实际归还时间")
  private String realBackTime;
  @ApiModelProperty(value = "领用受理人")
  private String borrowDealer;
  @ApiModelProperty(value = "领用受理时间")
  private String borrowDealTime;
  @ApiModelProperty(value = "归还受理人")
  private String backDealer;
  @ApiModelProperty(value = "归还受理时间")
  private String backDealTime;
  @ApiModelProperty(value = "创建时间")
  private String createTime;
  @ApiModelProperty(value = "最后更新时间")
  private String lstUpdTime;
}
