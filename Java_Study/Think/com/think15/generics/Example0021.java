package com.think15.generics;

/**
 *15.2.1 һ��Ԫ����� 
 *  Ԫ��:��һ�����ֱ�Ӵ���洢�����е�һ����һ����������������ȡ���е�Ԫ�أ�
 *  ���ǲ�Ը�������д���µĶ���(�������Ҳ��Ϊ���ݴ��Ͷ������ʹ)��
 */
public class Example0021 {
  public static void main(String args[]){
	  
  }
}

/**
 * ���洴��һ��2άԪ��
 */
class TwoTuple<A,B>{
	public final A first;
	public final B second;
	public TwoTuple(A a, B b){
		first  = a;
		second = b;
	}
	public String toString(){
		return "(" + first + "," + second + ")";
	}
}

/**
 *���ǿ���ͨ�����ɻ�����ʵ�ֳ��ȸ��ӳ���Ԫ�顣 
 */
class ThreeTuple<A,B,C> extends TwoTuple<A,B>{
	public final C third;
	public ThreeTuple(A a,B b,C c){
		super(a, b);
		third = c;
	}
	public String toString(){
		return "(" + first + "," + second + "," + third +  ")";
	}
}


class ThreeTupleTest{
	static ThreeTuple<String,Long,Integer> f(){
		return new ThreeTuple<String,Long,Integer>("aa", 32L, 15);
	}
}