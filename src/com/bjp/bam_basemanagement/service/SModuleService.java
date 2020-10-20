package com.bjp.bam_basemanagement.service;

import java.util.List;

import com.bjp.pojo.SEntry;
import com.bjp.pojo.SModule;

public interface SModuleService {
	List<SModule> list();
	void add(SModule record);
	void update(SModule record);
	void delete(int Id);
	SModule get(int Id);
	
	SModule findSModuleByName(String moduleName);
}
