package com.think08.polymorphic;

import org.junit.Test;

/**
 *  Example0031�� Frog���󴴽������Լ��ĳ�Ա���󣬲���֪������Ӧ�ô����(ֻҪFrog����)�����Frog����֪����ʱ����
 *  dispose()ȥ�ͷ����Ա����
 *  
 *  Ȼ���������Щ��Ա�����д�������һ�����߶����������������ô������ͱȽϸ�����.���ǿ��Բ��ü���������¼��������������
 *  �����������⡣
 */
public class Example0032 {
   
	@Test
	public void testComposing(){
		Shared shared = new Shared();
		Composing[] composing = {
				                  new Composing(shared),
				                  new Composing(shared),
				                  new Composing(shared),
				                  new Composing(shared),
				                  new Composing(shared),
				                  new Composing(shared),
		                        };
		for(Composing c : composing)
			c.dispose();
	}
}

class Shared{
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public Shared(){
		System.out.println("Creatubg " + this);
	}
	public void addRef(){refcount++;}
	protected void dispose(){
		if(--refcount == 0){
			System.out.println("Disposing " + this);
		}
	}
	public String toString(){return "Shared " + id;}
}


class Composing{
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Shared shared){
		System.out.println("Creating " + this);
		this.shared = shared;
		this.shared.addRef();
	}
	protected void dispose(){
        System.out.println("Disposing " + this);
        shared.dispose();
	}
	public String toString(){return "Composing " + id;}
	
}