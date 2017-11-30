package com.think15.generics;

import java.util.Iterator;
import java.util.Random;

/**
 * 15.3：泛型接口。例如生成器(Generator)
 */
public class Example003 {
   public static void main(String args[]){
	   CoffeeGenerator gen = new CoffeeGenerator();
	   for(int i=0; i<5; i++){
		   System.out.println(gen.next());
	   }
	   for(Coffee c : new CoffeeGenerator(5) ){
		   System.out.println(c);
	   }
   }
}

interface Generator<T>{
	T next();
}

class Coffee{
	private static long counter = 0;
	private final long id = counter++;
	public String toString(){
		return getClass().getSimpleName() + " " + id;
	}
}

class Latte extends Coffee{}

class Mocha extends Coffee{}

class Cappuccino extends Coffee{}

class Americano extends Coffee{}

class Breve extends Coffee{}

/**
 * 编写一个类，随机生成不同的Coffee对象 
 */
class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
	
	private Class[] types = {
			                 Latte.class,
			                 Mocha.class,
			                 Cappuccino.class,
			                 Americano.class,
			                 Breve.class,
	                         };
    private static Random rand = new Random(47);
    
    public CoffeeGenerator(){
    }
    
    private int size = 0;
    
    public CoffeeGenerator(int size){
    	this.size = size;
    }
    
    class CoffeeIterator implements Iterator<Coffee>{
      int count = size;
	  public Coffee next() {
		 count--;
		 return CoffeeGenerator.this.next();
	  }
	  public void remove() { //Not implements
		  throw new UnsupportedOperationException();
	  }
	  public boolean hasNext() {
		return count>0;
	  }
    }
    
    public Iterator<Coffee> iterator(){
    	return new CoffeeIterator();
    }
    
	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
		  throw new RuntimeException(e);
		} 
	}
	
}
