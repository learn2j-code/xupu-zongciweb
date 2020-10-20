package com.bjp.mapper;

import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductPicExample;
import java.util.List;

public interface ProductPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductPic record);

    int insertSelective(ProductPic record);

    List<ProductPic> selectByExample(ProductPicExample example);

    ProductPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductPic record);

    int updateByPrimaryKey(ProductPic record);
}