package com.crawler;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpclientTest2 {
	public static void main(String[] args) throws ParseException, IOException  {
		String url = "http://www.w3school.com.cn/b.asp";
	    HttpClient httpClient = HttpClients.custom().build(); //初始化httpclient
	    HttpGet httpGet = new HttpGet(url);
	    //获取结果
	    HttpResponse httpResponse = null;
	    try {
	      httpResponse = httpClient.execute(httpGet);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    HttpEntity httpEntity = httpResponse.getEntity();
	    System.out.println("get code"+httpResponse.getStatusLine().getStatusCode());
	    String entity = EntityUtils.toString(httpEntity,"gbk"); //注意这里设置编码
	    System.out.println(entity);

	}
}

