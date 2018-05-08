package com.dongk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXValidator;
import org.dom4j.util.XMLErrorHandler;

/**
 * @ClassName XmReadlUtil
 * @Description ��ȡXML�ַ���������
 * @author dongk
 * @Date 2018��4��24�� ����10:23:17
 * @version 1.0.0
 */
public class XmReadlUtil {
	
	/**
	 * @Description �õ�ĳ���ڵ��ֵ
	 * @param root
	 * @param keys
	 * @return
	 */
	public static String getValueByKey(Map<String, Object> root,String... keys){
	   if(keys.length > 1) {
		   List<String> param = new ArrayList<String>(Arrays.asList(keys));
		   Map<String, Object> parent = (Map<String, Object>) root.get(param.remove(0));
		   return getValueByKey(parent,param.toArray(new String[param.size()]));
	   }else if(keys.length == 1){
		   return (String) root.get(keys[0]);
	   }
		return "";
	}

	/**
	 * Document����ת��ΪMAP
	 * @param doc
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> Dom2Map(Document doc) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null)
			return map;
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			List list = e.elements();
			if (list.size() > 0) {
				map.put(e.getName(), Dom2Map(e));
			} else
				map.put(e.getName(), e.getText());
		}
		return map;
	}

	/**
	 * ����Element�������MAP
	 * @param e
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map Dom2Map(Element e) {
		Map map = new HashMap();
		List list = e.elements();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();

				if (iter.elements().size() > 0) {
					Map m = Dom2Map(iter);
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if (obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					} else
						map.put(iter.getName(), m);
				} else {
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if (obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					} else
						map.put(iter.getName(), iter.getText());
				}
			}
		} else
			map.put(e.getName(), e.getText());
		return map;
	}
	
	/**
	 * @author dongk  2017/01/19
	 * @param  xmlDocment : ��ҪУ���XML�ĵ�
	 * @return ���У��ͨ�������� "", ���򷵻�ʧ����Ϣ
	 **/
	public static String xmlValidate(Document xmlDocument, String xsdPath) throws Exception{
		String result = "";
        XMLErrorHandler errorHandler = new XMLErrorHandler();              //����Ĭ�ϵ�XML��������   
        SAXParserFactory factory = SAXParserFactory.newInstance();         //��ȡ���� SAX �Ľ�������ʵ��   
  
        factory.setValidating(true);                                       //�������ڽ���ʱ��֤ XML ���ݡ�
        factory.setNamespaceAware(true);                                   //ָ���ɴ˴������ɵĽ��������ṩ�� XML ���ƿռ��֧�֡�
        SAXParser parser = factory.newSAXParser();                         //ʹ�õ�ǰ���õĹ����������� SAXParser ��һ����ʵ����
        parser.setProperty(   
                "http://java.sun.com/xml/jaxp/properties/schemaLanguage",   
                "http://www.w3.org/2001/XMLSchema");   
        parser.setProperty(   
                "http://java.sun.com/xml/jaxp/properties/schemaSource",   
                Thread.currentThread().getContextClassLoader().getResource("") + xsdPath);   
  
        SAXValidator validator = new SAXValidator(parser.getXMLReader());     //����һ��SAXValidatorУ�鹤�ߣ�������У�鹤�ߵ�����   
        validator.setErrorHandler(errorHandler);                              //����У�鹤�ߵĴ�������������������ʱ�����ԴӴ����������еõ�������Ϣ��
        validator.validate(xmlDocument);                                      //У��   
        
        if (errorHandler.getErrors().hasContent()) {                          //���������Ϣ��Ϊ�գ�˵��У��ʧ�ܣ���ӡ������Ϣ  
            Element errorElement = errorHandler.getErrors();
            List<Element> errorList = errorElement.elements();
            if(null != errorList && errorList.size() > 0)
            {
            	for(int i=0; i < errorList.size(); i++)
            	{
            		Element ele = errorList.get(i);
            		result += ele.getText();
            	}
            }
        } else {   
           result = "";
        }   
        return result;
	}


}
