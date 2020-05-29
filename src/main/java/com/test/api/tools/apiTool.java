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
	 * �ӽӿڻ�ȡjson
	 * @return
	 * @throws Exception 
	 */
	public String getJson(String strurl) throws Exception{
		String json="";
		//����rui�ķ�ʽ����ֹʹ��string���ڱ����ʽ����
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
