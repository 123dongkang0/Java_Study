package com.think15.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.7.4边界处的动作。
  * 　　java泛型可以表示没有任何意义的事物，正是因为有了擦除的缘故。
 */
public class Example0074 {
   public static void main(String args[]){
	   ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
	   String[] stringArray = stringMaker.create(9);
	   System.out.println(Arrays.toString(stringArray));
	   
	   System.out.println(stringMaker.create("Hello",4));
   }
}

class ArrayMaker<T>{
	private Class<T> kind;
	public ArrayMaker(Class<T> kind){this.kind = kind;}
	
	T[] create(int size){
		return (T[])Array.newInstance(kind, size);
	}
	
	List<T> create(){
		return new ArrayList<T>();
	}
	
	List<T> create(T t,int n){
		List<T> result = new ArrayList<T>();
		for(int i=0; i<n; i++){
			result.add(t);
		}
		return result;
	}
}

