package cn.sharing.dao.entity;

import java.io.Serializable;

public class Stock implements Serializable {
  /** 序列化ID */
  private static final long serialVersionUID = 8703864469054619768L;
  /** uuid */
  private String uuid;

  /** 物品代码 */
  private String goodsCode;
  /** 物品编号 */
  private int no;
  /** 物品状态 */
  private int state;
  /** 物品说明 */
  private String memo;

  /** uuid */
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  /** 物品代码 */
  public String getGoodsCode() {
    return goodsCode;
  }

  public void setGoodsCode(String goodsCode) {
    this.goodsCode = goodsCode;
  }

  /** 物品编号 */
  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  /** 物品状态 */
  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  /** 物品说明 */
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}