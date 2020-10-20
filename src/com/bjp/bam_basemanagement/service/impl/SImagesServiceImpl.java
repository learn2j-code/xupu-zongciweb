package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SImagesService;
import com.bjp.mapper.SImagesMapper;
import com.bjp.pojo.SImages;
import com.bjp.pojo.SImagesExample;
@Service
public class SImagesServiceImpl implements SImagesService {
	@Autowired
	SImagesMapper simagesMapper;
	@Override
	public List<SImages> list() {
		SImagesExample example = new SImagesExample();
		example.setOrderByClause("compositor desc");
		return simagesMapper.selectByExample(example);
	}
	@Override
	public void add(SImages record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SImages record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SImages get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SImages> findSImageListByClanHallId(Integer clanHallId) {
		SImagesExample example = new SImagesExample();
		example.setOrderByClause("compositor asc");
		example.createCriteria().andClanIdEqualTo(clanHallId);
		return simagesMapper.selectByExample(example);
	}
	
	
	

}
