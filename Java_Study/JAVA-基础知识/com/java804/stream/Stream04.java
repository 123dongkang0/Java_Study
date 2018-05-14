package com.java804.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*       4.4 流操作
*       
*         1. java.util.stream.Stream 中的Stram接口中定义了许多操作。它们可以分成两大类
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream04
* <br><b>Date:</b> 2018年4月12日 下午2:38:07
*/
public class Stream04 {
   
	/**
	 * 
	 *   除非流水线上触发一个终端操作，否则中间操作不会执行任何处理——它们很懒 。
	 * 这是因为中间操作一般都可以合并起来，在终端操作时一次性全部处理
	 */
	@Test
	public void test01() {
		List<String> names = StreamConstant.menu             //=============================
				              .stream()                      //          中间操作
				              .map(Dish :: getName)          //=================================
				              .collect(Collectors.toList()); //终端操作
	}
	
	/**
	 * 在这里打印流操作的中间操作，你会发现它将对个操作整合在一起来执行
	 * 
	 * 什么是终端操作？
	 * 返回结果是任何不适流的值，比如List、Integer,甚至void
	 */
	@Test
	public void test02() {
		List<String> names = StreamConstant.menu    
				              .stream()
				              .filter(d -> {
						            	   System.out.println("filtering..." + d.getName());
						            	   return d.getCalories() > 300L;
				                       })
				               .map( d -> {
						            	   System.out.println("maping ..." + d.getName());
						            	   return d.getName();
				                       })
				               .limit(3)
				              .collect(Collectors.toList()); 
	}
}
