package com.dongk.util;

/**
 * @author dongk
 * @date 2018-01-05
 * @description POI解析Excel文档，并生成JSON字符串的时候，
 *            起辅助作用的bean
 *  
 */
public class POIParseJsonBean {
     
	private String keyName;           //json串key值
	private String validateType;      //校验类型
	private String validateMessage;   //当不符合校验类型的时候，提示此字符串
	
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
