package com.java804.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*       4.4 ������
*       
*         1. java.util.stream.Stream �е�Stram�ӿ��ж����������������ǿ��Էֳ�������
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream04
* <br><b>Date:</b> 2018��4��12�� ����2:38:07
*/
public class Stream04 {
   
	/**
	 * 
	 *   ������ˮ���ϴ���һ���ն˲����������м��������ִ���κδ��������Ǻ��� ��
	 * ������Ϊ�м����һ�㶼���Ժϲ����������ն˲���ʱһ����ȫ������
	 */
	@Test
	public void test01() {
		List<String> names = StreamConstant.menu             //=============================
				              .stream()                      //          �м����
				              .map(Dish :: getName)          //=================================
				              .collect(Collectors.toList()); //�ն˲���
	}
	
	/**
	 * �������ӡ���������м��������ᷢ�������Ը�����������һ����ִ��
	 * 
	 * ʲô���ն˲�����
	 * ���ؽ�����κβ�������ֵ������List��Integer,����void
	 */
	@Test
	public void test02() {
		List<String> names = StreamConstant.menu    
				              .stream()
				              .filter(d -> {
						            	   System.out.println("filtering..." + d.getName());
						            	   return d.getCalories() > 300L;
				                       })
				               .map( d -> {
						            	   System.out.println("maping ..." + d.getName());
						            	   return d.getName();
				                       })
				               .limit(3)
				              .collect(Collectors.toList()); 
	}
}
