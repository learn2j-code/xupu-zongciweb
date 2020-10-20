package com.bjp.bam_storemanagement.vo;

import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductType;
import com.bjp.util.Page;

public class RequestEntity {
	private Integer id;
	private Page page;
	private ProductType productType;
	private ProductInfo productInfo;
	private ProductPic productPic;
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public ProductPic getProductPic() {
		return productPic;
	}

	public void setProductPic(ProductPic productPic) {
		this.productPic = productPic;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
