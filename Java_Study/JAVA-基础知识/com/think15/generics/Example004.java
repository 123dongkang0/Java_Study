package com.think15.generics;
/**
 * 15.4 ���ͷ���
 *  
 *  1.����һ��static�ķ������ԣ��޷����ʷ���������Ͳ��������ԣ����static������Ҫʹ�÷���������
 *    �Ϳ���ʹ���Ϊ���ͷ�����
 *    
 *  2.�Ƿ�ӵ�з��ͷ��������ڵ����Ƿ��Ƿ���û�й�ϵ 
 */
public class Example004 {
   public static void main(String args[]){
	   GenericMethods gm = new GenericMethods();
	   gm.f("");
	   gm.f(1);
	   gm.f(1.0);
	   gm.f(1.0F);
   }
   
}


class GenericMethods{
	public <T> void f(T x){
		System.out.println(x.getClass().getName());
	}
}

