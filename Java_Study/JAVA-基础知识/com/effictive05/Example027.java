package com.effictive05;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * ��27�������ȿ��Ƿ��ͷ����� 
 *   1.)����̬���߷�������ʹ���ڷ��ͻ���(Collections�����еķ����������ͻ�);
 *   2.)�����ͷ����������������ǣ�������ȷָ�����Ͳ�����ֵ��
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
	 * 1��������һ���򵥵ķ��ͷ��� 
	 * 
	 *    union�ľ��������ڣ��������ϵ����ͣ��������������һ������ֵ��������ȫ����ͬ��
	 */
	public static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	/**
	 * 2)��ʹ�÷��ͷ������Խ��������Ƶ������ٴ����д�� 
	 */
	
	//Map<String,List<String>> anagrams = new HashMap(); //���о���
	Map<String,List<String>> anagrams = newHashMap();
	public static<K,V> HashMap<K, V> newHashMap(){
		return new HashMap<K, V>();
	}
	
	/**
	 * 3�������͵�����������ʱ��Ҫ�������ɱ䵫���ʺ�����಻ͬ���͵Ķ������ڷ�����ͨ������ʵ�ֵ�
	 *     ���Ը����б�Ҫ�����Ͳ���ʹ�õ������� 
	 */
	/**
	 * 3.1������ͨ�������� 
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
      
	}

}

interface UnaryFunction<T>{
	T apply(T arg);
}
