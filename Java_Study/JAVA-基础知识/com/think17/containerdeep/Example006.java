package com.think17.containerdeep;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 17.6 Set和存储顺序 
 * 
 *  Set
 *    接口： Set接口不维护元素的顺序
 *    
 *  HashSet
 *    为了快速查找而设计的Set。存入HashSet的元素必须定义hashCode();
 *    
 *  TreeSet
 *    保持次序的Set, 底层是树结构。 使用它可以从SET中提取有序的序列。元素必须实现
 *  Comparable接口。
 *  
 *  LinkedHashSet 
 *    具有HashSet的查询速度，且内部使用链表维护元素的顺序（插入的次序）。在使用迭代器遍历
 *  Set的时候。结果会按照元素插入的次序来显示。元素也必须定义hashCode()方法。
 *  
 */

/**
 * 
 * 如果没有其它方面的限制，我们应该首先使用HashSet，因为它在速度方面进行了优化
 * 
 */
public class Example006 {
	
	static <T> void test(Set<T> set, Class<T> type){
		TypesForSets.fill(set, type);
		TypesForSets.fill(set, type);  //重复插入
		TypesForSets.fill(set, type);  
		System.out.println(set);
	}
   
	@Test
	public void testSet(){
		test(new HashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);
		
		test(new HashSet<SetType>(), SetType.class); //三次都能插入
		test(new HashSet<TreeType>(), TreeType.class); 
		
		test(new LinkedHashSet<SetType>(), SetType.class); //三次都能插入
		test(new LinkedHashSet<TreeType>(), TreeType.class); 
		
		try{
			test(new TreeSet<SetType>(), SetType.class); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			test(new TreeSet<HashType>(), HashType.class); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

class SetType{
	int i;
	public SetType(int n){ i=n; }
	public boolean equals(Object o){
		return o instanceof SetType && (i == ((SetType)o).i);
	}
	public String toString(){
		return Integer.toString(i);
	}
}

class HashType extends SetType{

	public HashType(int n) {
		super(n);
	}
	
	public int hashCode(){return i;}
}

class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int n) {
		super(n);
	}

	public int compareTo(TreeType arg) {
		return (arg.i < i ? -1 : (arg.i == i ? 0 : 1 ));
	}
	
}

class TypesForSets{
	static <T> Set<T> fill(Set<T> set, Class<T> type){
		try{
			for(int i=0; i<10; i++){
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		}catch(Exception e){
			throw new RuntimeException();
		}
		return set;
	}
}

