package com.think11.hodingobject;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 11.7 LinkedList
 *   
 *    1.LinkedListҲ��ArrayListһ��ʵ���˻�����List�ӿڣ�������ִ��ĳЩ��������List�м������Ƴ���
 *      ʱ��ArrayList���Ӹ�Ч������������ʲ�������ȴҪ��ѷһЩ��
 *    2.LinkedList������˿���ʹ������ջ�����л���˫�˶��еķ�����
 *    
 */
public class Example007 {
    
	@Test
	public void test01(){
		String strArray[] = {"str1", "str2", "str3", "str4", "str5"};
		LinkedList<String> strList = new LinkedList<String>(Arrays.asList(strArray));
		
		//getFirst() �� element() ��ȫһ�������Ƕ������б�ĵ�һ��Ԫ�أ����Ҳ��Ƴ�����
		System.out.println(" strList.getFirst() " + strList.getFirst());
		System.out.println(" strList.element() " + strList.element());
	}
}
