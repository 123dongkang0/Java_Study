package com.think15.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 14.5.6 一个Set实用工具
 *    如何使用Set来表达数学中的关系式，使用泛型方法，可以很方便的做到这一点，
 * 且可以用于多种类型。 
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
 *此枚举类型中包含了所有水彩画的颜色 
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
	 *计算两个set集合的并集 
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
    
	/**
	 * 计算两个Set集合的交集
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}
	
	/**
	 * 计算Set集合superset相对于Set集合subSet的差集
	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subSet){
		Set<T> result = new HashSet<T>(superset);
		result.removeAll(subSet);
		return result;
	}
	
	/**
	 * 计算两个Set集合的补集
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b){
		return difference(union(a,b), difference(a,b));
	}
	
}
