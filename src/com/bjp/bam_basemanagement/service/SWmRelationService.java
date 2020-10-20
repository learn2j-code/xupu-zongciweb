package com.bjp.bam_basemanagement.service;

import java.util.List;
import com.bjp.pojo.SWebsite;
import com.bjp.pojo.SWmRelation;

public interface SWmRelationService {
	List<SWmRelation> list();
	void add(SWmRelation record);
	void update(SWmRelation record);
	void delete(int Id);
	SWmRelation get(int Id);
	
	List<SWmRelation> findModuleIdListByWebsiteId(Integer websiteId);
}
