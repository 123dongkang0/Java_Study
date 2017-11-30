package com.dongk.effictive02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * ��5�������ⴴ������Ҫ�Ķ��� 
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
 * �������һ��������
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

