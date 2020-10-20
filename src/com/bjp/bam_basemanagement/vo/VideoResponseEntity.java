package com.bjp.bam_basemanagement.vo;

import java.util.List;

import com.bjp.pojo.MVideo;
import com.bjp.pojo.MVideoComment;
import com.bjp.util.Page;

public class VideoResponseEntity extends ResponseEntity {
	private List<MVideoComment> mvideoCommentList;
	private List<MVideo> mvideoList;
	private Page page;
	public List<MVideoComment> getMvideoCommentList() {
		return mvideoCommentList;
	}
	public void setMvideoCommentList(List<MVideoComment> mvideoCommentList) {
		this.mvideoCommentList = mvideoCommentList;
	}
	public List<MVideo> getMvideoList() {
		return mvideoList;
	}
	public void setMvideoList(List<MVideo> mvideoList) {
		this.mvideoList = mvideoList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
