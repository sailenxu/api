package com.test.api.tools;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class response {
	String xlspath="C:\\Users\\xusaisai\\Desktop\\work\\7fresh\\7fresh-api.xlsx";
	String ip="http://mwpgwb.m.jd.com";
	String path="/mwp/mobileDispatch";

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		String parameters="api=7fresh.seckill.query&appName=7fresh&uuid=23sdafadf00000&brand=海尔&upc=120000&storeId=131215&pin=dzx123&data.seckillId=2017101710&data.page=2&data.pageSize=20";
//		String parameters2="api=7fresh.ware.hasPromotionWares&client=android&appName=7fresh&uuid=23sdafadf&data={\"storeId\":131215,\"promotionId\":4524,\"page\":1,\"pagesize\":10}";
		response r=new response();
		System.out.println(r.getURL());
		apiTool apitool=new apiTool(r.getURL());
		System.out.println(apitool.getJson());
		
		
	}
	/***
	 * 生成url中的参数（键值对）
	 * @return
	 * @throws Exception
	 */
	private String getURLpram() throws Exception{
		String urlPram="";
		xlsTool xlstool=new xlsTool(xlspath);
		List<String> cells1=xlstool.getAllCellInL(0, 0);//第1列的值
		List<String> cells2=xlstool.getAllCellInL(0, 1);//第2列的值
		for (int i = 0; i < cells1.size()-1; i++) {
			urlPram=urlPram+cells1.get(i)+"="+cells2.get(i)+"&";
		}
		urlPram=urlPram+cells1.get(cells1.size()-1)+"="+cells2.get(cells2.size()-1);
		return urlPram;
		
	}
	/***
	 * 生成完整url
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public String getURL() throws Exception{
		String url=ip+path+"?"+getURLpram();
		return url;
	}
}
