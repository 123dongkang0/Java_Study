package com.dongk.datatype;

import org.junit.Test;

/**
* <b>Description:
*     String 字面量创建对象和new 创建对象的区别
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.dongk.datatype
* <br><b>ClassName:</b> DataType002
* <br><b>Date:</b> 2018年6月25日 上午1:07:48
*/
public class DataType002 {
	
	@Test
	public void test01() {
		String s = "hello",
			   t = "hello";
		char c[] = {'h','e','l','l','o'};
		
		System.out.println(s == t);  //true java中内容相同的字符串常量只保存一份，为了节省内存
		System.out.println(t.equals(c)); //false 类型不一样
		System.out.println(t.equals(new String("hello"))); //true 只保存一分
	}

}
