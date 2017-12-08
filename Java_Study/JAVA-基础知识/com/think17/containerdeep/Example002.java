package com.think17.containerdeep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.think.pub.Generator;

/**
 * 17.2 填充容器 
 * 
 *    1.Collections有一些实用的static方法，可以使用它们来填充容器；
 */
public class Example002 {
    
	/**
	 * 从输出我们可以清楚的观察到，无论 nCopies 或者 fill，它们的位置都指向相同的位置 
	 */
	@Test
	public void testFillingLists(){
		List<StringAddress> list = new ArrayList<StringAddress>(
				   // nCopies(n,T)返回由指定对象的 n 个副本组成的不可变列表
				   Collections.nCopies(4, new StringAddress("Hello"))
				);
		System.out.println(list);
		
		//使用指定元素替换指定列表中的所有元素。
		Collections.fill(list, new StringAddress("World!"));
		System.out.println(list);
	}
	
}


class StringAddress{
	private String s;
	public StringAddress(String s){this.s = s;}
	public String toString(){
		return super.toString() + ":" +  s + "\n";
	}
}


class CollectionData<T> extends ArrayList<T>{
	public CollectionData(Generator<T> gen , int quantity){
		for(int i=0; i<quantity; i++){
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen , int quantity){
		return new CollectionData<T>(gen, quantity);
	}
}
