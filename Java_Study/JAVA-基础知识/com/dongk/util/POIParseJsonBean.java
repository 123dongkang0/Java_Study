package com.dongk.util;

/**
 * @author dongk
 * @date 2018-01-05
 * @description POI����Excel�ĵ���������JSON�ַ�����ʱ��
 *            �������õ�bean
 *  
 */
public class POIParseJsonBean {
     
	private String keyName;           //json��keyֵ
	private String validateType;      //У������
	private String validateMessage;   //��������У�����͵�ʱ����ʾ���ַ���
	
	public POIParseJsonBean(){
		
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValidateType() {
		return validateType;
	}

	public void setValidateType(String validateType) {
		this.validateType = validateType;
	}

	public String getValidateMessage() {
		return validateMessage;
	}

	public void setValidateMessage(String validateMessage) {
		this.validateMessage = validateMessage;
	}
	
	
}
