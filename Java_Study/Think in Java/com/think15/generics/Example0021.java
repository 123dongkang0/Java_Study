package com.think15.generics;

/**
 *15.2.1 一个元组类库 
 *  元组:将一组对象直接打包存储于其中的一个单一对象，这个容器允许读取其中的元素，
 *  但是不愿徐向其中存放新的对象(这个概念也称为数据传送对象或信使)。
 */
public class Example0021 {
  public static void main(String args[]){
	  
  }
}

/**
 * 下面创建一个2维元组
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
 *我们可以通过集成机制来实现长度更加长的元组。 
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