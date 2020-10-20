package com.bjp.mapper;

import com.bjp.pojo.SUser;
import com.bjp.pojo.SUserExample;
import java.util.List;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUser record);

    int insertSelective(SUser record);

    List<SUser> selectByExampleWithBLOBs(SUserExample example);

    List<SUser> selectByExample(SUserExample example);

    SUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKeyWithBLOBs(SUser record);

    int updateByPrimaryKey(SUser record);
}