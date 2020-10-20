package com.bjp.bam_xupumanagement.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjp.bam_basemanagement.service.SClanHallService;
import com.bjp.bam_basemanagement.service.SContentService;
import com.bjp.bam_basemanagement.service.SEntryService;
import com.bjp.bam_basemanagement.service.SImagesService;
import com.bjp.bam_basemanagement.service.SLinkurlService;
import com.bjp.bam_basemanagement.service.SModuleService;
import com.bjp.bam_basemanagement.service.SSystemService;
import com.bjp.bam_basemanagement.service.SWebsiteService;
import com.bjp.bam_basemanagement.service.SWmRelationService;
import com.bjp.bam_xupumanagement.service.XuPuService;
import com.bjp.bam_xupumanagement.vo.ArticleInfo;
import com.bjp.bam_xupumanagement.vo.ClanHall;
import com.bjp.bam_xupumanagement.vo.WebInfo;
import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SContent;
import com.bjp.pojo.SEntry;
import com.bjp.pojo.SImages;
import com.bjp.pojo.SLinkurl;
import com.bjp.pojo.SModule;
import com.bjp.pojo.SSystem;
import com.bjp.pojo.SWebsite;
import com.bjp.pojo.SWmRelation;
import com.bjp.util.jpinyin.PinyinException;
import com.bjp.util.jpinyin.PinyinHelper;
import com.github.pagehelper.util.StringUtil;
@Service
public class XuPuServiceImpl implements XuPuService {

	@Autowired
	SWmRelationService swmRelationService;
	
	@Autowired
	SLinkurlService slinkurlService;
	
	@Autowired
	SWebsiteService swebsiteService;
	@Autowired
	SSystemService ssystemService;
	
	@Autowired
	SEntryService sentryService;
	@Autowired
	SContentService scontentService;
	
	@Autowired
	SModuleService smoduleService;
	@Autowired
	SClanHallService sclanHallService;
	
	@Autowired
	SImagesService simagesService;
	
	@Override
	public WebInfo findWebInfoByWebsite(WebInfo webInfo) {
		SWebsite swebsite = swebsiteService.findWebsiteByName(webInfo.getWebsite());
		Integer websiteId = swebsite.getId();
		
		
		List<SWmRelation> swmRelationList = swmRelationService.findModuleIdListByWebsiteId(websiteId);
		
		List<SLinkurl> slinkurlList = slinkurlService.findSLinkurlListByWebsiteId(websiteId);
		
		webInfo.setSwebsite(swebsite);
		webInfo.setSwmRelationList(swmRelationList);
		webInfo.setSlinkurlList(slinkurlList);
		return webInfo;
	}

	@Override
	public List<SEntry> findArticalListByModuleId(Integer moduleId) {
		return sentryService.findSEntryListByModuleId(moduleId);
	}

	@Override
	public ArticleInfo findArticleInfoByEntryId(Integer entryId) {
		SContent scontent = scontentService.findArticalContentBySEntryId(entryId);
    	SEntry sentry = sentryService.get(entryId);
    	ArticleInfo article = new ArticleInfo();
    	article.setArticalAbstract(sentry.getArticalAbstract());
    	article.setContent(scontent.getContent());
    	article.setId(entryId);
    	article.setKeyword(sentry.getKeyword());
    	article.setImageUrl(sentry.getImageUrl());
    	article.setTitle(sentry.getTitle());
    	article.setArticleTime(sentry.getReleaseDate());
    	article.setNickname(sentry.getNickname());
		return article;
	}

	@Override
	public Map<String,List<SEntry>> findBJXArticalListByModuleName(String moduleName) throws PinyinException {
		SModule smodule = smoduleService.findSModuleByName(moduleName);
		if(smodule==null){
			return null;
		}
		List<SEntry> sentryList = sentryService.findSEntryListByModuleIdAndPYIsNone(smodule.getId());
		for(SEntry entry:sentryList){
			String title = entry.getTitle();
			if(StringUtil.isEmpty(title)){
				continue;
			}
			
			String firstA = PinyinHelper.getShortPinyin(title).substring(0, 1);
			entry.setDef1(firstA);
			sentryService.update(entry);
		}
		Map<String,List<SEntry>> entryMap = new HashMap<String,List<SEntry>>();
		//26字母
		for(int i=(int)'a';i<'a'+26;i++)
		{
			String alpha = (char)i+"";
			List<SEntry> outputEntryList = sentryService.findSEntryListByModuleIdAndPYNotNone(smodule.getId(), alpha);
			String alphA = (char)(i-32)+"";
			if(!outputEntryList.isEmpty()){
				entryMap.put(alphA, outputEntryList);
			}
		}
		
		return entryMap;
	}

	
	@Override
	public List<ClanHall> findClanHallListByRecommendFlag(Integer recommend) {
		List<SClanHall> sclanHallList = sclanHallService.findClanHallListByRecommendFlag(recommend);
		List<ClanHall> clanHallList = new ArrayList<ClanHall>();
		for(SClanHall sclanHall:sclanHallList){
			ClanHall clanHall = packageClanHallFrom(sclanHall);
			//根据id查图片
			List<SImages> imageAddressList = simagesService.findSImageListByClanHallId(sclanHall.getId());
			clanHall.setImageAddress( imageAddressList.size()>0?imageAddressList.get(0).getImageUrl():null );
			clanHallList.add(clanHall);
		}
		return clanHallList;
	}

	@Override
	public ClanHall findClanHallById(Integer clanHallId) {
		SClanHall sclanHall = sclanHallService.get(clanHallId);
		if(sclanHall==null){
			return null;
		}
		ClanHall clanHall = packageClanHallFrom(sclanHall);
		//根据id查图片
		List<SImages> imageAddressList = simagesService.findSImageListByClanHallId(clanHallId);
		clanHall.setImageList(imageAddressList);
		return clanHall;
	}

	@Override
	public List<ClanHall> findClanHallByAddress(String address,String name) {
		List<SClanHall> sclanHallList = sclanHallService.findClanHallByAddress(address,name);
		List<ClanHall> clanHallList = new ArrayList<ClanHall>();
		for(SClanHall sclanHall:sclanHallList){
			ClanHall clanHall = packageClanHallFrom(sclanHall);
			
			clanHallList.add(clanHall);
		}
		return clanHallList;
	}

	@Override
	public List<ClanHall> findNewClanHallList() {
		List<SClanHall> sclanHallList = sclanHallService.list();
		List<ClanHall> clanHallList = new ArrayList<ClanHall>();
		for(SClanHall sclanHall:sclanHallList){
			ClanHall clanHall = packageClanHallFrom(sclanHall);
			//根据id查图片
			List<SImages> imageAddressList = simagesService.findSImageListByClanHallId(sclanHall.getId());
			clanHall.setImageAddress( imageAddressList.size()>0?imageAddressList.get(0).getImageUrl():null );
			clanHall.setImageList(imageAddressList);
			clanHallList.add(clanHall);
		}
		return clanHallList;
	}
	
	private ClanHall packageClanHallFrom(SClanHall sclanHall){
		ClanHall clanHall = new ClanHall();
		clanHall.setAddress(sclanHall.getAddress());
		clanHall.setContacts(sclanHall.getContacts());
		clanHall.setCoordinate(sclanHall.getCoordinate());
		clanHall.setCreateTime(sclanHall.getCreateTime());
		clanHall.setDelFlg(sclanHall.getDelFlg());
		clanHall.setDetails(sclanHall.getDetails());
		clanHall.setFulladdress(sclanHall.getFulladdress());
		clanHall.setId(sclanHall.getId());
		clanHall.setName(sclanHall.getName());
		clanHall.setNameOfAHall(sclanHall.getNameOfAHall());
		clanHall.setSynopsis(sclanHall.getSynopsis());
		clanHall.setRecommend(sclanHall.getRecommend());
		clanHall.setTel(sclanHall.getTel());
		clanHall.setUpdateTime(sclanHall.getUpdateTime());
		clanHall.setIntroduction(sclanHall.getIntroduction());
		clanHall.setCoverImage(sclanHall.getCoverImage());
		clanHall.setCoverImageThumb(sclanHall.getCoverImageThumb());
		clanHall.setProtectedFlag(sclanHall.getProtectedFlag());
		clanHall.setDef1(sclanHall.getDef1());
		clanHall.setDef2(sclanHall.getDef2());
		clanHall.setSurname(sclanHall.getSurname());
		clanHall.setReview(sclanHall.getReview());
		clanHall.setNickname(sclanHall.getNickname());
		return clanHall;
	}

	//根据地址首字母查询祠堂大全
	@Override
	public Map<String, List<SClanHall>> findSClanHallListByAlpha() throws PinyinException {
		List<SClanHall> sentryList = sclanHallService.findSClanHallListByPYIsNone();
		for(SClanHall sclanHall:sentryList){
			String address = sclanHall.getAddress();
			if(StringUtil.isEmpty(address)){
				continue;
			}
			
			String firstA = PinyinHelper.getShortPinyin(address).substring(0, 1);
			sclanHall.setDef1(firstA);
			sclanHallService.update(sclanHall);
		}
		Map<String,List<SClanHall>> entryMap = new HashMap<String,List<SClanHall>>();
		//26字母
		for(int i=(int)'a';i<'a'+26;i++)
		{
			String alpha = (char)i+"";
			List<SClanHall> outputSClanHallList = sclanHallService.findSClanHallListByPYNotNone(alpha);
			String alphA = (char)(i-32)+"";
			if(!outputSClanHallList.isEmpty()){
				entryMap.put(alphA, outputSClanHallList);
			}
		}
		
		return entryMap;
	}

	//根据姓氏首字母查询祠堂大全
	@Override
	public Map<String, List<SClanHall>> findSClanHallListBySurnameAlpha() throws PinyinException {
		List<SClanHall> sentryList = sclanHallService.findSClanHallListBySurnamePYIsNone();
		for(SClanHall sclanHall:sentryList){
			String surname = sclanHall.getSurname();
			if(StringUtil.isEmpty(surname)){
				continue;
			}
			
			String firstA = PinyinHelper.getShortPinyin(surname).substring(0, 1);
			sclanHall.setDef2(firstA);
			sclanHallService.update(sclanHall);
		}
		Map<String,List<SClanHall>> entryMap = new HashMap<String,List<SClanHall>>();
		//26字母
		for(int i=(int)'a';i<'a'+26;i++)
		{
			String alpha = (char)i+"";
			List<SClanHall> outputSClanHallList = sclanHallService.findSClanHallListBySurnamePYNotNone(alpha);
			String alphA = (char)(i-32)+"";
			if(!outputSClanHallList.isEmpty()){
				entryMap.put(alphA, outputSClanHallList);
			}
		}
		
		return entryMap;
	}
}
