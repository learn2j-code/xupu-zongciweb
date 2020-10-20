package com.bjp.mapper;

import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.BbsArticleExample;
import java.util.List;

public interface BbsArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsArticle record);

    int insertSelective(BbsArticle record);

    List<BbsArticle> selectByExampleWithBLOBs(BbsArticleExample example);

    List<BbsArticle> selectByExample(BbsArticleExample example);

    BbsArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsArticle record);

    int updateByPrimaryKeyWithBLOBs(BbsArticle record);

    int updateByPrimaryKey(BbsArticle record);
}