package com.think15.generics;

/**
 * 15.10.4 ²¹²¶»ñ×ª»» 
 */
public class Example0104 {
   public static void main(String args[]){
	   Holder raw = new Holder<Integer>(1);
	   CaptureConversion.f1(raw);
	   CaptureConversion.f2(raw);
	   
	   Holder rqwBasic = new Holder();
	   rqwBasic.set(new Object());
	   CaptureConversion.f1(rqwBasic);
	   CaptureConversion.f2(rqwBasic);
	   
	   Holder<?> wildCarded = new Holder<Double>(1.0);
	   CaptureConversion.f1(wildCarded);
	   CaptureConversion.f2(wildCarded);
   }
}

class CaptureConversion{
	static <T> void f1(Holder<T> holder){
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	
	static void f2(Holder<?> holder){
		f1(holder);
	}
}


