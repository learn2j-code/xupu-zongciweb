package com.bjp.pojo;

import java.util.Date;

public class SEntry {
    /** 主键ID*/
    private Integer id;

    /** 模块ID*/
    private Integer moduleId;

    /** 站点ID*/
    private String websiteId;

    /** */
    private String websiteName;

    /** 本地地址*/
    private String imageUrl;

    /** FTP地址*/
    private String imageFtpurl;

    /** 标题*/
    private String title;

    /** 作者*/
    private String author;

    /** 来源*/
    private String source;

    /** 摘要*/
    private String articalAbstract;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 发布时间*/
    private Date releaseDate;

    /** 备注*/
    private String remarks;

    /** 删除标志*/
    private Integer delFlg;

    /** 是否发布1：是，0：否*/
    private Integer issue;

    /** 关键词*/
    private String keyword;

    /** 自定义字段*/
    private String def1;

    /** 自定义字段*/
    private String def2;

    /** 自定义字段*/
    private String def3;

    /** 审核状态（未提交：1；退回：2；已提交：3；已通过：4）；*/
    private Integer review;

    /** 文章作者-别名*/
    private String nickname;

    /** 缩略图*/
    private String thumbnail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId == null ? null : websiteId.trim();
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName == null ? null : websiteName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageFtpurl() {
        return imageFtpurl;
    }

    public void setImageFtpurl(String imageFtpurl) {
        this.imageFtpurl = imageFtpurl == null ? null : imageFtpurl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getArticalAbstract() {
        return articalAbstract;
    }

    public void setArticalAbstract(String articalAbstract) {
        this.articalAbstract = articalAbstract == null ? null : articalAbstract.trim();
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3 == null ? null : def3.trim();
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }
}