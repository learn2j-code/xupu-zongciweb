package com.bjp.mapper;

import com.bjp.pojo.SWmRelation;
import com.bjp.pojo.SWmRelationExample;
import java.util.List;

public interface SWmRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SWmRelation record);

    int insertSelective(SWmRelation record);

    List<SWmRelation> selectByExample(SWmRelationExample example);

    SWmRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SWmRelation record);

    int updateByPrimaryKey(SWmRelation record);
}