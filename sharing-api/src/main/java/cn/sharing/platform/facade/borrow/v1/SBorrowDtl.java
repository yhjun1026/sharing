package cn.sharing.platform.facade.borrow.v1;

import java.math.BigDecimal;

/**
 * 物品借用明细
 *
 * Created by guotao on 2018.01.20.
 */
public class SBorrowDtl {

  private String goodsuuid;

  private String goodscode;

  private String goodsname;

  private BigDecimal borrowqty;

  private String borrowdescrip;

  private BigDecimal depositamt;

  private Integer damaged;

  private String returndescrip;

  private BigDecimal backqty;

  private BigDecimal payamt;

  private BigDecimal backdepositamt;

  private String memo;

  public String getGoodsuuid() {
    return goodsuuid;
  }

  public void setGoodsuuid(String goodsuuid) {
    this.goodsuuid = goodsuuid;
  }

  public String getGoodscode() {
    return goodscode;
  }

  public void setGoodscode(String goodscode) {
    this.goodscode = goodscode;
  }

  public String getGoodsname() {
    return goodsname;
  }

  public void setGoodsname(String goodsname) {
    this.goodsname = goodsname;
  }

  public String getBorrowdescrip() {
    return borrowdescrip;
  }

  public void setBorrowdescrip(String borrowdescrip) {
    this.borrowdescrip = borrowdescrip;
  }

  public BigDecimal getDepositamt() {
    return depositamt;
  }

  public void setDepositamt(BigDecimal depositamt) {
    this.depositamt = depositamt;
  }

  public Integer getDamaged() {
    return damaged;
  }

  public void setDamaged(Integer damaged) {
    this.damaged = damaged;
  }

  public String getReturndescrip() {
    return returndescrip;
  }

  public void setReturndescrip(String returndescrip) {
    this.returndescrip = returndescrip;
  }

  public BigDecimal getPayamt() {
    return payamt;
  }

  public void setPayamt(BigDecimal payamt) {
    this.payamt = payamt;
  }

  public BigDecimal getBackdepositamt() {
    return backdepositamt;
  }

  public void setBackdepositamt(BigDecimal backdepositamt) {
    this.backdepositamt = backdepositamt;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public BigDecimal getBorrowqty() {
    return borrowqty;
  }

  public void setBorrowqty(BigDecimal borrowqty) {
    this.borrowqty = borrowqty;
  }

  public BigDecimal getBackqty() {
    return backqty;
  }

  public void setBackqty(BigDecimal backqty) {
    this.backqty = backqty;
  }
}
