package com.java803.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

/**
* <b>Description:
*     3.4 使用函数式接口？
*     
*     这里介绍JAVA8常见的几个函数式接口 Predicate
*                                    Consumer
*                                    Function
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018年4月13日 上午9:59:42
*/
public class Lambda04 {
    
	/**
	 * 3.4.1 Predicate 
	 * 
	 *    java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，
	 *  它接受泛型T对象，并返回一个boolean。
	 */
	@Test
	public void test01() {
		List<String> listOfString = Arrays.asList("","AAAA","ccccc","");
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(listOfString,nonEmptyStringPredicate);
		nonEmpty.forEach(System.out::println);
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		for(T s : list) {
			if(p.test(s))
				results.add(s);
		}
		return results;
	}
	
	/**
	 * 3.4.2 Consumer
	 * 
	 *    java.util.function.Consumer<T>定义了一个名叫accept的抽象方法，它接受泛型T的对象，
	 * 没有返回（void）。你如果需要访问类型T的对象，并对其执行某些操作，就可以使用这个接口。
	 * 比如，你可以用它来创建一个forEach方法，接受一个Integers的列表，并对其中每个元素执行操作。
	 * 在下面的代码中，你就可以使用这个forEach方法，并配合Lambda来打印列表中的所有元素。
	 *   
	 */
	@Test
	public void test02() {
		forEach(
				Arrays.asList(1,2,3,4,5),
				(Integer i) -> System.out.println(i)
				);
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T i: list) {
			c.accept(i);
		}
	}
	
	/**
	 * 3.4.5 Function
	 * 
	 *      java.util.function.Function<T, R>接口定义了一个叫作apply的方法，它接受一个泛型T的对象，
	 *   并返回一个泛型R的对象。如果你需要定义一个Lambda，将输入对象的信息映射到输出，
	 *   就可以使用这个接口（比如提取苹果的重量，或把字符串映射为它的长度）。在下面的代码中，
	 *   我们向你展示如何利用它来创建一个map方法，以将一个String列表映射到包含每个String长度的Integer列表。
	 *   
	 */
	@Test
	public void test03() {
		List<Integer> map = map(
					Arrays.asList("lambdas","in","action"),
					(String s) -> s.length()
				   );
		map.forEach(System.out :: println);
		
	}
	
	public static <T,R> List<R> map(List<T> list, Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
	
}
