package com.think10.innerclass;

import org.junit.Test;

/**
 * 10.8 Ϊʲô��Ҫ�ڲ��ࡣ
 *  
 */
public class Example008 {
   
   @Test
   public void testMultiInterfaces(){
	   X x = new X();
	   Y y = new Y();
	   
	   MultiInterfaces.takesA(x);
	   MultiInterfaces.takesB(x);
	   
	   MultiInterfaces.takesA(y);
	   MultiInterfaces.takesB(y.makeB());
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
	 B makeB(){
		return new B(){};
	}
}

class MultiInterfaces{
	 static void takesA(A a){}
	 static void takesB(B b){}
	 
}

