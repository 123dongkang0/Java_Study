package com.effictive05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * ��25�����б�����������
 * 
 *  1)������ͷ�����ȣ���������Ҫ�Ĳ�ͬ��
 *    1.1����������Э��ģ������Sub[]����Super�������ͣ���ô��������Sub[]����Super�������͡�������
 *          �ǲ��ɱ�ġ�
 *    1.2���������Ǿ��廯�� ,��������������ʱ��֪�����Ҽ������Ԫ�ص�Լ�����ͣ�
 *    
 *  2)������ͷ��ͻ��ʹ�õ�ʱ����������˱��������߾��棬��һ��ӦӦ����ʹ���б����������顣
 */
public class Example025 {
    
	@Test
	public void test01(){
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don,t fit in";   //�������޷������������ʱ����
	}
	
	/**
	 * 2)��������Ϊʲô���ܹ����ڷ��������ԭ�� 
	 */
	@Test
	public void test02(){
		
		/*
		List<String>[] stringLists = new List<String>[];   //(1)
		
		List<Integer> intList = Arrays.asList(42);
		
		Object[] objects = stringLists;  //�Ϸ��ģ���Ϊ������Э��ġ�
		
		objects[0] = intList;            //���ԣ���Ϊ������ͨ��������ʵ�ֵ�
		
		String s = stringLists[0].get(0);  //�������������ת�����쳣��Ϊ�˷�ֹ����������������Ե�һ�и���һ������ʱ����
		*/
	}
	
	/**
	 * 3����������һ��ͬ���б��һ������(ӵ����������б�ͬ���͵Ĳ���ֵ)��
	 *      Ȼ���дһ������reduce����ʹ�ú���apply��������б�(����applyΪ������㣬��ôreduce�������б�������Ԫ�ص�ֵ)
	 * 
	 */
	
	/**
	 * 3.1����û�з���ʱ�Ĵ��룺 ��ʹ��ͬ������飩
	 */
	static Object reduce01(List list, Function f, Object initVal){
		synchronized(list){
			Object result = initVal;
			for(Object o : list)
				result = f.apply(result, o);
			return result;
		}
	}
	
	/**
	 * 3.2���� �ڱ�����ִ��apply����(������ͬ�������)
	 *     ����List��toArray����(�����ڲ������б�)
	 *     
	 *     ����ʹ��������ʵ�ֱ��ݣ������й����У����ܻ����ClassCaseException
	 */
	static <E> Object reduce02(List<E> list, Function<E> f, E initVal){
		E[] sanpshot = (E[])list.toArray(); //����ǿ��ת���󣬻��о������
		E result = initVal;
		for(E e:sanpshot)
			result = f.apply(result, initVal);
		return result;
	}
	
	/**
	 * 3.3���� �ڱ�����ִ��apply����
	 *     ����List
	 *     ��δ�����Ȼ�е� �߳������ǿ���ȷ����������ʱ����õ�ClassCastException�쳣��
	 *     ������ֵ�õġ�
	 */
	static <E> Object reduce03(List<E> list, Function<E> f, E initVal){
		List<E> sanpshot;
		synchronized(list){
			sanpshot = new ArrayList<E>(list);
		}
		E result = initVal;
		for(E e:sanpshot)
			result = f.apply(result, e);
		return result;
	}
	
	
}

interface Function<T>{
	T apply(T arg1, T arg2);
}

