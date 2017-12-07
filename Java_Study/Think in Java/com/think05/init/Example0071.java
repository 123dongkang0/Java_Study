package com.think05.init;

import org.junit.Test;

/**
 * 5.7 构造器初始化 
 * 
 */
public class Example0071 {
   
	@Test
	public void testCups(){
		Cups cups1 = new Cups();
		Cups cups2 = new Cups();
	}
	
	@Test
	public void testMugs(){
		System.out.println("Inside main()");
		new Mugs();
		System.out.println("new Mugs() completed");
		new Mugs(1);
		System.out.println("new Mugs(1) completed");
		
	}
}

/**
 * 1)、静态数据块的初始化
 *     
 *     Java允许将多个静态初始化动作组织成一个特殊的 "静态子句"(也叫作 "静态块")。
 *  和其它的静态初始化动作是一样的。
 */
class Cup{
	Cup(int marker){
		System.out.println("Cup(" + marker  + ")");
	}
	void f(int marker){
		System.out.println("f(" + marker + ")");
	}
}

/**
 * cup1、cup2、cup2只会在类创建的时候初始化一次。
 */
class Cups{
	static Cup cup1;
	static Cup cup2;
	
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
		Cup cup3 = new Cup(3);  //不能在其它方法中访问 cup3
	}
	Cups(){
		System.out.println("Cups()");
	}
}

/**
 * 2)、非静态实例的初始化(构造代码块)
 *     
 *    Java也有类似于1）中的语法，来初始化每一个对象的非静态变量。
 *  通过下面的例子可以看到，构造代码块的初始化在构造方法之前，并且每次
 *  创建实例都会调用。  
 */
class Mug{
	Mug(int marker){
		System.out.println("Mug(" + marker + ")");
	}
	void f(int marker){
		System.out.println("f(" + marker + ")");
	}
}

class Mugs{
	Mug mug1;
	Mug mug2;
	{
		mug1 = new Mug(1);
		mug2 = new Mug(2);
		System.out.println("mug1 and mug2 initialized");
	}
	Mugs(){
		System.out.println("Mugs()");
	}
	Mugs(int i){
		System.out.println("Mugs(int)");
	}
	
}
