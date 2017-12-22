package com.think08.polymorphic;

import org.junit.Test;

/**
 * 8.3.2 继承和清理 
 * 
 *    1）、通过组合和继承方法来创建新类时，永远不必担心对象的清理问题，子对象通常都会留给垃圾回收进行处理。
 *    
 *    2）、尽管通常不必执行清理工作，但是一旦选择需要执行，就必须谨慎和小心
 *       2.1）、销毁的顺序应该和初始化的顺序相反。
 *       2.3）、顺序如下：
 *             导出类：
 *             成员变量反顺序清理：
 *             基类；
 *             
 * 
 */
public class Example0031 {
   
	@Test
	public void testFrog(){
		Frog frog = new Frog();
		System.out.println("Bye!");
		frog.dispose();
	}
}

class Characteristic{
	private String s;
	Characteristic(String s){
		this.s = s;
		System.out.println("Creating Characteristic " + s);
	}
	protected void dispose(){
		System.out.println("Disposing Characteristic " + s);
	}
}

class Description{
	private String s;
	Description(String s){
		this.s = s;
		System.out.println("Creating Description " + s);
	}
	protected void dispose(){
		System.out.println("Disposing Description " + s);
	}
}

class LivingCreature{
	private Characteristic p = new Characteristic(" is alive ");
	private Description t = new Description(" Basic Living Creature ");
	LivingCreature(){
		System.out.println(" LivingCreature() ");
	}
	protected void dispose(){
		System.out.println("LivingCreature Dispose  " );
		t.dispose();
		p.dispose();
	}
}


class Animal extends LivingCreature{
	private Characteristic p = new Characteristic(" has heare");
	private Description t = new Description(" Animal not Vegetable ");
	Animal(){
		System.out.println(" Animal() ");
	}
	protected void dispose(){
		System.out.println("Animal Dispose " );
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

class Amphibian extends Animal{
	private Characteristic p = new Characteristic(" can live in water");
	private Description t = new Description(" Both water and land ");
	Amphibian(){
		System.out.println(" Amphibian() ");
	}
	protected void dispose(){
		System.out.println("Amphibian Dispose " );
		t.dispose();
		p.dispose();
		super.dispose();
	}
}

class Frog extends Amphibian{
	private Characteristic p = new Characteristic(" Croaks ");
	private Description t = new Description(" Eats Bugs ");
	Frog(){
		System.out.println(" Frog() ");
	}
	protected void dispose(){
		System.out.println("Frog Dispose " );
		t.dispose();
		p.dispose();
		super.dispose();
	}
}
