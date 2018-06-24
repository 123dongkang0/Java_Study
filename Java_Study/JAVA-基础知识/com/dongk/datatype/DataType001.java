package com.dongk.datatype;

import org.junit.Test;

public class DataType001 {
    
	/**
	 *  当满足下面两个条件的时候，Java就会进行自动数据类型转换。
	 *     1.两者类型兼容。
	 *     2.目标类型大于源类型。
	 * 
	 */
	@Test
	public void test01() {
		
		//1.要保存有效的type值，int类型总是够的，所以会自动转换
		byte a = 8;
		int b = a;
		//char c = a; 两者不兼容
		System.out.println(b);
		
	}
	
	/**
	 *  强制转换不兼容的数据类型。
	 *   int转换为byte
	 */
	@Test
	public void test02() {
		
		//1.int 转换为byte
		int a = 257;
		byte b = (byte)a;  //结果为1,257/256(byte的范围)的余数
		System.out.println(b);
		System.out.println(1257 % 256);
		
	}
	
	/**
	 *  强制转换不兼容的数据类型。
	 *   double转换为byte
	 */
	@Test
	public void test03() {
		
		//double转换为byte
		double a = 27.344;
		byte b = (byte)a;  //丢掉小数部分
		System.out.println(b);
		
	}
	
	/**
	 *  强制转换不兼容的数据类型。
	 *   double转换为int
	 */
	@Test
	public void test04() {
		
		//double转换为int
		double a = 27.344;
		int b = (int)a;  //丢掉小数部分
		System.out.println(b);
		
	}
}
