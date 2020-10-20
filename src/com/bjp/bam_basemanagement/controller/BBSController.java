package com.bjp.bam_basemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjp.bam_basemanagement.service.BbsArticleService;
import com.bjp.bam_basemanagement.service.BbsCommentService;
import com.bjp.bam_basemanagement.service.BbsTypeService;
import com.bjp.bam_basemanagement.service.MVideoCommentService;
import com.bjp.bam_basemanagement.service.MVideoService;
import com.bjp.bam_basemanagement.vo.BBSResponseEntity;
import com.bjp.bam_basemanagement.vo.RequestEntity;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.bam_xupumanagement.vo.ClanHall;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.BbsComment;
import com.bjp.pojo.BbsType;
import com.bjp.pojo.MVideo;
import com.bjp.pojo.MVideoComment;
import com.bjp.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class BBSController {
	@Autowired
	BbsArticleService bbsArticleService;
	@Autowired
	BbsTypeService bbsTypeService;
	@Autowired
	BbsCommentService bbsCommentService;
	
	@Autowired
	MVideoService mvideoService;
	
	@Autowired
	MVideoCommentService mvideoCommentService;
	
	//分页查询 所有留言板列表(按时间倒序排列)
	@RequestMapping("findAllBbsArticleList")
	public @ResponseBody BBSResponseEntity findAllBbsArticleList(@RequestBody RequestEntity requestEntity){
		BBSResponseEntity bbsResponseEntity = new BBSResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<BbsArticle> bbsArticleList = bbsArticleService.findAllBbsArticleList();
		int total = (int)new PageInfo<>(bbsArticleList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		bbsResponseEntity.setBbsArticleList(bbsArticleList);
		bbsResponseEntity.setPage(page);
		return bbsResponseEntity;
	}
	
	//查询最新留言板列表(1个月内的，按时间倒序排列)
	@RequestMapping("findLastestBbsArticleList")
	public @ResponseBody BBSResponseEntity findLastestBbsArticleList(@RequestBody RequestEntity requestEntity){
		BBSResponseEntity bbsResponseEntity = new BBSResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<BbsArticle> bbsArticleList = bbsArticleService.findLastestBbsArticleList();
		int total = (int)new PageInfo<>(bbsArticleList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		bbsResponseEntity.setBbsArticleList(bbsArticleList);
		bbsResponseEntity.setPage(page);
		return bbsResponseEntity;
	}
	
	//查询精华留言板列表(精华标志为1的帖子，按时间倒序排列)
	@RequestMapping("findBestBbsArticleList")
	public @ResponseBody BBSResponseEntity findBestBbsArticleList(@RequestBody RequestEntity requestEntity){
		BBSResponseEntity bbsResponseEntity = new BBSResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<BbsArticle> bbsArticleList = bbsArticleService.findBestBbsArticleList();
		int total = (int)new PageInfo<>(bbsArticleList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		bbsResponseEntity.setBbsArticleList(bbsArticleList);
		bbsResponseEntity.setPage(page);
		return bbsResponseEntity;
	}
	
	//查询精华留言板列表(精华标志为1的帖子，按时间倒序排列)
	@RequestMapping("findBbsArticleListByType")
	public @ResponseBody BBSResponseEntity findBbsArticleListByType(@RequestBody RequestEntity requestEntity){
		BBSResponseEntity bbsResponseEntity = new BBSResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<BbsArticle> bbsArticleList = bbsArticleService.findBbsArticleListByType(requestEntity.getTypeId());
		int total = (int)new PageInfo<>(bbsArticleList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		bbsResponseEntity.setBbsArticleList(bbsArticleList);
		bbsResponseEntity.setPage(page);
		return bbsResponseEntity;
	}
	
	//新增帖子(发表帖子)
	@RequestMapping("addBbsArticle")
	public @ResponseBody ResponseEntity addBbsArticle(@RequestBody BbsArticle bbsArticle){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsArticleService.add(bbsArticle);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//编辑帖子
	@RequestMapping("updateBbsArticle")
	public @ResponseBody ResponseEntity updateBbsArticle(@RequestBody BbsArticle bbsArticle){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsArticleService.update(bbsArticle);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//删除帖子
	@RequestMapping("deleteBbsArticle")
	public @ResponseBody ResponseEntity deleteBbsArticle(@RequestBody BbsArticle bbsArticle){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsArticleService.delete(bbsArticle.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//查询帖子详情
	@RequestMapping("findBbsArticleDetail")
	public @ResponseBody BbsArticle findBbsArticleDetail(@RequestBody BbsArticle bbsArticle){
//		bbsArticleService.updateViewNum(bbsArticle);
		return bbsArticleService.get(bbsArticle.getId());
	}
	
	//查询主题列表
	@RequestMapping("findAllBbsTypeList")
	public @ResponseBody List<BbsType> findAllBbsTypeList(){
		return bbsTypeService.list();
	}
	
	//查询某帖子的评论列表
	@RequestMapping("findAllBbsCommentList")
	public @ResponseBody BBSResponseEntity findAllBbsCommentList(@RequestBody RequestEntity requestEntity){
		BBSResponseEntity bbsResponseEntity = new BBSResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<BbsComment> bbsCommentList = bbsCommentService.findAllBbsCommentList(requestEntity.getId());
		int total = (int)new PageInfo<>(bbsCommentList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		bbsResponseEntity.setBbsCommentList(bbsCommentList);;
		bbsResponseEntity.setPage(page);
		return bbsResponseEntity;
	}
	
	//对某帖子的评论或回复
	@RequestMapping("addBbsComment")
	public @ResponseBody ResponseEntity addBbsComment(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.add(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//更新某评论的点赞量 
	@RequestMapping("updateAgreeNum")
	public @ResponseBody ResponseEntity updateAgreeNum(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.updateAgreeNum(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//更新某评论的不赞同量
	@RequestMapping("updateDisagreeNum")
	public @ResponseBody ResponseEntity updateDisagreeNum(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.updateDisagreeNum(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//禁言某评论
	@RequestMapping("bannedComment")
	public @ResponseBody ResponseEntity bannedComment(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.bannedComment(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//查看某评论详情
	@RequestMapping("findCommentById")
	public @ResponseBody BBSResponseEntity findCommentById(@RequestBody BbsComment record){
		BBSResponseEntity responseEntity = new BBSResponseEntity();
		try {
			BbsComment bbsComment = bbsCommentService.get(record.getId());
			responseEntity.setBbsComment(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//编辑某评论
	@RequestMapping("updateComment")
	public @ResponseBody ResponseEntity updateComment(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.update(bbsComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//删除某评论
	@RequestMapping("deleteCommentById")
	public @ResponseBody ResponseEntity deleteCommentById(@RequestBody BbsComment bbsComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			bbsCommentService.delete(bbsComment.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	@RequestMapping("messageBorad")
	public String  messageBorad(Model model,Integer start,Integer count){
		Page page = new Page();
		page.setStart(start);
		page.setCount(count);
		int pageNum = (start-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum,count);
		List<BbsArticle> bbsArticleList = bbsArticleService.findAllBbsArticleList();
		int total = (int)new PageInfo<>(bbsArticleList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		model.addAttribute("bbsArticleList",bbsArticleList);
		model.addAttribute("page",page);
	    return "messageBorad";  
	}
	
	@RequestMapping("messageDetail")
	public String  messageDetail(Model model,Integer id){
		BbsArticle bbsArticle = bbsArticleService.get(id);
		bbsArticleService.updateViewNum(bbsArticle);
//		Page page = new Page();
//		page.setStart(start);
//		page.setCount(count);
//		int pageNum = (start-1);
//		if(pageNum<0){
//			return null;
//		}
//		PageHelper.offsetPage(pageNum,count);
//		List<BbsComment> bbsCommentList = bbsCommentService.findAllBbsCommentList(id);
//		int total = (int)new PageInfo<>(bbsCommentList).getTotal();
//		page.setTotal(total);
//		page.caculateLast(total);
		
		model.addAttribute("bbsArticle",bbsArticle);
//		model.addAttribute("bbsCommentList",bbsCommentList);
//		model.addAttribute("page",page);
		model.addAttribute("id",id);
	    return "messageDetail"; 
	}
	
	@RequestMapping("videoDetail")
	public String  videoDetail(Model model,Integer id){
		MVideo mvideo = mvideoService.get(id);
		mvideoService.updateVideoViewNum(mvideo);
//		Page page = new Page();
//		page.setStart(start);
//		page.setCount(count);
//		int pageNum = (start-1);
//		if(pageNum<0){
//			return null;
//		}
//		PageHelper.offsetPage(pageNum,count);
//		List<MVideoComment> mvideoCommentList = mvideoCommentService.findVideoCommentListByVideoId(id);
//		int total = (int)new PageInfo<>(mvideoCommentList).getTotal();
//		page.setTotal(total);
//		page.caculateLast(total);
//		model.addAttribute("page",page);
		model.addAttribute("mvideo",mvideo);
//		model.addAttribute("mvideoCommentList",mvideoCommentList);
		model.addAttribute("id",id);
	    return "videoDetail";  
	}
	
	@RequestMapping("videoList")
	public String  videoList(Model model,Integer start,Integer count){
		Page page = new Page();
		page.setStart(start);
		page.setCount(count);
		int pageNum = (start-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum,count);
		List<MVideo> mvideoList = mvideoService.findAllMVideoList();
		int total = (int)new PageInfo<>(mvideoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		model.addAttribute("mvideoList",mvideoList);
		model.addAttribute("page",page);
	    return "videoList";  
	}
}
