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
	 * �����ַ
	 */
	public static String getConnectionURL(String url, List<NameValuePair> params) {
		String returnMsg = "";
		/*
		 * NameValuePairʵ����������ķ�װ
		 */
		if (params == null) {
			params = new ArrayList<NameValuePair>();
		}

		CloseableHttpClient httpClient = getHttpClient();

		try {
			
			/* ����HTTPost���� */
			HttpPost httpRequest = new HttpPost(url);
			/* ������������������� */
			httpRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
			/* �������󲢵ȴ���Ӧ */
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			/* ��״̬��Ϊ200 ok */

			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				/* ���������� */
				returnMsg = EntityUtils.toString(httpResponse.getEntity());
				// System.out.println(returnMsg);
			} else {
				JSONObject obj = new JSONObject();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("flag", "error");
				map.put("errorMsg", "�������");
				obj.putAll(map);
				returnMsg = obj.toString();
			}
			// httpClient.close();

		} catch (ClientProtocolException e) {
			// TODO ��������ʧ��
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			JSONObject obj = new JSONObject();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "error");
			map.put("errorMsg", "�������");
			obj.putAll(map);
			returnMsg = obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject obj = new JSONObject();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("flag", "error");
			map.put("errorMsg", "�������");
			obj.putAll(map);
			returnMsg = obj.toString();
		}

		return returnMsg;
	}

	/**
	 * �ļ��ϴ�
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
	 * ȡ������
	 * @return
	 */
	public static CloseableHttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		return httpClient;
	}

	/**
	 * �ر�����
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
