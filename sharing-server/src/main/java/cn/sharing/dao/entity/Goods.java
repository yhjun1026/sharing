package cn.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goods implements Serializable {

  /** 序列化ID */
  private static final long serialVersionUID = 5198509064679750131L;
  /** uuid */
  private String uuid;
  /** 物品代码 */
  private String code;
  /** 物品名称 */
  private String name;
  /** 物品类型 */
  private String type;
  /** 物品状态 */
  private Integer state;
  /** 物品数量 */
  private int quantity;
  /** 物品库存数量 */
  private int stockQuantity;
  /** 物品图片 */
  private String picture;
  /** 物品描述 */
  private String description;
  /** 单价 */
  private BigDecimal price;
  /** 押金价格 */
  private BigDecimal depositamt;
  /** 赔偿价格 */
  private BigDecimal repayamt;
  /** 成本价格 */
  private BigDecimal costPrice;
  /** 租用价格 */
  private BigDecimal rentPrice;
  /** 修改人 */
  private String laster;
  /** 修改时间 */
  private Date lastupdtime;
  /** 说明 */
  private String memo;
  /** 门店ID */
  private String storeuuid;

  /** uuid */
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
  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  /** 物品数量 */
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /** 物品库存数量 */
  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  /** 物品图片 */
  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  /** 物品描述 */
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

  /** 押金价格 */
  public BigDecimal getDepositamt() {
    return depositamt;
  }

  public void setDepositamt(BigDecimal depositamt) {
    this.depositamt = depositamt;
  }

  /** 赔偿价格 */
  public BigDecimal getRepayamt() {
    return repayamt;
  }

  public void setRepayamt(BigDecimal repayamt) {
    this.repayamt = repayamt;
  }

  /** 成本价格 */
  public BigDecimal getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(BigDecimal costPrice) {
    this.costPrice = costPrice;
  }

  /** 租用价格 */
  public BigDecimal getRentPrice() {
    return rentPrice;
  }

  public void setRentPrice(BigDecimal rentPrice) {
    this.rentPrice = rentPrice;
  }

  /** 修改人 */
  public String getLaster() {
    return laster;
  }

  public void setLaster(String laster) {
    this.laster = laster;
  }

  /** 修改时间 */
  public Date getLastupdtime() {
    return lastupdtime;
  }

  public void setLastupdtime(Date lastupdtime) {
    this.lastupdtime = lastupdtime;
  }

  /** 说明 */
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  /** 门店ID */
  public String getStoreUuid() {
    return storeuuid;
  }

  public void setStoreUuid(String storeUuid) {
    this.storeuuid = storeUuid;
  }
}