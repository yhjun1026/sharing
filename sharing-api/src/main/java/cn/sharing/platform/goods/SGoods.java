package cn.sharing.platform.goods;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物品信息
 *
 * Created by guotao on 2018.01.18.
 */
public class SGoods {
  private String uuid;
  private String code;
  private String name;
  private String type;
  private Integer stat;
  private String picture;
  private String description;
  private BigDecimal price;
  private BigDecimal depositamt;
  private BigDecimal repayamt;
  private String laster;
  private Date lastupdtime;
  private String memo;
  private String storeuuid;

  /** 物品uuid */
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
  /** 物品代码 */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
  /** 物品名称 */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  /** 物品类型 */
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  /** 物品状态 */
  public Integer getStat() {
    return stat;
  }

  public void setStat(Integer stat) {
    this.stat = stat;
  }
  /** 图片 */
  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }
  /** 描述 */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  /** 单价 */
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
  /** 押金 */
  public BigDecimal getDepositamt() {
    return depositamt;
  }

  public void setDepositamt(BigDecimal depositamt) {
    this.depositamt = depositamt;
  }
  /** 偿还金额 */
  public BigDecimal getRepayamt() {
    return repayamt;
  }

  public void setRepayamt(BigDecimal repayamt) {
    this.repayamt = repayamt;
  }
  /** 最后修改人 */
  public String getLaster() {
    return laster;
  }

  public void setLaster(String laster) {
    this.laster = laster;
  }
  /** 最后修改时间 */
  public Date getLastupdtime() {
    return lastupdtime;
  }

  public void setLastupdtime(Date lastupdtime) {
    this.lastupdtime = lastupdtime;
  }
  /** 备注 */
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
  /** 组织uuid */
  public String getStoreuuid() {
    return storeuuid;
  }

  public void setStoreuuid(String storeuuid) {
    this.storeuuid = storeuuid;
  }
}
