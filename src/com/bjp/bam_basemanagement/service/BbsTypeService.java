package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.BbsType;

public interface BbsTypeService {
	List<BbsType> list();
	void add(BbsType record);
	void update(BbsType record);
	void delete(int Id);
	BbsType get(int Id);
}
