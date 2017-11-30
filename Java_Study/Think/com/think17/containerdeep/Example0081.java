package com.think17.containerdeep;

import java.util.Map;

/**
 * 17.8.1 ÐÔÄÜ 
 */
public class Example0081 {
  public static void main(String args[]){
	  
  }
}

class Maps{
	public static void pritKeys(Map<Integer,String> map){
		System.out.println("Size = " + map.size() + ";");
		System.out.println(" keys: ");
		System.out.println(map.keySet());
	}
	
	public static void test(Map<Integer,String> map){
		System.out.println(map.getClass().getSimpleName());
		//map.putAll(new CountingM)
	}
}
