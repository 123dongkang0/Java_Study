package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.3）、构造器和多态 
 */
public class Example003 {
     
	/**
	 * 我们可以看到构造器的调用顺序为
	 * 
	 *  1）基类构造器，这个步骤会不断的反复递归下去；
	 *  2）按照顺序调用成员的初始化方法。
	 *  3）调用导出类构造器的主体。
	 */
	@Test
	public void testSandwich(){
		new Sandwich();
	}
}

/**
 * 1)、构造器的调用顺序 
 */

class Meal{
	Meal(){
		System.out.println("Meal()");
	}
}

class Bread{
	Bread(){
		System.out.println("Bread()");
	}
}

class Cheese{
	Cheese(){
		System.out.println("Cheese()");
	}
}

class Lettuce{
	Lettuce(){
		System.out.println("Lettuce()");
	}
}

class Lunch extends Meal{
	Lunch(){
		System.out.println("Lunch()");
	}
}

class PortableLunch extends Lunch{
	PortableLunch(){
		System.out.println("PortableLunch()");
	}
}

class Sandwich extends PortableLunch{
	private Bread b = new Bread();
	private Cheese c = new Cheese();
	public Sandwich(){
		System.out.println("Sandwich()");
	}
}

