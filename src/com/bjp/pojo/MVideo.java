package com.bjp.pojo;

import java.util.Date;

public class MVideo {
    /** */
    private Integer id;

    /** */
    private String videoTitle;

    /** */
    private String keywords;

    /** */
    private String videoAddress;

    /** */
    private Integer viewNum;

    /** */
    private Date createTime;

    /** */
    private Date updateTime;

    /** 视频简介*/
    private String videoIntro;

    /** */
    private String videoDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress == null ? null : videoAddress.trim();
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
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

    public String getVideoIntro() {
        return videoIntro;
    }

    public void setVideoIntro(String videoIntro) {
        this.videoIntro = videoIntro == null ? null : videoIntro.trim();
    }

    public String getVideoDetail() {
        return videoDetail;
    }

    public void setVideoDetail(String videoDetail) {
        this.videoDetail = videoDetail == null ? null : videoDetail.trim();
    }
}