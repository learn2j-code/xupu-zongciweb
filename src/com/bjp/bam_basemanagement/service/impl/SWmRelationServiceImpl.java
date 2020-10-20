package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SWmRelationService;
import com.bjp.mapper.SWmRelationMapper;
import com.bjp.pojo.SWmRelation;
import com.bjp.pojo.SWmRelationExample;
@Service
public class SWmRelationServiceImpl implements SWmRelationService {
	@Autowired
	SWmRelationMapper swmRelationMapper;
	@Override
	public List<SWmRelation> list() {
		SWmRelationExample example = new SWmRelationExample();
		example.setOrderByClause("id desc");
		return swmRelationMapper.selectByExample(example);
	}

	@Override
	public void add(SWmRelation record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SWmRelation record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SWmRelation get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SWmRelation> findModuleIdListByWebsiteId(Integer websiteId) {
		SWmRelationExample example = new SWmRelationExample();
		example.setOrderByClause("id asc");
		example.createCriteria().andWebsiteIdEqualTo(websiteId);
		return swmRelationMapper.selectByExample(example);
	}
}
