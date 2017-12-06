package com.think07.reuseclass;

import java.util.Random;

import org.junit.Test;

/**
 * 7.8 final�ؼ��� 
 * 
 * ������̸����final����ʹ�õ���������������ݡ��������ࡣ
 */
public class Example008 {

	@Test
	public void testFinalData(){
		FinalData fd1 = new FinalData("fd1");
		//���󣺲��ܸı�
		//fd1.VALUE_THREE++;
		
		fd1.v2.i++;
		fd1.v1 = new Value(0);
		fd1.VAL_3.i++;
		//���󣬲��ܸı�����
		//fd1.VAL_3 = new Value(0);
		
		for(int i = 0; i<fd1.a.length; i++){
			fd1.a[i]++;   //�����ֵ���Ա��ı�
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
		
		//op.f();  //���ܹ����������������Ϊ����final
		//op.g();
		
		WithFinal wf = op2;
		
		//wf.f();
		//wf.g();
	}
	
}

/**
 * 1����final���� ����ʾ�����ı�ı���ʱ����
 * 
 *    ���ڻ������ͣ�finalʹ��ֵ�㶨���䣻
 *    ���ڶ������ã�finalʹ���ú㶨���䣻
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
	public static final int VALUE_THREE = 39;    //���Ա�������֮��
	
	/**
	 * i4��INT_5˵����
	 *  
	 *    ������Ϊĳ��������final�ľ���Ϊ�ڱ���ʱ����֪������ֵ��������ʱʹ���������ʼ��
	 *  i4��INT_5����˵�����������
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
 * 2�����հ�final
 *    java �������� "�հ�final"�� ����Ҫȷ�� "�հ�final" ��ʹ��֮ǰ�����ʼ��
 */
class Poppet{
	private int i;
	Poppet(int i){ this.i = i;}
}

class BlankFinal{
	final int i = 0;
	final int j;   //�հ�final
	final Poppet p;  //�հ�finalָ��
	
	public BlankFinal(){
		j = i;
		p = new Poppet(1);
	}
}

/**
 * 3����final����
 *    
 *    java�����ڲ����б����������ķ�ʽ������ָ��Ϊfinal,����ζ�����޷��ڷ�����
 * ���� ����������ָ��Ķ���
 */
class Gizmo{
	public void spin(){
		System.out.println("Gizmo spain");
	}
}

class FinalArguments{
	void with(final Gizmo g){
		//g = new Gizmo();   //�Ƿ��ģ����� g �� final ���ε�
	}
	
	void without(Gizmo g){
		g = new Gizmo();
		g.spin();
	}
	
	int g(final int i){
		//i++;      //�Ƿ��ģ����ܸı�i��ֵ
		return i + 1;
	}
}

/**
 * 4����final����
 * 
 *    ΪʲôҪʹ��final����
 *    1�����ѷ�����������ֹ�κμ̳����޸����Ķ���
 *    
 *    �������е�private��������ʽ��ָ��Ϊfinal�ġ������޷�ȡ��private�ķ���������Ҳ���޷���������
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
	 * ���ಢû�и��Ǹ����f()�� ֻ���������ִ�����ͬ���ѡ� 
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
 * 5����final��
 * 
 *    ������̳�һ�����ʱ�򣬿���ʹ��final������
 *    
 */
class SmallBrain{}

final class Dinosaur{
	int i = 7,
	    j = i;
	SmallBrain x = new SmallBrain();
	void f(){}
}

//��������д����ΪDinosaurʹ��final������
// class Further extends Dinosaur{}
