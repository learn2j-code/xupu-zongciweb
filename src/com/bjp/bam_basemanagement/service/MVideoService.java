package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.MVideo;

public interface MVideoService {
	List<MVideo> list();
	void add(MVideo record);
	void update(MVideo record);
	void delete(int id);
	MVideo get(int id);
	
	List<MVideo> findAllMVideoList();
	void updateVideoViewNum(MVideo record);
}
