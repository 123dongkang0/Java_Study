package com.java805.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;


/**
* <b>Description:
*      5.3  查找和匹配
*      
*        1.allMatch、anyMatch、noneMatch、findFirst和findAny方法提供了这样的工具。
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream02
* <br><b>Date:</b> 2018年4月12日 下午5:43:21
*/
public class usestream03 {

    /**
     * 
     * 5.3.1 检查谓词是否至少匹配一个元素
     * 
     *   anyMatch方法可以回答“流中是否有一个元素能匹配给定的谓词”。
     * 比如，你可以用它来看看菜单里面是否有素食可选择
     */
	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu;
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
	}
	
    /**
     * 5.3.2 检查谓词是否匹配所有的元素 
     * 
     *  判断是否所有菜的卡路里都低于 1000
     */
	@Test
	public void test02() {
		//和allMatch相对的是noneMatch
		boolean isHealthy = StreamConstant.menu
				    .stream()
				    .allMatch(d -> d.getCalories() < 1000);
		System.out.println(isHealthy);
	}
	
	/**
     * 5.3.3 查找元素
     * 
     *    findAny方法将返回当前流中的任意元素。它可以与其他流操作结合使用。比如，你可能想找到一道素食菜肴。
     *  你可以结合使用filter和findAny方法来实现这个查询：
     */
	@Test
	public void test03() {
		//和allMatch相对的是noneMatch
		Optional<Dish> dish = StreamConstant.menu
						.stream()
						.filter(Dish::isVegetarian)
						.findAny();
		System.out.println(dish.get().getName());
	}
	
	/**
     * 5.3.4 查找第一个元素
     * 
     *    findFirst 找出第一个平方能被3整除的数
     *    
     */
	@Test
	public void test04() {
		List<Integer> someNumbers  = Arrays.asList(1,2,3,4,5);
		Optional<Integer> firstSquareDivisibleByThree = 
				 someNumbers.stream()
				 .map(x -> x * x)
				 .filter(x -> x % 3 == 0)
				 .findFirst();
		System.out.println(firstSquareDivisibleByThree.get());
	}
	
	
	
}
