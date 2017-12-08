package com.effictive02;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * ��6�� ���������ڶ��������
 */
public class Example006 {
   public static void main(String args[]){
	  // WeakHashMap<M, V>
   }
}

//can you spot the "memory leak"?
/**
 * 1������γ�����һ�� "�ڴ�й©" ���ա�
 * 
 *  ���һ��ջ��������Ȼ������������ô����ջ�е������Ķ��󲻻ᵱ�����������ա���Ϊelements����û��
 *  ��� "�����" ֮�����á�
 *  
 *  �޸�����ķ����ܼ򵥣�ֻ����Ҫ�����Щ���ü��ɡ�
 *  public Object pop(){
 *		if(size == 0)
 *			throw new EmptyStackException();
 *      Object result = elements[--size];
 *      elements[size] == null;
 *		return result;
 *	}
 */
class Stack{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop(){
		if(size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}
	
	private void ensureCapacity(){
		if(elements.length == size)
			elements = Arrays.copyOf(elements, 2*size + 1);
	}
}