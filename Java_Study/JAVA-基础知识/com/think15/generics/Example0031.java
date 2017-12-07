package com.think15.generics;

import java.util.Iterator;

/**
 *15.3 : 使用Generator<T> 接口的另外一个实现，
 *    它负责生成Fibonacci数列
 */
public class Example0031 {
   public static void main(String args[]){
//	   Fibonacci gen = new Fibonacci();
//	   for(int i=0; i<18; i++){
//		   System.out.println(gen.next() + " ");
//	   }
	   
	   for(int i : new IterableFibonacci(5)){
		   System.out.print(i + " ");
	   }
   }
}

/**
 * 在Fibonacci类的里里外外都使用的是int类型，但是其类型参数确是Integer.
 * 这个例子引出了Java泛型的一个局限性，基本类型无法作为参数类型；
 */
class Fibonacci implements Generator<Integer>{
    private int count = 0;
    
	public Integer next() {
		return fib(count++);
	}
    
	private int fib(int n){
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}
}

/**
 *如果还想更进一步，编写一个实现了Iterable的Fibonacci数列。有两种方法：
 *1.重写上面的Fibonacci数列；
 *2.通过继承的方法创建一个适配器。(我们选择这种方法来实现) 
 */
class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    
	int n=0;
	
	public IterableFibonacci(){}
	
	public IterableFibonacci(int size){
		this.n = size;
	}
	
	/**
	 * 为什么一定要实现Iterable接口，为什么不直接实现Iterator接口呢？ 
	 * 
	 * 因为Iterator接口的核心方法next()或者hasNext() 是依赖于迭代器的当前迭代位置的。 
     * 如果Collection直接实现Iterator接口，势必导致集合对象中包含当前迭代位置的数据(指针)。 
     * 当集合在不同方法间被传递时，由于当前迭代位置不可预置，那么next()方法的结果会变成不可预知。 
     * 除非再为Iterator接口添加一个reset()方法，用来重置当前迭代位置。 
     * 但即时这样，Collection也只能同时存在一个当前迭代位置。 
     * 而Iterable则不然，每次调用都会返回一个从头开始计数的迭代器。 
     * 多个迭代器是互不干扰的。 
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public void remove() {
				throw new UnsupportedOperationException();
			}
			public Integer next() {
				n--;
				return IterableFibonacci.this.next();
			}
			public boolean hasNext() {
				return n > 0;
			}
		};
	}
	
}

