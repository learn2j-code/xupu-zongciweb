package com.bjp.bam_xupumanagement.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bjp.bam_basemanagement.service.BbsArticleService;
import com.bjp.bam_basemanagement.service.SClanHallService;
import com.bjp.bam_basemanagement.service.SEntryService;
import com.bjp.bam_basemanagement.service.SImagesService;
import com.bjp.bam_basemanagement.service.SLinkurlService;
import com.bjp.bam_basemanagement.service.SUserService;
import com.bjp.bam_basemanagement.vo.RequestEntity;
import com.bjp.bam_basemanagement.vo.ResponseEntity;
import com.bjp.bam_basemanagement.vo.SEntryExtends;
import com.bjp.bam_xupumanagement.service.XuPuService;
import com.bjp.bam_xupumanagement.vo.ArticleInfo;
import com.bjp.bam_xupumanagement.vo.ArticlePage;
import com.bjp.bam_xupumanagement.vo.ClanHall;
import com.bjp.bam_xupumanagement.vo.ClanHallPage;
import com.bjp.bam_xupumanagement.vo.WebInfo;
import com.bjp.pojo.BbsArticle;
import com.bjp.pojo.SClanHall;
import com.bjp.pojo.SEntry;
import com.bjp.pojo.SImages;
import com.bjp.pojo.SLinkurl;
import com.bjp.pojo.SModule;
import com.bjp.pojo.SUser;
import com.bjp.util.HttpRequest;
import com.bjp.util.Page;
import com.bjp.util.jpinyin.PinyinException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class SearchController {
	//第三方平台提供的参数
	private static String appid="15b6ebb3ed408f";
	private static String token="68a7959b31af3c39125999821b669a3d";
	@Autowired
	SEntryService sentryService;
	@Autowired
	SClanHallService sclanHallService;
	@Autowired
	XuPuService xupuService;
	@Autowired
	SImagesService simagesService;
	@Autowired
	SLinkurlService slinkurlService;
	@Autowired
	SUserService suserService;
	@Autowired
	BbsArticleService bbsArticleService;
	
	
	@RequestMapping("findArticalListByModuleId")
	public @ResponseBody List<SEntry> findArticalListByModuleId(@RequestBody WebInfo webInfo){
		List<SEntry> tempList = xupuService.findArticalListByModuleId(webInfo.getModuleId());
		return tempList;
	}
	
	@RequestMapping("findWebInfoByWebsite")
	public @ResponseBody WebInfo findWebInfoByWebsite(@RequestBody WebInfo webInfo){
		return xupuService.findWebInfoByWebsite(webInfo);
	}
	
	@RequestMapping("findArticalContentByArticalId")
	public @ResponseBody ArticleInfo findArticalContentByArticalId(@RequestBody ArticleInfo articleInfo){
		return xupuService.findArticleInfoByEntryId(articleInfo.getId());
	}
	
	@RequestMapping("/findArticalPageByModuleId")
    public @ResponseBody ArticlePage findArticalPageByModuleId(@RequestBody WebInfo webInfo){
    	//分页参数设置
    	Page page = webInfo.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> entryList = xupuService.findArticalListByModuleId(webInfo.getModuleId());
		int total = (int)new PageInfo<>(entryList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		ArticlePage articlePage = new ArticlePage();
		articlePage.setEntryList(entryList);
		articlePage.setPage(page);
        return articlePage;
    }
	
	@RequestMapping("/findClanHallListByRecommendFlag")
    public @ResponseBody ClanHallPage findClanHallListByRecommendFlag(@RequestBody ClanHallPage clanHallPage){
    	//分页参数设置
    	Page page = clanHallPage.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
		}
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<ClanHall> clanHallList = xupuService.findClanHallListByRecommendFlag(1);
    	
		int total = (int)new PageInfo<>(clanHallList).getTotal();
		page.setTotal(total);
		page.caculateLast(total);
		
		clanHallPage.setClanHallList(clanHallList);
		clanHallPage.setPage(page);
        return clanHallPage;
    }
	
	@RequestMapping("/findNewClanHallListByPage")
    public @ResponseBody ClanHallPage findNewClanHallListByPage(@RequestBody ClanHallPage clanHallPage){
    	//分页参数设置
    	Page page = clanHallPage.getPage();
    	int pageNum = (page.getStart()-1);
		if(pageNum<0){
			return null;
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
		
		clanHallPage.setClanHallList(clanHallList);;
		clanHallPage.setPage(page);
        return clanHallPage;
    }
	
	@RequestMapping("/findClanHallById")
    public @ResponseBody ClanHall findClanHallById(@RequestBody ClanHall clanHall){
        return xupuService.findClanHallById(clanHall.getId());
        
    }
	
	@RequestMapping("/findSLinkurlListByWebsiteId")
    public @ResponseBody List<SLinkurl> findSLinkurlListByWebsiteId(@RequestBody WebInfo webInfo){
        return slinkurlService.findSLinkurlListByWebsiteId(webInfo.getWebsiteId());
    }
	
	@RequestMapping("findBJXArticalListByModuleName")
	public @ResponseBody Map<String,List<SEntry>> findBJXArticalListByModuleName(@RequestBody SModule smodule){
		try {
//			smodule.setModuleName("百家姓");
			return xupuService.findBJXArticalListByModuleName(smodule.getModuleName());
		} catch (PinyinException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据姓氏查询姓氏信息
	@RequestMapping("findSurnameInfoBySurname")
    public @ResponseBody ResponseEntity findSurnameInfoBySurname(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<SEntryExtends> list = sentryService.findSEntryExtendsListByModuleIdAndSurname(1, requestEntity.getSurname());
		if(list!=null&&list.size()>=1){
			data.put("record", list.get(0));
		}else{
			data.put("record", null);
		}
		
		responseEntity.setData(data);
		return responseEntity;
    }
	
	//根据姓氏查姓氏资讯
	@RequestMapping("findSurnameNewsListBySurname")
    public @ResponseBody ResponseEntity findSurnameNewsListBySurname(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<SEntryExtends> list = sentryService.findSEntryExtendsListByModuleIdAndSurname(2, requestEntity.getSurname());
		data.put("list", list);
		
		responseEntity.setData(data);
		return responseEntity;
    }
	
	//根据姓氏查祠堂
	@RequestMapping("findClanHallListBySurname")
    public @ResponseBody ResponseEntity findClanHallListBySurname(@RequestBody RequestEntity requestEntity){
		ResponseEntity responseEntity = new ResponseEntity();
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<SClanHall> list = sclanHallService.findSClanHallListBySurname(requestEntity.getSurname());
		data.put("list", list);
		
		responseEntity.setData(data);
		return responseEntity;
    }
	
//	@RequestMapping("/")
//    public String redirect(){
//		 return "redirect:/index"; 
//	}
	
    @RequestMapping("/")
    public String list(Model model,WebInfo webInfo){
    	//请求首页数据
    	webInfo.setWebsite("宗祠网");
    	webInfo = xupuService.findWebInfoByWebsite(webInfo);
    	Integer bjxModuleId = 1;
    	Integer xszxModuleId = 2;
    	Integer xzzxModuleId = 3;
    	Integer zczxModuleId = 4;
    	
    	webInfo.setBjxModuleId(bjxModuleId);
    	webInfo.setXszxModuleId(xszxModuleId);
    	webInfo.setXzzxModuleId(xzzxModuleId);
    	webInfo.setZczxModuleId(zczxModuleId);
    	//分页参数设置
    	Page page = new Page();
		int pageNum = 0;
		//默认6个宗祠咨询
		page.setCount(6);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> zczxList = xupuService.findArticalListByModuleId(4);
		new PageInfo<>(zczxList).getTotal();
//		page.setTotal(total);
//        page.caculateLast(total);
    	
//		//姓氏资讯和寻租资讯
//		page.setCount(5);
//		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
//    	List<SEntry> xszyList = xupuService.findArticalListByModuleId(2);
//    	new PageInfo<>(xszyList).getTotal();
//    	
//    	page.setCount(5);
//		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
//    	List<SEntry> xzzxList = xupuService.findArticalListByModuleId(3);
//    	new PageInfo<>(xzzxList).getTotal();
    	
		//默认80个姓氏
		page.setCount(80);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> bjxList = xupuService.findArticalListByModuleId(1);
		new PageInfo<>(bjxList).getTotal();
    	
    	page.setCount(6);
    	PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<BbsArticle> bbsArticleList = bbsArticleService.findAllBbsArticleList();
		new PageInfo<>(bbsArticleList).getTotal();
		
		page.setCount(12);
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
		new PageInfo<>(sclanHallList).getTotal();
		model.addAttribute("bbsArticleList",bbsArticleList);
		model.addAttribute("clanHallList", clanHallList);
    	model.addAttribute("webInfo", webInfo);
    	model.addAttribute("zczxList", zczxList);
//        model.addAttribute("xszyList",xszyList);
//        model.addAttribute("xzzxList",xzzxList);
        model.addAttribute("bjxList", bjxList);
        return "index";
    }
    
	@RequestMapping("/findClanHallByAddress")
    public @ResponseBody List<ClanHall> findClanHallByAddress(@RequestBody ClanHall clanHall){
        return xupuService.findClanHallByAddress(clanHall.getAddress(),clanHall.getName());
    }
    
    
    @RequestMapping("news/articleDetail")
    public String newsArticleDetail(Model model,Integer id,WebInfo webInfo){
    	//请求首页数据
    	webInfo.setWebsite("宗祠网");
    	webInfo = xupuService.findWebInfoByWebsite(webInfo);
    	model.addAttribute("webInfo", webInfo);
    	ArticleInfo article = xupuService.findArticleInfoByEntryId(id);
    	
    	Page page = new Page();
		int pageNum = 0;
		//默认10个祠堂
		page.setCount(10);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<SClanHall> sclanHallList = sclanHallService.list();
		new PageInfo<>(sclanHallList).getTotal();
    	
		model.addAttribute("sclanHallList", sclanHallList);
        model.addAttribute("article",article);
        model.addAttribute("id",id);
        return "news/articleDetail";
    }
    
	@RequestMapping("news")
	public ModelAndView  information(){
	    ModelAndView mv = new ModelAndView("/news");
	    return mv;  
	}
	
	@RequestMapping("product")
	public ModelAndView  product(){
	    ModelAndView mv = new ModelAndView("/product");
	    return mv;  
	}
	
	@RequestMapping("productDetail")
	public ModelAndView  productDetail(){
	    ModelAndView mv = new ModelAndView("/productDetail");
	    return mv;  
	}
	
	@RequestMapping("orderList")
	public ModelAndView  orderList(){
	    ModelAndView mv = new ModelAndView("/orderList");
	    return mv;  
	}
	
	@RequestMapping("orderDetail")
	public ModelAndView  orderDetail(){
	    ModelAndView mv = new ModelAndView("/orderDetail");
	    return mv;  
	}
	
	@RequestMapping("shoppingCart")
	public ModelAndView  shoppingCart(){
	    ModelAndView mv = new ModelAndView("/shoppingCart");
	    return mv;  
	}
//	@RequestMapping("moreInformation")
//	public ModelAndView  moreInformation(){
//	    ModelAndView mv = new ModelAndView("/moreInformation");
//	    return mv;  
//	}
    
//	@RequestMapping("citang/citangDetail")
//	public String  clanHallDetail(){
////	    ModelAndView mv = new ModelAndView("citang/citangDetail");
//	    return "citang/citangDetail";  
//	}
	
	@RequestMapping("citang/citangDetail")
	public String  clanHallDetail(HttpSession session,Model model,Integer id){
    	ClanHall clanHall = xupuService.findClanHallById(id);
//    	String logined = (String)session.getAttribute("logined");
//    	System.out.println("logined!!::   "  +logined);
//    	if(logined==null||(logined!=null&&!logined.equalsIgnoreCase("success"))){
//    		clanHall.setDetails(clanHall.getIntroduction());
//    	}
//    	System.out.println("clanHall detail =   "  +clanHall.getDetails());
    	String surname = clanHall.getSurname();
    	//查同姓氏的百家姓和咨询列表
    	//分页参数设置
    	Page page = new Page();
    	int pageNum = 0;
    	//姓氏信息
		page.setCount(1);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> xsInfoList = sentryService.findSEntryListByModuleIdAndSurname(1, surname);
    	new PageInfo<>(xsInfoList).getTotal();
    	SEntry xsInfo = new SEntry();
    	if(xsInfoList!=null&&xsInfoList.size()>0){
    		xsInfo = xsInfoList.get(0);
    	}
		    	
		//姓氏资讯
		page.setCount(10);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> xszyList = sentryService.findSEntryListByModuleIdAndSurname(2, surname);
    	new PageInfo<>(xszyList).getTotal();
    	
    	model.addAttribute("xsInfo", xsInfo);
    	model.addAttribute("xszyList", xszyList);
        model.addAttribute("clanHall",clanHall);
        model.addAttribute("id",id);
	    return "citang/citangDetail";  
	}
	
	
	
	@RequestMapping("clanHallMap")
	public ModelAndView  clanHallMap(){
	    ModelAndView mv = new ModelAndView("/clanHallMap");
	    return mv;  
	}
	
//	@RequestMapping("clanHallMap")
//	public String  clanHallMap(Model model,@RequestBody ClanHallPage clanHallPage){
//		//分页参数设置
//    	Page page = clanHallPage.getPage();
//    	int pageNum = (page.getStart()-1);
//		if(pageNum<0){
//			return null;
//		}
//		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
//    	List<ClanHall> clanHallList = xupuService.findClanHallListByRecommendFlag(1);
//    	
//		int total = (int)new PageInfo<>(clanHallList).getTotal();
//		page.setTotal(total);
//		page.caculateLast(total);
//		
//		clanHallPage.setClanHallList(clanHallList);
//		clanHallPage.setPage(page);
//		
//        model.addAttribute("clanHallPage",clanHallPage);
//        return "clanHallMap"; 
//	}
	
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
	@RequestMapping("logined")
	public @ResponseBody ResponseEntity logined(HttpServletRequest request){
		ResponseEntity responseEntity = new ResponseEntity();
		HttpSession session = request.getSession(); //这句是获取session，true是表示如果没有则新建一个session，可以不用填
		session.setAttribute("logined","success"); //这句话是写入一个标识，你也可以把登录的账号设置在session里面，防止发起修改请求时恶意篡改另一个帐号的资料
		System.out.println("用户已登录！！！！！" );
		return responseEntity;  
	}
	
	@RequestMapping("login")
	public ModelAndView  login(){
	    ModelAndView mv = new ModelAndView("login");
	    return mv;  
	}
	
	@RequestMapping("sendMessage")
	public ModelAndView  sendMessage(){
	    ModelAndView mv = new ModelAndView("sendMessage");
	    return mv;  
	}

	@RequestMapping("baijiaxing")
	public String baijiaxing(Model model){
		//请求百家姓根据姓氏首字母
		try {
			Map<String, List<SEntry>> entryMap = xupuService.findBJXArticalListByModuleName("百家姓");
			model.addAttribute("entryMap",entryMap);
		} catch (PinyinException e) {
			e.printStackTrace();
		}
        return "baijiaxing";  
	}
	
	@RequestMapping("baijiaxingDetail")
    public String baijiaxingDetail(Model model,Integer id,WebInfo webInfo){
    	//请求首页数据
    	webInfo.setWebsite("宗祠网");
    	webInfo = xupuService.findWebInfoByWebsite(webInfo);
    	model.addAttribute("webInfo", webInfo);
    	ArticleInfo article = xupuService.findArticleInfoByEntryId(id);
    	String surname = article.getTitle();
    	//分页参数设置
    	Page page = new Page();
		int pageNum = 0;
		//默认10个姓氏咨询
		page.setCount(10);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
    	List<SEntry> xszxList = xupuService.findArticalListByModuleId(2);
		new PageInfo<>(xszxList).getTotal();
    	
		//默认10个祠堂
		page.setCount(10);
		PageHelper.offsetPage(pageNum*page.getCount(),page.getCount());
		List<SClanHall> sclanHallList = sclanHallService.findSClanHallListBySurname(surname);
		new PageInfo<>(sclanHallList).getTotal();
		
		model.addAttribute("xszxList", xszxList);
		model.addAttribute("sclanHallList", sclanHallList);
        model.addAttribute("article",article);
        model.addAttribute("id",id);
        return "baijiaxingDetail";
    }
//	@RequestMapping("allClanHall")
//	public ModelAndView  allClanHall(){
//	    ModelAndView mv = new ModelAndView("allClanHall");
//	    return mv;  
//	}
	
	@RequestMapping("login/thirdlogin")
	public ModelAndView thirdlogin(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("login");
		
		String code  =  request.getParameter("code");
		System.out.println("第三方登录返回结果："+code );
		if("".equals(code )||null==code ){
			System.out.println("回调函数没有执行");
			return null;
		}else{		
			 String url=HttpRequest.sendPost("http://open.51094.com/user/auth.html", "type=get_user_info&code="+code+"&appid="+appid+"&token="+token+"");
	         System.out.println(url);
			 //解析结果		
			 JSONObject jsonObj = new JSONObject(url);
            // 得到指定json key对象的value对象
	 		//解析封装对象
			String nickname = String.valueOf(jsonObj.get("name"));
			String img = String.valueOf(jsonObj.get("img"));
			String sex = String.valueOf(jsonObj.get("sex"));
			String uniqId = String.valueOf(jsonObj.get("uniq"));
			String from = String.valueOf(jsonObj.get("from"));
			
			SUser suser = new SUser();
			suser.setLoginFrom(from);
			suser.setNickname(nickname);
			suser.setUniqId(uniqId);
			suser.setImg(img);
			suser.setSex(Integer.valueOf(sex));
			
			Integer id = suserService.login(suser);
			suser.setId(id);
			mv.addObject("user", suser);
//			HttpSession session = request.getSession(true); //这句是获取session，true是表示如果没有则新建一个session，可以不用填
//			session.setAttribute("logined","success"); //这句话是写入一个标识，你也可以把登录的账号设置在session里面，防止发起修改请求时恶意篡改另一个帐号的资料
//			System.out.println("用户已登录！！！！！:"+session.getAttribute("logined") );
			return mv;
		}
	}
		
//	@RequestMapping("findSClanHallListByAlpha")
//	public @ResponseBody Map<String,List<SClanHall>>  findSClanHallListByAlpha(){
//		try {
//			return xupuService.findSClanHallListByAlpha();
//		} catch (PinyinException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@RequestMapping("citangji")
    public String citangji(Model model){
    	//请求祠堂大全根据姓氏首字母，原来是根据
		try {
			Map<String, List<SClanHall>> entryMap = xupuService.findSClanHallListByAlpha();
			model.addAttribute("entryMap",entryMap);
		} catch (PinyinException e) {
			e.printStackTrace();
		}
        return "citangji";
    }
	
	@RequestMapping("citang")
	public String  citang(Model model){
		//请求祠堂大全根据姓氏首字母，原来是根据
		try {
			Map<String, List<SClanHall>> entryMap = xupuService.findSClanHallListBySurnameAlpha();
			model.addAttribute("entryMap",entryMap);
		} catch (PinyinException e) {
			e.printStackTrace();
		}
        return "citang";
	}
	
}
