package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SUserService;
import com.bjp.mapper.SUserMapper;
import com.bjp.pojo.SUser;
import com.bjp.pojo.SUserExample;
@Service
public class SUserServiceImpl implements SUserService {
	@Autowired
	SUserMapper suserMapper;
	@Override
	public List<SUser> list() {
		SUserExample example = new SUserExample();
		example.setOrderByClause("id desc");
		return suserMapper.selectByExample(example);
	}

	@Override
	public void add(SUser record) {
		suserMapper.insertSelective(record);
	}

	@Override
	public void update(SUser record) {
		suserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		suserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SUser get(int id) {
		return suserMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer login(SUser record) {
		Integer id = null;
		if(record!=null){
			List<SUser> userList = findUserByUniqId(record.getUniqId());
			if(userList.size()>0){
				id = userList.get(0).getId();
				SUser user = new SUser();
				user.setId(id);
				user.setOnlineFlag(1);
				update(user);
			}else{
				add(record);
				id = record.getId();
			}
		}
		return id;
		
	}

	@Override
	public List<SUser> findUserByUniqId(String uniqId) {
		SUserExample example = new SUserExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andUniqIdEqualTo(uniqId);
		return suserMapper.selectByExample(example);
	}

}
