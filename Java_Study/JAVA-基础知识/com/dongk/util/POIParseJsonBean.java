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
	private POIParseJsonValidate validateType;      //У������
	private String[] validateCondition;             //У�����
	private boolean isNull;  //�Ƿ����Ϊ��
	private String validateMessage;   //��������У�����͵�ʱ����ʾ���ַ���
	
	public POIParseJsonBean(){
		
	}
	
    public POIParseJsonBean(String keyName,
    		                POIParseJsonValidate validateType,
    		                String[] validateCondition,
    		                boolean isNull){
    	this.keyName = keyName;
    	this.validateType = validateType;
    	this.validateCondition = validateCondition;
    	this.isNull = isNull;
	}
    
    public POIParseJsonBean(String keyName,
	                        POIParseJsonValidate validateType,
				            String[] validateCondition,
				            boolean isNull,
				            String validateMessage){
		this.keyName = keyName;
		this.validateType = validateType;
		this.validateCondition = validateCondition;
		this.isNull = isNull;
		this.validateMessage = validateMessage;
	}

	public String getKeyName() {
		return keyName;
	}
	
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public POIParseJsonValidate getValidateType() {
		return validateType;
	}

	public void setValidateType(POIParseJsonValidate validateType) {
		this.validateType = validateType;
	}

	public String getValidateMessage() {
		return validateMessage;
	}

	public void setValidateMessage(String validateMessage) {
		this.validateMessage = validateMessage;
	}

	public String[] getValidateCondition() {
		return validateCondition;
	}

	public void setValidateCondition(String[] validateCondition) {
		this.validateCondition = validateCondition;
	}

	public boolean isNull() {
		return isNull;
	}

	public void setNull(boolean isNull) {
		this.isNull = isNull;
	}
	
	
}
