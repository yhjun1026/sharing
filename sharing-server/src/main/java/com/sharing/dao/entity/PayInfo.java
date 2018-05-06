package com.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayInfo implements Serializable {
    private String uuid;

    private String payid;

    private Integer transtype;

    private Integer paytype;

    private String tradeno;

    private String outtradeno;

    private BigDecimal payamt;

    private String payuser;

    private Date paytime;

    private String oritradeno;

    private String oriouttradeno;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Integer getTranstype() {
        return transtype;
    }

    public void setTranstype(Integer transtype) {
        this.transtype = transtype;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno == null ? null : tradeno.trim();
    }

    public String getOuttradeno() {
        return outtradeno;
    }

    public void setOuttradeno(String outtradeno) {
        this.outtradeno = outtradeno == null ? null : outtradeno.trim();
    }

    public BigDecimal getPayamt() {
        return payamt;
    }

    public void setPayamt(BigDecimal payamt) {
        this.payamt = payamt;
    }

    public String getPayuser() {
        return payuser;
    }

    public void setPayuser(String payuser) {
        this.payuser = payuser == null ? null : payuser.trim();
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getOritradeno() {
        return oritradeno;
    }

    public void setOritradeno(String oritradeno) {
        this.oritradeno = oritradeno == null ? null : oritradeno.trim();
    }

    public String getOriouttradeno() {
        return oriouttradeno;
    }

    public void setOriouttradeno(String oriouttradeno) {
        this.oriouttradeno = oriouttradeno == null ? null : oriouttradeno.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}