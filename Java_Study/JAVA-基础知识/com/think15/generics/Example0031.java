package com.think15.generics;

import java.util.Iterator;

/**
 *15.3 : ʹ��Generator<T> �ӿڵ�����һ��ʵ�֣�
 *    ����������Fibonacci����
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
 * ��Fibonacci����������ⶼʹ�õ���int���ͣ����������Ͳ���ȷ��Integer.
 * �������������Java���͵�һ�������ԣ����������޷���Ϊ�������ͣ�
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
 *����������һ������дһ��ʵ����Iterable��Fibonacci���С������ַ�����
 *1.��д�����Fibonacci���У�
 *2.ͨ���̳еķ�������һ����������(����ѡ�����ַ�����ʵ��) 
 */
class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    
	int n=0;
	
	public IterableFibonacci(){}
	
	public IterableFibonacci(int size){
		this.n = size;
	}
	
	/**
	 * Ϊʲôһ��Ҫʵ��Iterable�ӿڣ�Ϊʲô��ֱ��ʵ��Iterator�ӿ��أ� 
	 * 
	 * ��ΪIterator�ӿڵĺ��ķ���next()����hasNext() �������ڵ������ĵ�ǰ����λ�õġ� 
     * ���Collectionֱ��ʵ��Iterator�ӿڣ��Ʊص��¼��϶����а�����ǰ����λ�õ�����(ָ��)�� 
     * �������ڲ�ͬ�����䱻����ʱ�����ڵ�ǰ����λ�ò���Ԥ�ã���ônext()�����Ľ�����ɲ���Ԥ֪�� 
     * ������ΪIterator�ӿ����һ��reset()�������������õ�ǰ����λ�á� 
     * ����ʱ������CollectionҲֻ��ͬʱ����һ����ǰ����λ�á� 
     * ��Iterable��Ȼ��ÿ�ε��ö��᷵��һ����ͷ��ʼ�����ĵ������� 
     * ����������ǻ������ŵġ� 
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

