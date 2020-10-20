package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SLinkurl;

public interface SLinkurlService {
	List<SLinkurl> list();
	void add(SLinkurl record);
	void update(SLinkurl record);
	void delete(int recordId);
	SLinkurl get(int recordId);
	
	List<SLinkurl> findSLinkurlListByWebsiteId(Integer websiteId);
}
