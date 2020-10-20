package com.bjp.bam_basemanagement.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SContentService;
import com.bjp.mapper.SContentMapper;
import com.bjp.pojo.SContent;
import com.bjp.pojo.SContentExample;
import com.bjp.pojo.SEntryExample;
@Service
public class SContentServiceImpl implements SContentService {
	@Autowired
	SContentMapper scontentMapper;
	@Override
	public List<SContent> list() {
		SContentExample example = new SContentExample();
		example.setOrderByClause("id desc");
		return scontentMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public void add(SContent record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SContent record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int recordId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SContent get(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SContent findArticalContentBySEntryId(Integer sentryd) {
		SContentExample example = new SContentExample();
		example.createCriteria().andEntryIdEqualTo(sentryd);
		List<SContent> scontentList = scontentMapper.selectByExampleWithBLOBs(example);
		return scontentList.size()>0?scontentList.get(0):null;
	}
	

}
