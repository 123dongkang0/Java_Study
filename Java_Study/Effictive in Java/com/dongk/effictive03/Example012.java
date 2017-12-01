package com.dongk.effictive03;

/**
 * 第12条：考虑实现Comparable接口 
 */
public class Example012 {
   public static void main(String args[]){
	   
   }
}

/**
 * 1. 使用已有的Comparator
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
 * 2.在Example009.java 文件,PhoneNumber类中实现Comparable
 */

