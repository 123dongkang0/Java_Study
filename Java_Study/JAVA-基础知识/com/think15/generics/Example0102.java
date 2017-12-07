package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.10.2 逆变
 *    还有一种办法，使用超类型通配符
 */
public class Example0102 {
  public static void main(String args[]){
	  ArrayList<Fruit> flist = new ArrayList<Fruit>();
	  SuperTypeWildcards.weiteTo(flist);
	  System.out.println(flist);
	  
	  //=================================
	  GenericWriting.f1();
	  GenericWriting.f2();
  }
}

class SuperTypeWildcards{
	static void weiteTo(List<? super Apple> apples){
		apples.add(new Apple());
		apples.add(new Jonathan());
	    //apples.add(new Fruit());
	}
}

/**
 * 超类型边界放松了可以向方法传递的参数上所作的限制：
 *  
 */
class GenericWriting{
	static <T> void wirteExact(List<T> list, T item){
		list.add(item);
	}
	
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruit = new ArrayList<Fruit>();
	
	static void f1(){
		wirteExact(apples, new Apple());
		wirteExact(fruit,  new Apple());
	}
	
	static <T> void writeWithWildCard(List<? super T> list, T item){
		list.add(item);
	}
	
	static void f2(){
		writeWithWildCard(apples, new Apple());
		writeWithWildCard(fruit,  new Apple());
	}
}