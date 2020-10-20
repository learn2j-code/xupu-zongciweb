package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SSystemService;
import com.bjp.mapper.SSystemMapper;
import com.bjp.pojo.SSystem;
import com.bjp.pojo.SSystemExample;
@Service
public class SSystemServiceImpl implements SSystemService {
	@Autowired
	SSystemMapper ssystemMapper;
	@Override
	public List<SSystem> list() {
		SSystemExample example = new SSystemExample();
		example.setOrderByClause("id desc");
		return ssystemMapper.selectByExample(example);
	}
	@Override
	public void add(SSystem record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SSystem record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SSystem get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SSystem findSystemByWebsiteId(Integer websiteId) {
		SSystemExample example = new SSystemExample();
		example.setOrderByClause("id desc");
		List<SSystem> ssystemList = ssystemMapper.selectByExample(example);
		return ssystemList.size()>0?ssystemList.get(0):null;
	}
}
