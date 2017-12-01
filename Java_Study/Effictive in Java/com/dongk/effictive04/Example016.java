package com.dongk.effictive04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * ��16���� ���������ڼ̳� 
 *     
 *     1.��Խ���߽�ļ̳��Ƿǳ�Σ�յ���Ϊ��
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
 * ʵ��һ�����ܣ�
 *    HashSet�Ӵ��������ܹ�����˶��ٸ�Ԫ�ء�(ɾ����ҲҪ��������)
 *    HashSet�����������Ԫ�صķ���add()��addAll(). 
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
