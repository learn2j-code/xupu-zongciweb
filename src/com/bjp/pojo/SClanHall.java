package com.bjp.pojo;

import java.util.Date;

public class SClanHall {
    /** ID主键*/
    private Integer id;

    /** 宗祠名称*/
    private String name;

    /** 堂号*/
    private String nameOfAHall;

    /** 地址*/
    private String address;

    /** 详细地址*/
    private String fulladdress;

    /** 坐标*/
    private String coordinate;

    /** 联系人*/
    private String contacts;

    /** 电话*/
    private String tel;

    /** 简介*/
    private String synopsis;

    /** 推荐*/
    private Integer recommend;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 删除标志*/
    private Integer delFlg;

    /** 地址的首字母*/
    private String def1;

    /** 祠堂简介*/
    private String introduction;

    /** */
    private String coverImage;

    /** 0:不保护，1：保护*/
    private Integer protectedFlag;

    /** 封面缩略图*/
    private String coverImageThumb;

    /** */
    private String def2;

    /** 姓氏*/
    private String surname;

    /** 审核状态（未提交：1；退回：2；已提交：3；已通过：4）；*/
    private Integer review;

    /** 作者-别名*/
    private String nickname;

    /** 详情*/
    private String details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNameOfAHall() {
        return nameOfAHall;
    }

    public void setNameOfAHall(String nameOfAHall) {
        this.nameOfAHall = nameOfAHall == null ? null : nameOfAHall.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress == null ? null : fulladdress.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
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

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public Integer getProtectedFlag() {
        return protectedFlag;
    }

    public void setProtectedFlag(Integer protectedFlag) {
        this.protectedFlag = protectedFlag;
    }

    public String getCoverImageThumb() {
        return coverImageThumb;
    }

    public void setCoverImageThumb(String coverImageThumb) {
        this.coverImageThumb = coverImageThumb == null ? null : coverImageThumb.trim();
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}