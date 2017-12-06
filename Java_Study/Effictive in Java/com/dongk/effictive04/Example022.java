package com.dongk.effictive04;

import org.junit.Test;

/**
 * 第22条： 优先考虑静态成员类 
 * 
 *   非静态成员类需要和外部类建立关系，这种关系需要消耗非静态成员类实例的空间。因此一般有限选择静态成员类。
 */
public class Example022 {
   
	/**
	 * 场景1：
	 *    如果成员类的实例都需要指向外围类的实例，成员类就应该是非静态的。
	 */
	private int currentNumber = 0;
	private class InnerClazz implements Runnable{
		public void run() {
			System.out.println(currentNumber);
		}
	}
	
	
	/**
	 * 场景2：
	 *    如果成员类的实例不需要需要指向外围类的实例，成员类就应该是静态的。
	 */
	private static class NestedInnerClazz implements Runnable{
		public void run() {
			System.out.println("Hello world!!");
		}
	}
	
	/**
	 * 场景3： 匿名类的使用。
	 * 
	 *   如果只是需要在一个地方创建实例，并且已经有一个预置的类型说明这个类的特征，就把它
	 * 做成匿名类。  使用匿名类可以让代码更加简洁，易于理解。
	 */
	@Test
	public void test03(){
		Runnable r = new Runnable() {
			public void run() {
               System.out.println("Example022.test03().");				
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
	
}


