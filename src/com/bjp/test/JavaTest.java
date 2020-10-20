package com.bjp.test;

import java.util.Arrays;
import java.util.List;

import com.bjp.constant.ClanConstant;

public class JavaTest {

	public static void main(String[] args) {
//		String identity = "长子";
//		List<String> sonKeyWordList = Arrays.asList( (ClanConstant.SONKEYWORD).split(ClanConstant.COMMA));
//		List<String> daughterKeyWordList = Arrays.asList((ClanConstant.DAUGHTERWORD).split(ClanConstant.COMMA));
//		List<String> husbandKeyWordList = Arrays.asList((ClanConstant.HUSBANDWORD).split(ClanConstant.COMMA));
//		List<String> wifeKeyWordList = Arrays.asList((ClanConstant.WIFEKEYWORD).split(ClanConstant.COMMA));
//		if(sonKeyWordList.contains(identity)||husbandKeyWordList.contains(identity)){
//			System.out.println(ClanConstant.CLANMEMBERCONTENT_MALE);
//		}
//		if(daughterKeyWordList.contains(identity)||wifeKeyWordList.contains(identity)){
//			System.out.println(ClanConstant.CLANMEMBERCONTENT_FEMALE);
//		}
//		String url = "http://localhost/zongciweb/wenzhang/2222";
//		int start = url.indexOf("wenzhang");
//		int end = 0;
//		int idStart = 0;
//		if(start>0){
//			end = start+8;
//			idStart = start+9;
//		}
//		System.out.println(start);
//		System.out.println(url.substring(start, end));
//		System.out.println(url.substring(idStart));
		
		String url = "http://jpay.100jp.cn/seo/media/465/20180824/015432_1535046872650.jpg";
		System.out.println(url.substring(url.indexOf("seo/")));
	}

}
