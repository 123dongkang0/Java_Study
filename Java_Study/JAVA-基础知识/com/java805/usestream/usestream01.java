package com.java805.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*        5.1 筛选和切片  
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream
* <br><b>Date:</b> 2018年4月12日 下午5:12:15
*/
public class usestream01 {
   
	/**
	 * 5.1.1 用谓词筛选 
	 *    筛选出所有的素菜
	 */
	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu
				          .stream()
				          .filter(Dish :: isVegetarian)
				          .collect(Collectors.toList());
		menu.forEach(d -> System.out.println(d.getName()));
	}
	
	/**
	 * 5.1.2 筛选各异的元素
	 *    流还支持一个叫做distinct的方法，它会返回一个元素各异（根据
	 *      流所生成元素的hashCode和equals方法来实现）的流，
	 *      
	 *    下面代码会筛选出列表中所有的偶数，并且确保没有重复出现
	 */
	@Test
	public void test02() {
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,3,2,4);
		numbers.stream()
		.filter(i -> i % 2 == 0)
		.distinct()
		.forEach(System.out :: println);
	}
	
	/**
	 * 5.1.3 截短流
	 *    
	 *     流支持limit(n)方法，该方法会返回一个不超过给定长度的流。 如果流是
	 *  有序的，则最多会返回前n个元素。
	 *  
	 *      limit也可以用在无序流上，比如源是一个Set,这种情况下，limit的结果不会
	 *   以任何顺序排列。
	 */
	@Test
	public void test03() {
		 //选出热量超过300卡路里的头三道菜
		List<Dish> menu = StreamConstant.menu
				.stream()
				.filter(d -> d.getCalories() > 300)
				.limit(3)
				.collect(Collectors.toList());
		
		menu.forEach(d -> System.out.println(d.getName()));
	}
	
	/**
	 * 5.1.4 跳过元素
	 *    
	 *    流支持skip(n)方法，返回一个扔掉了前n个元素的流。
	 *  如果流中元素不足n个，则返回一个空流。
	 *  
	 *   下面的代码将跳过超过300卡路里的头两道菜，并返回剩下的。
	 */
	@Test
	public void test04() {
         List<Dish> menus = StreamConstant.menu
        		    .stream()
        		    .filter(d -> d.getCalories() > 300)
        		    .skip(2)
        		    .collect(Collectors.toList());
         menus.forEach(d -> System.out.println(d.getName()));
	}
}
