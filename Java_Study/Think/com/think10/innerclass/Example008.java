package com.think10.innerclass;

/**
 * 10.8 Ϊʲô��Ҫ�ڲ��ࡣ
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
 * 10.8.1 ʵ�ֶ�̳�,���Բο�Example002.java�е�����
 */
interface A{}

interface B{}

//ʹ�õ�һ��
class X implements A, B{}

//ʹ���ڲ���
class Y implements A{
	private B makeB(){
		return new B(){};
	}
}

class MultiInterfaces{
	 static void takesA(A a){}
	 static void takesB(B b){}
	 
}

