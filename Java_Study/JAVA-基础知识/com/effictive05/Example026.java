package com.effictive05;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;

import org.junit.Test;

/**
 * 第26条： 优先考虑泛型 
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
 * 1)、在第6条中有个简单的堆栈实现 ，使用泛型来实现
 * 
 */
class Stack<E>{
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack(){
		//因为Java的泛型是通过擦除来实现的，所以不能这样子写。
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
 * 2)、也可以对泛型的参数做校验 
 *   如下：泛型的参数必须是 Delayed 的一个子类
 */
class DelayQueue<E extends Delayed>{
	
}

