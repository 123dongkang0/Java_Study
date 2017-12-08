package com.think11.hodingobject;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 11.7 LinkedList
 *   
 *    1.LinkedList也像ArrayList一样实现了基本的List接口，但是它执行某些操作（在List中间插入和移除）
 *      时比ArrayList更加高效，但在随机访问操作方面却要稍逊一些。
 *    2.LinkedList还添加了可以使其用作栈、队列或者双端队列的方法。
 *    
 */
public class Example007 {
	
	String strArray[] = {"str1", "str2", "str3", "str4", "str5"};
	LinkedList<String> strList = new LinkedList<String>(Arrays.asList(strArray));
    
	@Test
	public void test01(){
		//getFirst() 、 element() 完全一样，它们都返回列表的第一个元素，并且不移除它。
		System.out.println(" strList.getFirst() " + strList.getFirst());
		System.out.println(" strList.element() " + strList.element());
		
		//peek() 和 getFirst() 、 element()方式稍有差别，它在列表为空时返回null
	    System.out.println(" strList.peek() " + strList.peek());
	}
	
	@Test
	public void test02(){
		//remove()、removeFirst()完全一样，他们都移除并返回列表的头
		System.out.println(" strList.remove() " + strList.remove());
		System.out.println(" strList.removeFirst() " + strList.removeFirst());
		System.out.println(strList);
		
		//poll()和remove()、removeFirst()稍有差别，它在列表为空时返回null
		System.out.println(" strList.poll() " + strList.poll());
		
	}
	
	@Test
	public void test03(){
		strList.addFirst("str0");         //插入首部
		System.out.println(strList);
		
		strList.add("str6");              //插入尾部，返回boolean
		System.out.println(strList);
		
		strList.addLast("str7");           //插入尾部，不返回任何值
		System.out.println(strList);
	}
	
	@Test 
	public void test04(){
		System.out.println(strList.removeLast());   //移除并返回最后一个元素
	}
}
