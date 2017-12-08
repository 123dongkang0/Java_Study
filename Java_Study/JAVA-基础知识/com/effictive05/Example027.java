package com.effictive05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 第27条：优先考虑泛型方法。 
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

}
