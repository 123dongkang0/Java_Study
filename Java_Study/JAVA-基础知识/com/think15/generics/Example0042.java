package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.4.2 泛型方法与可变参数 
 */
public class Example0042 {
   public static void main(String args[]){
	  List<String> ls = GenericVarargs.makeList("A");
	  System.out.println(ls);
	  ls = GenericVarargs.makeList("A","B","C");
	  System.out.println(ls);
	  ls = GenericVarargs.makeList("ABCDEFHIJKLMNOPQRSTUWXYZ".split(""));
	  System.out.println(ls);
   }
}


class GenericVarargs{
	
	public static <T> List<T> makeList(T... args){
		List<T> result = new ArrayList<T>();
		for(T item : args){
			result.add(item);
		}
		return result;
	}
	
}