package com.dongk.struts2.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
      public static void main(String args[]){
    	  ArrayStack<String> strArray = new ArrayStack<String>();
    	  strArray.push("java Hello World");
    	  strArray.push("C++ Hello World");
    	  for(String str : strArray){
    		  System.out.println(str);
    	  }
      }
}

class ArrayStack<T> implements Iterable<T>{
	private T[] a = (T[])new Object[100];
	private int n = 0;
	
	public void push(T item){
		a[n++] = item;
	}
	
	public T pop(){
		return a[n--];
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}
	
	private class ArrayIterator implements Iterator<T>{
		private int i=0;
		@Override
		public boolean hasNext() {
			return i < n;
		}
		@Override
		public T next() {
			return a[i++];
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
}