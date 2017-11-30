package com.dongk.effictive02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 第5条：避免创建不必要的对象 
 */
public class Example005 {
   public static void main(String args[]){
	   //String s = new String("stringgette")//DON'T DO THIS
	   String s = "stringgette";
	   
	   Long sum = 0L;
	   for(long i=0; i<Integer.MAX_VALUE; i++){
		   sum += i;
	   }
	   System.out.println(sum);
   }
}

/**
 * 在这里举一个反例：
 *     
 */
class Person{
	private final Date birthDate;
	
	public Person(Date birthDate){
	  this.birthDate = birthDate;
	}
	
	/**
	 * 每次都新建一个Calendar、一个TIMEZONE和两个Date实例，这是不必要的。
	 */
	public boolean isBabyBoomer(){
	   Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	   gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
	   Date boomStart = gmtCal.getTime();
	   
	   gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
	   Date boomEnd = gmtCal.getTime();
	   return birthDate.compareTo(boomStart)>=0 &&
			   birthDate.compareTo(boomStart)<0; 
	}
}

/**
 * 应该使用下面的这种方式 
 */
class Person2{
	
    private static final Date BOOM_START;
    private static final Date BOOM_END;
	
	static{
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946,Calendar.JANUARY,1,0,0,0);
		BOOM_START = gmtCal.getTime();
	    gmtCal.set(1965,Calendar.JANUARY,1,0,0,0);
	    BOOM_END = gmtCal.getTime();
	}
	
    private final Date birthDate;
 	
	public Person2(Date birthDate){
	  this.birthDate = birthDate;
	}
}

