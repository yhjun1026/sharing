package com.sharing.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class GoodsBorrowMst implements Serializable {
    private String uuid;

    private String billNumber;

    private String stat;

    private String borrowType;

    private String borrower;

    private String mobile;

    private String address;

    private Date planReturnTime;

    private Date realReturnTime;

    private String borrowOperator;

    private Date borrowOperateTime;

    private String returnOperator;

    private Date returnOperateTime;

    private Date createTime;

    private Date lstUpdTime;

    private String memo;

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

    public String getBorrowType() {
        return borrowType;
    }

    public void setBorrowType(String borrowType) {
        this.borrowType = borrowType == null ? null : borrowType.trim();
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

    public Date getPlanReturnTime() {
        return planReturnTime;
    }

    public void setPlanReturnTime(Date planReturnTime) {
        this.planReturnTime = planReturnTime;
    }

    public Date getRealReturnTime() {
        return realReturnTime;
    }

    public void setRealReturnTime(Date realReturnTime) {
        this.realReturnTime = realReturnTime;
    }

    public String getBorrowOperator() {
        return borrowOperator;
    }

    public void setBorrowOperator(String borrowOperator) {
        this.borrowOperator = borrowOperator == null ? null : borrowOperator.trim();
    }

    public Date getBorrowOperateTime() {
        return borrowOperateTime;
    }

    public void setBorrowOperateTime(Date borrowOperateTime) {
        this.borrowOperateTime = borrowOperateTime;
    }

    public String getReturnOperator() {
        return returnOperator;
    }

    public void setReturnOperator(String returnOperator) {
        this.returnOperator = returnOperator == null ? null : returnOperator.trim();
    }

    public Date getReturnOperateTime() {
        return returnOperateTime;
    }

    public void setReturnOperateTime(Date returnOperateTime) {
        this.returnOperateTime = returnOperateTime;
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