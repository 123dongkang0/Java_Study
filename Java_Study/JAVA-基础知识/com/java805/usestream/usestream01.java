package com.java805.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*        5.1 ɸѡ����Ƭ  
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream
* <br><b>Date:</b> 2018��4��12�� ����5:12:15
*/
public class usestream01 {
   
	/**
	 * 5.1.1 ��ν��ɸѡ 
	 *    ɸѡ�����е��ز�
	 */
	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu
				          .stream()
				          .filter(Dish :: isVegetarian)
				          .collect(Collectors.toList());
		menu.forEach(d -> System.out.println(d.getName()));
	}
	
	/**
	 * 5.1.2 ɸѡ�����Ԫ��
	 *    ����֧��һ������distinct�ķ��������᷵��һ��Ԫ�ظ��죨����
	 *      ��������Ԫ�ص�hashCode��equals������ʵ�֣�������
	 *      
	 *    ��������ɸѡ���б������е�ż��������ȷ��û���ظ�����
	 */
	@Test
	public void test02() {
		List<Integer> numbers = Arrays.asList(1,2,1,3,3,3,2,4);
		numbers.stream()
		.filter(i -> i % 2 == 0)
		.distinct()
		.forEach(System.out :: println);
	}
	
	/**
	 * 5.1.3 �ض���
	 *    
	 *     ��֧��limit(n)�������÷����᷵��һ���������������ȵ����� �������
	 *  ����ģ������᷵��ǰn��Ԫ�ء�
	 *  
	 *      limitҲ���������������ϣ�����Դ��һ��Set,��������£�limit�Ľ������
	 *   ���κ�˳�����С�
	 */
	@Test
	public void test03() {
		 //ѡ����������300��·���ͷ������
		List<Dish> menu = StreamConstant.menu
				.stream()
				.filter(d -> d.getCalories() > 300)
				.limit(3)
				.collect(Collectors.toList());
		
		menu.forEach(d -> System.out.println(d.getName()));
	}
	
	/**
	 * 5.1.4 ����Ԫ��
	 *    
	 *    ��֧��skip(n)����������һ���ӵ���ǰn��Ԫ�ص�����
	 *  �������Ԫ�ز���n�����򷵻�һ��������
	 *  
	 *   ����Ĵ��뽫��������300��·���ͷ�����ˣ�������ʣ�µġ�
	 */
	@Test
	public void test04() {
         List<Dish> menus = StreamConstant.menu
        		    .stream()
        		    .filter(d -> d.getCalories() > 300)
        		    .skip(2)
        		    .collect(Collectors.toList());
         menus.forEach(d -> System.out.println(d.getName()));
	}
}
