package com.bjp.bam_basemanagement.vo;

import com.bjp.util.Page;

public class RequestEntity {
	private Page page;
	private int typeId;
	private int id;//帖子id 或视频id
	private String surname;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
