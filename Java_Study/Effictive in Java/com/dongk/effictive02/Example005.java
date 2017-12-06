package com.dongk.effictive02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

/**
 * ��5�������ⴴ������Ҫ�Ķ��� 
 */
public class Example005 {

	@Test
   public void testStr(){
	 //String s = new String("stringgette")//DON'T DO THIS
	   /**
	    *������ͬһ̨����������еĴ��룬ֻҪ���ǰ�����ͬ���ַ������泣�����ö���ͻᱻ���� 
	    */
	   String s = "stringgette";
   }
   
   @Test
   public void testLong(){
	   //Long sum = 0L;   //ʹ��Long Ƶ�����в��䡢װ����������ܵ��£�
	   long sum = 0L;
	   for(long i=0; i<Integer.MAX_VALUE; i++){
		   sum += i;
	   }
	   System.out.println(sum);
   }
}

/**
 * 1�����������һ��������
 *   
 *     �ж�һ�����Ƿ������ 1946-1945 ��֮��
 *     
 */
class Person{
	private final Date birthDate;
	
	public Person(Date birthDate){
	  this.birthDate = birthDate;
	}
	
	/**
	 * ÿ�ζ��½�һ��Calendar��һ��TIMEZONE������Dateʵ�������ǲ���Ҫ�ġ�
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
 * Ӧ��ʹ����������ַ�ʽ 
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

