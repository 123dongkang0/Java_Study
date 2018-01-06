package com.dongk.util;

/**
 * @author dongk
 * @date 2018-01-05
 * @description 字符串校验枚举
 *  
 */
public enum POIParseJsonValidate {
	
	
	NON_VALIDATE{      //非空判断
		public boolean validateString(String str){
			if(str == null || "".equals(str)){
				return false;
			}else{
				return true;
			}
		}
	};
	
	
    
	
	/**
	 * @author dongk
	 * @date 2018-01-05
	 * @description 校验通过返回true,否则返回false
	 */
	public abstract boolean validateString(String str);
}
