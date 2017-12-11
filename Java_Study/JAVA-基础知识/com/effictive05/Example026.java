package com.effictive05;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;

import org.junit.Test;

/**
 * ��26���� ���ȿ��Ƿ��� 
 */
public class Example026 {
    
	@Test
	public void testStack(){
		Stack<String> stack = new Stack<String>();
		for(String arg: new String[]{"aa","bb","cc"}){
			stack.push(arg);
		}
		while(!stack.isEmpty())
			System.out.println(stack.pop().toUpperCase());
	}
}

/**
 * 1)���ڵ�6�����и��򵥵Ķ�ջʵ�� ��ʹ�÷�����ʵ��
 * 
 */
class Stack<E>{
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		//��ΪJava�ķ�����ͨ��������ʵ�ֵģ����Բ���������д��
		//elements = new E[DEFAULT_INITIAL_CAPACITY];
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		
	}
	
	public void push(E e){
		ensureCapacity();
		elements[size++] = e;
	}
	
	public boolean isEmpty(){
		if(size <= 0){
			return true;
		}else{
			return false;
		}
	} 
	
	public E pop(){
		if(size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}
	
	private void ensureCapacity(){
		if(elements.length == size)
			elements = Arrays.copyOf(elements, 2*size + 1);
	}
}


/**
 * 2)��Ҳ���ԶԷ��͵Ĳ�����У�� 
 *   ���£����͵Ĳ��������� Delayed ��һ������
 */
class DelayQueue<E extends Delayed>{
	
}

