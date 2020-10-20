package com.bjp.mapper;

import com.bjp.pojo.SPraise;
import com.bjp.pojo.SPraiseExample;
import java.util.List;

public interface SPraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SPraise record);

    int insertSelective(SPraise record);

    List<SPraise> selectByExample(SPraiseExample example);

    SPraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SPraise record);

    int updateByPrimaryKey(SPraise record);
}