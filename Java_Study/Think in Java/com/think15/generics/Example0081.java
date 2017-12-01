package com.think15.generics;

/**
 * 15.8.1 创建类型实例 
 */
public class Example0081 {
   public static void main(String args[]){
	   ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
	   System.out.println("ClassAsFactory<Employee> Successed");
	   
	   try{
		   /**
		    * 创建失败，是因为Integer没有默认的构造方法。
		    */
		   ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
		   System.out.println("ClassAsFactory<Integer> Successed");
	   }catch(Exception e){
		   System.out.println("ClassAsFactory<Integer> failed");
	   }
	   
	   
	   new Foo2<Integer>(new IntergerFactory());
	   new Foo2<Widget>(new Widget.Factory());
   }
}


/**
 * java的解决办法是传递一个工厂对象 ，用它来创建新的class对象。
 */

class ClassAsFactory<T>{
	T x;
	public ClassAsFactory(Class<T> kind){
		try{
			x = kind.newInstance();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
}

class Employee{}


/**
 *显式的工厂 
 */
interface FactoryI<T>{
	T create();
}

class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory){
		x = factory.create();
	}
}

class IntergerFactory implements FactoryI<Integer>{
	public Integer create() {
		return new Integer(0);
	}
}

class Widget{
	public static class Factory implements FactoryI<Widget>{
		public Widget create() {
			return new Widget();
		}
	}
}

/**
 * 还有一种方式模板方法设计模式。 
 */
abstract class GenericWithCreate<T>{
	final T	element;
	GenericWithCreate(){
		element = create();
	}
	abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{
	X create() {
		return new X();
	}
	void f(){
		System.out.println(element.getClass().getSimpleName());
	}
}


