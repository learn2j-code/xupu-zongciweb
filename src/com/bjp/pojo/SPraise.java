package com.bjp.pojo;

import java.util.Date;

public class SPraise {
    /** 主键ID*/
    private Integer id;

    /** 记录表ID*/
    private Integer entryId;

    /** ip地址*/
    private String ipAddress;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 点赞标记*/
    private Integer praiseFlg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
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

    public Integer getPraiseFlg() {
        return praiseFlg;
    }

    public void setPraiseFlg(Integer praiseFlg) {
        this.praiseFlg = praiseFlg;
    }
}