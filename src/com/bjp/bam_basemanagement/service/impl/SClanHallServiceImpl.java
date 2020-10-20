package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.bjp.bam_basemanagement.service.SClanHallService;
import com.bjp.mapper.SClanHallMapper;
import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SClanHallExample;
import com.bjp.pojo.SClanHallExample.Criteria;
import com.bjp.pojo.SEntry;
@Service
public class SClanHallServiceImpl implements SClanHallService {
	@Autowired
	SClanHallMapper sclanHallMapper;
	@Override
	public List<SClanHall> list() {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andDelFlgEqualTo(0).andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public void add(SClanHall record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SClanHall record) {
		sclanHallMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SClanHall get(int id) {
		// TODO Auto-generated method stub
		return sclanHallMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<SClanHall> findClanHallListByRecommendFlag(Integer recommend) {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("update_time desc");
		example.createCriteria().andRecommendEqualTo(1).andDelFlgEqualTo(0).andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public List<SClanHall> findClanHallByAddress(String address, String name) {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("update_time desc");
		Criteria criteria = example.createCriteria();
		criteria.andDelFlgEqualTo(0).andReviewEqualTo(4);
		if(!StringUtils.isEmpty(address)){
			criteria.andAddressLike("%"+address+"%");
		}
		if(!StringUtils.isEmpty(name)){
			criteria.andNameLike("%"+name+"%");
		}
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public List<SClanHall> findNewClanHallList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SClanHall> findSClanHallListByPYNotNone(String alpha) {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("address desc");
		example.createCriteria().andDelFlgEqualTo(0).andDef1EqualTo(alpha).andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public List<SClanHall> findSClanHallListByPYIsNone() {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andDelFlgEqualTo(0).andDef1IsNull().andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	
	@Override
	public List<SClanHall> findSClanHallListBySurnamePYNotNone(String alpha) {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("surname asc");
		example.createCriteria().andDelFlgEqualTo(0).andDef2EqualTo(alpha).andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public List<SClanHall> findSClanHallListBySurnamePYIsNone() {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andDelFlgEqualTo(0).andDef2IsNull().andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
	@Override
	public List<SClanHall> findSClanHallListBySurname(String surname) {
		SClanHallExample example = new SClanHallExample();
		example.setOrderByClause("surname asc");
//		example.createCriteria().andDelFlgEqualTo(0).andNameLike("%"+surname+"%").andReviewEqualTo(4);
		example.createCriteria().andDelFlgEqualTo(0).andSurnameEqualTo(surname).andReviewEqualTo(4);
		return sclanHallMapper.selectByExample(example);
	}
}
