package com.dongk.effictive03;

/**
 * ��12��������ʵ��Comparable�ӿ� 
 */
public class Example012 {
   public static void main(String args[]){
	   
   }
}

/**
 * 1. ʹ�����е�Comparator
 */
final class CaseInsensitiveString12 implements Comparable<CaseInsensitiveString12>{
    private final String s;
	
	public CaseInsensitiveString12(String s){
	  if(s == null)
		  throw new NullPointerException();
	  this.s = s;
	}
	
	@Override
	public int compareTo(CaseInsensitiveString12 cis) {
		return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
	}
	
}

/**
 * 2.��Example009.java �ļ�,PhoneNumber����ʵ��Comparable
 */

