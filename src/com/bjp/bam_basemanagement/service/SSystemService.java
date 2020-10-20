package com.bjp.bam_basemanagement.service;

import java.util.List;
import com.bjp.pojo.SSystem;

public interface SSystemService {
	List<SSystem> list();
	void add(SSystem record);
	void update(SSystem record);
	void delete(int Id);
	SSystem get(int Id);
	
	SSystem findSystemByWebsiteId(Integer websiteId);
}
