package com.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class HttpclientRenren {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException, IOException {
		HttpClient httpclient = HttpClients.custom().build(); //初始化httpclient
		String renRenLoginURL = "http://www.renren.com/PLogin.do"; //登陆的地址
		HttpPost httpost = new HttpPost(renRenLoginURL);  //采用post方法
		//建立一个NameValuePair数组，用于存储欲传送的参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
		nvps.add(new BasicNameValuePair("origURL","http://www.renren.com/home"));  //登录之后要请求的地址  
		nvps.add(new BasicNameValuePair("email", ""));   //输入你的邮箱地址
		nvps.add(new BasicNameValuePair("password", ""));   //输入你的密码
		@SuppressWarnings("unused")
		HttpResponse response = null;
		try {  
			//表单参数提交
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));  
			response = httpclient.execute(httpost); 
		} catch (Exception e) {  
			e.printStackTrace();  
		} finally {  
			httpost.abort();  
		}  
		//登录完成之后需要请求的内容
		HttpGet httpget = new HttpGet("http://www.renren.com/465530468/profile?v=info_timeline");  
		// 构建一个 responseHandler
		ResponseHandler<String> responseHandler = new BasicResponseHandler();  
		String responseBody = "";  
		try {  
			responseBody = httpclient.execute(httpget, responseHandler);  
		} catch (Exception e) {  
			e.printStackTrace();  
			responseBody = null;  
		} finally {  
			httpget.abort();  
			httpclient.getConnectionManager().shutdown();  
		}  
		//输出请求到的内容
		System.out.println(responseBody);

	}

}
