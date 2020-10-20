package com.bjp.pojo;

import java.util.Date;

public class MVideoComment {
    /** */
    private Integer id;

    /** 评论者id*/
    private Integer userId;

    /** 评论者名字*/
    private String userName;

    /** 视频id*/
    private Integer videoId;

    /** 上一条评论id，默认为0：表示直接回复的主视频，如果为评论id：表示是回复的某一条评论*/
    private Integer parentId;

    /** 赞同*/
    private Integer agreeNum;

    /** 不赞同*/
    private Integer disagreeNum;

    /** 禁言标志，默认为0:表示不禁言，1为禁言*/
    private Integer bannedFlag;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** 评论内容*/
    private String commentContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(Integer agreeNum) {
        this.agreeNum = agreeNum;
    }

    public Integer getDisagreeNum() {
        return disagreeNum;
    }

    public void setDisagreeNum(Integer disagreeNum) {
        this.disagreeNum = disagreeNum;
    }

    public Integer getBannedFlag() {
        return bannedFlag;
    }

    public void setBannedFlag(Integer bannedFlag) {
        this.bannedFlag = bannedFlag;
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

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}