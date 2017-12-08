package com.effictive02;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * 第6条 ：消除过期对象的引用
 */
public class Example006 {
   public static void main(String args[]){
	  // WeakHashMap<M, V>
   }
}

//can you spot the "memory leak"?
/**
 * 1）、这段程序有一个 "内存泄漏" 风险。
 * 
 *  如果一个栈先增长，然后再收缩，那么，从栈中弹出来的对象不会当做垃圾被回收。因为elements数组没有
 *  解除 "活动部分" 之外引用。
 *  
 *  修复问题的方法很简单，只是需要清空这些引用即可。
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