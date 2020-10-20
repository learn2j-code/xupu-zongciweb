package com.bjp.bam_basemanagement.vo;

import java.util.Map;

import com.bjp.constant.CommonConstant;

public class ResponseEntity {
	private Map<String,Object> data;
	private int success=CommonConstant.RESPONSE_SUCCESS;
	private String errorMsg=null;
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
