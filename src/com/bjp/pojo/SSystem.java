package com.bjp.pojo;

import java.util.Date;

public class SSystem {
    /** 主键ID*/
    private Integer id;

    /** 站点ID*/
    private Integer websiteId;

    /** 关键词*/
    private String keyword;

    /** 摘要*/
    private String websiteAbstract;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 备注*/
    private String remarks;

    /** 删除标志*/
    private Integer delFlg;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getWebsiteAbstract() {
        return websiteAbstract;
    }

    public void setWebsiteAbstract(String websiteAbstract) {
        this.websiteAbstract = websiteAbstract == null ? null : websiteAbstract.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }
}