package cn.sharing.dao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Goods implements Serializable {
    private String uuid;

    private String code;

    private String name;

    private String type;

    private Integer stat;

    private String picture;

    private String description;

    private BigDecimal price;

    private BigDecimal depositamt;

    private BigDecimal repayamt;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDepositamt() {
        return depositamt;
    }

    public void setDepositamt(BigDecimal depositamt) {
        this.depositamt = depositamt;
    }

    public BigDecimal getRepayamt() {
        return repayamt;
    }

    public void setRepayamt(BigDecimal repayamt) {
        this.repayamt = repayamt;
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