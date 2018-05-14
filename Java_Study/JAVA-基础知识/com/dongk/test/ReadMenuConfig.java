package com.dongk.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class ReadMenuConfig{
	private static final String MENU_CONFIG_PATH = "D://menuConfig.xml";
	private static void stepThroughAll(Node start,String name){
		
		if(start.getNodeType()==start.ELEMENT_NODE){
			
			NamedNodeMap startAttr=start.getAttributes();
			String url = null;
			String title = null;
			String nname = "";
			String images = null;
			
		    for(int i=0;i<startAttr.getLength();i++){
			  Node attr=startAttr.item(i);
			  			  
			  if (attr.getNodeName().equals("name")){
				  nname = attr.getNodeValue();
			  }else if (attr.getNodeName().equals("url")){
				  url = attr.getNodeValue();
			  }else if (attr.getNodeName().equals("title")){
				  title = attr.getNodeValue();
			  }else if (attr.getNodeName().equals("images")){
				  images = attr.getNodeValue();
			  }
		
		    }
		    if (nname.equals(name)){
		    	String str = "update t_menu_info set url='" + url + "', image='" + images + "'  where menu_code  = '" + nname + "';";
		    	System.out.println(str);
		    	return;
		    }
		    
	    }
		
		for(Node child=start.getFirstChild(); child!=null; child = child.getNextSibling())
			stepThroughAll(child,name);
	}
	
	private static DocumentBuilder db;
	
	static{		
		   try{
		     DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			 db=dbf.newDocumentBuilder();
		   }catch(Exception e){
                 e.printStackTrace();
		   }
	}
	
	public static void parse(String address) throws Exception{
		synchronized(ReadMenuConfig.class){
		  String path = MENU_CONFIG_PATH;
		   InputStream is = new FileInputStream(new File(path));
		   Document doc=null;
		   Element root;
		   
		   try {
				doc=db.parse(is);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   root=doc.getDocumentElement();
		   
		   stepThroughAll(root,address);
			
		}	   
	}
};
