package com.think15.generics;

import java.util.ArrayList;

/**
 * 15.6 �������ӵ�ģ��
 * 
 *   ���͵�һ����Ҫ�ĺô������ܹ��򵥶���ȫ�Ĵ������ӵ�ģ�͡�
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
 * ����ListԪ�� 
 */
class TupleList<A,B,C> extends ArrayList<ThreeTuple<A,B,C>>{
	
}
