package com.think15.generics;

import java.lang.reflect.Array;

/**
 * 15.8.2 泛型数组 
 */
public class Example0082 {
   static final int SIZE = 100;
   static Generic<Integer>[] gia;
   public static void main(String args[]){
	   // gia = new Object[SIZE]; //不能编译
	   gia = (Generic<Integer>[])new Generic[SIZE];   //创建擦除类型的新数组，然后对其进行转型
	   System.out.println(gia.getClass().getSimpleName());
	   gia[0] = new Generic<Integer>();
	   
	   GenericArray<Integer> gai = new GenericArray<Integer>(10);
	   //Integer[] ia = gai.rep();   //可编译，运行时错误
	   Object[] oa = gai.rep();
	   
	   GenericArray2<Integer> gai2 = new GenericArray2<Integer>(10);
	   for(int i=0; i<10; i++){
		   gai2.put(i, i);
	   }
	   for(int i=0; i<10; i++){
		  System.out.print(gai2.get(i) + "  ");
	   }
	   System.out.println();
	   
	  //Integer[] ia = gai.rep(); //可编译，运行时错误
	   
	   GenericArrayWithTypeTokem<Integer> gaiType = new GenericArrayWithTypeTokem<Integer>(Integer.class, 10);
	   Integer[] ia = gaiType.rep();
   }
}

class Generic<T>{}

/**
 * 简单的泛型包装器 
 */
class GenericArray<T>{
	private T[] array;
	
	public GenericArray(int sz){
		array = (T[]) new Object[sz];
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){
		return array;
	}
}

/**
 * 最好在集合内部使用Object[],然后但你使用数组元素时，添加一个对于T的转型
 */
class GenericArray2<T>{
	private Object[] array;
    
	public GenericArray2(int sz){
		array = new Object[sz];
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return (T) array[index];
	}
	
	public T[] rep(){
		return (T[]) array;
	}
}

/**
 * 传递一个类型标记 :
 *   Class<T> : 类型标记，以便从擦除中恢复。
 */
class GenericArrayWithTypeTokem<T>{
	private T[] array;
	
	public GenericArrayWithTypeTokem(Class<T> type, int sz){
		array = (T[]) Array.newInstance(type, sz);
	}
	
	public void put(int index, T item){
		array[index] = item;
	}
	
	public T get(int index){
		return array[index];
	}
	
	public T[] rep(){return array;}
}


