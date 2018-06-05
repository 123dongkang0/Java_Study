package com.java803.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import com.java8.model.Apple;

/**
* <b>Description:
*     3.6 方法引用？
*     
*      方法引用可以被看作仅仅调用特定方法的Lambda的一种快捷写法。
*  它的基本思想是，如果一个Lambda代表的只是“直接调用这个方法”，那最好还是用名称来调用它，
*  而不是去描述如何调用它。
*  
*     方法引用就是Lambda表达式的快捷写法
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018年4月13日 上午9:59:42
*/
public class Lambda06 {
    
	@Test
	public void test01(){
		
		List<String> str = Arrays.asList("a","E","A","D","E");
		
		//str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		
		//等效方法引用如下
		str.sort(String :: compareToIgnoreCase);
		str.forEach(System.out :: println);
	}
	
	/**
	 * 3.6.2 构造函数的引用
	 *     Function 只是适合有一个参数的构造函数。
	 *     //Integer ： 表示构造方法的参数类型是Integer，且只有一个参数
	 */
	@Test
	public void test02() {
		//等价于,Function<Integer, Apple> c1 = (weight) -> new Apple(weight); 
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(110);
	}
	
	@Test
	public void test03() {
		List<Integer> weights = Arrays.asList(7,3,4,10);
		List<Apple> apples = map(weights, Apple::new);
		apples.forEach(System.out::println);
	}
	
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
		List<Apple> result = new ArrayList<>();
		for(Integer e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
	
	/**
	 * BiFunction 适合具有两个参数的构造函数
	 */
	@Test
	public void test04() {
		/**
		 * Integer : 表示构造函数的第一个参数的类型是Integer
		 * String : 标识构造函数的第二个参数的类型是String 
		 */
		BiFunction<Integer,String, Apple> c3 = Apple::new;
		Apple a3 = c3.apply( 110,"green");
		
	}
}
