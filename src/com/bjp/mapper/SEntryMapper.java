package com.bjp.mapper;

import com.bjp.pojo.SEntry;
import com.bjp.pojo.SEntryExample;
import java.util.List;

public interface SEntryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SEntry record);

    int insertSelective(SEntry record);

    List<SEntry> selectByExampleWithBLOBs(SEntryExample example);

    List<SEntry> selectByExample(SEntryExample example);

    SEntry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SEntry record);

    int updateByPrimaryKeyWithBLOBs(SEntry record);

    int updateByPrimaryKey(SEntry record);
}