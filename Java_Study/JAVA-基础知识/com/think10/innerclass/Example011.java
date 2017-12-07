package com.think10.innerclass;

/**
 *10.11 : 局部内部类 。
 *  1.局部内部类不能有访问修饰符。
 *  2.可以访问当前代码块的所有常量以及外围类的所有成员。
 */
public class Example011 {
   public static void main(String args[]){
	   LocalInnerClass lic = new LocalInnerClass();
	   Counter c1 = lic.getCounter("Local inner");
	   Counter c2 = lic.getCounter2("Anonymous inner");
	   
	   for(int i=0; i<5; i++){
		   System.out.println(c1.next());
	   }
	   
	   for(int i=0; i<5; i++){
		   System.out.println(" " + c2.next());
	   }
   }
}

/**
 * 在此处我们对匿名类 和 局部内部类进行比较;
 * 
 * 他们的唯一区别是局部内部类可以重载构造器。而匿名内部类只能用于实例初始化。
 */
interface Counter{
   int next();	
}

class LocalInnerClass{
	private int count = 0;
	Counter getCounter(final String name){
		
		class LocalCounter implements Counter{
			public LocalCounter(){
				System.out.println("LocalCounter");
			}
			public int next() {
				System.out.print(name);
				return count++;
			}
		}
		
		return new LocalCounter();
	}
	
	Counter getCounter2(final String name){
		return new Counter() {
			{
				System.out.println("Counter");
			}
			public int next() {
				System.out.print(name);
				return count++;
			}
		};
	}
}
