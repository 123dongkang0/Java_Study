package com.dongk.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * @ClassName XmlWriteUtil
 * @Description ���� XML�ַ���������
 * @author dongk
 * @Date 2018��4��24�� ����10:18:18
 * @version 1.0.0
 */
public class XmlWriteUtil {

	/**
	 * MAP����ת��ΪXML��ʽ
	 * @param map
	 * @param xmlDecl �磺 "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
	 * @return
	 */
	public static String callMap2XML(Map map, String xmlDecl) {
		StringBuffer sb = new StringBuffer();
		sb.append(xmlDecl);
		map2XML(map, sb);
		return sb.toString();
	}
	
	/**
	 * MAP����ת��ΪXML��ʽ���������ԣ�
	 * @date 2016-12-16
	 * @param elementMap �ڵ�����/ֵ
	 * @param attributeMap �ڵ�����/��������ֵ
	 * @param xmlDecl �磺 "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
	 * @return
	 */
	public static String callMap2XML(Map<String, Object> elementMap, Map<String, Object> attributeMap, String xmlDecl) {
		StringBuffer sb = new StringBuffer();
		sb.append(xmlDecl);
		map2XML(elementMap, attributeMap, sb);
		return sb.toString();
	}

	/**
	 * ����MAP����ΪXML��ʽ
	 * @param map
	 * @param sb
	 */
	@SuppressWarnings("rawtypes")
	private static void map2XML(Map map, StringBuffer sb) {
		Set set = map.keySet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			String key = (String) it.next();
			Object value = map.get(key);
			if (null == value)
				value = "";
			if (value.getClass().getName().equals("java.util.ArrayList")) {
				ArrayList list = (ArrayList) map.get(key);
				sb.append("<" + key + ">");
				for (int i = 0; i < list.size(); i++) {
					HashMap hm = (HashMap) list.get(i);
					map2XML(hm, sb);
				}
				sb.append("</" + key + ">");

			} else {
				if (value instanceof HashMap) {
					sb.append("<" + key + ">");
					map2XML((HashMap) value, sb);
					sb.append("</" + key + ">");
				} else {
					sb.append("<" + key + ">" + value + "</" + key + ">");
				}

			}

		}
	}
	
	/**
	 * ����MAP����ΪXML��ʽ���������ԣ�
	 * �ڵ����ƶ�Ӧ�������ж��ʱvalueֵΪmap
	 * �ڵ����ƶ�Ӧ�ж��ʱvalueֵΪlist������������Իᰴ��˳����ӣ�û������ֵҲ��Ҫһ����map��
	 * @date 2016-12-16
	 * @param elementMap �ڵ�����/ֵ
	 * @param attributeMap �ڵ�����/��������ֵ
	 * @param sb
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void map2XML(Map<String, Object> elementMap, Map<String, Object> attributeMap, StringBuffer sb) {
		Set set = elementMap.keySet();
		for (Iterator it = set.iterator(); it.hasNext();) {
			String key = (String) it.next();
			Object value = elementMap.get(key);
			if (null == value)
				value = "";
			if (value.getClass().getName().equals("java.util.ArrayList")) {
				ArrayList list = (ArrayList) elementMap.get(key);
				sb.append("<").append(key).append(">");
				for (int i = 0; i < list.size(); i++) {
					HashMap hm = (HashMap) list.get(i);
					map2XML(hm, attributeMap, sb);
				}
				sb.append("</").append(key).append(">");

			} else {
				if (value instanceof HashMap) {
					if (attributeMap.containsKey(key)) {
						addAttribute(key, attributeMap, sb);
					} else {
						sb.append("<").append(key).append(">");
					}
					map2XML((HashMap) value, attributeMap, sb);
					sb.append("</").append(key).append(">");
				} else {
					if (attributeMap.containsKey(key)) {
						addAttribute(key, attributeMap, sb);
					} else {
						sb.append("<").append(key).append(">");
					}
					sb.append(value).append("</").append(key).append(">");
				}

			}

		}
	}
	
	/**
	 * xml��������������
	 * @param key
	 * @param attributeMap
	 * @param sb
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static String addAttribute(String key, Map<String, Object> attributeMap, StringBuffer sb) {
		Object value = attributeMap.get(key);
		if (value.getClass().getName().equals("java.util.ArrayList")) {
			ArrayList list = (ArrayList) attributeMap.get(key);
			if (list.size() != 0) {
				sb.append("<").append(key);
				HashMap hm = (HashMap) list.get(0);//��˳��ȡ��һ��
				if (hm.size() != 0) {//��ֵ����ýڵ�û������ֵ
					Iterator it  = hm.entrySet().iterator();
					while (it.hasNext()) {
						Entry entry = (Entry)it.next();
						sb.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
					}
				}
				sb.append(">");
				list.remove(0);//������Ƴ���ǰ��һ��
				if (((ArrayList) attributeMap.get(key)).size() == 0) {
					attributeMap.remove(key);
				}
			}
		} else {
			HashMap hm = (HashMap) attributeMap.get(key);
			if (hm.size() != 0) {//��ֵ����ýڵ�û������ֵ
				Iterator it  = hm.entrySet().iterator();
				sb.append("<" + key);
				while (it.hasNext()) {
					Entry entry = (Entry)it.next();
					sb.append(" ").append(entry.getKey()).append("=").append("\"").append(entry.getValue()).append("\"");
				}
				sb.append(">");
				attributeMap.remove(key);//������Ƴ�
			}
		}
		return sb.toString();
	}
	
}
