package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.3.3 构造器内部的多态方法的行为 
 * 
 *    在一个构造器的内部调用正在构造的对象的某个动态绑定方法，那么会发生什么情况呢？请看下面。
 */
public class Example0033 {
   
	/**
	 * 我们可以看到基类中的draw()方法并没有被覆盖。
	 */
	@Test
	public void testRoundGlyph(){
		new RoundGlyph(5);
	}
	
}

class Glyph{
	void draw(){
		System.out.println("Glyph.draw()");
	}
	Glyph(){
		System.out.println("Glyph before draw()");
		draw();
		System.out.println("Glyph after draw()");
	}
}

class RoundGlyph extends Glyph{
	private int radius = 1;
	RoundGlyph(int r){
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	void draw(){
		System.out.println("RoundGlyph.draw()");
	}
}