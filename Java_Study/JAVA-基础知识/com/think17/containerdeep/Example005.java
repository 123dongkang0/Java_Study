package com.think17.containerdeep;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 17.5 List的功能方法 
 */
public class Example005 {
	
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	
	public static void basicTest(List<String> a){
		a.add(1,"x");       //增加到位置1
		a.add("x");         //增加到最后
		
		//a.addAll(Countr)
	}

}
