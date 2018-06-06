package com.java805.usestream;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.itextpdf.text.log.SysoCounter;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*    5.4 ��Լ
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream04
* <br><b>Date:</b> 2018��6��5�� ����10:52:13
*/
public class usestream04 {
    
	/**
	* <b>Description:
	*    5.4.1 Ԫ�����
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��5�� ����10:55:59
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Integer[] numbers = {1,3,5,7,9};
		
		//java8֮ǰ
		int sum = 0;
		for(int number : numbers)
			sum = sum + number;
		System.out.println(sum);
		
		//java8
		//Arrays.asList(numbers).stream().reduce(0,(a,b) -> a + b);
		Arrays.asList(numbers).stream().reduce(0,Integer :: sum);
	}
	
	
	 
		/**
		* <b>Description:
		*    5.4.2 ���ֵ����Сֵ
		* </b><br> 
		* @Note
		* <b>Author:dongk</b>
		* <br><b>Date:</b> 2018��6��5�� ����10:55:59
		* <br><b>Version:</b> 1.0
		* <br><b>param:</b>
		* <br><b>return:</b>
		*/
		@Test
		public void test02() {
			Integer[] numbers = {1,3,5,7,9};
			System.out.println("���ֵ��" + Arrays.asList(numbers).stream().reduce(Integer :: max));
			System.out.println("��Сֵ��" + Arrays.asList(numbers).stream().reduce(Integer :: min));
		}
		
		/**
		* <b>Description:
		*    �ҵ��˵����ж��ٵ��ˣ����ǰ�����ģʽ���� map-reduceģʽ
		* </b><br> 
		* @Note
		* <b>Author:dongk</b>
		* <br><b>Date:</b> 2018��6��6�� ����9:19:49
		* <br><b>Version:</b> 1.0
		* <br><b>param:</b>
		* <br><b>return:</b>
		*/
		@Test
		public void test03() {
			Integer reduce = StreamConstant.menu.stream().map(d-> 1).reduce(0, Integer :: sum);
			//Ҳ����ʹ��stram���õķ���
			//long reduce = StreamConstant.menu.stream().count();
			System.out.println("��ǰ��" + reduce + "����");
		}
		
	
}
