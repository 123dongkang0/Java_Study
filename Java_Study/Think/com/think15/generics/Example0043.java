package com.think15.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 *15.4.3 ����Generator�ķ��ͷ��� 
 *   ���������������ǿ��Ժܷ�������һ��Collection,�����ͻ����ֲ����Ǿ���ʵ������ģ�
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

