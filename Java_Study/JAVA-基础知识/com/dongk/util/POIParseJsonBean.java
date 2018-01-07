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
	private POIParseJsonValidate validateType;      //校验类型
	private String[] validateCondition;             //校验参数
	private boolean isNull;  //是否可以为空
	private String validateMessage;   //当不符合校验类型的时候，提示此字符串
	
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
