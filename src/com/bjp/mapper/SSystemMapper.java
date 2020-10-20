package com.bjp.mapper;

import com.bjp.pojo.SSystem;
import com.bjp.pojo.SSystemExample;
import java.util.List;

public interface SSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SSystem record);

    int insertSelective(SSystem record);

    List<SSystem> selectByExample(SSystemExample example);

    SSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SSystem record);

    int updateByPrimaryKey(SSystem record);
}