package com.java805.usestream;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*    数值流：
*    
*       java 8 正对于原始类型特化了3个流IntStream、DoubleStream、
*        LongStream.
*        
*     为什么要特化出这3个流出来？
*       因为装箱的复杂化，造成了性能的减弱。   
*    
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream06
* <br><b>Date:</b> 2018年6月6日 上午10:54:42
*/
public class usestream06 {
     
	
	/**
	* <b>Description:
	*    1.映射到数值流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test01() {
		 int calories = StreamConstant.menu.stream()
		 .mapToInt(Dish :: getCalories)
		 .sum();
	}
	
	/**
	* <b>Description:
	*    2.转换会对象流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test02() {
		IntStream intStream = StreamConstant.menu.stream().mapToInt(Dish :: getCalories);
		Stream<Integer> stream = intStream.boxed();
		
	}
	
	/**
	* <b>Description:
	*    3.默认的OptionalInt
	*         专门正对于int的Optional
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test03() {
		OptionalInt max = StreamConstant.menu
		  .stream()
		  .mapToInt(Dish :: getCalories)
		  .max();
	}
	
	/**
	* <b>Description:
	*    5.6.2.数值范围
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test04() {
		//一个从1到100的偶数流
		IntStream evenNumbers = IntStream.range(1, 100)
		.filter(n -> n % 2==0);
	}
	
}
