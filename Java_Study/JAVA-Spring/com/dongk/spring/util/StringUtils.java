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
		
		//���� path ����ǰ׺, ��Ҫ��ǰ׺���κδ���
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
				//ָ��ǰĿ¼ - ɾ����
			}else if(TOP_PATH.equals(element)){
				//ע�ᶥ��·��
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
	 *  �ַ���ͨ���ָ���ת�����ַ������顣 
	 *  <p>
	 *  �����ָ���ֶ��"�ַ���ɣ����ǿ�����Ϊ����һ���ַ����ָ�����"
	 *  @param str : ������ַ���
	 *  @param delimiter : �ָ���
	 *  @param charsToDelete : һ����Ҫɾ�����ַ�������ɾ����ϣ���Ļ��з���e.g. "\r\n\f" 
	 *  ��ɾ���ַ��������в�ϣ���Ļ��з���
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
				// �����ַ��������ಿ��, �������ַ���Ϊ ""��ʱ��������.
				result.add(deleteAny(str.substring(pos), charsToDelete));
			}
		}
		return toStringArray(result);
	}
	
	/**
	 * ɾ�������ַ������κ��ַ�.
	 * @param inString ԭʼ�ַ���
	 * @param charsToDelete һ����Ҫɾ�����ַ�.
	 *       E.g "az\n" ��ɾ�� 'a' 's' '����'
	 * @return ����ɾ������ַ���
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
	 *�����ת���� String ����, ������ϱ������String.
	 * @param collection ������
	 * @return ����
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
