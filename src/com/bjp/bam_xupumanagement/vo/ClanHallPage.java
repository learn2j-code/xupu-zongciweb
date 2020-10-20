package com.bjp.bam_xupumanagement.vo;

import java.util.List;

import com.bjp.util.Page;

public class ClanHallPage {
	private List<ClanHall> clanHallList;
	private Page page;
	public List<ClanHall> getClanHallList() {
		return clanHallList;
	}
	public void setClanHallList(List<ClanHall> clanHallList) {
		this.clanHallList = clanHallList;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
