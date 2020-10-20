package com.bjp.bam_xupumanagement.vo;

import java.util.List;

import com.bjp.pojo.SEntry;
import com.bjp.util.Page;

public class ArticlePage {
	private Page page;
	
	private List<SEntry> entryList;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<SEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<SEntry> entryList) {
		this.entryList = entryList;
	}
}
