package com.think15.generics;
/**
 *15.2 简单的泛型 
 */
public class Example002 {
   public static void main(String args[]){
	   Holder2 h20 = new Holder2("aa");
	   Holder2 h21 = new Holder2(1);
	   
	   Holder3 h30 = new Holder3<String>("aa");
	   Holder3 h31 = new Holder3<Integer>(123);
   }
}

/**
 *在Java SE5之前，为了让类支持多种类型，我们可以让这个类直接持有Object对象。
 *如下： 
 *
 */
class Holder2{
	private Object a;
	public Holder2(Object a){this.a = a;}
	public void set(Object a){this.a = a;}
}

/**
 *但是通常情况 ，我们只会使用容器持有一种类型的对象。我们更多希望的是：
 *暂时不指定类型，而是稍后再决定具体使用什么类型。泛型可以达到这个目的。
 */

class Holder3<T>{
	private T a;
	public Holder3(T a){this.a = a;}
	public void set(T a){this.a = a;}
	public T get(){return a;}
}
