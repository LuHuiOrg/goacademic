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
	
		String target = "{\n" +
                "\t\"error\": 0,\n" +
                "\t\"status\": \"success\",\n" +
                "\t\"date\": \"2017-07-22\",\n" +
                "\t\"results\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"currentCity\": \"北京\",\n" +
                "\t\t\t\"pm25\": \"34\",\n" +
                "\t\t\t\"index\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"穿衣\",\n" +
                "\t\t\t\t\t\"zs\": \"较冷\",\n" +
                "\t\t\t\t\t\"tipt\": \"穿衣指数\",\n" +
                "\t\t\t\t\t\"des\": \"建议着大衣、呢外套加毛衣、卫衣等服装。体弱者宜着厚外套、厚毛衣。因昼夜温差较大，注意增减衣服。\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"洗车\",\n" +
                "\t\t\t\t\t\"zs\": \"不宜\",\n" +
                "\t\t\t\t\t\"tipt\": \"洗车指数\",\n" +
                "\t\t\t\t\t\"des\": \"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"感冒\",\n" +
                "\t\t\t\t\t\"zs\": \"极易发\",\n" +
                "\t\t\t\t\t\"tipt\": \"感冒指数\",\n" +
                "\t\t\t\t\t\"des\": \"天气寒冷，且昼夜温差很大，极易发生感冒。请特别注意增加衣服保暖防寒。\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"运动\",\n" +
                "\t\t\t\t\t\"zs\": \"适宜\",\n" +
                "\t\t\t\t\t\"tipt\": \"运动指数\",\n" +
                "\t\t\t\t\t\"des\": \"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"title\": \"紫外线强度\",\n" +
                "\t\t\t\t\t\"zs\": \"中等\",\n" +
                "\t\t\t\t\t\"tipt\": \"紫外线强度指数\",\n" +
                "\t\t\t\t\t\"des\": \"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t],\n" +
                "\t\t\t\"weather_data\": [\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"date\": \"周六 07月22日 (实时：24℃)\",\n" +
                "\t\t\t\t\t\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/yin.png\",\n" +
                "\t\t\t\t\t\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/yin.png\",\n" +
                "\t\t\t\t\t\"weather\": \"阴\",\n" +
                "\t\t\t\t\t\"wind\": \"南风微风\",\n" +
                "\t\t\t\t\t\"temperature\": \"28 ~ 24℃\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"date\": \"周日\",\n" +
                "\t\t\t\t\t\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/leizhenyu.png\",\n" +
                "\t\t\t\t\t\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/leizhenyu.png\",\n" +
                "\t\t\t\t\t\"weather\": \"雷阵雨\",\n" +
                "\t\t\t\t\t\"wind\": \"南风微风\",\n" +
                "\t\t\t\t\t\"temperature\": \"28 ~ 24℃\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"date\": \"周一\",\n" +
                "\t\t\t\t\t\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/zhenyu.png\",\n" +
                "\t\t\t\t\t\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/yin.png\",\n" +
                "\t\t\t\t\t\"weather\": \"阵雨转阴\",\n" +
                "\t\t\t\t\t\"wind\": \"东北风微风\",\n" +
                "\t\t\t\t\t\"temperature\": \"29 ~ 23℃\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"date\": \"周二\",\n" +
                "\t\t\t\t\t\"dayPictureUrl\": \"http://api.map.baidu.com/images/weather/day/duoyun.png\",\n" +
                "\t\t\t\t\t\"nightPictureUrl\": \"http://api.map.baidu.com/images/weather/night/yin.png\",\n" +
                "\t\t\t\t\t\"weather\": \"多云转阴\",\n" +
                "\t\t\t\t\t\"wind\": \"南风微风\",\n" +
                "\t\t\t\t\t\"temperature\": \"28 ~ 22℃\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
		
	 String city = "北京";	
		
	 String json = WeatherUtil.getJson(city);	
	 System.out.println(json);
	 String url = "http://api.map.baidu.com/telematics/v3/weather?location="+city+"&output=json&ak=eF0eRGFALjkkqTx6sR8TwyWZ";
	 
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
