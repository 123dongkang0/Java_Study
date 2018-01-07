package com.dongk.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongk
 * @date 2018-01-05
 * @description 字符串校验枚举
 *  
 */
public enum POIParseJsonValidate {
	
	NO_VALIDATE{      //不做任何判断
		public String validate(String str, String[] conditions, boolean isNull){
			if(isNull){
				return "1";
			}else{
				if(str == null || "".equals(str)){
					return "数据不能为null！";
				}else{
					return "1";
				}
			}
		}
	},
	NUMBER_VALIDATE{  //校验是否数字类型
        /**
         * @param str : 需要校验的字符串
         * @param len : 总长度
         * @param pre : 精度
         * @return  1 : 校验成功， 
         *          “错误信息” : 校验失败 
         */
		public String validate(String str, String[] conditions, boolean isNull){
			int len = Integer.parseInt(conditions[0]);
			int prec = Integer.parseInt(conditions[1]);
        	try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "数据不能为null！";
        			}
    			}else{
    				
    				if(!str.matches("^(0|([1-9][0-9]*))(\\.[0-9]*)?$")){
    					return "请输入正确的数字格式！";
    				}
    				
    				//正整数
    				if(prec==0){  
    		            if(str.indexOf(".") > 0){  
    						return "输入的数据必须为正整数！";     
    					}
    				}
    				
    				if(str.indexOf(".") < 0){
    					if(len != 0 && str.length() > (len - prec)){
    						return "输入的数据整数位不能超过" + (len - prec) + "位！";
    					}
    				}else{
    					if(str.split("\\.")[0].length() >( len - prec)){
    						return "输入的数据整数位不能超过" + (len - prec) + "位！";
    					}  
    					if(str.split("\\.")[1].length() > prec){
    						return "输入的数据小数位不能超过" + prec + "位！";
    					}
    				}
    				
    				return "1";
    			}
        	}catch(Exception e){
        		e.printStackTrace();
        		return "请输入正确的数字类型";
        	}
        }		
	},
	DATE_VALIDATE{  //校验是日期类型
		/**
         * @param str : 需要校验的字符串
         * @param conditions : 校验的日期格式
         *          "1" : YYYY-MM-DD
         *          "2" ： YYYY-MM-DD hh:mm:ss
         * @return  1 : 校验成功， 
         *          “错误信息” : 校验失败 
         */
		public String validate(String str, String[] conditions, boolean isNull){
			int format = Integer.parseInt(conditions[0]);
			try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "数据不能为null！";
        			}
    			}else{
    				
    				if(!str.matches(dateFormatType.get(format))){
    					return "请输入正确的日期格式！";
    				}else{
    					int year = Integer.parseInt(str.substring(0, 4));  
    			        if (year <= 0)  
    			        	return "请输入正确的日期格式！";  
    			        int month = Integer.parseInt(str.substring(5, 7));  
    			        if (month <= 0 || month > 12)  
    			        	return "请输入正确的日期格式！";  
    			        int day = Integer.parseInt(str.substring(8, 10));  
    			        if (day <= 0 || day > DAYS[month])  
    			        	return "请输入正确的日期格式！";
    			        if (month == 2 && day == 29 && !isGregorianLeapYear(year)) {  
    			        	return "请输入正确的日期格式！"; 
    			        }  
    			        int hour = Integer.parseInt(str.substring(11, 13));  
    			        if (hour < 0 || hour > 23)  
    			        	return "请输入正确的日期格式！"; 
    			        int minute = Integer.parseInt(str.substring(14, 16));  
    			        if (minute < 0 || minute > 59)  
    			        	return "请输入正确的日期格式！";  
    			        int second = Integer.parseInt(str.substring(17, 19));  
    			        if (second < 0 || second > 59)  
    			        	return "请输入正确的日期格式！";
    				}
    				
    				return "1";
    			}
        	}catch(Exception e){
        		e.printStackTrace();
        		return "请输入正确的日期格式！";
        	}
		}
	},
	SLASH_VALIDATE{  //校验字符串中是否存在 "/"
		public String validate(String str, String[] conditions,  boolean isNull){
			try{
        		if(str == null || "".equals(str)){
        			if(isNull){
        				return "1";
        			}else{
        				return "数据不能为null！";
        			}
    			}else{
    			   if(str.indexOf("/") < 0){
    				   return "请输入正确的格式！";
    			   }
    			   return "1";
    			}
    		}catch(Exception e){
        		e.printStackTrace();
        		return "请输入正确的格式！";
        	}
		}
	}
	;
	
	/**
	 * @param str ：需要校验的字符串
	 * @param conditions : 一些特殊校验的特殊参数
	 * @param isNull : 是否可以为空
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
