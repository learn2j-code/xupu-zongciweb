package com.bjp.bam_storemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjp.bam_storemanagement.service.ProductInfoService;
import com.bjp.bam_storemanagement.service.ProductPicService;
import com.bjp.bam_storemanagement.service.ProductTypeService;
import com.bjp.bam_storemanagement.vo.RequestEntity;
import com.bjp.bam_storemanagement.vo.ResponseEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.ProductInfo;
import com.bjp.pojo.ProductPic;
import com.bjp.pojo.ProductType;



//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("productpic")
public class ProductPicController {
	@Autowired
	ProductPicService productPicService;
	
	//查询 (按序排列)
	@RequestMapping("findAll")
	public @ResponseBody ResponseEntity findAll(){
		ResponseEntity responseEntity = new ResponseEntity();
		List<ProductPic> productPicList = productPicService.list();
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productPicList", productPicList);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//查询 (按序排列)
	@RequestMapping("findProductPicListByProductId")
	public @ResponseBody ResponseEntity findProductPicListByProductId(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		List<ProductPic> productPicList = productPicService.list();
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productPicList", productPicList);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	
	//查询详情
	@RequestMapping("findById")
	public @ResponseBody ResponseEntity findById(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		ProductPic productPic = productPicService.get(requestEntity.getId());
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productPic", productPic);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//新增
	@RequestMapping("add")
	public @ResponseBody ResponseEntity add(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productPicService.add(requestEntity.getProductPic());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//编辑
	@RequestMapping("update")
	public @ResponseBody ResponseEntity update(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productPicService.update(requestEntity.getProductPic());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//删除
	@RequestMapping("deleteById")
	public @ResponseBody ResponseEntity delete(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productPicService.delete(requestEntity.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
}
