package com.sharing.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsBorrowMst implements Serializable {
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

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getBillnumber() {
        return billnumber;
    }

    public void setBillnumber(String billnumber) {
        this.billnumber = billnumber == null ? null : billnumber.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getBorrowertype() {
        return borrowertype;
    }

    public void setBorrowertype(String borrowertype) {
        this.borrowertype = borrowertype == null ? null : borrowertype.trim();
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower == null ? null : borrower.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
        this.filler = filler == null ? null : filler.trim();
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
        this.laster = laster == null ? null : laster.trim();
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
        this.memo = memo == null ? null : memo.trim();
    }

    public String getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(String storeuuid) {
        this.storeuuid = storeuuid == null ? null : storeuuid.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}