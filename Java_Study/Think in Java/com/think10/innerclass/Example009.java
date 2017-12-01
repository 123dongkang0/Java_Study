package com.think10.innerclass;

/**
 * 10.9 内部类的继承 
 *   因为内部类的构造器必须连接到指向其外围类的引用，
 *  所以继承内部类的时候，必须使用特殊的语法来明确说清它们
 *  之间的关系
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
