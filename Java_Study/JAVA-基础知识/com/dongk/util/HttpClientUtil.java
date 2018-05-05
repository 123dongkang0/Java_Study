package com.dongk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class HttpClientUtil {

	private static CloseableHttpClient httpClient;

	/**
	 * 请求地址
	 */
	public static String getConnectionURL(String url, List<NameValuePair> params) {
		String returnMsg = "";
		/*
		 * NameValuePair实现请求参数的封装
		 */
		if (params == null) {
			params = new ArrayList<NameValuePair>();
		}

		CloseableHttpClient httpClient = getHttpClient();

		try {
			
			/* 建立HTTPost对象 */
			HttpPost httpRequest = new HttpPost(url);
			/* 添加请求参数到请求对象 */
			httpRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			/* 发送请求并等待响应 */
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			/* 若状态码为200 ok */

			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				/* 读返回数据 */
				returnMsg = EntityUtils.toString(httpResponse.getEntity());
				// System.out.println(returnMsg);
			} else {
				JSONObject obj = new JSONObject();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("flag", "error");
				map.put("errorMsg", "请求出错");
				obj.putAll(map);
				returnMsg = obj.toString();
			}
			// httpClient.close();

		} catch (ClientProtocolException e) {
			// TODO 返回连接失败
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			JSONObject obj = new JSONObject();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "error");
			map.put("errorMsg", "请求出错");
			obj.putAll(map);
			returnMsg = obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject obj = new JSONObject();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "error");
			map.put("errorMsg", "请求出错");
			obj.putAll(map);
			returnMsg = obj.toString();
		}

		return returnMsg;
	}

	/**
	 * 文件上传
	 * 
	 * @param path
	 */
	public static void fileUpload(String url, String filePath) {

		CloseableHttpClient httpclient = getHttpClient();
        
		FileBody fileBody = new FileBody(new File(filePath));
		  
		try {
			HttpPost post = new HttpPost(url);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addPart("file", fileBody);
			
			//builder.addPart("listSeqNo", new StringBody("12345678548",ContentType.TEXT_HTML));

			HttpEntity entity = builder.build();

			post.setEntity(entity);
			HttpResponse response = httpclient.execute(post);
			if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {

				HttpEntity entitys = response.getEntity();
				if (entity != null) {
					System.out.println(entity.getContentLength());
					System.out.println(EntityUtils.toString(entitys));
				}
			}
			// httpclient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得链接
	 * @return
	 */
	public static CloseableHttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		return httpClient;
	}

	/**
	 * 关闭链接
	 */
	public static void closeConnection() {
		if (httpClient != null) {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
