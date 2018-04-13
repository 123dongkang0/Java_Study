package com.java803.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

/**
* <b>Description:
*     3.4 ʹ�ú���ʽ�ӿڣ�
*     
*     �������JAVA8�����ļ�������ʽ�ӿ� Predicate
*                                    Consumer
*                                    Function
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018��4��13�� ����9:59:42
*/
public class Lambda04 {
    
	/**
	 * 3.4.1 Predicate 
	 * 
	 *    java.util.function.Predicate<T>�ӿڶ�����һ������test�ĳ��󷽷���
	 *  �����ܷ���T���󣬲�����һ��boolean��
	 */
	@Test
	public void test01() {
		List<String> listOfString = Arrays.asList("","AAAA","ccccc","");
		Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
		List<String> nonEmpty = filter(listOfString,nonEmptyStringPredicate);
		nonEmpty.forEach(System.out::println);
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> results = new ArrayList<>();
		for(T s : list) {
			if(p.test(s))
				results.add(s);
		}
		return results;
	}
	
	/**
	 * 3.4.2 Consumer
	 * 
	 *    java.util.function.Consumer<T>������һ������accept�ĳ��󷽷��������ܷ���T�Ķ���
	 * û�з��أ�void�����������Ҫ��������T�Ķ��󣬲�����ִ��ĳЩ�������Ϳ���ʹ������ӿڡ�
	 * ���磬���������������һ��forEach����������һ��Integers���б���������ÿ��Ԫ��ִ�в�����
	 * ������Ĵ����У���Ϳ���ʹ�����forEach�����������Lambda����ӡ�б��е�����Ԫ�ء�
	 *   
	 */
	@Test
	public void test02() {
		forEach(
				Arrays.asList(1,2,3,4,5),
				(Integer i) -> System.out.println(i)
				);
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for(T i: list) {
			c.accept(i);
		}
	}
	
	/**
	 * 3.4.5 Function
	 * 
	 *      java.util.function.Function<T, R>�ӿڶ�����һ������apply�ķ�����������һ������T�Ķ���
	 *   ������һ������R�Ķ����������Ҫ����һ��Lambda��������������Ϣӳ�䵽�����
	 *   �Ϳ���ʹ������ӿڣ�������ȡƻ��������������ַ���ӳ��Ϊ���ĳ��ȣ���������Ĵ����У�
	 *   ��������չʾ���������������һ��map�������Խ�һ��String�б�ӳ�䵽����ÿ��String���ȵ�Integer�б�
	 *   
	 */
	@Test
	public void test03() {
		List<Integer> map = map(
					Arrays.asList("lambdas","in","action"),
					(String s) -> s.length()
				   );
		map.forEach(System.out :: println);
		
	}
	
	public static <T,R> List<R> map(List<T> list, Function<T,R> f){
		List<R> result = new ArrayList<>();
		for(T s : list) {
			result.add(f.apply(s));
		}
		return result;
	}
	
}
