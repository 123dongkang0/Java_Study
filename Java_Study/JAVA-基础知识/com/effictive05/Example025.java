package com.effictive05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 第25条：列表优先于数组
 * 
 *  1)、数组和泛型相比，有两个重要的不同点
 *    1.1）、数组是协变的，即如果Sub[]就是Super的子类型，那么数组类型Sub[]就是Super的子类型。而泛型
 *          是不可变的。
 *    1.2）、数组是具体化的 ,因此数组会在运行时才知道并且检查它们元素的约束类型；
 *    
 *  2)、数组和泛型混合使用的时候，如果出现了编译错误或者警告，第一反应应该是使用列表来代替数组。
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
	
	/**
	 * 3）、假设有一个同步列表和一个函数(拥有两个与该列表同类型的参数值)，
	 *      然后编写一个方法reduce，并使用函数apply处理这个列表(假设apply为求和运算，那么reduce就是求列表中所有元素的值)
	 * 
	 */
	
	/**
	 * 3.1）、没有泛型时的代码： （使用同步代码块）
	 */
	static Object reduce01(List list, Function f, Object initVal){
		synchronized(list){
			Object result = initVal;
			for(Object o : list)
				result = f.apply(result, o);
			return result;
		}
	}
	
	/**
	 * 3.2）、 在备份上执行apply方法(不适用同步代码块)
	 *     利用List的toArray方法(它在内部锁定列表)
	 *     
	 *     下面使用数组来实现备份，在运行过程中，可能会出现ClassCaseException
	 */
	static <E> Object reduce02(List<E> list, Function<E> f, E initVal){
		E[] sanpshot = (E[])list.toArray(); //进行强制转换后，会有警告出现
		E result = initVal;
		for(E e:sanpshot)
			result = f.apply(result, initVal);
		return result;
	}
	
	/**
	 * 3.3）、 在备份上执行apply方法
	 *     利用List
	 *     这段代码虽然有点 冗长，但是可以确定它在运行时不会得到ClassCastException异常，
	 *     所以是值得的。
	 */
	static <E> Object reduce03(List<E> list, Function<E> f, E initVal){
		List<E> sanpshot;
		synchronized(list){
			sanpshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for(E e:sanpshot)
			result = f.apply(result, e);
		return result;
	}
	
	
}

interface Function<T>{
	T apply(T arg1, T arg2);
}

