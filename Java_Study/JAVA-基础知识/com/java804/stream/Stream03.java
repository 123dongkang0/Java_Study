package com.java804.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.transform.ToListResultTransformer;
import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*        4.3 ���뼯��
*        
*          1.���ͼ�����ʲô����
*             1.1 ���� �� Java8�еļ��Ͼ����Ǵ���DVD�ϵĵ�Ӱ�������б��������ݽṹ����ӵ�е�����ֵ-ÿ��Ԫ�ص�ֵ��������������ܼӵ������У���
*             1.2 ��   �� Java8 �е������������ߵ���ý�忴��Ӱ������Ƶ��һ����ֻ������Ҫ��ʱ��Ż����ֵ��
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream03
* <br><b>Date:</b> 2018��4��12�� ����2:38:07
*/
public class Stream03 {
    
	/**
	 * 4.3.1 ��ֻ�ܱ���һ��
	 * 
	 *  С��Ĳ�����������Ѿ������ĵ��쳣��
	 */
	@Test
	public void test01() {
		List<String> title = Arrays.asList("JAVA 8","IN","Action");
		Stream<String> s = title.stream();
		s.forEach(System.out :: println);
		s.forEach(System.out :: println);
	}
	
	/**
	 * 4.3.2  ���ͼ��ϵ���һ�����������ǵĵ�����ʽ
	 *   ���ϣ��ⲿ������
	 *   �� �� �ڲ�������
	 */
	@Test
	public void test02() {
		List<String> names = StreamConstant.menu
				              .stream()
				              .map(Dish :: getName)
				              .collect(Collectors.toList());
	}
}
