package com.think15.generics;

import java.lang.reflect.Array;

/**
 * 15.8.2 �������� 
 */
public class Example0082 {
   static final int SIZE = 100;
   static Generic<Integer>[] gia;
   public static void main(String args[]){
	   // gia = new Object[SIZE]; //���ܱ���
	   gia = (Generic<Integer>[])new Generic[SIZE];   //�����������͵������飬Ȼ��������ת��
	   System.out.println(gia.getClass().getSimpleName());
	   gia[0] = new Generic<Integer>();
	   
	   GenericArray<Integer> gai = new GenericArray<Integer>(10);
	   //Integer[] ia = gai.rep();   //�ɱ��룬����ʱ����
	   Object[] oa = gai.rep();
	   
	   GenericArray2<Integer> gai2 = new GenericArray2<Integer>(10);
	   for(int i=0; i<10; i++){
		   gai2.put(i, i);
	   }
	   for(int i=0; i<10; i++){
		  System.out.print(gai2.get(i) + "  ");
	   }
	   System.out.println();
	   
	  //Integer[] ia = gai.rep(); //�ɱ��룬����ʱ����
	   
	   GenericArrayWithTypeTokem<Integer> gaiType = new GenericArrayWithTypeTokem<Integer>(Integer.class, 10);
	   Integer[] ia = gaiType.rep();
   }
}

class Generic<T>{}

/**
 * �򵥵ķ��Ͱ�װ�� 
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
 * ����ڼ����ڲ�ʹ��Object[],Ȼ����ʹ������Ԫ��ʱ�����һ������T��ת��
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
 * ����һ�����ͱ�� :
 *   Class<T> : ���ͱ�ǣ��Ա�Ӳ����лָ���
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


