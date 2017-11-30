package com.think15.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * 15.11 使用Java 泛型的时候可能会出现的各类问题 
 * 
 *   1. 任何基本类型都不能作为类型参数。
 *   2. 一个类不能实现同一个泛型接口的两种变体。（因为擦除的原因）
 */
public class Example011 {
	public static final int SIZE = 10;
    public static void main(String args[]){
    	FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
    	for(String s : "A B C D E F G H I J".split(" ")){
    		strings.push(s);
    	}
    	
    	for(int i=0; i<SIZE; i++){
			String s = strings.pop();
			System.out.print(s + " ");
		}
    }
}

class FixedSizeStack<T>{
	private int index = 0;
	private Object[] storage;
	
	public FixedSizeStack(int size){
		storage = new Object[size];
	}
	
	public void push(T item){
		storage[index++] = item;
	}
	
	public T pop(){
		return (T)storage[--index];
    }
	
}

class NeedCasting{
	public void f(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		List<Weight> shapes = (List<Weight>) in.readObject();
	}
	
}

class ClassCasting{
	public void f(String[] args) throws Exception{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
		List<Weight> lw2 = List.class.cast(in.readObject());
	}
	
}