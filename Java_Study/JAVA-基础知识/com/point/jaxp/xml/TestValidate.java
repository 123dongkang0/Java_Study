package com.point.jaxp.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;

public class TestValidate {
    public static void main(String args[]){
    	try{
    		if(args.length != 2){
    			System.err.println("Usage: java TestDOMParing [filename]");
    			System.exit(1);
    		}
    		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    		//factory.setValidating(true);
    		factory.setNamespaceAware(false);
    		DocumentBuilder builder = factory.newDocumentBuilder();
    		Document doc = builder.parse(new File(args[0]));
    		SchemaFactory constraintFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    		Source constraints = new StreamSource(new File(args[1]));
    		Schema schema = constraintFactory.newSchema(constraints);
    		Validator validator = schema.newValidator();
    		
    		validator.validate(new DOMSource(doc));
    		System.out.println("Document validates fine.");
    		//printNode(doc,"");
    	}catch(Exception e){
    		System.out.println("Document validates error :" + e.getMessage() );
    	}
    }
}
