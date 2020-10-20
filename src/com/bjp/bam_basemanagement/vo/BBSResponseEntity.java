package com.bjp.bam_basemanagement.vo;

import java.util.List;

import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.BbsComment;
import com.bjp.util.Page;

public class BBSResponseEntity extends ResponseEntity {
	private List<BbsArticle> bbsArticleList;
	private List<BbsComment> bbsCommentList;
	private BbsComment bbsComment;
	private Page page;
	public List<BbsArticle> getBbsArticleList() {
		return bbsArticleList;
	}
	public void setBbsArticleList(List<BbsArticle> bbsArticleList) {
		this.bbsArticleList = bbsArticleList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<BbsComment> getBbsCommentList() {
		return bbsCommentList;
	}
	public void setBbsCommentList(List<BbsComment> bbsCommentList) {
		this.bbsCommentList = bbsCommentList;
	}
	public BbsComment getBbsComment() {
		return bbsComment;
	}
	public void setBbsComment(BbsComment bbsComment) {
		this.bbsComment = bbsComment;
	}
}
