package com.bjp.bam_basemanagement.service;

import java.util.List;
import com.bjp.pojo.SWebsite;

public interface SWebsiteService {
	List<SWebsite> list();
	void add(SWebsite record);
	void update(SWebsite record);
	void delete(int Id);
	SWebsite get(int Id);
	
	SWebsite findWebsiteByName(String name);
}
