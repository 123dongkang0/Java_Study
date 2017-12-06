package com.dongk.effictive04;

import org.junit.Test;

/**
 * ��22���� ���ȿ��Ǿ�̬��Ա�� 
 * 
 *   �Ǿ�̬��Ա����Ҫ���ⲿ�ཨ����ϵ�����ֹ�ϵ��Ҫ���ķǾ�̬��Ա��ʵ���Ŀռ䡣���һ������ѡ��̬��Ա�ࡣ
 */
public class Example022 {
   
	/**
	 * ����1��
	 *    �����Ա���ʵ������Ҫָ����Χ���ʵ������Ա���Ӧ���ǷǾ�̬�ġ�
	 */
	private int currentNumber = 0;
	private class InnerClazz implements Runnable{
		public void run() {
			System.out.println(currentNumber);
		}
	}
	
	
	/**
	 * ����2��
	 *    �����Ա���ʵ������Ҫ��Ҫָ����Χ���ʵ������Ա���Ӧ���Ǿ�̬�ġ�
	 */
	private static class NestedInnerClazz implements Runnable{
		public void run() {
			System.out.println("Hello world!!");
		}
	}
	
	/**
	 * ����3�� �������ʹ�á�
	 * 
	 *   ���ֻ����Ҫ��һ���ط�����ʵ���������Ѿ���һ��Ԥ�õ�����˵���������������Ͱ���
	 * ���������ࡣ  ʹ������������ô�����Ӽ�࣬������⡣
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


