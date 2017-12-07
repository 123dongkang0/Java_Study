package com.point.autoboxing;

import java.util.ArrayList;

import org.junit.Test;

/**
 * JAVA �е��Զ�װ������䡣
 * 
 *     1. Java�е�ԭʼֵ���ͺͰ�װ���Ͷ�Ӧ���£�
 *       
 *       ԭʼֵ���ͣ� byte, short, char,      int,     long, float, double,  boolean
 *       ��װ���ͣ�     Byte, Short, Character, Integer, Long, Float, Double,  Boolean
 *     
 *     2.Ϊʲô���а�װ����
 *      ��ΪJava1.5֮����б�̣�����ֱ�ӵ��򼯺�(Collections)�з���ԭʼֵ����
 *      
 *     3.ʲô���Զ�װ����Զ����䣿
 *       �Զ�װ��: ����������valueOf��ԭʼ����ֵת���ɶ���;
 *       �Զ�����: ������ͨ����������intValue(),doubleValue()����ķ���������ת����ԭʼ����ֵ;
 */
public class Example001 {
   
	/**
	 * 1.ʲô����»ᷢ���Զ�װ��Ͳ��� 
	 */
	@Test
	public void test01(){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);       //�Զ�װ��
		intList.add(2);
		
		ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>();
		intLocal.set(4);       //�Զ�װ��
		
		int number = intList.get(0);    //�Զ�����
		int local = intLocal.get();      //�Զ�����
		
	}
	
	/**
	 * 2.������ȵıȽ� 
	 */
	@Test
	public void test02(){
	      int i1 = 1;
	      int i2 = 1;
	      System.out.println(i1 == i2);  //true
	      
	      Integer num1 = 1344;
	      int num2 = 1344;
	      System.out.println(num1 == num2); //true  num1 �Զ������num2���бȽ�
	      
	      /**
	       *  ����һ�ּ������,obj1��obj2�ĳ�ʼ�����������Զ�װ�������
	       *  ���Ǵ��ڽ�ʡ�ڴ�Ŀ��ǣ�JVM�Ỻ��-128��127��Integer����
	       *  ���obj1��obj2ʵ������ͬһ����������ʹ�á�==���ȽϷ���true�� 
	       **/
	      Integer obj1 = 1;   //�Զ�װ��
	      Integer obj2 = 1;
	      System.out.println(obj1 == obj2); //true
	      
	      Integer obj3 = 132;   //�Զ�װ��
	      Integer obj4 = 132;
	      System.out.println(obj3 == obj4); //false
	      
	      Integer one = new Integer(1);
	      Integer two = new Integer(2);
	      System.out.println(one == two);   //false
	      
	}
}
