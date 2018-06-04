package com.java805.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;


/**
* <b>Description:
*      5.3  ���Һ�ƥ��
*      
*        1.allMatch��anyMatch��noneMatch��findFirst��findAny�����ṩ�������Ĺ��ߡ�
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream02
* <br><b>Date:</b> 2018��4��12�� ����5:43:21
*/
public class usestream03 {

    /**
     * 
     * 5.3.1 ���ν���Ƿ�����ƥ��һ��Ԫ��
     * 
     *   anyMatch�������Իش������Ƿ���һ��Ԫ����ƥ�������ν�ʡ���
     * ���磬����������������˵������Ƿ�����ʳ��ѡ��
     */
	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu;
		if(menu.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("The menu is (somewhat) vegetarian friendly!!");
		}
		
	}
	
    /**
     * 5.3.2 ���ν���Ƿ�ƥ�����е�Ԫ�� 
     * 
     *  �ж��Ƿ����в˵Ŀ�·�ﶼ���� 1000
     */
	@Test
	public void test02() {
		//��allMatch��Ե���noneMatch
		boolean isHealthy = StreamConstant.menu
				    .stream()
				    .allMatch(d -> d.getCalories() < 1000);
		System.out.println(isHealthy);
	}
	
	/**
     * 5.3.3 ����Ԫ��
     * 
     *    findAny���������ص�ǰ���е�����Ԫ�ء����������������������ʹ�á����磬��������ҵ�һ����ʳ���ȡ�
     *  ����Խ��ʹ��filter��findAny������ʵ�������ѯ��
     */
	@Test
	public void test03() {
		//��allMatch��Ե���noneMatch
		Optional<Dish> dish = StreamConstant.menu
						.stream()
						.filter(Dish::isVegetarian)
						.findAny();
		System.out.println(dish.get().getName());
	}
	
	/**
     * 5.3.4 ���ҵ�һ��Ԫ��
     * 
     *    findFirst �ҳ���һ��ƽ���ܱ�3��������
     *    
     */
	@Test
	public void test04() {
		List<Integer> someNumbers  = Arrays.asList(1,2,3,4,5);
		Optional<Integer> firstSquareDivisibleByThree = 
				 someNumbers.stream()
				 .map(x -> x * x)
				 .filter(x -> x % 3 == 0)
				 .findFirst();
		System.out.println(firstSquareDivisibleByThree.get());
	}
	
	
	
}
