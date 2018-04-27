package com.dongk.util;

import java.util.Date;

import org.apache.commons.codec.binary.Base64;

public class StringUtils {
    
	/**
	 * @Description ��������������ת��Ϊ�ַ��� 
	 */
	public static <T>  String  dataToString(T source){
		if(source == null){
			return "";
		}if(source instanceof Integer){
			return (String) String.valueOf(source);
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
		}else if(clazz.equals(Integer.class)){
			return (T) new Integer(str);
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
	
	/**
	 * �������� "CN/�й�" ���ַ�����
	 * ��ȡ"CN"����
	 */
	public static String getCode(String str){
		if(str == null || "".equals(str.trim())){
			return null;
		}else{
			String[] strArray =  str.split("/");  
			if(strArray != null && strArray.length >= 1){
				return strArray[0];
			}
		}
		return null;
	}
	
	/**
	 * �������� "CN/�й�" ���ַ�����
	 * ��ȡ"�й�"����
	 */
	public static String getName(String str){
		if(str == null || "".equals(str.trim())){
			return null;
		}else{
			String[] strArray =  str.split("/");  
			if(strArray != null && strArray.length >= 2){
				return strArray[1];
			}
		}
		return null;
	}
	
	/**
	 * ������ת�����ַ�����ÿ��Ԫ��ʹ�� ";" ���� 
	 */
	public static String arrayTostr(String[] arrays){
		StringBuilder returnStr = new StringBuilder();
		for(String str : arrays){
			returnStr.append(";" + str);
		}
		returnStr.deleteCharAt(0);
		return returnStr.toString();
	}
	
	/**
	 * @Description ����nλ�����
	 * @param n
	 * @return
	 */
	public static String generateRandom(int n) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();                
		for(int i=0; i<n; i++)
			sb.append(random.nextInt(10));
		return sb.toString();
	}
	
	 /**
	 * @Description �õ�base64������ַ���
	 * @param str
	 * @return
	 */
	public static String getEncodeBase64(String str) {
		 Base64 base64 = new Base64();
		 return new String(base64.encode(str.getBytes()));
	 }
	
	 /**
	  * @Description �õ�base64������ַ���
	  * @param str
	  * @return
	  */
	public static String getDecodeBase64(String str) {
		 Base64 base64 = new Base64();
		 return new String(base64.decode(str.getBytes()));
	 }
}
