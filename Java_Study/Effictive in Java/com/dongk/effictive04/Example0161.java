package com.dongk.effictive04;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 第16条： 复合优先于继承 
 * 
 *     只有当子类真正是超类的子类型时。才适合用继承。换句话说，两个类只有确实存在继承关系时
 *     
 *     复合/转发设计
 *     
 *     
 *     
 */
public class Example0161 {
   public static void main(String args[]){
	   InstrumentedSet<String> s2 = new InstrumentedSet<String>(new HashSet<String>());
	   s2.addAll(Arrays.asList("Struts2.3","Spring3.0","Hibernate3.1"));
	   System.out.println(s2.getAddCount());
   }
}

class InstrumentedSet<E> extends ForwardingSet<E>{
    private int addCount = 0;
	
	public InstrumentedSet(Set s) {
		super(s);
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

class ForwardingSet<E> implements Set<E>{
	
	private final Set<E> s;
	
	public ForwardingSet(Set<E> s){this.s = s;}

	public int size() {return s.size();}
	public boolean isEmpty() {return s.isEmpty();}
	public boolean contains(Object o) {return s.contains(o);}
	public Iterator<E> iterator() {	return s.iterator();}
	public Object[] toArray() {return s.toArray();}
	public <T> T[] toArray(T[] a) {return s.toArray(a);}
	public boolean add(E e) {return s.add(e);}
	public boolean remove(Object o) {return s.remove(o);}
	public boolean containsAll(Collection<?> c) {return s.containsAll(c);}
	public boolean addAll(Collection<? extends E> c) {return s.addAll(c);}
	public boolean retainAll(Collection<?> c) {return s.retainAll(c);}
	public boolean removeAll(Collection<?> c) {return s.removeAll(c);}
	public void clear() {s.clear();}
	
}