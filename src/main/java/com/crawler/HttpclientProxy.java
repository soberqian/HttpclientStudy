package com.crawler;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpclientProxy {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setProxy(new HttpHost("171.97.67.160", 3128, null))
				.build();   //添加代理
		HttpGet httpGet = new HttpGet("http://www.w3school.com.cn/b.asp");  //设置请求的方式及网页
		HttpClient httpClient = HttpClients.custom().
				setDefaultRequestConfig(defaultRequestConfig).build();  //配置httpClient
		HttpResponse httpResponse = httpClient.execute(httpGet);  //执行请求
		System.out.println("状态码为:"+httpResponse.getStatusLine().getStatusCode());
		String result = EntityUtils.toString(httpResponse.getEntity(),"gbk");  //获取结果，html
		System.out.println(result);   //输出结果
	}

}
