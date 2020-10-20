package com.bjp.bam_storemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_storemanagement.service.ProductInfoService;
import com.bjp.bam_storemanagement.service.ProductPicService;
import com.bjp.mapper.ProductInfoMapper;
import com.bjp.mapper.ProductPicMapper;
import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductInfoExample;
import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductPicExample;
@Service
public class ProductPicServiceImpl implements ProductPicService {
	@Autowired
	ProductPicMapper mapper;
	@Override
	public List<ProductPic> list() {
		ProductPicExample example = new ProductPicExample();
		example.setOrderByClause("id asc");
		example.createCriteria();
		return mapper.selectByExample(example);
	}

	@Override
	public void add(ProductPic record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(ProductPic record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProductPic get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductPic> findProductPicListByProductId(Integer id) {
		ProductPicExample example = new ProductPicExample();
		example.setOrderByClause("id asc");
		example.createCriteria().andProductIdEqualTo(id);
		return mapper.selectByExample(example);
	}

	@Override
	public void deleteByProductId(Integer id) {
		List<ProductPic> productPicList = findProductPicListByProductId(id);
		for(ProductPic productPic:productPicList){
			delete(productPic.getId());
		}
	}
}
