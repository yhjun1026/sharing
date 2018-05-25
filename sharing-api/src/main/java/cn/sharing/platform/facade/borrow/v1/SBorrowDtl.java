package cn.sharing.platform.facade.borrow.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 物品借用明细
 *
 * Created by guotao on 2018.01.20.
 */
@Data
@ApiModel(description = "租用单明细信息")
public class SBorrowDtl {
  @ApiModelProperty(value = "具体物品uuid", required = true)
  private String goodsUuid;
  @ApiModelProperty(value = "具体物品code", required = true)
  private String goodsCode;
  @ApiModelProperty(value = "物品名称", required = true)
  private String goodsName;
  @ApiModelProperty(value = "物品单价", required = true)
  private BigDecimal goodsPrice;
  @ApiModelProperty(value = "需赔偿金额")
  private BigDecimal compensateAmt;
  @ApiModelProperty(value = "物品借出描述")
  private String borrowDescrip;
  @ApiModelProperty(value = "借用时缴纳押金")
  private BigDecimal depositAmt;
  @ApiModelProperty(value = "物品归还描述")
  private String backDescrip;
  @ApiModelProperty(value = "备注")
  private String memo;
  @ApiModelProperty(value = "图片")
  private String picture;
}
