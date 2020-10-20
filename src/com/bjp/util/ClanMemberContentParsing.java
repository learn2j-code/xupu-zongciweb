package com.bjp.util;

import java.util.HashMap;
import java.util.Map;

import com.bjp.constant.ClanConstant;

public class ClanMemberContentParsing {
	
	public static String getChineseNumberFromContent(String content){
		if(content!=null){
			String chineseNumber = content.substring(content.indexOf("第")+1, content.indexOf("派"));
			return chineseNumber;
		}
		return null;
	}
	
	public static Map<String,String> parsingMemberRelationship(
			String memberRelationship,
			String spouseKeyWordString,
			String childKeyWordString,
			String otherKeyWordString){
		Map<String, String> resultMap = new HashMap<String,String>();
		//step1：找配偶，进行内容拆分，然后将内容填入resultMap返回
		String[] spouseKeyWordList = spouseKeyWordString.split(ClanConstant.COMMA);
		for(String keyWord:spouseKeyWordList){
			if(memberRelationship.indexOf(keyWord)>0){
				String spouseName = memberRelationship.replaceFirst(keyWord, "");
				resultMap.put("spouseName", spouseName);
				resultMap.put(spouseName, keyWord);
				return resultMap;
			}
		}
		//step2：子女找父亲，进行内容拆分，然后将内容填入resultMap返回
		String[] childKeyWordList = childKeyWordString.split(ClanConstant.COMMA);
		String[] otherKeyWordList = otherKeyWordString.split(ClanConstant.COMMA);
		for(String keyWord:childKeyWordList){
			if(memberRelationship.indexOf(keyWord)>0){
				String fatherName = memberRelationship.replaceFirst(keyWord, "");
				for(String otherkeyWord:otherKeyWordList){
					if(memberRelationship.indexOf(otherkeyWord)>0){
						fatherName = fatherName.replaceFirst(otherkeyWord, "");
					}
					resultMap.put("fatherName", fatherName);
					resultMap.put(fatherName, keyWord);
					return resultMap;
				}
			}
		}		
		//检测返回数据是否为空，为空则说明关键字还有遗漏，需要补全
		return resultMap;
	}
	
	
	
	
	public static void main(String[] args) {
//		//字先从生于清乾隆27年壬午四月初一日午时年五十七殁于清嘉庆二十三年戊寅十二月二十七日戍时葬横直冲中顾脑寅申兼甲庚
//		String content = "生于清乾隆二十九年甲申正月初六日卯     时寿六十四殁于清道光七年丁亥十一月初二日午时葬古冲内屋塘中脑亥山已向生子二 子贵、子甫女二长适戴仲细、次适周献新";
//		content = content.trim();
//		
//		String memberRelationship = "路公之子";
//		Map<String, String> contentMap = parsingMemberRelationship(memberRelationship,
//				ClanConstant.SPOUSEKEYWORD,ClanConstant.CHILDKEYWORD,ClanConstant.OTHERKEYWORD);
//		for(String contentKey:contentMap.keySet()){
//			System.out.println("keyword:"+contentKey);
//			System.out.println("content:"+contentMap.get(contentKey));
//		}
		//map中以关键字+内容的形式存好了用户的信息，再通过关键字的形式从map中获取内容 填补到数据库字段中
		//在获取到内容时记得对内容进行 trim操作，去除空格
		
		
		System.out.println(getChineseNumberFromContent("第三十一派（声派）"));
	}
	
	/**
	 * 解析三段式中的族谱成员详细信息
	 * @param memberDetail
	 * @param foreKeyWordString
	 * @param backKeyWordString
	 * @return
	 */
//	//职务、住址、居住地等关键词，只有简单描述的如离异、转房等---把未能匹配的都完整保留在一个字段中，人工介入！
//	public static Map<String,String> parsingMemberDetail(String memberDetail,String foreKeyWordString,String backKeyWordString){
//		memberDetail = memberDetail.replaceAll(" ", "");
//		Map<String, String> resultMap = new HashMap<String,String>();
//		//step1：对用户基本信息的串添加@标识符
//		//年关键字可以通过判断前面是否有“时”字   还有“歿葬失考” 情况   
//		//原（原名是xx）  原派   现派
//		//配：开初女 必信女等 是地名还是父亲名字？
//		//只有配才有“名”
//		String[] foreKeyWordList = foreKeyWordString.split(comma);
////			List keyWordList = java.util.Arrays.asList(keyWordString.split(","));
//		//前段内容替换；
//		for(String keyWord:foreKeyWordList){
//			if(keyWord.equals("时年")||keyWord.equals("时寿")){
//				memberDetail=memberDetail.replaceFirst(keyWord, "时"+intelnet+keyWord.substring(keyWord.indexOf("时")+1)+colon);
//				continue;
//			}
//			memberDetail = memberDetail.replaceFirst(keyWord, intelnet+keyWord+colon);
//		}
//		
//		String preString = memberDetail.substring(0,memberDetail.lastIndexOf(intelnet));
//		System.out.println("preString:"+preString);
//		String subString = memberDetail.substring(memberDetail.lastIndexOf(intelnet));
//		
//		//从最后一个@开始去解析子、女
//		String[] backKeyWordList = backKeyWordString.split(comma);
//		//后段内容替换：
//		for(String keyWord:backKeyWordList){
//			//判断第一个‘子’或‘女’前面是否有"生"字，有则在生字前加入@
//			if(subString.indexOf(keyWord)>0 &&
//				subString.substring((subString.indexOf(keyWord)-1)).startsWith("生")){
//				subString = subString.replaceFirst("生"+keyWord+subString.substring(subString.indexOf(keyWord)+1, subString.indexOf(keyWord)+2), 
//						intelnet+"生"+keyWord+colon+subString.substring(subString.indexOf(keyWord)+1, subString.indexOf(keyWord)+2)+asterisk);
//				continue;
//			}
//			subString = subString.replaceFirst(keyWord+subString.substring(subString.indexOf(keyWord)+1, subString.indexOf(keyWord)+2), 
//					intelnet+keyWord+colon+subString.substring(subString.indexOf(keyWord)+1, subString.indexOf(keyWord)+2)+asterisk);
//		}
//		System.out.println("subString:"+subString);
//		//step2：对子女个数、继承、出嫁关系 添加@分隔符
//		//对子女关系再解析
//		//系继入作标长子(是过继过来的，原作标的长子)  定出继作享为后(述定是过继给别人，作为作享的后人)  长适戴仲细(长女嫁给戴仲细)
//		String childKeyString = "系继入,出继,适";		
//		//生子一   述理止是什么意思？？？  女一 适周儒阶 连名字都没有 关系不好维护
//		memberDetail = preString + subString;		
//		System.out.println("memberDetail:"+memberDetail);	
//		//当字符串合并后，发现字符串前未加@符号  说明该字符串的第一个@前的内容就是该人的姓名  不过 还有 “才美女” “必信女”等 是父亲名字
//				
//		//step3：最后开始对加了标识符的字符串进行分割和装配，这块逻辑需要添加保护
//		String[] userInfoList = memberDetail.split(intelnet);
//		for(String userInfo:userInfoList){
//			if(!userInfo.isEmpty()){
//				String[] keyAndValue = userInfo.split(colon);
//				resultMap.put(keyAndValue[0], keyAndValue[1]);
//			}				
//		}		
//		return resultMap;
//	}
	/**
	 * 男性解析
	 * keyword：原派(派名、现派)，字，号，学名，原，又名，居，生于，年，寿，歿于，葬，(抚)子
	 * @param memberDetail
	 * @return
	 */
	/**
	 * 女性解析
	 * keyword：改嫁，xx离异，(开庭（父亲）长（季，幼，之）--此关系是否有用？)女，名，生于，年，寿，歿于，葬，(生)子，出继，系继入，过继，殇，(生)女，适，(xx)杜出--继室与原配子女的关系？，随母下堂，
	 * @param memberDetail
	 * @return
	 */
}
