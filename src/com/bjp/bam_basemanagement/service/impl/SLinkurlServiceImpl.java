package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SContentService;
import com.bjp.bam_basemanagement.service.SLinkurlService;
import com.bjp.mapper.SContentMapper;
import com.bjp.mapper.SLinkurlMapper;
import com.bjp.pojo.SContent;
import com.bjp.pojo.SContentExample;
import com.bjp.pojo.SLinkurl;
import com.bjp.pojo.SLinkurlExample;
@Service
public class SLinkurlServiceImpl implements SLinkurlService {
	@Autowired
	SLinkurlMapper slinkurlMapper;
	@Override
	public List<SLinkurl> list() {
		SLinkurlExample example = new SLinkurlExample();
		example.setOrderByClause("id desc");
		return slinkurlMapper.selectByExample(example);
	}
	@Override
	public void add(SLinkurl record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SLinkurl record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int recordId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SLinkurl get(int recordId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SLinkurl> findSLinkurlListByWebsiteId(Integer websiteId) {
		SLinkurlExample example = new SLinkurlExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andWebsiteIdEqualTo(websiteId);
		return slinkurlMapper.selectByExample(example);
	}
	
	

}
