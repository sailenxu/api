package com.test.api.tools;

import java.net.URI;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class apiTool {
	/***
	 * 从接口获取json
	 * @return
	 * @throws Exception 
	 */
	public String getJson(String strurl) throws Exception{
		String json="";
		//采用rui的方式，防止使用string由于编码格式报错
		URL url=new URL(strurl);
		URI uri=new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
		
		HttpClient http=new DefaultHttpClient();
		HttpGet httpGet=new HttpGet(uri);
		try {
			HttpResponse response=http.execute(httpGet);
			HttpEntity entity=response.getEntity();
			json=EntityUtils.toString(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
