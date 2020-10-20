package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.BbsArticle;

public interface BbsArticleService {
	List<BbsArticle> list();
	void add(BbsArticle record);
	void update(BbsArticle record);
	void delete(int Id);
	BbsArticle get(int Id);
	
	List<BbsArticle> findAllBbsArticleList();
	List<BbsArticle> findLastestBbsArticleList();
	List<BbsArticle> findBestBbsArticleList();
	List<BbsArticle> findBbsArticleListByType(int typeId);
	
	void updateViewNum(BbsArticle record);
	
}
