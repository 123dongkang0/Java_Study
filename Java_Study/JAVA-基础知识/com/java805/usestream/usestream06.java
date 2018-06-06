package com.java805.usestream;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*    ��ֵ����
*    
*       java 8 ������ԭʼ�����ػ���3����IntStream��DoubleStream��
*        LongStream.
*        
*     ΪʲôҪ�ػ�����3����������
*       ��Ϊװ��ĸ��ӻ�����������ܵļ�����   
*    
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream06
* <br><b>Date:</b> 2018��6��6�� ����10:54:42
*/
public class usestream06 {
     
	
	/**
	* <b>Description:
	*    1.ӳ�䵽��ֵ��
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test01() {
		 int calories = StreamConstant.menu.stream()
		 .mapToInt(Dish :: getCalories)
		 .sum();
	}
	
	/**
	* <b>Description:
	*    2.ת���������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test02() {
		IntStream intStream = StreamConstant.menu.stream().mapToInt(Dish :: getCalories);
		Stream<Integer> stream = intStream.boxed();
		
	}
	
	/**
	* <b>Description:
	*    3.Ĭ�ϵ�OptionalInt
	*         ר��������int��Optional
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test03() {
		OptionalInt max = StreamConstant.menu
		  .stream()
		  .mapToInt(Dish :: getCalories)
		  .max();
	}
	
	/**
	* <b>Description:
	*    5.6.2.��ֵ��Χ
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����11:00:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void test04() {
		//һ����1��100��ż����
		IntStream evenNumbers = IntStream.range(1, 100)
		.filter(n -> n % 2==0);
	}
	
}
