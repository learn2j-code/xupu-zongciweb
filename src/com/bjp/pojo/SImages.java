package com.bjp.pojo;

public class SImages {
    /** */
    private Integer id;

    /** 宗祠ID*/
    private Integer clanId;

    /** 顺序*/
    private Integer compositor;

    /** 本地地址*/
    private String imageUrl;

    /** FTP地址*/
    private String imageFtpurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClanId() {
        return clanId;
    }

    public void setClanId(Integer clanId) {
        this.clanId = clanId;
    }

    public Integer getCompositor() {
        return compositor;
    }

    public void setCompositor(Integer compositor) {
        this.compositor = compositor;
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
}