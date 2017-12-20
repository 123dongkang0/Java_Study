package com.effictive05;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * 第27条：优先考虑泛型方法。 
 *   1.)、静态工具方法尤其使用于泛型化。(Collections中所有的方法都被泛型化);
 *   2.)、泛型方法最显著的特征是，无需明确指定类型参数的值。
 */
public class Example027 {
	
	@Test
	public void testUnion(){
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom","Dick","Harry"));
		Set<String> Stooges = new HashSet<String>(Arrays.asList("Larry","Moe","Curly"));
		Set<String> aflCio = union(guys, Stooges);
		System.out.println(aflCio);
		
	}
	
	/**
	 * 1）、定义一个简单的泛型方法 
	 * 
	 *    union的局限性在于，三个集合的类型（两个输入参数和一个返回值），必须全部相同。
	 */
	public static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	/**
	 * 2)、使用泛型方法可以进行类型推导，减少代码编写量 
	 */
	
	//Map<String,List<String>> anagrams = new HashMap(); //会有警告
	Map<String,List<String>> anagrams = newHashMap();
	public static<K,V> HashMap<K, V> newHashMap(){
		return new HashMap<K, V>();
	}
	
	/**
	 * 3）、泛型单例工厂。有时需要创建不可变但又适合于许多不同类型的对象。由于泛型是通过擦除实现的
	 *     可以给所有必要的类型参数使用单个对象 
	 */
	/**
	 * 3.1）、普通单例对象 
	 */
	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};
	
	public static <T> UnaryFunction<T> identityFunction(){
		return (UnaryFunction<T>)IDENTITY_FUNCTION;
	}
	
	@Test
	public void testUnaryFunction(){
       String[] strings = {"jute","hemp","nylon"};
       UnaryFunction<String> sameString = identityFunction();
       for(String s : strings)
    	   System.out.println(sameString.apply(s));
       
       Number[] numbers = {1,2.0,3L};
       UnaryFunction<Number> sameNumber = identityFunction();
       for(Number n : numbers)
    	   System.out.println(sameNumber.apply(n));
	}
	
	/**
	 * 4）、限定参数类型
	 */
	public static <T extends Comparable<T>> T max(List<T> list){
		Iterator<T> i = list.iterator();
		T result = i.next();
		while(i.hasNext()){
			T t = i.next();
			if(t.compareTo(result) > 0)
				result = t;
		}
		return result;
	}
	
}

interface UnaryFunction<T>{
	T apply(T arg);
}

//需要注意的是，所有的类型都只能和自身的类型做比较的
interface Comparable<T>{
	int compareTo(T o);
}
