package cn.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Stock implements Serializable {
    private String uuid;

    private BigDecimal inv;

    private BigDecimal qty;

    private BigDecimal useqty;

    private Date lastupdtime;

    private String memo;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public BigDecimal getInv() {
        return inv;
    }

    public void setInv(BigDecimal inv) {
        this.inv = inv;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getUseqty() {
        return useqty;
    }

    public void setUseqty(BigDecimal useqty) {
        this.useqty = useqty;
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

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}