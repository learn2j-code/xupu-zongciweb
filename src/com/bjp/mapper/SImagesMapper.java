package com.bjp.mapper;

import com.bjp.pojo.SImages;
import com.bjp.pojo.SImagesExample;
import java.util.List;

public interface SImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SImages record);

    int insertSelective(SImages record);

    List<SImages> selectByExample(SImagesExample example);

    SImages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SImages record);

    int updateByPrimaryKey(SImages record);
}