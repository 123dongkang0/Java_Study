package com.think10.innerclass;


/**
 *10.6�����ڲ��� 
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
 * ���﷨ָ���� : "����һ���̳���Contents��������Ķ���"��
 *       �����������Ĭ�ϵĹ�����������Contents
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
 *Parcel7 �� ����� Parcel7b �ļ���ʽ��  
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
 * ʹ���в�����������
 * 
 * wrapping ֻ��һ�����о���ʵ�ֵ���ͨ�࣬
 * �������Ǳ��䵼���൱������ "�ӿ�"  ��ʹ�á�
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
 * ����һ�������ڲ��࣬ϣ��ʹ��һ�������ⲿ����Ķ�����ô ��������Ҫ���������������final.
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
  * Parcel9�У�ֻ�Ǽ򵥵ĸ�һ���ֶθ�ֵ�� 
  * ����������ƹ���������Ϊ������β����ˣ�
  * �������в������й���������Ϊ��������û�����֣����ǿ���ͨ��ʵ����ʼ���ﵽ������Ч����
  * 
  */
 abstract class Base{
	 public Base(int i){
		 System.out.println("Base constructor. i = " + i);
	 }
	 public abstract void f();
 }
 
/**
 *�ڴ����� ����Ҫ��i��final����Ϊi�����ݸ���������๹��������������������ֱ�ӱ�ʹ�õġ�
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
 *�����ڲ���ʾ����
 *  �ٷù������� 
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