package com.dongk.effictive03;

import java.util.HashMap;
import java.util.Map;

/**
 * 第9条：覆盖 equlas时总要覆盖hashCode
 *      两个equals相等的对象，其hashCode值必须是一致的。
 *      
 *      >编写hashCode的原则
 *      1.相等的对象必须具备相等的hashCode。
 *      2.必须将equals中没有的域排除。
 */
public class Example009 {
   public static void main(String args[]){
	   //和HashMap一起使用的情况下
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
