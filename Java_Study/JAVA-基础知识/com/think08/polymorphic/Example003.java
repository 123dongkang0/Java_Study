package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.3�����������Ͷ�̬ 
 */
public class Example003 {
     
	/**
	 * ���ǿ��Կ����������ĵ���˳��Ϊ
	 * 
	 *  1�����๹�������������᲻�ϵķ����ݹ���ȥ��
	 *  2������˳����ó�Ա�ĳ�ʼ��������
	 *  3�����õ����๹���������塣
	 */
	@Test
	public void testSandwich(){
		new Sandwich();
	}
}

/**
 * 1)���������ĵ���˳�� 
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

