package com.think15.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 15.13 ��̬���Ͱ�ȫ 
 */
public class Example013 {
   public static void main(String args[]){
	   List<Dog> dogs1 = new ArrayList<Dog>();
	   CheckedList.oldStyleMethod(dogs1);   //��è���빷����ȫû���κ�����(�������ƻ����������)
	   
	   //ʹ�����ͼ��
	   List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
	   try{
		   CheckedList.oldStyleMethod(dogs2);
	   }catch(Exception e){
		   System.out.println(e);
	   }
	   
   }
}

class Cat{}
class Dog{}

class CheckedList{
	static void oldStyleMethod(List pribablyDogs){
		pribablyDogs.add(new Cat());
	}
}