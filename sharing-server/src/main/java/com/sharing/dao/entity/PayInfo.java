package com.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayInfo implements Serializable {
    private String uuid;

    private String payId;

    private Integer transType;

    private Integer payType;

    private String tradeNo;

    private String outTradeNo;

    private BigDecimal payAmt;

    private String payUser;

    private Date payTime;

    private String oriTradeNo;

    private String oriOutTradeNo;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public BigDecimal getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser == null ? null : payUser.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOriTradeNo() {
        return oriTradeNo;
    }

    public void setOriTradeNo(String oriTradeNo) {
        this.oriTradeNo = oriTradeNo == null ? null : oriTradeNo.trim();
    }

    public String getOriOutTradeNo() {
        return oriOutTradeNo;
    }

    public void setOriOutTradeNo(String oriOutTradeNo) {
        this.oriOutTradeNo = oriOutTradeNo == null ? null : oriOutTradeNo.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}