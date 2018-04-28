package com.dongk.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import com.dongk.util.HttpClientUtil;
import com.dongk.util.StringUtils;

public class HttpClientUtilTest {
	
	@Test
	public void test01() {
		
		List<NameValuePair> param = new ArrayList<NameValuePair>();
		param.add(new BasicNameValuePair("Data", "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48TWVzc2FnZT48SGVhZD48VGVsZXBob25lU2hlZXRObz4xMTwvVGVsZXBob25lU2hlZXRObz48U2VydmVyQ2hhbm5lbD4xMTE8L1NlcnZlckNoYW5uZWw+PFByb2JsZW1UaW1lPjIwMTgwNDI0MjM1MzIzMDAyPC9Qcm9ibGVtVGltZT48Q3JlZGl0Tm8+MTExPC9DcmVkaXRObz48RW50Tm1hZT4xMTE8L0VudE5tYWU+PENvbnRhY3Rlcj4xMTE8L0NvbnRhY3Rlcj48VGVsPjExMTwvVGVsPjxFbWFpbD48L0VtYWlsPjxDb250YWN0SW5mbz4xMTE8L0NvbnRhY3RJbmZvPjxCaXpTeXN0ZW0+UzAxPC9CaXpTeXN0ZW0+PFByb2JsZW1UeXBlPjExMTwvUHJvYmxlbVR5cGU+PFByb2JsZW1DbGFzc2lmeT4xMTE8L1Byb2JsZW1DbGFzc2lmeT48UHJpb3JpdHk+MTE8L1ByaW9yaXR5PjxQcm9jZXNzUmVzdWx0PjExMTwvUHJvY2Vzc1Jlc3VsdD48UHJvY2Vzc05leHRVc2VySWQ+MTExMTwvUHJvY2Vzc05leHRVc2VySWQ+PFVzZXJJZD4xMTE8L1VzZXJJZD48L0hlYWQ+PC9NZXNzYWdlPg=="));
		param.add(new BasicNameValuePair("Sign", "23"));
		param.add(new BasicNameValuePair("SignType", "YPTYKF"));
		param.add(new BasicNameValuePair("SenderId", "CEBHDY"));
		param.add(new BasicNameValuePair("BusiCode", "YPTU001"));
		
		String returnMsg = HttpClientUtil.getConnectionURL("http://192.168.1.217:90/EptProxyService/CommDataService", param);
		
		System.out.println(returnMsg);
		System.out.println(returnMsg.substring(returnMsg.indexOf("Data=") + 5));
		try {
			System.out.println(StringUtils.getDecodeBase64(returnMsg.substring(returnMsg.indexOf("Data=") + 5)));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
