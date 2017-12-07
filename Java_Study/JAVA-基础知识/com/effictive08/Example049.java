package com.effictive08;

import java.util.Comparator;

import org.junit.Test;

/**
 * 第49条：基本类型优先于装箱基本类型
 * 
 *  1.基本类型、装箱基本类型的区别。
 *    1.1 基本类型只有值；而装箱基本类型则具有和它们值不同的同一性。
 *    1.2 基本类型通常比装箱基本类型更加节省时间和空间。
 */
public class Example049 {
	
	/**
	 * 1.装箱类型可能在无意中导致程序出错。 
	 */
	@Test
	public void test01(){
		
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return first < second ? -1 : (first == second ? 0 : 1);
			}
		};
		
		int comparaResult = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(comparaResult);  //1
		
		/**
		 * 结果可能和你想象的不太一样，它输出的并不是0，而是1
		 *  first < second ：这个表达式工作的很好，
		 *  执行计算会导致first、second引用的Integer实例被自动拆箱
		 *  
		 *  first == second：做同一性比较，所以不相等
		 */
	}
	
	/**
	 * 2.装箱类型导致程序工作缓慢 
	 */
	@Test
	public void test02(){
		//Long sum = 0L;
		long sum = 0L;  //应该修改为 基础类型 long
		for(long i=0; i<Integer.MAX_VALUE; i++){
			/**
			 * 此步骤先将可以分解如下：
			 *    sum = sum.intValue() + i;            //自动拆箱进行计算
             *    Integer sum = new Integer(result);   //自动装箱返回
			 */
			sum += i;  
		}
		System.out.println(sum);
	}
}
