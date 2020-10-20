package com.bjp.bam_storemanagement.service;

import java.util.List;

import com.bjp.bam_storemanagement.vo.ProductInfoExtends;
import com.bjp.pojo.ProductInfo;

public interface ProductInfoService {
	List<ProductInfo> list();
	void add(ProductInfo record);
	void update(ProductInfo record);
	void delete(int id);
	ProductInfoExtends get(int id);
	
	List<ProductInfo> findProductInfoListInCondition(ProductInfo condition);
	List<ProductInfoExtends> packageProductInfoExtends(List<ProductInfo> list);
}
