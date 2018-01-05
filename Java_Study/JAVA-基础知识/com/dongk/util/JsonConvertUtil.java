package com.dongk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

/**
 * @author dongk
 * @date 2018-01-05
 * @description Jsonת��������(json-lib-2.4.jar)
 *  
 */
public class JsonConvertUtil {
    
	
	/**
	 *@description ��json�ַ����л�ȡָ������ 
	 */
	public static <T> T get(JSONObject json, String value){
		return (T) json.get(value);
	}
	
	private static final String  format ="yyyy-MM-dd HH:mm:ss";  
	
	private static class JsonDateValueProcessor implements JsonValueProcessor{
		
		private final SimpleDateFormat sdf;
		
		public JsonDateValueProcessor(String formatStr){
			if(formatStr != null && !"".equals(formatStr)){
				sdf = new SimpleDateFormat(formatStr,Locale.CHINA);
			}else{
				sdf = new SimpleDateFormat(format,Locale.CHINA);
            
			}
		}
		 
		public Object processArrayValue(Object paramObject, JsonConfig paramJsonConfig) 
		{
			return process(paramObject);
		}

		public Object processObjectValue(String paramString, Object paramObject, JsonConfig paramJsonConfig) 
		{
			return process(paramObject);
		}
		
		private Object process(Object value)
		{  
			if(value instanceof Date){    
		        return sdf.format(value);  
		    }    
		    return value == null ? "" : value.toString();    
		}
		
	}
	

	public static <T> JSONObject getJSONObject(T javaBean, String[] excludes){
		return getJSONObject(javaBean, excludes, null);
	}
	
	/**
	 * @author dongk
	 * @date 2018-01-05
	 * @description ����JSONObject����
	 * @param javaBean : java����
	 * @param excludes : ��Ҫ�ų�������
	 * @param format   : java������java.util.Date����ת���ĸ�ʽ
	 * 
	 * @return ���ɵ�JSONObject����  
	 */
	public static <T> JSONObject getJSONObject(T javaBean, String[] excludes, String format){
		
		JsonConfig jsonConfig =  new  JsonConfig();  
		
		if(excludes != null && excludes.length > 0)
			jsonConfig.setExcludes(excludes);
		
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor(format));
		
		return JSONObject.fromObject(javaBean, jsonConfig);  
		
	}
	
	
	/**
	 * @author dongk
	 * @date 2018-01-05
	 * @description ����JSONObject����,������ֵΪnull������
	 * @param javaBean : java����
	 * @param excludes : ��Ҫ�ų�������
	 * @param format   : java������java.util.Date����ת���ĸ�ʽ
	 * 
	 * @return ���ɵ�JSONObject����  
	 */
	public static <T> JSONObject getJSONObjectFilterNull(T javaBean, String[] excludes, String format){
		
		JsonConfig jsonConfig =  new  JsonConfig();  
		
		if(excludes != null && excludes.length > 0)
			jsonConfig.setExcludes(excludes);
		
		jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor(format));
		
		PropertyFilter filter = new PropertyFilter() {
	        public boolean apply(Object object, String fieldName, Object fieldValue) {
	          return null == fieldValue;
	       }
		 };
		jsonConfig.setJsonPropertyFilter(filter);
		
		return JSONObject.fromObject(javaBean, jsonConfig);  
		
	}
	
}
