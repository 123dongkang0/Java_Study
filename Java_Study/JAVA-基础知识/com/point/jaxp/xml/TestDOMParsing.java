package com.point.jaxp.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestDOMParsing {
    public static void main(String args[]){
    	try{
    		if(args.length != 1){
    			System.err.println("Usage: java TestDOMParing [filename]");
    			System.exit(1);
    		}
    		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    		factory.setValidating(true);
    		factory.setNamespaceAware(false);
    		DocumentBuilder builder = factory.newDocumentBuilder();
    		Document doc = builder.parse(new File(args[0]));
    		printNode(doc,"");
    	}catch(Exception e){
    		
    	}
    }
    
    private static void printNode(Node node, String indent)  {
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + node.getNodeType());
        switch (node.getNodeType()) {
            case Node.DOCUMENT_NODE:
                System.out.println("<xml version=\"1.0\">\n");
                // recurse on each child
                NodeList nodes = node.getChildNodes();
                if (nodes != null) {
                    for (int i=0; i<nodes.getLength(); i++) {
                        printNode(nodes.item(i), "");
                    }
                }
                break;
                
            case Node.ELEMENT_NODE:
                String name = node.getNodeName();
                System.out.print(indent + "<" + name);
                NamedNodeMap attributes = node.getAttributes();
                for (int i=0; i<attributes.getLength(); i++) {
                    Node current = attributes.item(i);
                    System.out.print(" " + current.getNodeName() +
                                     "=\"" + current.getNodeValue() +
                                     "\"");
                }
                System.out.print(">");
                
                // recurse on each child
                NodeList children = node.getChildNodes();
                if (children != null) {
                    for (int i=0; i<children.getLength(); i++) {
                        printNode(children.item(i), indent + "  ");
                    }
                }
                
                System.out.print("</" + name + ">");
                break;

            case Node.TEXT_NODE:
                System.out.print(node.getNodeValue());
                break;
        }
    }
    
}
