package com.bjp.bam_basemanagement.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.BbsArticleService;
import com.bjp.mapper.BbsArticleMapper;
import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.BbsArticleExample;
@Service
public class BbsArticleServiceImpl implements BbsArticleService {
	@Autowired
	BbsArticleMapper bbsArticleMapper;
	@Override
	public List<BbsArticle> list() {
		BbsArticleExample example = new BbsArticleExample();
		example.setOrderByClause("id desc");
		example.createCriteria();
		return bbsArticleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void add(BbsArticle record) {
		bbsArticleMapper.insertSelective(record);
	}

	@Override
	public void update(BbsArticle record) {
		bbsArticleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int Id) {
		bbsArticleMapper.deleteByPrimaryKey(Id);
	}

	@Override
	public BbsArticle get(int Id) {
		return bbsArticleMapper.selectByPrimaryKey(Id);
	}

	@Override
	public List<BbsArticle> findAllBbsArticleList() {
		BbsArticleExample example = new BbsArticleExample();
		example.setOrderByClause("id desc");
		example.createCriteria();
		return bbsArticleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<BbsArticle> findLastestBbsArticleList() {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // 设置为当前时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
		date = calendar.getTime();
		BbsArticleExample example = new BbsArticleExample();
		example.setOrderByClause("id desc");
		example.createCriteria().andCreateTimeBetween(date, new Date());
		return bbsArticleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<BbsArticle> findBestBbsArticleList() {
		BbsArticleExample example = new BbsArticleExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andBestFlagEqualTo(1);
		return bbsArticleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<BbsArticle> findBbsArticleListByType(int typeId) {
		BbsArticleExample example = new BbsArticleExample();
		example.setOrderByClause("create_time desc");
		example.createCriteria().andTypeIdEqualTo(typeId);
		return bbsArticleMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void updateViewNum(BbsArticle record) {
		BbsArticle bbsArticle = get(record.getId());
		record.setViewNum(bbsArticle.getViewNum()+1);
		update(record);
	}

}
