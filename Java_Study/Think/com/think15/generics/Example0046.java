package com.think15.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 14.5.6 һ��Setʵ�ù���
 *    ���ʹ��Set�������ѧ�еĹ�ϵʽ��ʹ�÷��ͷ��������Ժܷ����������һ�㣬
 * �ҿ������ڶ������͡� 
 */
public class Example0046 {
   public static void main(String args[]){
	   Set<Watercolors> set1= EnumSet.range(Watercolors.ZINC, Watercolors.BLUE);
	   Set<Watercolors> set2= EnumSet.range(Watercolors.DEEP_YELLOW, Watercolors.DEEP_GREEN);
	   
	   System.out.println(Sets.union(set1, set2));
	   System.out.println(Sets.intersection(set1, set2));
	   System.out.println(Sets.difference(set1, set2));
	   System.out.println(Sets.complement(set1, set2));
	   
   }
}

/**
 *��ö�������а���������ˮ�ʻ�����ɫ 
 */
enum Watercolors{
	ZINC,
	LEMON_YELLOW,
	MEDIUM_YELLOW,
	DEEP_YELLOW,
	BLUE,
	LEMON_BLUE,
	MEDIUM_BLUE,
	DEEP_BLUE,
	GREEN,
	LEMON_GREEN,
	MEDIUM_GREEN,
	DEEP_GREEN,
}

class Sets{
	
	/**
	 *��������set���ϵĲ��� 
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
    
	/**
	 * ��������Set���ϵĽ���
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	/**
	 * ����Set����superset�����Set����subSet�Ĳ
	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subSet){
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subSet);
		return result;
	}
	
	/**
	 * ��������Set���ϵĲ���
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return difference(union(a,b), difference(a,b));
	}
	
}
