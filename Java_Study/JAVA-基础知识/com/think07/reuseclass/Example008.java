package com.think07.reuseclass;

import java.util.Random;

import org.junit.Test;

/**
 * 7.8 final关键字 
 * 
 * 在这里谈论了final可能使用到的三种情况：数据、方法和类。
 */
public class Example008 {

	@Test
	public void testFinalData(){
		FinalData fd1 = new FinalData("fd1");
		//错误：不能改变
		//fd1.VALUE_THREE++;
		
		fd1.v2.i++;
		fd1.v1 = new Value(0);
		fd1.VAL_3.i++;
		//错误，不能改变引用
		//fd1.VAL_3 = new Value(0);
		
		for(int i = 0; i<fd1.a.length; i++){
			fd1.a[i]++;   //数组的值可以被改变
		}
		
		System.out.println(fd1);
	}
	
	@Test
	public void testBlankFinal(){
		new BlankFinal();
	}
	
	@Test
	public void testFinalArguments(){
		FinalArguments bf = new FinalArguments();
		bf.with(null);
		bf.without(null);
	}
	
	@Test
	public void testWithFinal(){
		OverrideingPrivate2 op2 = new OverrideingPrivate2();
		op2.f();
		op2.g();
		
		OverrideingPrivate op = op2;
		
		//op.f();  //不能够调用这个方法，因为他是final
		//op.g();
		
		WithFinal wf = op2;
		
		//wf.f();
		//wf.g();
	}
	
}

/**
 * 1）、final数据 ：表示永不改变的编译时常量
 * 
 *    对于基础类型，final使数值恒定不变；
 *    对于对象引用，final使引用恒定不变；
 */
class Value{
   int i;
   public Value(int i){this.i = i;}
}

class FinalData{
	private static Random rand = new Random(47);
	private String id;
	
	public FinalData(String id){this.id=id;}
	
    final int valueOne = 9;
    static final int VALUE_TWO = 99;
	public static final int VALUE_THREE = 39;    //可以被用作包之外
	
	/**
	 * i4、INT_5说明：
	 *  
	 *    不能因为某个数据是final的就认为在编译时可以知道它的值，在运行时使用随机数初始化
	 *  i4、INT_5，就说明了这个问题
	 */
    final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);
	
    Value v1 = new Value(11);
    final Value v2 = new Value(22);
    static final Value VAL_3 = new Value(33);
	
    final int[] a = {1, 2, 3, 4, 5, 6};
	
	public String toString(){
		return id + ": " + " i4 = "+ i4 + ", INT_5 =  " + INT_5;
	}
	
}

/**
 * 2）、空白final
 *    java 允许生成 "空白final"， 但是要确保 "空白final" 在使用之前必须初始化
 */
class Poppet{
	private int i;
	Poppet(int i){ this.i = i;}
}

class BlankFinal{
	final int i = 0;
	final int j;   //空白final
	final Poppet p;  //空白final指引
	
	public BlankFinal(){
		j = i;
		p = new Poppet(1);
	}
}

/**
 * 3）、final参数
 *    
 *    java允许在参数列表中以声明的方式将参数指明为final,这意味着你无法在方法中
 * 更改 参数引用所指向的对象。
 */
class Gizmo{
	public void spin(){
		System.out.println("Gizmo spain");
	}
}

class FinalArguments{
	void with(final Gizmo g){
		//g = new Gizmo();   //非法的，参数 g 是 final 修饰的
	}
	
	void without(Gizmo g){
		g = new Gizmo();
		g.spin();
	}
	
	int g(final int i){
		//i++;      //非法的，不能改变i的值
		return i + 1;
	}
}

/**
 * 4）、final方法
 * 
 *    为什么要使用final方法
 *    1）、把方法锁定，防止任何继承类修改它的定义
 *    
 *    类中所有的private方法都隐式的指定为final的。由于无法取用private的方法，所以也就无法覆盖它。
 */
class WithFinal{
	private final void f(){
		System.out.println("WithFinal.f()...");
	}
	private void g(){
		System.out.println("WithFinal.g()...");
	}
}

class OverrideingPrivate extends WithFinal{
	/**
	 * 此类并没有覆盖父类的f()， 只不过是名字凑巧相同而已。 
	 */
	private final void f(){
		System.out.println("OverrideingPrivate.f()...");
	}
	private void g(){
		System.out.println("OverrideingPrivate.g()...");
	}
}

class OverrideingPrivate2 extends OverrideingPrivate{
	public final void f(){
		System.out.println("OverrideingPrivate2.f()...");
	}
	public void g(){
		System.out.println("OverrideingPrivate2.g()...");
	}
}

/**
 * 5）、final类
 * 
 *    不打算继承一个类的时候，可以使用final来修饰
 *    
 */
class SmallBrain{}

final class Dinosaur{
	int i = 7,
	    j = i;
	SmallBrain x = new SmallBrain();
	void f(){}
}

//不能这样写，因为Dinosaur使用final来修饰
// class Further extends Dinosaur{}
