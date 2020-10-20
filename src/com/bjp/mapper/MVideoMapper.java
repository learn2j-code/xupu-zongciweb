package com.bjp.mapper;

import com.bjp.pojo.MVideo;
import com.bjp.pojo.MVideoExample;
import java.util.List;

public interface MVideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MVideo record);

    int insertSelective(MVideo record);

    List<MVideo> selectByExampleWithBLOBs(MVideoExample example);

    List<MVideo> selectByExample(MVideoExample example);

    MVideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MVideo record);

    int updateByPrimaryKeyWithBLOBs(MVideo record);

    int updateByPrimaryKey(MVideo record);
}