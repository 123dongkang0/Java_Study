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
	
	String strArray[] = {"str1", "str2", "str3", "str4", "str5"};
	LinkedList<String> strList = new LinkedList<String>(Arrays.asList(strArray));
    
	@Test
	public void test01(){
		//getFirst() �� element() ��ȫһ�������Ƕ������б�ĵ�һ��Ԫ�أ����Ҳ��Ƴ�����
		System.out.println(" strList.getFirst() " + strList.getFirst());
		System.out.println(" strList.element() " + strList.element());
		
		//peek() �� getFirst() �� element()��ʽ���в�������б�Ϊ��ʱ����null
	    System.out.println(" strList.peek() " + strList.peek());
	}
	
	@Test
	public void test02(){
		//remove()��removeFirst()��ȫһ�������Ƕ��Ƴ��������б��ͷ
		System.out.println(" strList.remove() " + strList.remove());
		System.out.println(" strList.removeFirst() " + strList.removeFirst());
		System.out.println(strList);
		
		//poll()��remove()��removeFirst()���в�������б�Ϊ��ʱ����null
		System.out.println(" strList.poll() " + strList.poll());
		
	}
	
	@Test
	public void test03(){
		strList.addFirst("str0");         //�����ײ�
		System.out.println(strList);
		
		strList.add("str6");              //����β��������boolean
		System.out.println(strList);
		
		strList.addLast("str7");           //����β�����������κ�ֵ
		System.out.println(strList);
	}
	
	@Test 
	public void test04(){
		System.out.println(strList.removeLast());   //�Ƴ����������һ��Ԫ��
	}
}
