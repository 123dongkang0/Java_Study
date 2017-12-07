package com.think10.innerclass;

import org.junit.Test;

import com.think10.innerclass.ClassInInterface.ClassInInterfaceException;

/**
 *10.7 嵌套类 ：
 *  内部类声明为static,这称作嵌套类，
 */
public class Example007 {
	
   @Test
   public void testParcel11(){
	   Contents c = Parcel11.contents();
	   Destination d = Parcel11.destination("Tasmania");
   }
   
   @Test
   public void testImpClassInInterface(){
	   ImpClassInInterface ici = new ImpClassInInterface();
	   try {
			ici.getValue();
	   }catch (ClassInInterfaceException e) {
			e.printStackTrace();
	   }
   }
   
}

/**
 *  如果内部类不需要引用外部类的属性，就将内部类声明为Staitac
 *  
 *  1）、创建嵌套类对象，并不需要外围类对象。
 *  2）、嵌套类不能访问非静态外围类属性。
 */
class Parcel11{
	
	private static class ParcelContents implements Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destination{
		private String label;
		private ParcelDestination(String whereTo){
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
		public static void f(){}
		static int x = 10;
		static class AnotherLevel{
			public static void f(){}
			static int x = 10;
		}
	}
	
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}
	
	public static Contents contents(){
		return new ParcelContents();
	}
}

/**
 * 10.7.1 接口内部类
 *   正常情况下，不能在接口内部放置任何代码，但是嵌套类可以作为接口的一部分。
 *   
 *   1）、接口中的任何类都是public 和 static 的
 */
interface ClassInInterface{
	
	int getValue() throws ClassInInterfaceException;
	
	class ClassInInterfaceException extends java.lang.Exception{
		public ClassInInterfaceException(String msg){
			super(msg);
		}
	}
	
}

class ImpClassInInterface implements ClassInInterface{

	public int getValue() throws ClassInInterfaceException {
		throw  new ClassInInterfaceException("ClassInInterface has exception!!");
	}
	
}

