package com.dongk.datatype;

import org.junit.Test;

/**
* <b>Description:
*     String ���������������new �������������
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.dongk.datatype
* <br><b>ClassName:</b> DataType002
* <br><b>Date:</b> 2018��6��25�� ����1:07:48
*/
public class DataType002 {
	
	@Test
	public void test01() {
		String s = "hello",
			   t = "hello";
		char c[] = {'h','e','l','l','o'};
		
		System.out.println(s == t);  //true java��������ͬ���ַ�������ֻ����һ�ݣ�Ϊ�˽�ʡ�ڴ�
		System.out.println(t.equals(c)); //false ���Ͳ�һ��
		System.out.println(t.equals(new String("hello"))); //true ֻ����һ��
	}

}
