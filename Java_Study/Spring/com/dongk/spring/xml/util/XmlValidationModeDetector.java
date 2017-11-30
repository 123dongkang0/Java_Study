package com.dongk.spring.xml.util;

/**
 * XML流使用 DTD 或是 XSD 来验证  
 * 
 * @author Dongk
 */
public class XmlValidationModeDetector {
   
	/**
	 * 表明不做验证 
	 */
	public final static int VALIDATE_NONE = 0;
	
	/**
	 * 表明自动选择验证方式
	 */
	public final static int VALIDATE_AUTO = 1;
	
	/**
	 * 表明使用DTD验证 
	 */
	public final static int VALIDATE_DTD = 2;
	
	/**
	 * 表明使用XSD验证 
	 */
	public final static int VALIDATE_XSD = 3;
}
