package com.think15.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 *15.4.3 用于Generator的泛型方法 
 *   利用生成器，我们可以很方便的填充一个Collection,而泛型化这种操作是具有实际意义的：
 */
public class Example0043 {
    public static void main(String args[]){
        Collection<Coffee> coffee = Generators.fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);	
        for(Coffee c : coffee){
        	System.out.print(c + " ");
        }
        
        System.out.println();
        
        Collection<Integer> fnumbers = Generators.fill(new ArrayList<Integer>(), new Fibonacci(), 4);
        for(Integer i : fnumbers){
        	System.out.print(i + " ");
        }
    }
}

class Generators{
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
		for(int i=0; i<n; i++){
			coll.add(gen.next());
		}
		return coll;
	}
	
}

