package com.think15.generics;
/**
 *15.2 �򵥵ķ��� 
 */
public class Example002 {
   public static void main(String args[]){
	   Holder2 h20 = new Holder2("aa");
	   Holder2 h21 = new Holder2(1);
	   
	   Holder3 h30 = new Holder3<String>("aa");
	   Holder3 h31 = new Holder3<Integer>(123);
   }
}

/**
 *��Java SE5֮ǰ��Ϊ������֧�ֶ������ͣ����ǿ����������ֱ�ӳ���Object����
 *���£� 
 *
 */
class Holder2{
	private Object a;
	public Holder2(Object a){this.a = a;}
	public void set(Object a){this.a = a;}
}

/**
 *����ͨ����� ������ֻ��ʹ����������һ�����͵Ķ������Ǹ���ϣ�����ǣ�
 *��ʱ��ָ�����ͣ������Ժ��پ�������ʹ��ʲô���͡����Ϳ��Դﵽ���Ŀ�ġ�
 */

class Holder3<T>{
	private T a;
	public Holder3(T a){this.a = a;}
	public void set(T a){this.a = a;}
	public T get(){return a;}
}
