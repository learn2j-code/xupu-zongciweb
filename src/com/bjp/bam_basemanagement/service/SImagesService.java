package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SImages;

public interface SImagesService {
	List<SImages> list();
	void add(SImages record);
	void update(SImages record);
	void delete(int Id);
	SImages get(int Id);
	
	List<SImages> findSImageListByClanHallId(Integer clanHallId);
}
