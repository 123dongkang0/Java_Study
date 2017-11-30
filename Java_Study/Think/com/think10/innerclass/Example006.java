package com.think10.innerclass;


/**
 *10.6匿名内部类 
 */
public class Example006 {
    public static void main(String args[]){
    	Parcel7 p = new Parcel7();
    	Contents c = p.contents();
    	System.out.println("contents : " + c.value());
    	
    	Parcle8 p8 = new Parcle8();
    	Wrapping w = p8.wrapping(10);
    	System.out.println(w.value());
    	
    	AnonymousConstructor.getBase(10);
    	
    	Factories.serviceConsumer(Implmentation1.factory);
    	Factories.serviceConsumer(Implmentation2.factory);
    }
} 

/**
 * 此语法指的是 : "创建一个继承自Contents的匿名类的对象"。
 *       此匿名类采用默认的构造器来生成Contents
 */
class Parcel7 {
	  public Contents contents(){
		  return new Contents() {
				 private int i = 11;
				 public int value() {
					return i;
				 }
				};
	  }
}

/**
 *Parcel7 是 下面的 Parcel7b 的简化形式。  
 */
class Parcel7b{
	class MyContents implements Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	public Contents contents(){
		return new MyContents();
	}
}

class Wrapping{
	private int i;
	public Wrapping(int x){ i = x;}
	public int value(){return i;}
}

/**
 * 使用有参数构造器：
 * 
 * wrapping 只是一个具有具体实现的普通类，
 * 但它还是被其导出类当做公共 "接口"  来使用。
 */
class Parcle8{
	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value() * 47;
		   }
		};
	}
}


/**
 * 定义一个匿名内部类，希望使用一个在其外部定义的对象，那么 编译器会要求其参数的引用是final.
 */
 class Parcel9{
	  public Destination destomation(final String dest){
		  return new Destination(){
		            private String label = dest;
					public String readLabel() {
						return label;
					}
				  };
	  }
 }
 
 /**
  * Parcel9中，只是简单的给一个字段赋值， 
  * 如果想做类似构造器的行为，该如何操作了？
  * 匿名类中不可能有构造器，因为它根本就没有名字；但是可以通过实例初始化达到这样的效果。
  * 
  */
 abstract class Base{
	 public Base(int i){
		 System.out.println("Base constructor. i = " + i);
	 }
	 public abstract void f();
 }
 
/**
 *在此类中 ，不要求i是final，因为i被传递给匿名类基类构造器，不是在匿名类中直接被使用的。
 */
class AnonymousConstructor{
	 public static Base getBase(int i){
		 return new Base(i) {
					 {
						 System.out.println("Inside instance initializer.");
						// i= 3;
					 }
					public void f() {
						 System.out.println("In anonymous f()");
					}
				};
	 }
 }

/**
 *匿名内部类示例：
 *  再访工厂方法 
 */
 interface Service{
	 void method1();
	 void method2();
 }
 
 interface ServiceFactory{
	 Service getService();
 }
 
 class Implmentation1 implements Service{
	 private Implmentation1(){}
	 public void method1() {
		System.out.println("Implmentation1 method1");
	 }
	 public void method2() {
		System.out.println("Implmentation1 method2");
	 }
	 public static ServiceFactory factory = 
		   new ServiceFactory() {
				public Service getService() {
					return new Implmentation1();
				}
			};
 }
 
 class Implmentation2 implements Service{
	 private Implmentation2(){}
	 public void method1() {
		System.out.println("Implmentation2 method1");
	 }
	 public void method2() {
		System.out.println("Implmentation2 method2");
	 }
	 public static ServiceFactory factory = 
		   new ServiceFactory() {
				public Service getService() {
					return new Implmentation2();
				}
			};
 }
 
 class Factories{
	 public static void serviceConsumer(ServiceFactory fact){
		 Service s = fact.getService();
		 s.method1();
		 s.method2();
	 }
 }