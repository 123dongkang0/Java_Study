package com.think05.init;

import org.junit.Test;

/**
 * 5.7 ��������ʼ�� 
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
 * 1)����̬���ݿ�ĳ�ʼ��
 *     
 *     Java���������̬��ʼ��������֯��һ������� "��̬�Ӿ�"(Ҳ���� "��̬��")��
 *  �������ľ�̬��ʼ��������һ���ġ�
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
 * cup1��cup2��cup2ֻ�����ഴ����ʱ���ʼ��һ�Ρ�
 */
class Cups{
	static Cup cup1;
	static Cup cup2;
	
	static{
		cup1 = new Cup(1);
		cup2 = new Cup(2);
		Cup cup3 = new Cup(3);  //���������������з��� cup3
	}
	Cups(){
		System.out.println("Cups()");
	}
}

/**
 * 2)���Ǿ�̬ʵ���ĳ�ʼ��(��������)
 *     
 *    JavaҲ��������1���е��﷨������ʼ��ÿһ������ķǾ�̬������
 *  ͨ����������ӿ��Կ�������������ĳ�ʼ���ڹ��췽��֮ǰ������ÿ��
 *  ����ʵ��������á�  
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
