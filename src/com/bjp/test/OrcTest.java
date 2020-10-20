package com.bjp.test;

import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class OrcTest {
    //设置APPID/AK/SK
    public static final String APP_ID = "10768617";
    public static final String API_KEY = "oZWGKB4DToktQz69euqKoHPO";
    public static final String SECRET_KEY = "lgw08bLmUgk8crkyjKenMvX9XmspABB5";

    public void sample(AipOcr client) {
    	// 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        
        
        // 参数为本地图片路径
        String image = "test.jpg";
        JSONObject res = client.basicGeneral(image, options);
        System.out.println(res.toString(2));

        // 参数为本地图片二进制数组
//        byte[] file = readImageFile(image);
//        res = client.basicGeneral(file, options);
//        System.out.println(res.toString(2));

        
        // 通用文字识别, 图片参数为远程url图片
//        res = client.basicGeneralUrl(url, options);
//        System.out.println(res.toString(2));

    }
    
    
    public static void main(String[] args) {
//        // 初始化一个AipOcr
//        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//    	// 传入可选参数调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
////        options.put("language_type", "CHN_ENG");
////        options.put("detect_direction", "true");
////        options.put("detect_language", "true");
////        options.put("probability", "true");
//        
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
////        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
////        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
////        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//        options.put("detect_direction", "true");
//        options.put("probability", "true");


        // 调用接口
        int cols = 4;
        int num = 3;
        for(int i=3;i<=num;i++){
        	for (int j = 0; j < cols; j++) {  
        		// 初始化一个AipOcr
                AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
            	// 传入可选参数调用接口
                HashMap<String, String> options = new HashMap<String, String>();
                
                // 可选：设置网络连接参数
                client.setConnectionTimeoutInMillis(2000);
                client.setSocketTimeoutInMillis(60000);

                options.put("detect_direction", "true");
                options.put("probability", "true");
        		
        		String path = "D://pictures//temp//";
        		path += "map_" + i + "_" + j + ".jpg"; 
        		JSONObject res = client.basicAccurateGeneral(path, options);
        		System.out.println(res.toString(2));
    	        JSONArray res1 = res.getJSONArray("words_result");
    	        int size = res1.length();
    	        for(int k=size-1;k>=0;k--){
    	        	System.out.println(res1.getJSONObject(k).get("words"));
    	        }
        	}  
        }
        
        
//        String path = "D://pictures//temp//map_2_2.jpg";
//        JSONObject res = client.basicAccurateGeneral(path, options);
//        System.out.println(res.toString(2));
//        JSONArray res1 = res.getJSONArray("words_result");
//        int size = res1.length();
//        for(int i=size-1;i>=0;i--){
//        	System.out.println(res1.getJSONObject(i).get("words"));
//        }
    }

	
}
