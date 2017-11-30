package com.think15.generics;

import java.util.ArrayList;

/**
 * 15.6 构建复杂的模型
 * 
 *   泛型的一个重要的好处就是能够简单而安全的创建复杂的模型。
 */
public class Example006 {
  public static void main(String args[]){
	  TupleList<String,Long,Integer> t1 = new TupleList<String,Long,Integer>();
	  t1.add(ThreeTupleTest.f());
	  t1.add(ThreeTupleTest.f());
	  for(ThreeTuple<String,Long,Integer> temp : t1){
		  System.out.println(temp);
	  }
  }
}

/**
 * 创建List元组 
 */
class TupleList<A,B,C> extends ArrayList<ThreeTuple<A,B,C>>{
	
}
