package com.think17.containerdeep;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 17.5 List�Ĺ��ܷ��� 
 */
public class Example005 {
	
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	
	public static void basicTest(List<String> a){
		a.add(1,"x");       //���ӵ�λ��1
		a.add("x");         //���ӵ����
		
		//a.addAll(Countr)
	}

}
