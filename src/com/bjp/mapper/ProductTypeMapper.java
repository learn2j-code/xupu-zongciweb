package com.bjp.mapper;

import com.bjp.pojo.ProductType;
import com.bjp.pojo.ProductTypeExample;
import java.util.List;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}