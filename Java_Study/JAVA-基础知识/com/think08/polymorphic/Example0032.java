package com.think08.polymorphic;

import org.junit.Test;

/**
 *  Example0031中 Frog对象创建了它自己的成员对象，并且知道它们应该存活多久(只要Frog活着)，因此Frog对象知道何时调用
 *  dispose()去释放其成员对象。
 *  
 *  然而，如果这些成员对象中存在其他一个或者多个对象共享的情况，那么，问题就比较复杂了.我们可以采用计数器来记录共享对象的数量，
 *  来解决这个问题。
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