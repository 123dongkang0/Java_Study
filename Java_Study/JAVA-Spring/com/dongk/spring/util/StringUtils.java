package com.dongk.spring.util;

public class StringUtils {
   
	/**
	 * �滻�ַ����г��ֵ����е����ַ���
	 * 
	 * @param inString ���ܼ����ַ���
	 * @param oldPattern ���ַ���
	 * @param newPattern ���ַ���
	 * @return �滻����ַ���
	 */
	public static String replace(String inString, String oldPattern, String newPattern){
	   	if(!hasLength(inString) || !hasLength(oldPattern)  || newPattern == null){
	   		return inString;
	   	}
	   	StringBuilder sb = new StringBuilder();
	   	int pos = 0; //���ַ�����λ��
	   	int index = inString.indexOf(oldPattern);
	   	int patLen = oldPattern.length();
	   	while(index >= 0){
	   		sb.append(inString.substring(pos,index));
	   		sb.append(newPattern);
	   		pos = index + patLen;
	   		index = inString.indexOf(oldPattern,pos);
	   	}
	   	sb.append(inString.substring(pos));
	   	return sb.toString();
	}
	
	public static boolean hasLength(String str){
		return hasLength((CharSequence) str);
	}
	
	public static boolean hasLength(CharSequence str){
		return (str != null && str.length() > 0);
	}
	
}
