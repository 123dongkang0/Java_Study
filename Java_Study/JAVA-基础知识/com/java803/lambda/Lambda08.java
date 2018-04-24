package com.java803.lambda;

import java.util.Comparator;

import org.junit.Test;

import com.java8.model.Apple;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*         
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda08
* <br><b>Date:</b> 2018年4月24日 上午9:01:06
*/
public class Lambda08 {
     
	/**
	* <b>Description:
	*     3.8.1 比较复合器
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年4月24日 上午9:02:23
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
		
		//1.逆序，如果想要按照苹果重量递减怎么办
		StreamConstant.inventory.sort(c.reversed());
		StreamConstant.inventory.forEach(System.out::println);
		
		//2.比较器链，如果两个苹果一样重怎么办了，我们可以按照颜色来排序，如下
		StreamConstant.inventory.sort(c.reversed()
				                       .thenComparing(Apple::getColor)
				                       );
	}
	
	/**
	* <b>Description:
	*      3.8.2 谓词复合
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年4月24日 上午9:19:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		
	}
}
