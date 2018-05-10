package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfoParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *  物品借用单汇总
 *
 * Created by guotao on 2018.01.20.
 */
@Data
@ApiModel(description = "租用单基础信息")
public class SBorrow {
  @ApiModelProperty(value = "租借用户信息", required = true)
  private Custom custom;
  @ApiModelProperty(value = "计划归还时间(yyyy-MM-dd hh:mm:ss)", required = true)
  private String planBackTime;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "组织id")
  private String storeUuid;
  @ApiModelProperty(value = "租用商品明细", required = true)
  private List<SBorrowDtl> goodsDtl;

}
