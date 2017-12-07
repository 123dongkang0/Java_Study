package com.dongk.spring.xml;

import javax.xml.crypto.dsig.XMLValidateContext;

import com.dongk.spring.xml.util.XmlValidationModeDetector;

public class xmlDefinitionReader {
  
	/**
	 * ������֤����ʹ��
	 */
	public static final int VALIDATION_NONE = XmlValidationModeDetector.VALIDATE_NONE;
	
	/**
	 * �����Զ�ѡ����֤��ʽ
	 */
	public static final int VALIDATION_AUTO = XmlValidationModeDetector.VALIDATE_AUTO;
	
	
	/**
	 * ����ʹ��DTD��֤��ʽ
	 */
	public static final int VALIDATION_DTD = XmlValidationModeDetector.VALIDATE_DTD;
	
	
	/**
	 * ����ʹ��XSD��֤��ʽ
	 */
	public static final int VALIDATION_NONO = XmlValidationModeDetector.VALIDATE_XSD;
	
	
	private int validationMode = VALIDATION_AUTO;
    
	protected int getValidationModeForResource(Resource resource){
		int validationModeToUse = getValidationMode();
		if(validationModeToUse != VALIDATION_AUTO){
            return validationModeToUse;
		}
		int de
	}

	public int getValidationMode() {
		return validationMode;
	}


	public void setValidationMode(int validationMode) {
		this.validationMode = validationMode;
	}  
	
	
}
