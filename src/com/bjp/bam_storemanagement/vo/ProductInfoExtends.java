package com.bjp.bam_storemanagement.vo;

import java.util.List;

import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductType;

public class ProductInfoExtends extends ProductInfo {
	private String coverImageAddress;
	private List<ProductPic> productPicList;
	private ProductType productType;

	public List<ProductPic> getProductPicList() {
		return productPicList;
	}

	public void setProductPicList(List<ProductPic> productPicList) {
		this.productPicList = productPicList;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getCoverImageAddress() {
		return coverImageAddress;
	}

	public void setCoverImageAddress(String coverImageAddress) {
		this.coverImageAddress = coverImageAddress;
	}
}
