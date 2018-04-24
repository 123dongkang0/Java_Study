package com.java803.lambda;

import java.util.Comparator;

import org.junit.Test;

import com.java8.model.Apple;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*         
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda08
* <br><b>Date:</b> 2018��4��24�� ����9:01:06
*/
public class Lambda08 {
     
	/**
	* <b>Description:
	*     3.8.1 �Ƚϸ�����
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��4��24�� ����9:02:23
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
		
		//1.���������Ҫ����ƻ�������ݼ���ô��
		StreamConstant.inventory.sort(c.reversed());
		StreamConstant.inventory.forEach(System.out::println);
		
		//2.�Ƚ��������������ƻ��һ������ô���ˣ����ǿ��԰�����ɫ����������
		StreamConstant.inventory.sort(c.reversed()
				                       .thenComparing(Apple::getColor)
				                       );
	}
	
	/**
	* <b>Description:
	*      3.8.2 ν�ʸ���
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��4��24�� ����9:19:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		
	}
}
