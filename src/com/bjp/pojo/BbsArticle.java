package com.bjp.pojo;

import java.util.Date;

public class BbsArticle {
    /** */
    private Integer id;

    /** 标题*/
    private String bbsTitle;

    /** fk，主题类型id*/
    private Integer typeId;

    /** 主题类型名称*/
    private String typeName;

    /** 置顶标志，默认0不置顶，1为置顶*/
    private Integer stickFlag;

    /** 精华标志，默认0不精华，1为精华*/
    private Integer bestFlag;

    /** 作者id*/
    private Integer userId;

    /** 作者*/
    private String userName;

    /** 匿名标志，默认0不匿名，1为匿名*/
    private Integer nymFlag;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** 浏览量*/
    private Integer viewNum;

    /** 帖子内容*/
    private String bbsContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBbsTitle() {
        return bbsTitle;
    }

    public void setBbsTitle(String bbsTitle) {
        this.bbsTitle = bbsTitle == null ? null : bbsTitle.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getStickFlag() {
        return stickFlag;
    }

    public void setStickFlag(Integer stickFlag) {
        this.stickFlag = stickFlag;
    }

    public Integer getBestFlag() {
        return bestFlag;
    }

    public void setBestFlag(Integer bestFlag) {
        this.bestFlag = bestFlag;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getNymFlag() {
        return nymFlag;
    }

    public void setNymFlag(Integer nymFlag) {
        this.nymFlag = nymFlag;
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

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public String getBbsContent() {
        return bbsContent;
    }

    public void setBbsContent(String bbsContent) {
        this.bbsContent = bbsContent == null ? null : bbsContent.trim();
    }
}