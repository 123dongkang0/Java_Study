package com.think15.generics;

/**
 * 15.12 自限定类型 
 */
public class Example012 {
  public static void main(String args[]){
	  SubType st1 = new SubType(), st2 = new SubType();
	  st1.set(st2);
	  SubType st3 = st1.get();
	  st1.f();
	  
	  //========================================
	  A a = new A();
	  a.set(new A());
	  a = a.set(new A()).get();
	  C c = new C();
	  c = c.setAndGet(new C());
  }
}

class BasicHolder<T>{
	T element;
	void set(T arg){element = arg;}
	T get(){return element;}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}

class SubType extends BasicHolder<SubType>{}

/**
 *上面的例子无法做到自限定， 要做到自限定，必须采取一些步骤
 */
class SelfBounded<T extends SelfBounded<T>>{
	T element;
	SelfBounded<T> set(T arg){
		element = arg;
		return this;
	}
	T get(){
		return element;
	}
}

class A extends SelfBounded<A>{}
class B extends SelfBounded<A>{} //also ok

class C extends SelfBounded<C>{
	C setAndGet(C arg){
		set(arg);
		return get();
	}
}

class D{}

//class E extends SelfBounded<D>{}

class F extends SelfBounded{}
