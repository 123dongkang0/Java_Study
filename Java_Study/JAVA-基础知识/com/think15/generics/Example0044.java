package com.think15.generics;

import com.think.pub.Generator;

/**
 *15.4.4 编写一个通用的Generator 
 */
public class Example0044 {
   public static void main(String args[]){
	   Generator<CountedObject> gc = BasicGenerator.create(CountedObject.class);
       for(int i=0; i<5;i++){
    	System.out.println(gc.next());   
       }
   }
}

class BasicGenerator<T> implements Generator<T>{
   
	private Class<T> type;
	
	public BasicGenerator(Class<T> type){
		this.type = type;
	}
	
	public T next() {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public static <T> Generator<T> create(Class<T> type){
		return new BasicGenerator(type);
	}
}

/**
 * 一个具有默认构造器的简单类 
 */
class CountedObject{
	private static long counter = 0;
	private final long id = counter++;
	public long id(){
		return id;
	}
	public String toString(){
		return "CountedObject" + id;
	}
}