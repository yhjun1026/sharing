package cn.sharing.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class SharingMenu implements Serializable {
    private Integer id;

    private String code;

    private String name;

    private Integer parentId;

    private String showSep;

    private Date createtime;

    private String router;

    private String icon;

    private static final long serialVersionUID = 1L;

    private String updateSql;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getShowSep() {
        return showSep;
    }

    public void setShowSep(String showSep) {
        this.showSep = showSep == null ? null : showSep.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router == null ? null : router.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUpdateSql() {
        return this.updateSql;
    }

    public void setUpdateSql(String updateSql) {
        this.updateSql = updateSql;
    }
}