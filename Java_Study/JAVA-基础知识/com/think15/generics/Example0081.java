package com.think15.generics;

/**
 * 15.8.1 ��������ʵ�� 
 */
public class Example0081 {
   public static void main(String args[]){
	   ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
	   System.out.println("ClassAsFactory<Employee> Successed");
	   
	   try{
		   /**
		    * ����ʧ�ܣ�����ΪIntegerû��Ĭ�ϵĹ��췽����
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
 * java�Ľ���취�Ǵ���һ���������� �������������µ�class����
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
 *��ʽ�Ĺ��� 
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
 * ����һ�ַ�ʽģ�巽�����ģʽ�� 
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


