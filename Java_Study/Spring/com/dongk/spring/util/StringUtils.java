package com.dongk.spring.util;

public class StringUtils {
   
	/**
	 * Ìæ»»×Ö·û´®ÖÐ³öÏÖµÄËùÓÐµÄ×Ó×Ö·û´®
	 * 
	 * @param inString ½ÓÊÜ¼ì²éµÄ×Ö·û´®
	 * @param oldPattern ¾É×Ö·û´®
	 * @param newPattern ÐÂ×Ö·û´®
	 * @return Ìæ»»ºóµÄ×Ö·û´®
	 */
	public static String replace(String inString, String oldPattern, String newPattern){
	   	if(!hasLength(inString) || !hasLength(oldPattern)  || newPattern == null){
	   		return inString;
	   	}
	   	StringBuilder sb = new StringBuilder();
	   	int pos = 0; //¾É×Ö·û´®µÄÎ»ÖÃ
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
