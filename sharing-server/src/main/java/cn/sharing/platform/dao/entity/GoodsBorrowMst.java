package cn.sharing.platform.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsBorrowMst implements Serializable {
    private String uuid;

    private String billNumber;

    private String stat;

    private String borrower;

    private String mobile;

    private String address;

    private Date planBackTime;

    private Date realBackTime;

    private String borrowDealer;

    private Date borrowDealTime;

    private String backDealer;

    private Date backDealTime;

    private Date createTime;

    private Date lstUpdTime;

    private String memo;

    private String borrowPayUuid;

    private String backPayUuid;

    private String compensatePayUuid;

    private String storeUuid;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber == null ? null : billNumber.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
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

    public Date getPlanBackTime() {
        return planBackTime;
    }

    public void setPlanBackTime(Date planBackTime) {
        this.planBackTime = planBackTime;
    }

    public Date getRealBackTime() {
        return realBackTime;
    }

    public void setRealBackTime(Date realBackTime) {
        this.realBackTime = realBackTime;
    }

    public String getBorrowDealer() {
        return borrowDealer;
    }

    public void setBorrowDealer(String borrowDealer) {
        this.borrowDealer = borrowDealer == null ? null : borrowDealer.trim();
    }

    public Date getBorrowDealTime() {
        return borrowDealTime;
    }

    public void setBorrowDealTime(Date borrowDealTime) {
        this.borrowDealTime = borrowDealTime;
    }

    public String getBackDealer() {
        return backDealer;
    }

    public void setBackDealer(String backDealer) {
        this.backDealer = backDealer == null ? null : backDealer.trim();
    }

    public Date getBackDealTime() {
        return backDealTime;
    }

    public void setBackDealTime(Date backDealTime) {
        this.backDealTime = backDealTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLstUpdTime() {
        return lstUpdTime;
    }

    public void setLstUpdTime(Date lstUpdTime) {
        this.lstUpdTime = lstUpdTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getBorrowPayUuid() {
        return borrowPayUuid;
    }

    public void setBorrowPayUuid(String borrowPayUuid) {
        this.borrowPayUuid = borrowPayUuid == null ? null : borrowPayUuid.trim();
    }

    public String getBackPayUuid() {
        return backPayUuid;
    }

    public void setBackPayUuid(String backPayUuid) {
        this.backPayUuid = backPayUuid == null ? null : backPayUuid.trim();
    }

    public String getCompensatePayUuid() {
        return compensatePayUuid;
    }

    public void setCompensatePayUuid(String compensatePayUuid) {
        this.compensatePayUuid = compensatePayUuid == null ? null : compensatePayUuid.trim();
    }

    public String getStoreUuid() {
        return storeUuid;
    }

    public void setStoreUuid(String storeUuid) {
        this.storeUuid = storeUuid == null ? null : storeUuid.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}