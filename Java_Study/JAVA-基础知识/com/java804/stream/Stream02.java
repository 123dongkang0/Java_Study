package com.java804.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.junit.Test;

import com.java8.model.Dish;

/**
* <b>Description:
*        4.1 �����
*        
*          1. ʲô������
*             ֧�����ݴ��������Դ���ɵ�Ԫ�����С�
*             
*          2.Ԫ������
*             ���Ͻ��������ݣ��������Ǽ��㡣
*             ��Ԫ�����о����ṩ�����һ�����С�
*             
*          3.Դ
*            ��������Դ���缯�ϡ������������/�����Դ��       
*            
*          4.�ڲ�����
*            ��ʹ�õ�������ʾ�����ļ��ϲ�ͬ�����ĵ����������ڱ�����еġ�  
*          
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream02
* <br><b>Date:</b> 2018��4��12�� ����2:38:07
*/
public class Stream02 {

	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu;
				
	  List<String> heightCalories = menu.stream()             //��ȡһ����
								.filter(d -> d.getCalories() > 300)
								.map(Dish :: getName)     //��ȡ����  ��Dish :: getName ���ݷ������ã� 
								.limit(3)                 //ֻ��ѡ��ͷ����
								.collect(Collectors.toList()); 
	  System.out.println(heightCalories);
	}
	
}
