package com.effictive05;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ��25�����б�����������
 * 
 *  1)������ͷ�����ȣ���������Ҫ�Ĳ�ͬ��
 *    1.1����������Э��ģ������Sub[]����Super�������ͣ���ô��������Sub[]����Super�������͡�������
 *          �ǲ��ɱ�ġ�
 *    1.2���������Ǿ��廯��        
 */
public class Example025 {
    
	@Test
	public void test01(){
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don,t fit in";   //�������޷������������ʱ����
	}
	
	/**
	 * 2)��������Ϊʲô���ܹ����ڷ��������ԭ�� 
	 */
	@Test
	public void test02(){
		
		/*
		List<String>[] stringLists = new List<String>[];   //(1)
		
		List<Integer> intList = Arrays.asList(42);
		
		Object[] objects = stringLists;  //�Ϸ��ģ���Ϊ������Э��ġ�
		
		objects[0] = intList;            //���ԣ���Ϊ������ͨ��������ʵ�ֵ�
		
		String s = stringLists[0].get(0);  //�������������ת�����쳣��Ϊ�˷�ֹ����������������Ե�һ�и���һ������ʱ����
		*/
	}
}
