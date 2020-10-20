package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.BbsComment;
import com.bjp.pojo.MVideoComment;

public interface MVideoCommentService {
	List<MVideoComment> list();
	void add(MVideoComment record);
	void update(MVideoComment record);
	void delete(int id);
	MVideoComment get(int id);
	
	List<MVideoComment> findVideoCommentListByVideoId(Integer id);
	
	void updateVideoAgreeNum(MVideoComment record);
	void updateVideoDisagreeNum(MVideoComment record);
	void bannedVideoComment(MVideoComment record);
}
