package com.effictive05;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 第25条：列表优先于数组
 * 
 *  1)、数组和泛型相比，有两个重要的不同点
 *    1.1）、数组是协变的，即如果Sub[]就是Super的子类型，那么数组类型Sub[]就是Super的子类型。而泛型
 *          是不可变的。
 *    1.2）、数组是具体化的        
 */
public class Example025 {
    
	@Test
	public void test01(){
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don,t fit in";   //编译器无法发现这个运行时错误
	}
	
	/**
	 * 2)、阐述了为什么不能够存在泛型数组的原因 
	 */
	@Test
	public void test02(){
		
		/*
		List<String>[] stringLists = new List<String>[];   //(1)
		
		List<Integer> intList = Arrays.asList(42);
		
		Object[] objects = stringLists;  //合法的，因为数组是协变的。
		
		objects[0] = intList;            //可以，因为数组是通过擦除来实现的
		
		String s = stringLists[0].get(0);  //在这里会有类型转换的异常，为了防止这种情况发生，所以第一行给了一个编译时错误
		*/
	}
}
