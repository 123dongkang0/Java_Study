package com.dongk.spring.xml.util;

/**
 * XML��ʹ�� DTD ���� XSD ����֤  
 * 
 * @author Dongk
 */
public class XmlValidationModeDetector {
   
	/**
	 * ����������֤ 
	 */
	public final static int VALIDATE_NONE = 0;
	
	/**
	 * �����Զ�ѡ����֤��ʽ
	 */
	public final static int VALIDATE_AUTO = 1;
	
	/**
	 * ����ʹ��DTD��֤ 
	 */
	public final static int VALIDATE_DTD = 2;
	
	/**
	 * ����ʹ��XSD��֤ 
	 */
	public final static int VALIDATE_XSD = 3;
}
