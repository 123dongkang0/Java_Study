package com.think15.generics;

/**
 *15.4.5 简化元组的使用 
 */
public class Example0045 {
   public static void main(String args[]){
	   ThreeTuple<String,String,String> threeTuple = Tuple.threeTuple("aa", "bb", "cc");
	   System.out.println(threeTuple);
   }
}

class Tuple{
	
	public static <A,B> TwoTuple<A,B> tuple(A a, B b){
		return new TwoTuple(a, b);
	}
	
	public static <A,B,C> ThreeTuple<A,B,C> threeTuple(A a, B b, C c){
		return new ThreeTuple(a, b, c);
	}
	
}
