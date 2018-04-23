package cn.sharing.platform.facade.goods.v1;

import java.util.Date;
import java.util.List;

/**
 *  物品借用单汇总
 *
 * Created by guotao on 2018.01.20.
 */
public class SGoodsBorrow {
  private String uuid;

  private String billnumber;

  private String stat;

  private String borrowertype;

  private String borrower;

  private String mobile;

  private String address;

  private Date returntime;

  private Date realreturntime;

  private String filler;

  private Date fildate;

  private String laster;

  private Date lastupdtime;

  private String memo;

  private String storeuuid;

  private List<SGoodsBorrowDtl> sGoodsBorrowDtl;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getBillnumber() {
    return billnumber;
  }

  public void setBillnumber(String billnumber) {
    this.billnumber = billnumber;
  }

  public String getStat() {
    return stat;
  }

  public void setStat(String stat) {
    this.stat = stat;
  }

  public String getBorrowertype() {
    return borrowertype;
  }

  public void setBorrowertype(String borrowertype) {
    this.borrowertype = borrowertype;
  }

  public String getBorrower() {
    return borrower;
  }

  public void setBorrower(String borrower) {
    this.borrower = borrower;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getReturntime() {
    return returntime;
  }

  public void setReturntime(Date returntime) {
    this.returntime = returntime;
  }

  public Date getRealreturntime() {
    return realreturntime;
  }

  public void setRealreturntime(Date realreturntime) {
    this.realreturntime = realreturntime;
  }

  public String getFiller() {
    return filler;
  }

  public void setFiller(String filler) {
    this.filler = filler;
  }

  public Date getFildate() {
    return fildate;
  }

  public void setFildate(Date fildate) {
    this.fildate = fildate;
  }

  public String getLaster() {
    return laster;
  }

  public void setLaster(String laster) {
    this.laster = laster;
  }

  public Date getLastupdtime() {
    return lastupdtime;
  }

  public void setLastupdtime(Date lastupdtime) {
    this.lastupdtime = lastupdtime;
  }

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getStoreuuid() {
    return storeuuid;
  }

  public void setStoreuuid(String storeuuid) {
    this.storeuuid = storeuuid;
  }

  public List<SGoodsBorrowDtl> getsGoodsBorrowDtl() {
    return sGoodsBorrowDtl;
  }

  public void setsGoodsBorrowDtl(List<SGoodsBorrowDtl> sGoodsBorrowDtl) {
    this.sGoodsBorrowDtl = sGoodsBorrowDtl;
  }
}
