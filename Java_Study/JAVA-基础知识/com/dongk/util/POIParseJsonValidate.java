package com.dongk.util;

/**
 * @author dongk
 * @date 2018-01-05
 * @description �ַ���У��ö��
 *  
 */
public enum POIParseJsonValidate {
	
	
	NON_VALIDATE{      //�ǿ��ж�
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
	 * @description У��ͨ������true,���򷵻�false
	 */
	public abstract boolean validateString(String str);
}
