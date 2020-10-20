package com.bjp.mapper;

import com.bjp.pojo.BbsComment;
import com.bjp.pojo.BbsCommentExample;
import java.util.List;

public interface BbsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BbsComment record);

    int insertSelective(BbsComment record);

    List<BbsComment> selectByExampleWithBLOBs(BbsCommentExample example);

    List<BbsComment> selectByExample(BbsCommentExample example);

    BbsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbsComment record);

    int updateByPrimaryKeyWithBLOBs(BbsComment record);

    int updateByPrimaryKey(BbsComment record);
}