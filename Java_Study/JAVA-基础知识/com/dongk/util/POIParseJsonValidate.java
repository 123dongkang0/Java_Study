package com.dongk.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongk
 * @date 2018-01-05
 * @description �ַ���У��ö��
 *  
 */
public enum POIParseJsonValidate {
	
	NO_VALIDATE{      //�����κ��ж�
		public String validate(String str, String[] conditions, boolean isNull){
			if(isNull){
				return "1";
			}else{
				if(str == null || "".equals(str)){
					return "���ݲ���Ϊnull��";
				}else{
					return "1";
				}
			}
		}
	},
	NUMBER_VALIDATE{  //У���Ƿ���������
        /**
         * @param str : ��ҪУ����ַ���
         * @param len : �ܳ���
         * @param pre : ����
         * @return  1 : У��ɹ��� 
         *          ��������Ϣ�� : У��ʧ�� 
         */
		public String validate(String str, String[] conditions, boolean isNull){
			int len = Integer.parseInt(conditions[0]);
			int prec = Integer.parseInt(conditions[1]);
        	try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "���ݲ���Ϊnull��";
        			}
    			}else{
    				
    				if(!str.matches("^(0|([1-9][0-9]*))(\\.[0-9]*)?$")){
    					return "��������ȷ�����ָ�ʽ��";
    				}
    				
    				//������
    				if(prec==0){  
    		            if(str.indexOf(".") > 0){  
    						return "��������ݱ���Ϊ��������";     
    					}
    				}
    				
    				if(str.indexOf(".") < 0){
    					if(len != 0 && str.length() > (len - prec)){
    						return "�������������λ���ܳ���" + (len - prec) + "λ��";
    					}
    				}else{
    					if(str.split("\\.")[0].length() >( len - prec)){
    						return "�������������λ���ܳ���" + (len - prec) + "λ��";
    					}  
    					if(str.split("\\.")[1].length() > prec){
    						return "���������С��λ���ܳ���" + prec + "λ��";
    					}
    				}
    				
    				return "1";
    			}
        	}catch(Exception e){
        		e.printStackTrace();
        		return "��������ȷ����������";
        	}
        }		
	},
	DATE_VALIDATE{  //У������������
		/**
         * @param str : ��ҪУ����ַ���
         * @param conditions : У������ڸ�ʽ
         *          "1" : YYYY-MM-DD
         *          "2" �� YYYY-MM-DD hh:mm:ss
         * @return  1 : У��ɹ��� 
         *          ��������Ϣ�� : У��ʧ�� 
         */
		public String validate(String str, String[] conditions, boolean isNull){
			int format = Integer.parseInt(conditions[0]);
			try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "���ݲ���Ϊnull��";
        			}
    			}else{
    				
    				if(!str.matches(dateFormatType.get(format))){
    					return "��������ȷ�����ڸ�ʽ��";
    				}else{
    					int year = Integer.parseInt(str.substring(0, 4));  
    			        if (year <= 0)  
    			        	return "��������ȷ�����ڸ�ʽ��";  
    			        int month = Integer.parseInt(str.substring(5, 7));  
    			        if (month <= 0 || month > 12)  
    			        	return "��������ȷ�����ڸ�ʽ��";  
    			        int day = Integer.parseInt(str.substring(8, 10));  
    			        if (day <= 0 || day > DAYS[month])  
    			        	return "��������ȷ�����ڸ�ʽ��";
    			        if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {  
    			        	return "��������ȷ�����ڸ�ʽ��"; 
    			        }  
    			        int hour = Integer.parseInt(str.substring(11, 13));  
    			        if (hour < 0 || hour > 23)  
    			        	return "��������ȷ�����ڸ�ʽ��"; 
    			        int minute = Integer.parseInt(str.substring(14, 16));  
    			        if (minute < 0 || minute > 59)  
    			        	return "��������ȷ�����ڸ�ʽ��";  
    			        int second = Integer.parseInt(str.substring(17, 19));  
    			        if (second < 0 || second > 59)  
    			        	return "��������ȷ�����ڸ�ʽ��";
    				}
    				
    				return "1";
    			}
        	}catch(Exception e){
        		e.printStackTrace();
        		return "��������ȷ�����ڸ�ʽ��";
        	}
		}
	},
	SLASH_VALIDATE{  //У���ַ������Ƿ���� "/"
		public String validate(String str, String[] conditions,  boolean isNull){
			try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "���ݲ���Ϊnull��";
        			}
    			}else{
    			   if(str.indexOf("/") < 0){
    				   return "��������ȷ�ĸ�ʽ��";
    			   }
    			   return "1";
    			}
    		}catch(Exception e){
        		e.printStackTrace();
        		return "��������ȷ�ĸ�ʽ��";
        	}
		}
	}
	;
	
	/**
	 * @param str ����ҪУ����ַ���
	 * @param conditions : һЩ����У����������
	 * @param isNull : �Ƿ����Ϊ��
	 */
	abstract String validate(String str, String[] conditions, boolean isNull);
	
	private final static Map<Integer, String> dateFormatType = new HashMap<Integer, String>();
	
	private final static int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
	
	static{
		dateFormatType.put(1, "^(\\d{1,4})(-)(\\d{1,2})(-)(\\d{1,2})$");   //YYYY-MM-DD
		dateFormatType.put(2, "^(\\d{1,4})(-)(\\d{1,2})(-)(\\d{1,2}) (\\d{1,2}):(\\d{1,2}):(\\d{1,2})$");  //YYYY-MM-DD hh:mm:ss
	}
	
	public static final boolean isGregorianLeapYear(int year) {  
	    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);  
	}
}
