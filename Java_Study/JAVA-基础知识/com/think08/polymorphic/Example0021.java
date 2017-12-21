package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.2 这里我们来讨论向上转型的缺陷
 */
public class Example0021 {
	private void f() {
		System.out.println("private f()");
	}
	
	/**
	 * 输出的内容和我们想象的不太一样。 
	 */
	@Test
	public  void testDerived(){
		Example0021 po = new Derived();
		po.f();
	}
	
	@Test
	public void testStaticSub(){
		StaticSuper sp = new StaticSub();
		System.out.println(sp.dynamicGet());
		System.out.println(sp.staticGet());
	}
}

/**
 * 8.2.4 缺陷："覆盖" 私有方法。 
 * 
 *   子类无法覆盖父类的私有方法
 */
class Derived extends  Example0021{
	public void f(){
		System.out.println("pulbic f()");
	}
}

/**
 * 8.2.5 缺陷： 静态方法
 *    
 *     不要想当然的认为所有的事物都是可以多态地发生。只有普通的方法调用可以是多态的。
 *     静态方法并不是多态的。
 */
class StaticSuper{
	public static String staticGet(){
		return "Base staticGet()";
	}
	public String dynamicGet(){
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper{
	public static String staticGet(){
		return "Derived staticGet()";
	}
	public String dynamicGet(){
		return "Derived dynamicGet()";
	}
}

