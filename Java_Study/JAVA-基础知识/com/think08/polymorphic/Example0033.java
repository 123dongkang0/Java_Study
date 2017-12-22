package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.3.3 �������ڲ��Ķ�̬��������Ϊ 
 * 
 *    ��һ�����������ڲ��������ڹ���Ķ����ĳ����̬�󶨷�������ô�ᷢ��ʲô����أ��뿴���档
 */
public class Example0033 {
   
	/**
	 * ���ǿ��Կ��������е�draw()������û�б����ǡ�
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