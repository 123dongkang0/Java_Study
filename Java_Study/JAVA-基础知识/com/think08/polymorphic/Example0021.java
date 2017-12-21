package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.2 ������������������ת�͵�ȱ��
 */
public class Example0021 {
	private void f() {
		System.out.println("private f()");
	}
	
	/**
	 * ��������ݺ���������Ĳ�̫һ���� 
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
 * 8.2.4 ȱ�ݣ�"����" ˽�з����� 
 * 
 *   �����޷����Ǹ����˽�з���
 */
class Derived extends  Example0021{
	public void f(){
		System.out.println("pulbic f()");
	}
}

/**
 * 8.2.5 ȱ�ݣ� ��̬����
 *    
 *     ��Ҫ�뵱Ȼ����Ϊ���е����ﶼ�ǿ��Զ�̬�ط�����ֻ����ͨ�ķ������ÿ����Ƕ�̬�ġ�
 *     ��̬���������Ƕ�̬�ġ�
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

