package com.bjp.bam_storemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_storemanagement.service.ProductInfoService;
import com.bjp.bam_storemanagement.service.ProductPicService;
import com.bjp.bam_storemanagement.service.ProductTypeService;
import com.bjp.bam_storemanagement.vo.ProductInfoExtends;
import com.bjp.mapper.ProductInfoMapper;
import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductInfoExample;
import com.bjp.pojo.ProductInfoExample.Criteria;
import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductType;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	ProductInfoMapper mapper;
	
	@Autowired
	ProductPicService productPicService;
	
	@Autowired
	ProductTypeService productTypeService;
	@Override
	public List<ProductInfo> list() {
		ProductInfoExample example = new ProductInfoExample();
		example.setOrderByClause("id desc");
		example.createCriteria();
		return mapper.selectByExample(example);
	}

	@Override
	public void add(ProductInfo record) {
		mapper.insertSelective(record);
	}

	@Override
	public void update(ProductInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void delete(int id) {
		productPicService.deleteByProductId(id);
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public ProductInfoExtends get(int id) {
		ProductInfo productInfo = mapper.selectByPrimaryKey(id);
		ProductInfoExtends productInfoExtends = new ProductInfoExtends();
		BeanUtils.copyProperties(productInfo, productInfoExtends);
		List<ProductPic> productPicList = productPicService.findProductPicListByProductId(productInfo.getId());
		ProductType productType = productTypeService.get(productInfo.getTypeId());
		productInfoExtends.setProductPicList(productPicList);
		productInfoExtends.setProductType(productType);
		return productInfoExtends;
	}


	@Override
	public List<ProductInfo> findProductInfoListInCondition(ProductInfo condition) {
		ProductInfoExample example = new ProductInfoExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		if(condition!=null){
			if(condition.getTypeId()!=null&&condition.getTypeId()>0){
				criteria.andTypeIdEqualTo(condition.getTypeId());
			}
			if(condition.getHotFlag()!=null){
				criteria.andHotFlagEqualTo(condition.getHotFlag());
			}
		}
		return mapper.selectByExample(example);
	}

	@Override
	public List<ProductInfoExtends> packageProductInfoExtends(List<ProductInfo> list) {
		List<ProductInfoExtends> ProductInfoExtendsList = new ArrayList<ProductInfoExtends>();
		for(ProductInfo productInfo:list){
			ProductInfoExtends productInfoExtends = new ProductInfoExtends();
			BeanUtils.copyProperties(productInfo, productInfoExtends);
			
			List<ProductPic> productPicList = productPicService.findProductPicListByProductId(productInfo.getId());
			if(productInfo.getTypeId()!=null&&productInfo.getTypeId()>0){
				ProductType productType = productTypeService.get(productInfo.getTypeId());
				productInfoExtends.setProductType(productType);
			}
			productInfoExtends.setProductPicList(productPicList);
			if(productPicList!=null){
				productInfoExtends.setCoverImageAddress(productPicList.get(0).getPicAddress());
			}
			ProductInfoExtendsList.add(productInfoExtends);
		}
		return ProductInfoExtendsList;
	}

}
