package com.bjp.mapper;

import com.bjp.pojo.BbsType;
import com.bjp.pojo.BbsTypeExample;
import java.util.List;

public interface BbsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsType record);

    int insertSelective(BbsType record);

    List<BbsType> selectByExample(BbsTypeExample example);

    BbsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsType record);

    int updateByPrimaryKey(BbsType record);
}