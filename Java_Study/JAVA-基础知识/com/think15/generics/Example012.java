package com.think15.generics;

import org.junit.Test;

/**
 * 15.12 自限定类型 
 */
public class Example012 {
  
  @Test
  public void testSubType(){
	  SubType st1 = new SubType(), st2 = new SubType();
	  st1.set(st2);
	  SubType st3 = st1.get();
	  st1.f();
  }
  
  @Test
  public void testBasicOther(){
	  BasicOther b = new BasicOther(),
			    b2 = new BasicOther();
	  b.set(new Other());
	  Other other = b.get();
	  b.f();
  }
  
  @Test
  public void testSelfBounded(){
	  A a = new A();
	  a.set(new A());
	  a = a.set(new A()).get();
	  C c = new C();
	  c = c.setAndGet(new C());
  }
  
}

/**
 * BasicHolder相当于所有导出类的一个模板
 */
class BasicHolder<T>{
	T element;
	void set(T arg){element = arg;}
	T get(){return element;}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}

/**
 * 1）、为了理解自限定，我们先来看这个 古怪的循环泛型。
 *     在BasicHolder中使用的element其实就是SubType本身。
 */
class SubType extends BasicHolder<SubType>{}


/**
 * 2)、 BasicHolder可以使用任何类型作为其泛型参数，就像下面看到的那样：
 * 
 */
class Other{}

class BasicOther extends BasicHolder<Other>{}


/**
 *3）、上面的例子无法做到自限定， 要做到自限定，必须采取一些步骤
 *   3.1）、自限定的意义
 *        可以保证类型参数必须与正在被定义的类相同。
 *        
 *        遗憾的是F是可以编译的；因此说明自限定并不是可以强制执行的。
 *        
 *   3.2)、自限定只能强制用作继承关系
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

class A extends SelfBounded<A>{}  //因为A是SelfBounded<T>的子类，所以A可以作为T
class B extends SelfBounded<A>{} //also ok

class C extends SelfBounded<C>{
	C setAndGet(C arg){
		set(arg);
		return get();
	}
}

class D{}

//class E extends SelfBounded<D>{} //因为D不是SelfBounded<T>的子类

class F extends SelfBounded{}
