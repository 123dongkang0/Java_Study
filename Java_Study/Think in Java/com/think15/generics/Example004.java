package com.think15.generics;
/**
 * 15.4 泛型方法
 *  是否拥有泛型方法和所在的类是否是泛型没有关系 
 */
public class Example004 {
   public static void main(String args[]){
	   GenericMethods gm = new GenericMethods();
	   gm.f("");
	   gm.f(1);
	   gm.f(1.0);
	   gm.f(1.0F);
   }
}


class GenericMethods{
	public <T> void f(T x){
		System.out.println(x.getClass().getName());
	}
}

