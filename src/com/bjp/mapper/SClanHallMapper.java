package com.bjp.mapper;

import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SClanHallExample;
import java.util.List;

public interface SClanHallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SClanHall record);

    int insertSelective(SClanHall record);

    List<SClanHall> selectByExampleWithBLOBs(SClanHallExample example);

    List<SClanHall> selectByExample(SClanHallExample example);

    SClanHall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SClanHall record);

    int updateByPrimaryKeyWithBLOBs(SClanHall record);

    int updateByPrimaryKey(SClanHall record);
}