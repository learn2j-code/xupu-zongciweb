package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.BbsTypeService;
import com.bjp.mapper.BbsTypeMapper;
import com.bjp.pojo.BbsType;
import com.bjp.pojo.BbsTypeExample;
@Service
public class BbsTypeServiceImpl implements BbsTypeService {
	@Autowired
	BbsTypeMapper bbsTypeMapper;
	@Override
	public List<BbsType> list() {
		BbsTypeExample example = new BbsTypeExample();
		example.setOrderByClause("id asc");
		example.createCriteria();
		return bbsTypeMapper.selectByExample(example);
	}

	@Override
	public void add(BbsType record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BbsType record) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public BbsType get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
