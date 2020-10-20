package com.bjp.mapper;

import com.bjp.pojo.MVideoComment;
import com.bjp.pojo.MVideoCommentExample;
import java.util.List;

public interface MVideoCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MVideoComment record);

    int insertSelective(MVideoComment record);

    List<MVideoComment> selectByExampleWithBLOBs(MVideoCommentExample example);

    List<MVideoComment> selectByExample(MVideoCommentExample example);

    MVideoComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MVideoComment record);

    int updateByPrimaryKeyWithBLOBs(MVideoComment record);

    int updateByPrimaryKey(MVideoComment record);
}