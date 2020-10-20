package com.bjp.bam_storemanagement.service;

import java.util.List;

import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductPic;

public interface ProductPicService {
	List<ProductPic> list();
	void add(ProductPic record);
	void update(ProductPic record);
	void delete(int id);
	ProductPic get(int id);
	
	List<ProductPic> findProductPicListByProductId(Integer id);
	void deleteByProductId(Integer id);
}
