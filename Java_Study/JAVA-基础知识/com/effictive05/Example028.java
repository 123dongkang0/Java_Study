package com.effictive05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * 第28条：利用有限制通配符来提升API灵活性 
 * 
 *      为了获取最大限度的灵活性，在生产者或者消费者的输入参数上使用通配符类型。
 *      生产者-extends
 *      消费者-super
 *      
 *      如果某个输入参数既是生产者，又是消费者；那么通配符无法提供任何好处，因为你需要的是严格的类型匹配，
 *      这是不用任何通配符而得到的。
 *      
 */
public class Example028 {
   
	/**
	 * 1)、 给第26条中的类Stack添加方法 pushAll.
	 *     让它按照顺序将一系列的元素全部放到堆栈中。
	 * 
	 */
	@Test
	public void testStack28(){
		Stack28<Number> numberStack = new Stack28<Number>();
		List<Integer> integers =  Arrays.asList(1,3,5,2,0);
		//numberStack.pushAll(integers);  //这里会出现编译异常，以为参数化类型是不可变的
		numberStack.pushAll01(integers);
		System.out.println(numberStack.pop());
	}
	
	/**
	 * 2)、给第26条中的类Stack添加方法popAll. 
	 *     popAll方法从堆栈中弹出每个元素，并将这些元素添加到指定的集合中。
	 */
	@Test
	public void testStack2801(){
		Stack28<Number> numberStack = new Stack28<Number>();
		Collection<Object> objects = new ArrayList<Object>();
		//numberStack.popAll(objects);  //无法正确遍历，参数类型不一致的原因
		numberStack.popAll01(objects); 
	}
	
}

class Stack28<E> extends Stack<E>{
	
	public void pushAll(Iterable<E> src){
		for(E e:src)
			push(e);
	}
	
	/**
	 * 使用有限制的配置符类型来处理1)中遇到的情况 
	 */
	public void pushAll01(Iterable<? extends E> src){   //这样是类型安全的
		for(E e:src)
			push(e);
	}
	
	public void popAll(Collection<E> dst){
		while(!isEmpty())
			dst.add(pop());
	}
	
	/**
	 * 使用有限制的配置符类型来处理1)中遇到的情况 
	 * 接收的类型为 泛型参数 E 的超类型。
	 */
	public void popAll01(Collection<? super E> dst){
		while(!isEmpty())
			dst.add(pop());
	}
	
}