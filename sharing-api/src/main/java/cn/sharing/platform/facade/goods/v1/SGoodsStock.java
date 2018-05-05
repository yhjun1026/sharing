package cn.sharing.platform.facade.goods.v1;

import lombok.Data;

/**
 * 物品库存
 * <p>
 * Created by guotao on 2018.01.18.
 */
@Data
public class SGoodsStock {
  /** UUID */
  private String uuid;
  /** 商品编号 */
  private int no;
  /** 商品状态，精确到每一个的状态，取值 0表示可用，1表示已预定，2表示已租用，3表示已损坏，4表示已遗失 */
  private int state;
  /** 备注 */
  private String memo;

}
