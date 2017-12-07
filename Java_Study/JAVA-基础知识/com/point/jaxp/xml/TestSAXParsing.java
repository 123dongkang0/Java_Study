package com.point.jaxp.xml;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class TestSAXParsing {
   public static void main(String args[]){
	   System.out.println(args[0]);
		try {
			  if(args.length != 1){
				   System.err.println("Usage : java TestSAXParsing[filename]");
				   System.exit(1);
			   }
			   //Get SAX Parser Factory
			   SAXParserFactory factory = SAXParserFactory.newInstance();
			   //turn on validate,and turn off namespaces
			   factory.setValidating(true);
			   factory.setNamespaceAware(false);
			   SAXParser parse = factory.newSAXParser();
			   
			   //Find out if validating is supported
			   boolean isValidating = parse.isValidating();
			   //find out if namespaces are supported
			   boolean isNamespaceAware = parse.isNamespaceAware();
			   
			   
			   parse.parse(new File("JAXP/simple.xml"), new MyHandler());
		 } catch (ParserConfigurationException e) {
			e.printStackTrace();   //无法获取得JAXP实现或系统特性中指定的解析器
		 } catch (SAXException e) {
			e.printStackTrace();    //解析异常
		 }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
		   
   }
   
}

class MyHandler extends DefaultHandler{
	//SAX callback  implementations from DocumentHandler, ErrorHandler,etc.
	
	private Writer out;
	
	public MyHandler(){
		try {
			out = new OutputStreamWriter(System.out, "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public void startDocument() throws SAXException{
		print("<?xml version=\"1.0\"?>\n");
	}
	
	public void startElement(String uri, String localName,
			                 String qName,Attributes atts) throws SAXException{
		print("<" + qName);
		if(atts != null){
			for(int i=0, len=atts.getLength();i<len;i++){
				print(" " + atts.getQName(i) + "=\"" + atts.getValue(i) + "\"");
			}
		}
		print(">");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		print("</" + qName + ">\n");
	}

	@Override
	public void characters(char[] ch, int start, int len)
			throws SAXException {
		print(new String(ch,start,len));
	}

	public void print(String s) throws SAXException{
       try {
    	   out.write(s);
		   out.flush();
	   } catch (IOException e) {
			e.printStackTrace();
	   }
	}
	
}
