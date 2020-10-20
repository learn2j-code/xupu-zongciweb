package com.bjp.bam_xupumanagement.vo;

import java.util.List;

import com.bjp.pojo.SLinkurl;
import com.bjp.pojo.SModule;
import com.bjp.pojo.SSystem;
import com.bjp.pojo.SWebsite;
import com.bjp.pojo.SWmRelation;
import com.bjp.util.Page;

public class WebInfo {
	private Page page;
	private Integer websiteId;
	private Integer moduleId;
	
	private String website;
	
	private SSystem ssystem;
	
	private SWebsite swebsite;
	
	private Integer bjxModuleId;
	private Integer xszxModuleId;
	private Integer xzzxModuleId;
	
	private Integer zczxModuleId;
	
	private List<SWmRelation> swmRelationList;

	private List<SLinkurl> slinkurlList;
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public SSystem getSsystem() {
		return ssystem;
	}

	public void setSsystem(SSystem ssystem) {
		this.ssystem = ssystem;
	}
	
	public List<SWmRelation> getSwmRelationList() {
		return swmRelationList;
	}

	public void setSwmRelationList(List<SWmRelation> swmRelationList) {
		this.swmRelationList = swmRelationList;
	}

	public List<SLinkurl> getSlinkurlList() {
		return slinkurlList;
	}

	public void setSlinkurlList(List<SLinkurl> slinkurlList) {
		this.slinkurlList = slinkurlList;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public SWebsite getSwebsite() {
		return swebsite;
	}

	public void setSwebsite(SWebsite swebsite) {
		this.swebsite = swebsite;
	}

	public Integer getBjxModuleId() {
		return bjxModuleId;
	}

	public void setBjxModuleId(Integer bjxModuleId) {
		this.bjxModuleId = bjxModuleId;
	}

	public Integer getXszxModuleId() {
		return xszxModuleId;
	}

	public void setXszxModuleId(Integer xszxModuleId) {
		this.xszxModuleId = xszxModuleId;
	}

	public Integer getXzzxModuleId() {
		return xzzxModuleId;
	}

	public void setXzzxModuleId(Integer xzzxModuleId) {
		this.xzzxModuleId = xzzxModuleId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(Integer websiteId) {
		this.websiteId = websiteId;
	}

	public Integer getZczxModuleId() {
		return zczxModuleId;
	}

	public void setZczxModuleId(Integer zczxModuleId) {
		this.zczxModuleId = zczxModuleId;
	}

}
