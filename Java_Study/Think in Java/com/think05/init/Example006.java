package com.think05.init;

import org.junit.Test;

/**
 * 5.6 成员初始化
 *
 *
 */
public class Example006 {
    
	@Test
	public void testInitialValues(){
		new InitialValues().printInitialValues();
	}
}

/**
 * 1)、类的数据成员是基本类型，都会有一个初始值 
 */
class InitialValues{
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	float f;
	double d;
	InitialValues reference;
	
	void printInitialValues(){
		System.out.println("boolean " + t);
		System.out.println("char " + c);
		System.out.println("byte " + b);
		System.out.println("short " + s);
		System.out.println("int " + i);
		System.out.println("long " + l);
		System.out.println("float " + f);
		System.out.println("double " + d);
		System.out.println("InitialValues " + reference);  //null
	}
}

/**
 * 2)、初始化方式1：直接在指定类成员变量的时地方为其赋值
 */
class Depth{}

class InitialValues2{
	boolean t = true;
	char c = 'x';
	byte b = 47;
	short s = 0xff;
	int i = 999;
	long l = 1;
	float f = 3.14f;
	double d = 3.14159;
	Depth depth = new Depth();  //如果没有为depth指定初始值，就尝试使用它，则会发生运行时异常
}

/**
 * 3)、初始化方式2：通过方法来提供初始值
 */
class MethodInit{
	int i = f();   //初始化过程比较复杂的时候可以这样子写
	int f(){return 11;}
}

/**
 * 注意，这里不能写成
 * 
 * class MethodInit2{
 *  int j = g(i);
 *	int i = f();
 *	int f(){return 11;}
 *	int g(int n){return n*10;}
 * }
 *  
 * 这说明初始化的正确性取决于初始化的顺序
 */
class MethodInit2{
	int i = f();
	int j = g(i);
	int f(){return 11;}
	int g(int n){return n*10;}
}


