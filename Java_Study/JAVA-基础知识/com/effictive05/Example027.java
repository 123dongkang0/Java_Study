package com.effictive05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * ��27�������ȿ��Ƿ��ͷ����� 
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

}
