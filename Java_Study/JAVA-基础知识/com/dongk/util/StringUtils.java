package com.dongk.util;

import java.util.Date;

public class StringUtils {
    
	/**
	 * @Description ��������������ת��Ϊ�ַ��� 
	 */
	public static <T>  String  dataToString(T source){
		if(source == null){
			return "";
		}if(source instanceof String){
			return (String) source;
		}if(source instanceof Date){
			return DateHelper.getDateFormatStr("yyyy-MM-dd HH:mm:ss", (Date)source);
		}if(source instanceof Long){
			return String.valueOf(source);
		}if(source instanceof Double){
			return String.valueOf(source);
		}else{
		    return "";
		}
	} 
	
	/**
	 * @Description ����ת��Ϊ�ַ��� 
	 * @param source : ��Ҫת��������
	 * @param format : ��ʽ
	 */
	public static  String  dateToString(Date source, String format){
		if(source == null){
			return "";
		}else{
			return DateHelper.getDateFormatStr(format, source);
	    } 
	}
	
	/**
	 * @Description �ַ���ת����������������
	 * @param str   : ��Ҫת�����ַ���
	 * @param clazz : ���� 
	 */
	public static <T> T stringTodata(String str, Class clazz) throws Exception{
		if(str == null || "".equals(str.trim())){
			return null;
		}else if(clazz.equals(Date.class)){
			return (T) DateHelper.strToFormattedDate(str, "yyyy-MM-dd HH:mm:ss");
		}else if(clazz.equals(Long.class)){
			return (T) new Long(str);
		}else if(clazz.equals(Double.class)){
			return  (T) new Double(str);
		}else{
			return null;
		}
	}
	
	/**
	 * @Description ����ת��Ϊ�ַ��� 
	 * @param source : ��Ҫת��������
	 * @param format : ��ʽ
	 */
	public static Date stringTodata(String str, String format) throws Exception{
		if(str == null || "".equals(str.trim())){
			return null;
		}else{
			return DateHelper.strToFormattedDate(str, format);
		}
	}
	
	
}
