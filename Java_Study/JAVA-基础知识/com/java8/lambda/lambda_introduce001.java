package com.java8.lambda;

import org.junit.Test;

/**
 * 1.���lambda���ʽ��JAVAʵ�֣��������ṹ�ǳ��ؼ�����һ���� lambda���ʽ����
 *   �ڶ����Ǻ���ʽ�ӿڡ�
 */
public class lambda_introduce001 {
	
	@Test
	public void test01() {
		MyNumber myNum;
		
	    myNum = () -> 123.45;
		System.out.println(myNum.getValue());
		
	    myNum = () -> Math.random() * 100;
		System.out.println(myNum.getValue());
		
		//error ����ʽ�ӿڵķ���ֵ��double
		//myNum = () -> "Hello lambda";
	}
	
	/**
	 *��������lambda���ʽ 
	 */
	@Test
	public void test02() {
		NumercTest isEven = (n) -> (n%2) == 0;
		if(isEven.test(10)) System.out.println("10 is even");
		if(!isEven.test(9)) System.out.println("9 is not even");
		
		NumercTest isNonNeg = (n) -> n>=0;
		if(isNonNeg.test(1)) System.out.println(" 1 is non-negative");
		if(!isNonNeg.test(-1)) System.out.println(" -1 is negative");
	}

}

interface MyNumber{
	double getValue();
}


interface NumercTest{
	boolean test(int n);
}