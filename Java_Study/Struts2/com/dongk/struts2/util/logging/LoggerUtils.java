package com.dongk.struts2.util.logging;

import java.util.LinkedList;
import java.util.List;

/**
 * Logging utility methods
 * ��־��ʵ�÷���
 */
public class LoggerUtils {
    /**
     * Formats Messages using parameters. For example, the call:
     * ʹ�ò�������Ϣ��ʽ���� ���£� 
     * 
     * ����Ĳ���
     * <pre>
     *   format("foo #0 #1", "bob", "joe");
     * </pre>
     * 
     * ����ֵ
     * <pre>
     *   foo bob joe
     * </pre>
     * 
     * @param msg  The message, 
     *              ��Ϣ
     * @param args A list of arguments. Amaximum of 10 are supported.
     *             һϵ�еĲ���������ܳ���10����
     */
	public static String format(String msg, String... args){
		if(msg != null && msg.length() > 0 && msg.indexOf('#') > -1){
			StringBuilder sb = new StringBuilder();
			boolean isArg = false;
			for(int x=0; x<msg.length(); x++){
				char c = msg.charAt(x);
				if(isArg){
					isArg = false;
					if(Character.isDigit(c)){    //�ж�ָ���ַ��Ƿ�Ϊ����
						 int val = Character.getNumericValue(c);
						 if(val >=0 && val < args.length){
							 sb.append(args[val]);
							 continue;
						 }
					}
					sb.append('#');
				}
				if(c == '#'){
					isArg = true;
					continue;
				}
				sb.append(c);
			}
			
			//������һ���ַ���#
			if(isArg){
				sb.append("#");
			}
			return sb.toString();
		}
		
		return msg;
	}
	
	public static String format(String msg, Object[] args){
		List<String> strArgs = new LinkedList<String>();
		for(Object arg: strArgs){
			strArgs.add(arg != null ? arg.toString() : "(null)");
		}
		return format(msg, strArgs.toArray(new String[strArgs.size()]));
	}
	
}
