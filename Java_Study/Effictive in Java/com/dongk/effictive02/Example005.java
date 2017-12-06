package com.dongk.effictive02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

/**
 * 第5条：避免创建不必要的对象 
 */
public class Example005 {

	@Test
   public void testStr(){
	 //String s = new String("stringgette")//DON'T DO THIS
	   /**
	    *对于在同一台虚拟机中运行的代码，只要它们包含相同的字符串字面常量，该对象就会被重用 
	    */
	   String s = "stringgette";
   }
   
   @Test
   public void testLong(){
	   //Long sum = 0L;   //使用Long 频繁进行拆箱、装箱操作，性能低下；
	   long sum = 0L;
	   for(long i=0; i<Integer.MAX_VALUE; i++){
		   sum += i;
	   }
	   System.out.println(sum);
   }
}

/**
 * 1）、在这里举一个反例：
 *   
 *     判断一个人是否出生在 1946-1945 年之间
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

