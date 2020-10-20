package com.bjp.bam_basemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.MVideoService;
import com.bjp.mapper.MVideoMapper;
import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.MVideo;
import com.bjp.pojo.MVideoExample;
@Service
public class MVideoServiceImpl implements MVideoService {
	@Autowired
	MVideoMapper mvideoMapper;
	@Override
	public List<MVideo> list() {
		MVideoExample example = new MVideoExample();
		example.setOrderByClause("id desc");
		example.createCriteria();
		return mvideoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void add(MVideo record) {
		mvideoMapper.insertSelective(record);
	}

	@Override
	public void update(MVideo record) {
		mvideoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mvideoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public MVideo get(int id) {
		return mvideoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MVideo> findAllMVideoList() {
		MVideoExample example = new MVideoExample();
		example.setOrderByClause("id desc");
		example.createCriteria();
		return mvideoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void updateVideoViewNum(MVideo record) {
		MVideo mvideo = get(record.getId());
		record.setViewNum(mvideo.getViewNum()+1);
		update(record);
	}

}
