package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SContent;

public interface SContentService {
	List<SContent> list();
	void add(SContent record);
	void update(SContent record);
	void delete(int recordId);
	SContent get(int recordId);
	
	SContent findArticalContentBySEntryId(Integer sentryd);
}
