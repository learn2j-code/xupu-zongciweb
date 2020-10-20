package com.bjp.mapper;

import com.bjp.pojo.SModule;
import com.bjp.pojo.SModuleExample;
import java.util.List;

public interface SModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SModule record);

    int insertSelective(SModule record);

    List<SModule> selectByExample(SModuleExample example);

    SModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SModule record);

    int updateByPrimaryKey(SModule record);
}