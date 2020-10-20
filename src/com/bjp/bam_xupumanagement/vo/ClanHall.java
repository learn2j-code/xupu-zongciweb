package com.bjp.bam_xupumanagement.vo;

import java.util.List;

import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SImages;

public class ClanHall extends SClanHall {
	private String imageAddress;
	
	private List<SImages> imageList;

	public List<SImages> getImageList() {
		return imageList;
	}

	public void setImageList(List<SImages> imageList) {
		this.imageList = imageList;
	}

	public String getImageAddress() {
		return imageAddress;
	}

	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
}
