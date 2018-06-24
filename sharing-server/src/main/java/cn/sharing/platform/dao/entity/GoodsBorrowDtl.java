package cn.sharing.platform.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsBorrowDtl implements Serializable {
    private String uuid;

    private String goodsUuid;

    private String goodsCode;

    private String goodsName;

    private BigDecimal goodsPrice;

    private BigDecimal compensateAmt;

    private String borrowDescrip;

    private BigDecimal depositAmt;

    private String returnDescrip;

    private String borrowUuid;

    private String memo;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getGoodsUuid() {
        return goodsUuid;
    }

    public void setGoodsUuid(String goodsUuid) {
        this.goodsUuid = goodsUuid == null ? null : goodsUuid.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getCompensateAmt() {
        return compensateAmt;
    }

    public void setCompensateAmt(BigDecimal compensateAmt) {
        this.compensateAmt = compensateAmt;
    }

    public String getBorrowDescrip() {
        return borrowDescrip;
    }

    public void setBorrowDescrip(String borrowDescrip) {
        this.borrowDescrip = borrowDescrip == null ? null : borrowDescrip.trim();
    }

    public BigDecimal getDepositAmt() {
        return depositAmt;
    }

    public void setDepositAmt(BigDecimal depositAmt) {
        this.depositAmt = depositAmt;
    }

    public String getReturnDescrip() {
        return returnDescrip;
    }

    public void setReturnDescrip(String returnDescrip) {
        this.returnDescrip = returnDescrip == null ? null : returnDescrip.trim();
    }

    public String getBorrowUuid() {
        return borrowUuid;
    }

    public void setBorrowUuid(String borrowUuid) {
        this.borrowUuid = borrowUuid == null ? null : borrowUuid.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}