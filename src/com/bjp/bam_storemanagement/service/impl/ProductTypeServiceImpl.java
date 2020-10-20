package com.bjp.bam_storemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_storemanagement.service.ProductTypeService;
import com.bjp.mapper.ProductTypeMapper;
import com.bjp.pojo.ProductType;
import com.bjp.pojo.ProductTypeExample;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	ProductTypeMapper mapper;
	@Override
	public List<ProductType> list() {
		ProductTypeExample example = new ProductTypeExample();
		example.setOrderByClause("id asc");
		example.createCriteria();
		return mapper.selectByExample(example);
	}

	@Override
	public void add(ProductType record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(ProductType record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProductType get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

}
