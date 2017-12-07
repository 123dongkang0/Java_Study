package com.think15.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 15.13 动态类型安全 
 */
public class Example013 {
   public static void main(String args[]){
	   List<Dog> dogs1 = new ArrayList<Dog>();
	   CheckedList.oldStyleMethod(dogs1);   //将猫插入狗，完全没有任何问题(但是这破坏了你的容器)
	   
	   //使用类型检查
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