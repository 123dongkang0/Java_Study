package com.dongk.spring.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class StringUtils {
	
	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
	
	private static final String FOLDER_SEPARATOR = "/";
	
	private static final String TOP_PATH = "..";
	
	private static final String CURRENT_PATH = ".";
   
	/**
	 * 替换字符串中出现的所有的子字符串
	 * 
	 * @param inString 接受检查的字符串
	 * @param oldPattern 旧字符串
	 * @param newPattern 新字符串
	 * @return 替换后的字符串
	 */
	public static String replace(String inString, String oldPattern, String newPattern){
	   	if(!hasLength(inString) || !hasLength(oldPattern)  || newPattern == null){
	   		return inString;
	   	}
	   	StringBuilder sb = new StringBuilder();
	   	int pos = 0; //旧字符串的位置
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
	
	/**
	 * Normalize the path by suppressing sequences like "path/.." and
	 * inner simple dots.
	 * <p>The result is convenient for path comparison. For other uses,
	 * notice that Windows separators ("\") are replaced by simple slashes.
	 * @param path the original path
	 * @return the normalized path
	 */
	public static String cleanPath(String path){
		if(path == null){
			return null;
		}
		String pathToUse = replace(path, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);
		
		// Strip prefix from path to analyze, to not treat it as part of the
		// first path element. This is necessary to correctly parse paths like
		// "file:core/../core/io/Resource.class", where the ".." should just
		// strip the first "core" directory while keeping the "file:" prefix.
		
		//分析 path 剥离前缀, 不要对前缀做任何处理；
		int prefixIndex = pathToUse.indexOf(":");
		String prefix = "";
		if(prefixIndex != -1){
			prefix = pathToUse.substring(0,prefixIndex + 1);
			if(prefix.contains("/")){
				prefix = "";
			}else{
				pathToUse = pathToUse.substring(prefixIndex + 1);
			}
		}
		if(pathToUse.startsWith(FOLDER_SEPARATOR)){
			prefix = prefix + FOLDER_SEPARATOR;
			pathToUse = pathToUse.substring(1);
		}
		
		String[] pathArray =  delimitedListToStringArray(pathToUse,FOLDER_SEPARATOR);
		List<String> pathElements = new LinkedList<String>();
		int tops = 0;
		
		for(int i=pathArray.length - 1; i>=0; i--){
			String element = pathArray[i];
			if(CURRENT_PATH.equals(element)){
				//指向当前目录 - 删除它
			}else if(TOP_PATH.equals(element)){
				//注册顶部路径
				tops++;
			}else{
				if(tops > 0){
					tops--;
				}else{
					pathElements.add(0, element);
				}
			}
		}
		
		for(int i=0; i<tops; i++){
			pathElements.add(0, TOP_PATH);
		}
		
		return null;
		
	}
	
	public static String[] delimitedListToStringArray(String str, String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}
	
	/**
	 *  字符串通过分隔符转换成字符串数组。 
	 *  <p>
	 *  单个分割符又多个"字符组成：我们可以认为这是一个字符串分隔符。"
	 *  @param str : 输入的字符串
	 *  @param delimiter : 分隔符
	 *  @param charsToDelete : 一组想要删除的字符，用于删除不希望的换行符：e.g. "\r\n\f" 
	 *  将删除字符串中所有不希望的换行符。
	 *  </p>
	 */
	public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
		if (str == null) {
			return new String[0];
		}
		if (delimiter == null) {
			return new String[] {str};
		}
		List<String> result = new ArrayList<String>();
		if ("".equals(delimiter)) {
			for (int i = 0; i < str.length(); i++) {
				result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
			}
		}else {
			int pos = 0;
			int delPos;
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
				pos = delPos + delimiter.length();
			}
			if (str.length() > 0 && pos <= str.length()) {
				// 增加字符串的其余部分, 但是在字符串为 ""的时候不做处理.
				result.add(deleteAny(str.substring(pos), charsToDelete));
			}
		}
		return toStringArray(result);
	}
	
	/**
	 * 删除给定字符串的任何字符.
	 * @param inString 原始字符串
	 * @param charsToDelete 一组需要删除的字符.
	 *       E.g "az\n" 将删除 'a' 's' '换行'
	 * @return 返回删除后的字符串
	 */
	public static String deleteAny(String inString, String charsToDelete) {
		if (!hasLength(inString) || !hasLength(charsToDelete)) {
			return inString;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inString.length(); i++) {
			char c = inString.charAt(i);
			if (charsToDelete.indexOf(c) == -1) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 *将结合转换成 String 数组, 这个集合必须包含String.
	 * @param collection ：集合
	 * @return 数组
	 */
	public static String[] toStringArray(Collection<String> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new String[collection.size()]);
	}
	
	public static boolean hasLength(String str){
		return hasLength((CharSequence) str);
	}
	
	public static boolean hasLength(CharSequence str){
		return (str != null && str.length() > 0);
	}
	
}
