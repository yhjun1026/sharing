package com.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsBorrowDtl implements Serializable {
    private String uuid;

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

    private String borrowuuid;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid == null ? null : goodsuuid.trim();
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode == null ? null : goodscode.trim();
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public BigDecimal getBorrowqty() {
        return borrowqty;
    }

    public void setBorrowqty(BigDecimal borrowqty) {
        this.borrowqty = borrowqty;
    }

    public String getBorrowdescrip() {
        return borrowdescrip;
    }

    public void setBorrowdescrip(String borrowdescrip) {
        this.borrowdescrip = borrowdescrip == null ? null : borrowdescrip.trim();
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
        this.returndescrip = returndescrip == null ? null : returndescrip.trim();
    }

    public BigDecimal getBackqty() {
        return backqty;
    }

    public void setBackqty(BigDecimal backqty) {
        this.backqty = backqty;
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
        this.memo = memo == null ? null : memo.trim();
    }

    public String getBorrowuuid() {
        return borrowuuid;
    }

    public void setBorrowuuid(String borrowuuid) {
        this.borrowuuid = borrowuuid == null ? null : borrowuuid.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}