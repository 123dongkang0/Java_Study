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
    
	@Test
	public void test01(){
		String strArray[] = {"str1", "str2", "str3", "str4", "str5"};
		LinkedList<String> strList = new LinkedList<String>(Arrays.asList(strArray));
		
		//getFirst() 、 element() 完全一样，它们都返回列表的第一个元素，并且不移除它。
		System.out.println(" strList.getFirst() " + strList.getFirst());
		System.out.println(" strList.element() " + strList.element());
	}
}
