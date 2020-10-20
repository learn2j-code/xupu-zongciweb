package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SModuleService;
import com.bjp.mapper.SModuleMapper;
import com.bjp.pojo.SModule;
import com.bjp.pojo.SModuleExample;
@Service
public class SModuleServiceImpl implements SModuleService {
	@Autowired
	SModuleMapper smoduleMapper;
	@Override
	public List<SModule> list() {
		SModuleExample example = new SModuleExample();
		example.setOrderByClause("id desc");
		return smoduleMapper.selectByExample(example);
	}
	@Override
	public void add(SModule record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SModule record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public SModule get(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SModule findSModuleByName(String moduleName) {
		SModuleExample example = new SModuleExample();
		example.createCriteria().andModuleNameEqualTo(moduleName);
		List<SModule> smoduleList = smoduleMapper.selectByExample(example);
		
		return smoduleList.size()>0?smoduleList.get(0):null;
	}
}
