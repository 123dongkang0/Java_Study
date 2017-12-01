package com.think15.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.internal.ExactComparisonCriteria;

/**
 * 15.10.3 无界通配符 
 * 
 */
public class Example0103 {
  public static void main(String args[]){
	  UnboundedWildCards1.assign1(new ArrayList());
	  UnboundedWildCards1.assign2(new ArrayList());
	  UnboundedWildCards1.assign3(new ArrayList());
	  
	  UnboundedWildCards1.assign1(new ArrayList<String>());
	  UnboundedWildCards1.assign2(new ArrayList<String>());
	  UnboundedWildCards1.assign3(new ArrayList<String>());
	  
	  List<?> wildList = new ArrayList();
	  wildList = new ArrayList<String>();
	  
	  UnboundedWildCards1.assign1(wildList);
	  UnboundedWildCards1.assign2(wildList);
	  UnboundedWildCards1.assign3(wildList);
	  
	  
	  //===========================================================
	  UnboundedWildCards2.assign1(new HashMap());
	  UnboundedWildCards2.assign2(new HashMap());
	  UnboundedWildCards2.assign3(new HashMap());
	  
	  UnboundedWildCards2.assign1(new HashMap<String, Integer>());
	  UnboundedWildCards2.assign2(new HashMap<String, Integer>());
	  UnboundedWildCards2.assign3(new HashMap<String, Integer>());
	  
	  //===============================================================
	  Holder raw = new Holder<Long>();
	  raw = new Holder();
	  
	  Holder<Long> qualified = new Holder<Long>();
	  Holder<?>  unbounded = new Holder<Long>();
	  Holder<? extends Long> bounded = new Holder<Long>();
	  Long lng = 1L;
	  
	  WildCards.rawArgs(raw, lng);
	  WildCards.rawArgs(qualified, lng);
	  WildCards.rawArgs(unbounded, lng);
	  WildCards.rawArgs(bounded, lng);
	  
	  WildCards.unboundedArg(raw, lng);
	  WildCards.unboundedArg(qualified, lng);
	  WildCards.unboundedArg(unbounded, lng);
	  WildCards.unboundedArg(bounded, lng);
	  
	  Object r1 = WildCards.exact1(raw);
	  Long r2 = WildCards.exact1(qualified);
	  Object r3 = WildCards.exact1(unbounded);
	  Long r4 = WildCards.exact1(bounded);
	  
	  Long r5 = WildCards.exact2(raw,lng);
	  Long r6 = WildCards.exact2(qualified,lng);
	  //Long r7 = WildCards.exact2(unbounded,lng); //必须提供确切的参数
	  //Long r8 = WildCards.exact2(bounded,lng);
	  
	  Long r9 = WildCards.wildSubtype(raw,lng);
	  Long r10 = WildCards.wildSubtype(qualified,lng);
	  //Object r11 = WildCards.wildSubtype(unbounded,lng);
	  Long r12 = WildCards.wildSubtype(bounded,lng);
	  
	  WildCards.wildSupertype(raw,lng);
	  WildCards.wildSupertype(qualified,lng);
	 // WildCards.wildSupertype(unbounded,lng);
	 // WildCards.wildSupertype(bounded,lng);
	  
	  
  }
}

class UnboundedWildCards1{
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;
	
	static void assign1(List list){
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign2(List<?> list){
		list1 = list;
		list2 = list;
		list3 = list;
	}
	
	static void assign3(List<? extends Object> list){
		list1 = list;
		list2 = list;
		list3 = list;
	}
}

class UnboundedWildCards2{
	static Map map1;
	static Map<?,?> map2;
	static Map<String,?> map3;
	static void assign1(Map map){map1 = map;}
	static void assign2(Map<?,?> map){map2 = map;}
	static void assign3(Map<String,?> map){map3 = map;}
	
}

class WildCards{
	/**
	 *使用原生类型，就会放弃编译期的检查。可以将任何对象传递给Set(不安全的) 
	 */
	static void rawArgs(Holder holder, Object arg){
		holder.set(arg);
		Object obj = holder.get();
	}
	
	/**
	 *Holder<?>:将持有某种具体类型的同构集合，因此不能只是向其中传递Object 
	 */
	static void unboundedArg(Holder<?> holder, Object arg){
		//holder.set(arg);
		Object obj = holder.get();
	}
	
	static <T> T exact1(Holder<T> holder){
		T t = holder.get();
		return t;
	}
	
	static <T> T exact2(Holder<T> holder, T arg){
		holder.set(arg);
		T t = holder.get();
		return t;
	}
	
	static <T> T wildSubtype(Holder<? extends T> holder, T arg){
		//holder.set(arg);
		T t = holder.get();
		return t;
	}
	
	static <T> T wildSupertype(Holder<? super T> holder, T arg){
		holder.set(arg);
		//T t = holder.get();
		Object t = holder.get();
		return (T)t;
	}
	
	
}


