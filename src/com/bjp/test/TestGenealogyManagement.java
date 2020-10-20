package com.bjp.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjp.bam_basemanagement.service.SClanHallService;
import com.bjp.bam_basemanagement.service.SEntryService;
import com.bjp.bam_basemanagement.service.SImagesService;
import com.bjp.bam_basemanagement.service.SUserService;
import com.bjp.bam_xupumanagement.service.XuPuService;
import com.bjp.bam_xupumanagement.vo.ArticlePage;
import com.bjp.bam_xupumanagement.vo.ClanHall;
import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SEntry;
import com.bjp.pojo.SImages;
import com.bjp.pojo.SModule;
import com.bjp.pojo.SUser;
import com.bjp.util.Page;
import com.bjp.util.jpinyin.PinyinException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestGenealogyManagement {
	@Autowired
	SEntryService sentryService;
	@Autowired
	SClanHallService sclanHallService;
	@Autowired
	XuPuService xupuService;
	@Autowired
	SImagesService simagesService;
	
	@Autowired
	SUserService suserService;
//	@Test
	public void findByPage() {
		//分页参数设置
    	Page page = new Page();
    	page.setStart(1);
    	page.setCount(4);
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
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
    	
		int total = (int)new PageInfo<>(sclanHallList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		System.out.println("totalsize: "+sclanHallList.size());
		System.out.println("totalPage: "+page.getTotalPage());
		System.out.println("total: "+page.getTotal());
		int i=0;
		for(ClanHall clanHall:clanHallList){
			
			System.out.println("编号"+ (i++) +": "+clanHall.getName());
		}
        return ;
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
		return clanHall;
	}
	
//	@Test
	public void findBJXArticalListByModuleName() throws PinyinException {
		SModule smodule = new SModule();
		smodule.setModuleName("百家姓");
		Map<String,List<SEntry>> map = xupuService.findBJXArticalListByModuleName(smodule.getModuleName());
		System.out.println(map.get("a"));
	}
	
//	@Test
	public void findClanHallById() {
		String nickname = "张超";
		String img = "http://thirdqq.qlogo.cn/qqapp/102920293/33535hoihafaodihfiaoshfoahdfadshfadsfv/100";
		String sex = "1";
		String uniqId = "qq2v494kfUMKNAF4k";
		String from ="qq";
		
		SUser suser = new SUser();
		suser.setUniqId(uniqId);
		suser.setNickname(nickname);
		suser.setLoginFrom(from);
		suser.setImg(img);
		suser.setSex(Integer.valueOf(sex));
		suserService.add(suser);
	}
	
	@Test
	public void updateClanHallById() {
		List<SClanHall> clanhallList = sclanHallService.list();
		for(SClanHall sclanHall:clanhallList){
			SClanHall clanHall = new SClanHall();
			clanHall.setId(sclanHall.getId());
			
			String coverImage = sclanHall.getCoverImage();
			coverImage.indexOf("seo/");
			String coverImageThumb = sclanHall.getCoverImageThumb();
		}
	}
}
