package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SEntry;

public interface SClanHallService {
	List<SClanHall> list();
	void add(SClanHall record);
	void update(SClanHall record);
	void delete(int id);
	SClanHall get(int id);
	
	List<SClanHall> findClanHallListByRecommendFlag(Integer recommend);
	List<SClanHall> findClanHallByAddress(String address, String name);
	
	List<SClanHall> findNewClanHallList();
	
	//根據字母查列表
	List<SClanHall> findSClanHallListByPYNotNone(String alpha);
	List<SClanHall> findSClanHallListByPYIsNone();
	
	//根據姓氏字母查列表
	List<SClanHall> findSClanHallListBySurnamePYNotNone(String alpha);
	List<SClanHall> findSClanHallListBySurnamePYIsNone();
	
	//根據姓氏查列表
	List<SClanHall> findSClanHallListBySurname(String surname);
}


