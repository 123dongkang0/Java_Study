package com.dongk.spring.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import com.dongk.spring.xml.util.XmlValidationModeDetector;

/**
 * DocumentLoader Ĭ��ʵ��
 * 
 * <p>
 *   ʹ��JAXP�������غͽ���XML�ĵ�
 * </P>
 * 
 *@author Dongk
 */
public class DefaultDocumentLoader implements DocumentLoader{
	
	/**
	 * JAXP������������ schema ���Ե���֤��
	 */
	private static final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	
	/**
	 * JAXP���Ա�ʾ XSD schema ���ԡ�
	 */
	private static final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";
    
	/**
	 * ʹ�ñ�׼��JAXP��������XML�ĵ�
	 */
	public Document loadDocument(InputSource inputSource,
			EntityResolver entityResolver, ErrorHandler errorHandler,
			int validationMode, boolean namespaceAware) throws Exception {
		
		DocumentBuilderFactory factory = createDocumentBuilderFactory(validationMode,namespaceAware);
		DocumentBuilder builder = createDocumentBuilder(factory,entityResolver,errorHandler);
		return builder.parse(inputSource);
	}


	protected DocumentBuilderFactory createDocumentBuilderFactory(int validationMode, boolean namespaceAware) 
	       throws ParserConfigurationException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(namespaceAware);
		
		if(validationMode != XmlValidationModeDetector.VALIDATE_NONE){
			factory.setValidating(true);
			if(validationMode == XmlValidationModeDetector.VALIDATE_XSD){
				factory.setNamespaceAware(true);
				try{
					factory.setAttribute(SCHEMA_LANGUAGE_ATTRIBUTE, XSD_SCHEMA_LANGUAGE);
				}catch(IllegalArgumentException ex){
					ParserConfigurationException pcex = new ParserConfigurationException(
							"Unable to validate using XSD: Your JAXP provider [" + factory +
							"] does not support XML Schema. Are you running on Java 1.4 with Apache Crimson? " +
							"Upgrade to Apache Xerces (or Java 1.5) for full XSD support.");
					pcex.initCause(ex);
					throw pcex;
				}
			}
		}
		return null;
	}
	
	/**
	 *����JAXP DocumentBuilder,��������XML�ĵ����ܹ���������д
	 * 
	 *@param factory : JAXP DocumentBuilderFactory ���ڴ��� DocumentBuilder
	 *@param entityResolver : 
	 *@param errorHandler : 
	 *@return DocumentBuilder
	 */
	protected DocumentBuilder createDocumentBuilder(
			DocumentBuilderFactory factory, EntityResolver entityResolver,
			ErrorHandler errorHandler) throws ParserConfigurationException {
		
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		if(entityResolver != null){
			docBuilder.setEntityResolver(entityResolver);
		}
		if(errorHandler != null){
			docBuilder.setErrorHandler(errorHandler);
		}
		return docBuilder;
	}

}
