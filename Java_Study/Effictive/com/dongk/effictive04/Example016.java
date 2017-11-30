package com.dongk.effictive04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 第16条： 复合优先于继承 
 *     
 *     1.跨越包边界的继承是非常危险的行为。
 *     
 *     
 */
public class Example016 {
  public static void main(String args[]){
	  InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
	  s.addAll(Arrays.asList("Snap","Crackle","pop"));
	  System.out.println(s.getAddCount());
  }
}

/**
 * 实现一个功能：
 *    HashSet从创建至今，总共添加了多少个元素。(删除的也要计算在内)
 *    HashSet中有两个添加元素的方法add()、addAll(). 
 */
class InstrumentedHashSet<E> extends HashSet<E>{
   
	private int addCount = 0;
	
	public InstrumentedHashSet(){}
	
	public InstrumentedHashSet(int initCap, float loadFactor){
		super(initCap,loadFactor);
	}
	
	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount(){
		return addCount;
	}
	
}
