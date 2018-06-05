package com.java803.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

import com.java8.model.Apple;

/**
* <b>Description:
*     3.6 �������ã�
*     
*      �������ÿ��Ա��������������ض�������Lambda��һ�ֿ��д����
*  ���Ļ���˼���ǣ����һ��Lambda�����ֻ�ǡ�ֱ�ӵ������������������û�������������������
*  ������ȥ������ε�������
*  
*     �������þ���Lambda���ʽ�Ŀ��д��
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018��4��13�� ����9:59:42
*/
public class Lambda06 {
    
	@Test
	public void test01(){
		
		List<String> str = Arrays.asList("a","E","A","D","E");
		
		//str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		
		//��Ч������������
		str.sort(String :: compareToIgnoreCase);
		str.forEach(System.out :: println);
	}
	
	/**
	 * 3.6.2 ���캯��������
	 *     Function ֻ���ʺ���һ�������Ĺ��캯����
	 *     //Integer �� ��ʾ���췽���Ĳ���������Integer����ֻ��һ������
	 */
	@Test
	public void test02() {
		//�ȼ���,Function<Integer, Apple> c1 = (weight) -> new Apple(weight); 
		Function<Integer, Apple> c2 = Apple::new;
		Apple a2 = c2.apply(110);
	}
	
	@Test
	public void test03() {
		List<Integer> weights = Arrays.asList(7,3,4,10);
		List<Apple> apples = map(weights, Apple::new);
		apples.forEach(System.out::println);
	}
	
	public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f){
		List<Apple> result = new ArrayList<>();
		for(Integer e : list) {
			result.add(f.apply(e));
		}
		return result;
	}
	
	/**
	 * BiFunction �ʺϾ������������Ĺ��캯��
	 */
	@Test
	public void test04() {
		/**
		 * Integer : ��ʾ���캯���ĵ�һ��������������Integer
		 * String : ��ʶ���캯���ĵڶ���������������String 
		 */
		BiFunction<Integer,String, Apple> c3 = Apple::new;
		Apple a3 = c3.apply( 110,"green");
		
	}
}
