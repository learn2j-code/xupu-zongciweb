package com.bjp.bam_storemanagement.service;

import java.util.List;

import com.bjp.pojo.ProductType;

public interface ProductTypeService {
	List<ProductType> list();
	void add(ProductType record);
	void update(ProductType record);
	void delete(int id);
	ProductType get(int id);
	
//	List<ProductType> findProductTypeListBy
	
	
}
