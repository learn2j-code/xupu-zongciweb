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
import com.bjp.bam_storemanagement.vo.ProductInfoExtends;
import com.bjp.bam_storemanagement.vo.RequestEntity;
import com.bjp.bam_storemanagement.vo.ResponseEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.ProductInfo;
import com.bjp.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("productinfo")
public class ProductInfoController {
	@Autowired
	ProductInfoService productInfoService;
	
	//查询 (按序排列)
	@RequestMapping("findAll")
	public @ResponseBody ResponseEntity findAll(@RequestBody RequestEntity requestEntity){
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<ProductInfo> productInfoList = productInfoService.list();
		List<ProductInfoExtends> productInfoExtendsList = productInfoService.packageProductInfoExtends(productInfoList);
		
		int total = (int)new PageInfo<>(productInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		data.put("page", page);
		data.put("productInfoList", productInfoExtendsList);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//条件分页查询 (按序排列)
	@RequestMapping("findProductInfoInConditionByPage")
	public @ResponseBody ResponseEntity findProductInfoInConditionByPage(@RequestBody RequestEntity requestEntity){
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<ProductInfo> productInfoList = productInfoService.findProductInfoListInCondition(requestEntity.getProductInfo());
		List<ProductInfoExtends> productInfoExtendsList = productInfoService.packageProductInfoExtends(productInfoList);
		
		int total = (int)new PageInfo<>(productInfoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		data.put("page", page);
		data.put("productInfoList", productInfoExtendsList);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//查询详情
	@RequestMapping("findById")
	public @ResponseBody ResponseEntity findById(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		ProductInfoExtends productInfo = productInfoService.get(requestEntity.getId());
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("productInfo", productInfo);
		responseEntity.setData(data);
		return responseEntity;
	}
	
	//新增
	@RequestMapping("add")
	public @ResponseBody ResponseEntity add(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			ProductInfo productInfo = requestEntity.getProductInfo();
			productInfoService.add(productInfo);
			data.put("productInfo", productInfo);
			responseEntity.setData(data);
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
			productInfoService.update(requestEntity.getProductInfo());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//删除
	@RequestMapping("deleteById")
	public @ResponseBody ResponseEntity deleteById(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			productInfoService.delete(requestEntity.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
}
