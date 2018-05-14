package com.dongk.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;

import com.dongk.util.XmReadlUtil;

public class XmlReadUtilTest {
    
	public static void main(String args[]) {
		try {
			Document document = new SAXReader().read(new File("D://menuCode.xml"));  
			 Map<String, Object> map = XmReadlUtil.Dom2Map(document.getRootElement());
			// System.out.println(map);
			
			 ArrayList<Map<String,String>> list = (ArrayList<Map<String, String>>) map.get("ROW");
			 for(Map<String,String> str : list) {
				// System.out.println(str.get("MENU_CODE"));
				 ReadMenuConfig.parse(str.get("MENU_CODE"));
			 }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
