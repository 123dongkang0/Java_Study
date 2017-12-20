package com.effictive05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * ��28��������������ͨ���������API����� 
 * 
 *      Ϊ�˻�ȡ����޶ȵ�����ԣ��������߻��������ߵ����������ʹ��ͨ������͡�
 *      ������-extends
 *      ������-super
 *      
 *      ���ĳ������������������ߣ����������ߣ���ôͨ����޷��ṩ�κκô�����Ϊ����Ҫ�����ϸ������ƥ�䣬
 *      ���ǲ����κ�ͨ������õ��ġ�
 *      
 */
public class Example028 {
   
	/**
	 * 1)�� ����26���е���Stack��ӷ��� pushAll.
	 *     ��������˳��һϵ�е�Ԫ��ȫ���ŵ���ջ�С�
	 * 
	 */
	@Test
	public void testStack28(){
		Stack28<Number> numberStack = new Stack28<Number>();
		List<Integer> integers =  Arrays.asList(1,3,5,2,0);
		//numberStack.pushAll(integers);  //�������ֱ����쳣����Ϊ�����������ǲ��ɱ��
		numberStack.pushAll01(integers);
		System.out.println(numberStack.pop());
	}
	
	/**
	 * 2)������26���е���Stack��ӷ���popAll. 
	 *     popAll�����Ӷ�ջ�е���ÿ��Ԫ�أ�������ЩԪ����ӵ�ָ���ļ����С�
	 */
	@Test
	public void testStack2801(){
		Stack28<Number> numberStack = new Stack28<Number>();
		Collection<Object> objects = new ArrayList<Object>();
		//numberStack.popAll(objects);  //�޷���ȷ�������������Ͳ�һ�µ�ԭ��
		numberStack.popAll01(objects); 
	}
	
}

class Stack28<E> extends Stack<E>{
	
	public void pushAll(Iterable<E> src){
		for(E e:src)
			push(e);
	}
	
	/**
	 * ʹ�������Ƶ����÷�����������1)����������� 
	 */
	public void pushAll01(Iterable<? extends E> src){   //���������Ͱ�ȫ��
		for(E e:src)
			push(e);
	}
	
	public void popAll(Collection<E> dst){
		while(!isEmpty())
			dst.add(pop());
	}
	
	/**
	 * ʹ�������Ƶ����÷�����������1)����������� 
	 * ���յ�����Ϊ ���Ͳ��� E �ĳ����͡�
	 */
	public void popAll01(Collection<? super E> dst){
		while(!isEmpty())
			dst.add(pop());
	}
	
}