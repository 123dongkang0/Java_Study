package com.think05.init;

import org.junit.Test;

/**
 * 5.7 构造器初始化 
 * 
 *    即时没有显示的static修饰。构造器也是静态方法
 */
public class Example007 {
   
	@Test
	public void testHouse(){
		/**
		 * w3 会被初始化2次，第一次引用的对象将会被丢弃，并且被垃圾回收。 
		 */
		House h = new House();
		h.f();
	}
	
	/**
	 * 初始化的顺序是
	 *   静态对象(只初始化一次),
	 *   非静态对象，
	 */
	
	static Table table = new Table();
	static CupBoard cupboard = new CupBoard();
	@Test
	public void testBow1(){
		new CupBoard();
		new CupBoard();
		table.f2(1);
		cupboard.f3(1);
	}
}

/**
 * 1)、在类的内部，变量定义的先后顺序决定了初始化的顺序.
 *     无论它们散列在类的什么地方。
 */

class Window{
	Window(int marker){
		System.out.println("Window(" + marker + ")");
	}
}

class House{
	Window w1 = new Window(1);
	House(){
		System.out.println("House()");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void f(){
		System.out.println("f()");
	}
	Window w3 = new Window(3);
}

/**
 * 2)、静态数据的初始化
 *    无论创建对少个对象，静态数据都只占一份存储区域。
 */
class Bow1{
	Bow1(int marker){
		System.out.println("Bow1(" + marker + ")");
	}
	void f1(int marker){
		System.out.println("f1(" + marker + ")");
	}
}

class Table{
	static Bow1 Bow11 = new Bow1(1);
	Table(){
		System.out.println("Table()");
		Bow12.f1(1);
	}
	void f2(int marker){
		System.out.println("f2(" + marker + ")");
	}
	static Bow1 Bow12 = new Bow1(2);
}

class CupBoard{
	Bow1 Bow13 = new Bow1(3);
	static Bow1 Bow14 = new Bow1(4);
	CupBoard(){
		System.out.println("CupBoard()");
		Bow14.f1(1);
	}
	void f3(int marker){
		System.out.println("f3(" + marker + ")");
	}
	static Bow1 Bow15 = new Bow1(5);
}