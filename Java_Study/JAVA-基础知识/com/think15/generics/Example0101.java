package com.think15.generics;

import java.util.Arrays;
import java.util.List;

/**
 * 15.10.1 ±àÒëÆ÷ÓÐ¶à´ÏÃ÷ 
 */
public class Example0101 {
     public static void main(String args[]){
    	 List<? extends Fruit> flist = Arrays.asList(new Apple());
    	 Apple a = (Apple) flist.get(0);
    	 flist.contains(new Apple());
    	 flist.indexOf(new Apple());
    	 
    	 //============================================
    	 Holder<Apple> apple = new Holder<Apple>(new Apple());
    	 Apple d = apple.get();
    	 apple.set(d);
    	 
    	 Holder<? extends Fruit> fruit = apple;
    	 Fruit p = fruit.get();
    	 d = (Apple) fruit.get();
    	 try{
    		 Orange c = (Orange) fruit.get();
    	 }catch(Exception e){
    		 System.out.println(e);
    	 }
    	 //fruit.set(new Apple());
    	 System.out.println(fruit.equals(d));
     }
}


class Holder<T>{
	private T value;
	public Holder(){}
	public Holder(T value){this.value = value;}
	public void set(T value){this.value = value;}
	public T get(){return value;}
	public boolean equals(Object obj){
		return value.equals(obj);
	}
}