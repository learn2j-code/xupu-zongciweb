package com.bjp.pojo;

import java.util.Date;

public class SUser {
    /** 主键ID*/
    private Integer id;

    /** 用户名*/
    private String username;

    /** 密文密码*/
    private String password;

    /** 用户类型1：管理员；2：普通用户*/
    private Integer userRole;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;

    /** 备注*/
    private String remarks;

    /** 删除标志*/
    private Integer delFlg;

    /** 第三方平台唯一识别号*/
    private String uniqId;

    /** 性别*/
    private Integer sex;

    /** 来源，qq、微博或微信*/
    private String loginFrom;

    /** 在第三方平台中的名称*/
    private String nickname;

    /** 身份证*/
    private String identityCard;

    /** 手机号*/
    private Integer phoneNum;

    /** 在线标志，0不在线，1在线*/
    private Integer onlineFlag;

    /** 头像图片地址*/
    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
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

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId == null ? null : uniqId.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(String loginFrom) {
        this.loginFrom = loginFrom == null ? null : loginFrom.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getOnlineFlag() {
        return onlineFlag;
    }

    public void setOnlineFlag(Integer onlineFlag) {
        this.onlineFlag = onlineFlag;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}