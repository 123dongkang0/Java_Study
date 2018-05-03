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
		param.add(new BasicNameValuePair("Data", "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz48TWVzc2FnZT48SGVhZD48VGVsZXBob25lU2hlZXRObz4xMTwvVGVsZXBob25lU2hlZXRObz48U2VydmVyQ2hhbm5lbD61pdK7tLC/2jwvU2VydmVyQ2hhbm5lbD48UHJvYmxlbVRpbWU+MjAxODA0MjQyMzUzMjMwMDI8L1Byb2JsZW1UaW1lPjxDcmVkaXRObz4xMTE8L0NyZWRpdE5vPjxFbnRObWFlPjExMTwvRW50Tm1hZT48Q29udGFjdGVyPjExMTwvQ29udGFjdGVyPjxUZWw+tee7sDwvVGVsPjxFbWFpbD48L0VtYWlsPjxDb250YWN0SW5mbz4xMTE8L0NvbnRhY3RJbmZvPjxCaXpTeXN0ZW0+UzAxPC9CaXpTeXN0ZW0+PFByb2JsZW1UeXBlPjExMTwvUHJvYmxlbVR5cGU+PFByb2JsZW1DbGFzc2lmeT4xMTE8L1Byb2JsZW1DbGFzc2lmeT48UHJpb3JpdHk+MTE8L1ByaW9yaXR5PjxQcm9jZXNzUmVzdWx0PjExMTwvUHJvY2Vzc1Jlc3VsdD48UHJvY2Vzc05leHRVc2VySWQ+MTExMTwvUHJvY2Vzc05leHRVc2VySWQ+PFVzZXJJZD4xMTE8L1VzZXJJZD48L0hlYWQ+PC9NZXNzYWdlPg=="));
		param.add(new BasicNameValuePair("Sign", "23"));
//		param.add(new BasicNameValuePair("SignType", "YPTYKF"));
//		param.add(new BasicNameValuePair("SenderId", "CEBHDY"));
//		param.add(new BasicNameValuePair("BusiCode", "YPTU001"));
		
		String returnMsg = HttpClientUtil.getConnectionURL("http://192.168.1.91:8080/dyck_pt/yptAccept/acceptTelBill.action", param);
		System.out.println(returnMsg);
	}

}
