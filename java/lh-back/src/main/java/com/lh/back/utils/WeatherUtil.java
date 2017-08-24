package com.lh.back.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;
import com.lh.back.UtilPojo.WeatherBean;

public class WeatherUtil {
	
	/**
	 * 通过百度API获取当前城市天气情况
	 * @param city 城市
	 * @return 天气情况JSON字符串
	 * @throws IOException
	 */
	public static String getJson(String city) throws IOException{
			
			String urlStr= "http://api.map.baidu.com/telematics/v3/weather?location="+URLEncoder.encode(city,"utf-8")+"&output=json&ak=eF0eRGFALjkkqTx6sR8TwyWZ";
	        //http://api.map.baidu.com/telematics/v3/weather?location=库尔勒&output=json&ak=eF0eRGFALjkkqTx6sR8TwyWZ
	        //String urlStr = "http://api.map.baidu.com/telematics/v3/weather?location="+URLEncoder.encode(city,"utf-8")+"&output=json&ak=";
	        URL url = new URL(urlStr);
	        //获得链接O
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        //得到输入流
	        InputStream inputStream = connection.getInputStream();
	        //字节流--》字符流
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        byte[] b = new byte[1024];//byte数组
	        int n=0;//临时变量
	        while ((n=inputStream.read(b))!=-1){
	            baos.write(b,0,n);
	        }
	        String jsonStr=baos.toString("utf-8");
	        baos.close();//关闭流
	        inputStream.close();//关闭
	        return jsonStr;
		
	}
	
	//获取
	public static WeatherBean getWeather() throws IOException{
	
	 String city = "北京";	
		
	 String json = WeatherUtil.getJson(city);	
	 System.out.println(json);
	 
	 WeatherBean weatherBean = JSON.parseObject(json, WeatherBean.class);
	 System.out.println(weatherBean.toString());
     //List<WeatherResult> weatherResults = weatherBean.getResults();
     //WeatherData weatherData = weatherResults.get(0).getWeather_data().get(0);
     return weatherBean;
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println(getWeather().toString());
	}

}
