package com.bjp.mapper;

import com.bjp.pojo.SLinkurl;
import com.bjp.pojo.SLinkurlExample;
import java.util.List;

public interface SLinkurlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SLinkurl record);

    int insertSelective(SLinkurl record);

    List<SLinkurl> selectByExample(SLinkurlExample example);

    SLinkurl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SLinkurl record);

    int updateByPrimaryKey(SLinkurl record);
}