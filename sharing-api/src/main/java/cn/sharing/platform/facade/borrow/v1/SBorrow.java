package cn.sharing.platform.facade.borrow.v1;

import cn.sharing.platform.facade.payment.v1.PayInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 *  物品借用单汇总
 *
 * Created by guotao on 2018.01.20.
 */
@Data
@ApiModel(description = " 租用单")
public class SBorrow {
  private String uuid;

  @ApiModelProperty(value = "租用单单号", required = true)
  private String billnumber;

  @ApiModelProperty(value = "原租用单单号（类型为归还单时赋值对应租用单单号）", required = false)
  private String oriBillNumner;

  private String stat;

  @ApiModelProperty(value = "租用单类型（1为租用，-1为归还）", required = true)
  @NotBlank(message ="租用单类型[borrowertype]不能为空")
  private String borrowertype;

  private String borrower;
  @ApiModelProperty(value = "租借用户信息", required = true)
  private Custom custom;

  private Date returntime;

  private Date realreturntime;

  private String filler;

  private Date fildate;

  private String laster;

  private Date lastupdtime;

  private String memo;

  private String storeuuid;

  private PayInfo payInfo;

  private List<SBorrowDtl> sGoodsBorrowDtl;

}
