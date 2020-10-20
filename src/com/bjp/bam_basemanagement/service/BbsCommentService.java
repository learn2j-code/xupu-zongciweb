package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.BbsComment;

public interface BbsCommentService {
	List<BbsComment> list();
	void add(BbsComment record);
	void update(BbsComment record);
	void delete(int id);
	BbsComment get(int id);
	
	List<BbsComment> findAllBbsCommentList(Integer id);
	void updateAgreeNum(BbsComment record);
	void updateDisagreeNum(BbsComment record);
	void bannedComment(BbsComment record);
}
