package com.java8.lambda;

import org.junit.Test;

/**
 * 1.理解lambda表达式的JAVA实现，有两个结构非常关键，第一个是 lambda表达式自身，
 *   第二个是函数式接口。
 */
public class lambda_introduce001 {
	
	@Test
	public void test01() {
		MyNumber myNum = () -> 123.45;
		System.out.println(myNum.getValue());
	}

}

interface MyNumber{
	double getValue();
}
