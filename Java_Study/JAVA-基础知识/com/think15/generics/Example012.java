package com.think15.generics;

import org.junit.Test;

/**
 * 15.12 ���޶����� 
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
 * BasicHolder�൱�����е������һ��ģ��
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
 * 1����Ϊ��������޶���������������� �Źֵ�ѭ�����͡�
 *     ��BasicHolder��ʹ�õ�element��ʵ����SubType����
 */
class SubType extends BasicHolder<SubType>{}


/**
 * 2)�� BasicHolder����ʹ���κ�������Ϊ�䷺�Ͳ������������濴����������
 * 
 */
class Other{}

class BasicOther extends BasicHolder<Other>{}


/**
 *3��������������޷��������޶��� Ҫ�������޶��������ȡһЩ����
 *   3.1�������޶�������
 *        ���Ա�֤���Ͳ������������ڱ����������ͬ��
 *        
 *        �ź�����F�ǿ��Ա���ģ����˵�����޶������ǿ���ǿ��ִ�еġ�
 *        
 *   3.2)�����޶�ֻ��ǿ�������̳й�ϵ
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

class A extends SelfBounded<A>{}  //��ΪA��SelfBounded<T>�����࣬����A������ΪT
class B extends SelfBounded<A>{} //also ok

class C extends SelfBounded<C>{
	C setAndGet(C arg){
		set(arg);
		return get();
	}
}

class D{}

//class E extends SelfBounded<D>{} //��ΪD����SelfBounded<T>������

class F extends SelfBounded{}
