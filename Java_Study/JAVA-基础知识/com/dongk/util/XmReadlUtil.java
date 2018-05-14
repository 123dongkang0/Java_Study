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
 * @Description 读取XML字符串工机类
 * @author dongk
 * @Date 2018年4月24日 下午10:23:17
 * @version 1.0.0
 */
public class XmReadlUtil {
	
	/**
	 * @Description 得到某个节点的值
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
	 * Document对象转换为MAP
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
	 * 迭代Element对象存入MAP
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
	 * @param  xmlDocment : 需要校验的XML文档
	 * @return 如果校验通过，返回 "", 否则返回失败信息
	 **/
	public static String xmlValidate(Document xmlDocument, String xsdPath) throws Exception{
		String result = "";
        XMLErrorHandler errorHandler = new XMLErrorHandler();              //创建默认的XML错误处理器   
        SAXParserFactory factory = SAXParserFactory.newInstance();         //获取基于 SAX 的解析器的实例   
  
        factory.setValidating(true);                                       //解析器在解析时验证 XML 内容。
        factory.setNamespaceAware(true);                                   //指定由此代码生成的解析器将提供对 XML 名称空间的支持。
        SAXParser parser = factory.newSAXParser();                         //使用当前配置的工厂参数创建 SAXParser 的一个新实例。
        parser.setProperty(   
                "http://java.sun.com/xml/jaxp/properties/schemaLanguage",   
                "http://www.w3.org/2001/XMLSchema");   
        parser.setProperty(   
                "http://java.sun.com/xml/jaxp/properties/schemaSource",   
                Thread.currentThread().getContextClassLoader().getResource("") + xsdPath);   
  
        SAXValidator validator = new SAXValidator(parser.getXMLReader());     //创建一个SAXValidator校验工具，并设置校验工具的属性   
        validator.setErrorHandler(errorHandler);                              //设置校验工具的错误处理器，当发生错误时，可以从处理器对象中得到错误信息。
        validator.validate(xmlDocument);                                      //校验   
        
        if (errorHandler.getErrors().hasContent()) {                          //如果错误信息不为空，说明校验失败，打印错误信息  
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
