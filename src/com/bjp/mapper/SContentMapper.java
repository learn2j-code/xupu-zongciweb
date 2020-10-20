package com.bjp.mapper;

import com.bjp.pojo.SContent;
import com.bjp.pojo.SContentExample;
import java.util.List;

public interface SContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SContent record);

    int insertSelective(SContent record);

    List<SContent> selectByExampleWithBLOBs(SContentExample example);

    List<SContent> selectByExample(SContentExample example);

    SContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SContent record);

    int updateByPrimaryKeyWithBLOBs(SContent record);

    int updateByPrimaryKey(SContent record);
}