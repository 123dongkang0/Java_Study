package com.effictive08;

import java.util.Comparator;

import org.junit.Test;

/**
 * ��49������������������װ���������
 * 
 *  1.�������͡�װ��������͵�����
 *    1.1 ��������ֻ��ֵ����װ�������������к�����ֵ��ͬ��ͬһ�ԡ�
 *    1.2 ��������ͨ����װ��������͸��ӽ�ʡʱ��Ϳռ䡣
 */
public class Example049 {
	
	/**
	 * 1.װ�����Ϳ����������е��³������ 
	 */
	@Test
	public void test01(){
		
		Comparator<Integer> naturalOrder = new Comparator<Integer>() {
			public int compare(Integer first, Integer second) {
				return first < second ? -1 : (first == second ? 0 : 1);
			}
		};
		
		int comparaResult = naturalOrder.compare(new Integer(42), new Integer(42));
		System.out.println(comparaResult);  //1
		
		/**
		 * ������ܺ�������Ĳ�̫һ����������Ĳ�����0������1
		 *  first < second ��������ʽ�����ĺܺã�
		 *  ִ�м���ᵼ��first��second���õ�Integerʵ�����Զ�����
		 *  
		 *  first == second����ͬһ�ԱȽϣ����Բ����
		 */
	}
	
	/**
	 * 2.װ�����͵��³��������� 
	 */
	@Test
	public void test02(){
		//Long sum = 0L;
		long sum = 0L;  //Ӧ���޸�Ϊ �������� long
		for(long i=0; i<Integer.MAX_VALUE; i++){
			/**
			 * �˲����Ƚ����Էֽ����£�
			 *    sum = sum.intValue() + i;            //�Զ�������м���
             *    Integer sum = new Integer(result);   //�Զ�װ�䷵��
			 */
			sum += i;  
		}
		System.out.println(sum);
	}
}
