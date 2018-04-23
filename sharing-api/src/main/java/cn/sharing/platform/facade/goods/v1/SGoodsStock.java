package cn.sharing.platform.facade.goods.v1;

import java.math.BigDecimal;

/**
 * 物品库存
 *
 * Created by guotao on 2018.01.18.
 */
public class SGoodsStock {
  private String uuid;
  private Integer direction;
  private BigDecimal qty;
  private String memo;
  /** 物品uuid */
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
  /** 物品调整方向 */
  public Integer getDirection() {
    return direction;
  }

  public void setDirection(Integer direction) {
    this.direction = direction;
  }
  /** 物品调整数量 */
  public BigDecimal getQty() {
    return qty;
  }

  public void setQty(BigDecimal qty) {
    this.qty = qty;
  }
  /** 物品调整说明 */
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}
