package com.think05.init;

import org.junit.Test;

/**
 * 5.7 ��������ʼ�� 
 * 
 *    ��ʱû����ʾ��static���Ρ�������Ҳ�Ǿ�̬����
 */
public class Example007 {
   
	@Test
	public void testHouse(){
		/**
		 * w3 �ᱻ��ʼ��2�Σ���һ�����õĶ��󽫻ᱻ���������ұ��������ա� 
		 */
		House h = new House();
		h.f();
	}
	
	/**
	 * ��ʼ����˳����
	 *   ��̬����(ֻ��ʼ��һ��),
	 *   �Ǿ�̬����
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
 * 1)��������ڲ�������������Ⱥ�˳������˳�ʼ����˳��.
 *     ��������ɢ�������ʲô�ط���
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
 * 2)����̬���ݵĳ�ʼ��
 *    ���۴������ٸ����󣬾�̬���ݶ�ֻռһ�ݴ洢����
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