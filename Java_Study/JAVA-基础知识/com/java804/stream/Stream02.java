package com.java804.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.junit.Test;

import com.java8.model.Dish;

/**
* <b>Description:
*        4.1 流简介
*        
*          1. 什么是流？
*             支持数据处理操作的源生成的元素序列。
*             
*          2.元素序列
*             集合讲的是数据，流讲的是计算。
*             而元素序列就是提供计算的一组序列。
*             
*          3.源
*            生成流的源，如集合、数组或者输入/输出资源。       
*            
*          4.内部迭代
*            和使用迭代器显示迭代的集合不同，流的迭代操作是在背后进行的。  
*          
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream02
* <br><b>Date:</b> 2018年4月12日 下午2:38:07
*/
public class Stream02 {

	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu;
				
	  List<String> heightCalories = menu.stream()             //获取一个流
								.filter(d -> d.getCalories() > 300)
								.map(Dish :: getName)     //获取菜名  （Dish :: getName 传递方法引用） 
								.limit(3)                 //只是选择头三个
								.collect(Collectors.toList()); 
	  System.out.println(heightCalories);
	}
	
}
