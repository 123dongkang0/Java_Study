package com.think05.init;

import org.junit.Test;

/**
 * 5.6 ��Ա��ʼ��
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
 * 1)��������ݳ�Ա�ǻ������ͣ�������һ����ʼֵ 
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
 * 2)����ʼ����ʽ1��ֱ����ָ�����Ա������ʱ�ط�Ϊ�丳ֵ
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
	Depth depth = new Depth();  //���û��Ϊdepthָ����ʼֵ���ͳ���ʹ��������ᷢ������ʱ�쳣
}

/**
 * 3)����ʼ����ʽ2��ͨ���������ṩ��ʼֵ
 */
class MethodInit{
	int i = f();   //��ʼ�����̱Ƚϸ��ӵ�ʱ�����������д
	int f(){return 11;}
}

/**
 * ע�⣬���ﲻ��д��
 * 
 * class MethodInit2{
 *  int j = g(i);
 *	int i = f();
 *	int f(){return 11;}
 *	int g(int n){return n*10;}
 * }
 *  
 * ��˵����ʼ������ȷ��ȡ���ڳ�ʼ����˳��
 */
class MethodInit2{
	int i = f();
	int j = g(i);
	int f(){return 11;}
	int g(int n){return n*10;}
}


