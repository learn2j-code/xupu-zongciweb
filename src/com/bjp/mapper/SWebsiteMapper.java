package com.bjp.mapper;

import com.bjp.pojo.SWebsite;
import com.bjp.pojo.SWebsiteExample;
import java.util.List;

public interface SWebsiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SWebsite record);

    int insertSelective(SWebsite record);

    List<SWebsite> selectByExample(SWebsiteExample example);

    SWebsite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SWebsite record);

    int updateByPrimaryKey(SWebsite record);
}