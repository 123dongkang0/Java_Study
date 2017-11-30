package com.dongk.effictive03;

import java.util.HashMap;
import java.util.Map;

/**
 * ��9�������� equlasʱ��Ҫ����hashCode
 *      ����equals��ȵĶ�����hashCodeֵ������һ�µġ�
 *      
 *      >��дhashCode��ԭ��
 *      1.��ȵĶ������߱���ȵ�hashCode��
 *      2.���뽫equals��û�е����ų���
 */
public class Example009 {
   public static void main(String args[]){
	   //��HashMapһ��ʹ�õ������
	   Map<PhoneNumber,String> m = new HashMap<PhoneNumber, String>();
	   m.put(new PhoneNumber(707, 867, 5309), "Jenny");
	   System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
	   
	   System.out.println(new PhoneNumber(707, 867, 5309).hashCode());
	   System.out.println(new PhoneNumber(707, 867, 5309).hashCode());
   }
}

final class PhoneNumber implements Comparable<PhoneNumber>{
   private final short areCode;
   private final short prefix;
   private final short lineNumber;
   
   public PhoneNumber(int areCode, int prefix, int lineNumber){
	   rangeCheck(areCode, 999, "area code");
	   rangeCheck(prefix, 999, "prefix");
	   rangeCheck(lineNumber, 9999, "line number");
	   this.areCode = (short)areCode;
	   this.prefix = (short)prefix;
	   this.lineNumber = (short)lineNumber;
   }
   
   private static void rangeCheck(int arg, int max, String name){
	   if(arg<0 || arg>max)
		   throw new IllegalArgumentException(name + ":" + arg);
   }
   
   @Override
   public boolean equals(Object o){
	   if(o == this)
		   return true;
	   if((o instanceof PhoneNumber))
		   return false;
	   PhoneNumber pn = (PhoneNumber)o;
	   return   pn.lineNumber == lineNumber
			 && pn.prefix == prefix
			 && pn.areCode == areCode;
	                
   }
   
   @Override
	public int hashCode() {
	    int result = 17;
	    result =  31 * result + areCode;
	    result =  31 * result + prefix;
	    result =   31 * result + lineNumber;
		return result;
	}

	@Override
	public int compareTo(PhoneNumber o) {
		if(areCode < o.areCode)
			return -1;
	    if(areCode > o.areCode)
			return 1;
	    if(prefix < o.prefix)
			return -1;
	    if(prefix > o.prefix)
			return 1;
	    if(lineNumber < o.lineNumber)
			return -1;
	    if(lineNumber > o.lineNumber)
			return 1;
		 return 0;
	}
}
