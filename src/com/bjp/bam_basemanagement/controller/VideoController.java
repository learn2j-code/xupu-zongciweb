package com.bjp.bam_basemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjp.bam_basemanagement.service.MVideoCommentService;
import com.bjp.bam_basemanagement.service.MVideoService;
import com.bjp.bam_basemanagement.vo.RequestEntity;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.bam_basemanagement.vo.VideoResponseEntity;
import com.bjp.constant.CommonConstant;
import com.bjp.pojo.MVideo;
import com.bjp.pojo.MVideoComment;
import com.bjp.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class VideoController {
	@Autowired
	MVideoService mvideoService;
	@Autowired
	MVideoCommentService mvideoCommentService;
	//分页查询 所有视频列表(按时间倒序排列)
	@RequestMapping("findAllMVideoList")
	public @ResponseBody VideoResponseEntity findAllMVideoList(@RequestBody RequestEntity requestEntity){
		VideoResponseEntity videoResponseEntity = new VideoResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<MVideo> mvideoList = mvideoService.findAllMVideoList();
		int total = (int)new PageInfo<>(mvideoList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		videoResponseEntity.setMvideoList(mvideoList);
		videoResponseEntity.setPage(page);
		return videoResponseEntity;
	}
	
	//查询视频详情
	@RequestMapping("findMVideoDetail")
	public @ResponseBody MVideo findMVideoDetail(@RequestBody MVideo mvideo){
		mvideoService.updateVideoViewNum(mvideo);
		return mvideoService.get(mvideo.getId());
	}
	
	//新增视频
	@RequestMapping("addMVideo")
	public @ResponseBody ResponseEntity addMVideo(@RequestBody MVideo mvideo){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoService.add(mvideo);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//编辑视频
	@RequestMapping("updateMVideo")
	public @ResponseBody ResponseEntity updateMVideo(@RequestBody MVideo mvideo){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoService.update(mvideo);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//删除视频
	@RequestMapping("deleteMVideo")
	public @ResponseBody ResponseEntity deleteMVideo(@RequestBody MVideo mvideo){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoService.delete(mvideo.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//查询某视频的评论列表
	@RequestMapping("findVideoCommentList")
	public @ResponseBody VideoResponseEntity findVideoCommentList(@RequestBody RequestEntity requestEntity){
		VideoResponseEntity videoResponseEntity = new VideoResponseEntity();
		Page page = requestEntity.getPage();
		int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<MVideoComment> mvideoCommentList = mvideoCommentService.findVideoCommentListByVideoId(requestEntity.getId());
		int total = (int)new PageInfo<>(mvideoCommentList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		videoResponseEntity.setMvideoCommentList(mvideoCommentList);
		videoResponseEntity.setPage(page);
		return videoResponseEntity;
	}
	
	//对某视频的评论或回复
	@RequestMapping("addVideoComment")
	public @ResponseBody ResponseEntity addVideoComment(@RequestBody MVideoComment mvideoComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoCommentService.add(mvideoComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//更新某评论的点赞量 
	@RequestMapping("updateVideoAgreeNum")
	public @ResponseBody ResponseEntity updateVideoAgreeNum(@RequestBody MVideoComment mvideoComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoCommentService.updateVideoAgreeNum(mvideoComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	//更新某评论的不赞同量
	@RequestMapping("updateVideoDisagreeNum")
	public @ResponseBody ResponseEntity updateVideoDisagreeNum(@RequestBody MVideoComment mvideoComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoCommentService.updateVideoDisagreeNum(mvideoComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//禁言某评论
	@RequestMapping("bannedVideoComment")
	public @ResponseBody ResponseEntity bannedVideoComment(@RequestBody MVideoComment mvideoComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoCommentService.bannedVideoComment(mvideoComment);
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	//删除某评论
	@RequestMapping("deleteVideoCommentById")
	public @ResponseBody ResponseEntity deleteVideoCommentById(@RequestBody MVideoComment mvideoComment){
		ResponseEntity responseEntity = new ResponseEntity();
		try {
			mvideoCommentService.delete(mvideoComment.getId());
		} catch (Exception e) {
			responseEntity.setSuccess(CommonConstant.RESPONSE_FAIL);
			responseEntity.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		return responseEntity;
	}
}
