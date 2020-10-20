package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.MVideoCommentService;
import com.bjp.mapper.MVideoCommentMapper;
import com.bjp.pojo.MVideoComment;
import com.bjp.pojo.MVideoCommentExample;
@Service
public class MVideoCommentServiceImpl implements MVideoCommentService {
	@Autowired
	MVideoCommentMapper mvideoCommentMapper;
	@Override
	public List<MVideoComment> list() {
		MVideoCommentExample example = new MVideoCommentExample();
		example.setOrderByClause("id asc");
		example.createCriteria();
		return mvideoCommentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void add(MVideoComment record) {
		mvideoCommentMapper.insertSelective(record);
	}

	@Override
	public void update(MVideoComment record) {
		mvideoCommentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mvideoCommentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MVideoComment get(int id) {
		return mvideoCommentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MVideoComment> findVideoCommentListByVideoId(Integer id) {
		MVideoCommentExample example = new MVideoCommentExample();
		example.setOrderByClause("id asc");
		example.createCriteria().andVideoIdEqualTo(id);
		return mvideoCommentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void updateVideoAgreeNum(MVideoComment record) {
		MVideoComment videoComment = get(record.getId());
		record.setAgreeNum(videoComment.getAgreeNum()+1);
		update(record);
	}

	@Override
	public void updateVideoDisagreeNum(MVideoComment record) {
		MVideoComment videoComment = get(record.getId());
		record.setDisagreeNum(videoComment.getDisagreeNum()+1);
		update(record);
	}

	@Override
	public void bannedVideoComment(MVideoComment record) {
		record.setBannedFlag(1);
		update(record);
	}

}
