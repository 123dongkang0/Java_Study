package com.java8.lambda;

import org.junit.Test;

/**
 * 1.���lambda���ʽ��JAVAʵ�֣��������ṹ�ǳ��ؼ�����һ���� lambda���ʽ����
 *   �ڶ����Ǻ���ʽ�ӿڡ�
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
