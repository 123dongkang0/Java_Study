package com.think15.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 15.4.1 �ܸ��������Ͳ����ƶ�
 */
public class Example0041 {
   public static void main(String args[]){
	   //���������ƶϣ����Ա����������������������
	   Map<String,List<String>> sls = New.<String,List<String>>map();
      // Map<String,List<String>> sls = New.map();
       List<String> ls = New.list();
       
   }
}

class New{
	public static <K,V> Map<K, V> map(){
		return new HashMap<K, V>();
	}
	
	public static <T> List<T> list(){
		return new ArrayList<T>();
	}
	
	public static <T> LinkedList<T> lList(){
		return new LinkedList<T>();
	}
	
	public static <T> Set<T> set(){
		return new HashSet<T>();
	}
    
	public static <T> Queue<T> queue(){
		return new LinkedList<T>();
	}
}