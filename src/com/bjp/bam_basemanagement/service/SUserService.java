package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SUser;

public interface SUserService {
	List<SUser> list();
	void add(SUser record);
	void update(SUser record);
	void delete(int id);
	SUser get(int id);
	
	Integer login(SUser record);
	List<SUser> findUserByUniqId(String uniqId);
}
