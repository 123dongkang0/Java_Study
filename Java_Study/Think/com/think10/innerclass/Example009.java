package com.think10.innerclass;

/**
 * 10.9 �ڲ���ļ̳� 
 *   ��Ϊ�ڲ���Ĺ������������ӵ�ָ������Χ������ã�
 *  ���Լ̳��ڲ����ʱ�򣬱���ʹ��������﷨����ȷ˵������
 *  ֮��Ĺ�ϵ
 */
public class Example009 {
   public static void main(String args[]){
	   WithInner wi = new WithInner();
	   InheritInner ii = new InheritInner(wi);
   }
}

class WithInner{
	class Inner{}
}

class InheritInner extends WithInner.Inner{
	//!InheritInner(){} //won't compile
	InheritInner(WithInner wi){
		wi.super();
	}
}
