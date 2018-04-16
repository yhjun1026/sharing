package com.sharing.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class Store implements Serializable {
    private String uuid;

    private String code;

    private String name;

    private String licence;

    private Date lastupdtime;

    private String memo;

    private String upperuuid;

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

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence == null ? null : licence.trim();
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

    public String getUpperuuid() {
        return upperuuid;
    }

    public void setUpperuuid(String upperuuid) {
        this.upperuuid = upperuuid == null ? null : upperuuid.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}