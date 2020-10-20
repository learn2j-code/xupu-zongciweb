package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.BbsCommentService;
import com.bjp.mapper.BbsCommentMapper;
import com.bjp.pojo.BbsComment;
import com.bjp.pojo.BbsCommentExample;
@Service
public class BbsCommentServiceImpl implements BbsCommentService {
	@Autowired
	BbsCommentMapper bbsCommentMapper;
	@Override
	public List<BbsComment> list() {
		BbsCommentExample example = new BbsCommentExample();
		example.setOrderByClause("id asc");
		example.createCriteria();
		return bbsCommentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void add(BbsComment record) {
		bbsCommentMapper.insertSelective(record);
	}

	@Override
	public void update(BbsComment record) {
		bbsCommentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		bbsCommentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public BbsComment get(int id) {
		return bbsCommentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BbsComment> findAllBbsCommentList(Integer id) {
		BbsCommentExample example = new BbsCommentExample();
		example.setOrderByClause("id asc");
		example.createCriteria().andBbsIdEqualTo(id);
		return bbsCommentMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void updateAgreeNum(BbsComment record) {
		BbsComment bbsComment = get(record.getId());
		record.setAgreeNum(bbsComment.getAgreeNum()+1);
		update(record);
	}

	@Override
	public void updateDisagreeNum(BbsComment record) {
		BbsComment bbsComment = get(record.getId());
		record.setDisagreeNum(bbsComment.getDisagreeNum()+1);
		update(record);
	}

	@Override
	public void bannedComment(BbsComment record) {
		record.setBannedFlag(1);
		update(record);
	}
}
