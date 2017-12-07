package com.point.autoboxing;

import java.util.ArrayList;

import org.junit.Test;

/**
 * JAVA 中的自动装箱与拆箱。
 * 
 *     1. Java中的原始值类型和包装类型对应如下：
 *       
 *       原始值类型： byte, short, char,      int,     long, float, double,  boolean
 *       包装类型：     Byte, Short, Character, Integer, Long, Float, Double,  Boolean
 *     
 *     2.为什么会有包装类型
 *      因为Java1.5之后进行编程，不能直接地向集合(Collections)中放入原始值类型
 *      
 *     3.什么是自动装箱和自动拆箱？
 *       自动装箱: 编译器调用valueOf将原始类型值转换成对象;
 *       自动拆箱: 编译器通过调用类似intValue(),doubleValue()这类的方法将对象转换成原始类型值;
 */
public class Example001 {
   
	/**
	 * 1.什么情况下会发生自动装箱和拆箱 
	 */
	@Test
	public void test01(){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);       //自动装箱
		intList.add(2);
		
		ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>();
		intLocal.set(4);       //自动装箱
		
		int number = intList.get(0);    //自动拆箱
		int local = intLocal.get();      //自动拆箱
		
	}
	
	/**
	 * 2.对象相等的比较 
	 */
	@Test
	public void test02(){
	      int i1 = 1;
	      int i2 = 1;
	      System.out.println(i1 == i2);  //true
	      
	      Integer num1 = 1344;
	      int num2 = 1344;
	      System.out.println(num1 == num2); //true  num1 自动拆箱和num2进行比较
	      
	      /**
	       *  这是一种极端情况,obj1和obj2的初始化都发生了自动装箱操作。
	       *  但是处于节省内存的考虑，JVM会缓存-128到127的Integer对象。
	       *  因此obj1和obj2实际上是同一个对象。所以使用”==“比较返回true。 
	       **/
	      Integer obj1 = 1;   //自动装箱
	      Integer obj2 = 1;
	      System.out.println(obj1 == obj2); //true
	      
	      Integer obj3 = 132;   //自动装箱
	      Integer obj4 = 132;
	      System.out.println(obj3 == obj4); //false
	      
	      Integer one = new Integer(1);
	      Integer two = new Integer(2);
	      System.out.println(one == two);   //false
	      
	}
}
