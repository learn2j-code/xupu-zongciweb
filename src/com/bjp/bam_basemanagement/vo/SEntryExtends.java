package com.bjp.bam_basemanagement.vo;

import com.bjp.pojo.SContent;
import com.bjp.pojo.SEntry;

public class SEntryExtends extends SEntry{
	private SContent sContent;

	public SContent getsContent() {
		return sContent;
	}

	public void setsContent(SContent sContent) {
		this.sContent = sContent;
	}

}
