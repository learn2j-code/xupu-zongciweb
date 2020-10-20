package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SWebsiteService;
import com.bjp.mapper.SWebsiteMapper;
import com.bjp.pojo.SWebsite;
import com.bjp.pojo.SWebsiteExample;
@Service
public class SWebsiteServiceImpl implements SWebsiteService {
	@Autowired
	SWebsiteMapper swebsiteMapper;
	@Override
	public List<SWebsite> list() {
		SWebsiteExample example = new SWebsiteExample();
		example.setOrderByClause("id desc");
		return swebsiteMapper.selectByExample(example);
	}
	@Override
	public void add(SWebsite record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SWebsite record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SWebsite get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SWebsite findWebsiteByName(String name) {
		SWebsiteExample example = new SWebsiteExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andWebsiteEqualTo(name);
		List<SWebsite> websiteList = swebsiteMapper.selectByExample(example);
		return websiteList.size()>0?websiteList.get(0):null;
	}
}
