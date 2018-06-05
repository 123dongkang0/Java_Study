package com.java805.usestream;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

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
	
}
