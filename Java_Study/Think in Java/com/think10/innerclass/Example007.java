package com.think10.innerclass;

/**
 *10.7 嵌套类 ：
 *  如果不需要内部类对象与其外围类之间有联系，那么可以将内部类声明为static,这称作嵌套类，
 */
public class Example007 {
   public static void main(String args[]){
	   Contents c = Parcel11.contents();
	   Destination d = Parcel11.destination("Tasmania");
   }
}

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
