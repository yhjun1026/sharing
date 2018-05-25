package cn.sharing.platform.facade.goods.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 物品库存
 * <p>
 * Created by guotao on 2018.01.18.
 */
@Data
@ApiModel(description = "租用单物品归还对象")
public class SGoodsStock {
  /** UUID */
  @ApiModelProperty(value = "物品库存UUID")
  private String uuid;
  /** 物品UUID */
  @ApiModelProperty(value = "物品UUID")
  private String goodsUuid;
  /** 商品编号 */
  @ApiModelProperty(value = "商品编号")
  private int no;
  /** 商品状态，精确到每一个的状态，取值 0表示可用，1表示已预定，2表示已租用，3表示已损坏，4表示已遗失 */
  @ApiModelProperty(value = "商品状态，精确到每一个的状态，取值 0表示可用，1表示已预定，2表示已租用，3表示已损坏，4表示已遗失 ")
  private int state;
  /** 备注 */
  @ApiModelProperty(value = "state")
  private String memo;
  /** 乐观锁 */
  @ApiModelProperty(value = "乐观锁")
  private int lockVersion;

}
