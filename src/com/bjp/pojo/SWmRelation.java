package com.bjp.pojo;

public class SWmRelation {
    /** 主键ID*/
    private Integer id;

    /** 站点表主键*/
    private Integer websiteId;

    /** 模块表主键*/
    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}