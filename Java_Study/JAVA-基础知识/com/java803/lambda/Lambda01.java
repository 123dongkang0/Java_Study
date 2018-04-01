package com.java803.lambda;

import java.util.Comparator;

import org.junit.Test;

import com.java8.model.Apple;

/**
* <b>Description: 第三章 Lambda 表达式
*         本章的行文思路就是教你如何一步一步写出更简洁、更灵活的代码。
*      
*   3.1 Lambda 管中窥豹      
*      Lamdba表达式： 表示可传递的匿名函数的一种方式，它没有名称，但是它有参数列表、
*   函数主体、返回类型，可抛出的异常列表。
*         
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda01
* <br><b>Date:</b> 2018年4月1日 下午1:39:20
*/
public class Lambda01 {
	
	/**
	 * 3.2 在哪里以及如何使用Lambda表达式 ？
	 *      在函数式接口上使用Lambda表达式。
	 *      
	 *      3.2.1 什么是函数式接口？
	 *          只是定义了一个抽象方法的接口， Runable 就是一个函数式接口
	 */
	@Test
	public void test01() {
		Runnable r1 = () -> System.out.println("Hello World Lambda!!");
		process(r1);
	}
	
	public static void process(Runnable r) {
		r.run();
	}
	
	
	
}
      
	
