package com.bjp.mapper;

import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductInfoExample;
import java.util.List;

public interface ProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}