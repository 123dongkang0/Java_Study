package com.think10.innerclass;

/**
 * 10.8 为什么需要内部类。
 *  
 */
public class Example008 {
   public static void main(String args[]){
	   X x = new X();
	   Y y = new Y();
	   
	   MultiInterfaces.takesA(x);
	   MultiInterfaces.takesA(x);
	   
	   MultiInterfaces.takesA(y);
	   MultiInterfaces.takesA(y);
   }
}

/**
 * 10.8.1 实现多继承,可以参考Example002.java中的例子
 */
interface A{}

interface B{}

//使用单一类
class X implements A, B{}

//使用内部类
class Y implements A{
	private B makeB(){
		return new B(){};
	}
}

class MultiInterfaces{
	 static void takesA(A a){}
	 static void takesB(B b){}
	 
}

