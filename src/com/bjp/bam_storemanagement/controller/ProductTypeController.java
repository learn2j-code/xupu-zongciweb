package com.bjp.bam_storemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjp.bam_storemanagement.service.ProductTypeService;
import com.bjp.bam_storemanagement.vo.RequestEntity;
import com.bjp.bam_storemanagement.vo.ResponseEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.ProductType;



//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("producttype")
public class ProductTypeController {
	@Autowired
	ProductTypeService productTypeService;
	
	//查询 (按序排列)
	@RequestMapping("findAll")
	public @ResponseBody ResponseEntity findAll(){
		ResponseEntity responseEntity = new ResponseEntity();
		List<ProductType> productTypeList = productTypeService.list();
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productTypeList", productTypeList);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//查询详情
	@RequestMapping("findById")
	public @ResponseBody ResponseEntity findById(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		ProductType productType = productTypeService.get(requestEntity.getId());
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productType", productType);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//新增
	@RequestMapping("add")
	public @ResponseBody ResponseEntity addMVideo(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productTypeService.add(requestEntity.getProductType());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//编辑
	@RequestMapping("update")
	public @ResponseBody ResponseEntity updateMVideo(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productTypeService.update(requestEntity.getProductType());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//删除
	@RequestMapping("deleteById")
	public @ResponseBody ResponseEntity deleteMVideo(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productTypeService.delete(requestEntity.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
}
