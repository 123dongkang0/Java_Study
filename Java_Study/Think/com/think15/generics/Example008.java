package com.think15.generics;
/**
 * 15.8 擦除的补偿
 */
public class Example008 {
  public static void main(String args[]){
	  ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
	  System.out.println(ctt1.f(new Building()));
	  System.out.println(ctt1.f(new House()));
	  
	  ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
	  System.out.println(ctt2.f(new Building()));
	  System.out.println(ctt2.f(new House()));
  }
}

class Erased<T>{
	private final int SIZE = 100;
	public static void f(Object arg){
		/*
		if(arg instanceof T){}     //Error
		T var = new T();           //Error
		T[] array = new T[SIZE];    //Error
		*/
	}
}

/**
 * 可以通过引入类型标签对擦除进行补偿 
 *  类型标签： Class<T> kind;
 */
class Building{}

class House extends Building{}

class ClassTypeCapture<T>{
	Class<T> kind;
	public ClassTypeCapture(Class<T> kind){
		this.kind = kind;
	}
	public boolean f(Object arg){
		return kind.isInstance(arg);
	}
}
