package com.point.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

/**
 *  Java四种引用
 *  
 *  1)、设置JVM虚拟机大小
 *      最小值： -Xms5M
 *      最大值： -Xmx10M
 *      
 *  2、弱引用一般使用于缓存
 *  
 */
public class FourReference {
	/**
	 *（1）强引用（StrongReference）
	 */
	@Test
	public  void testStrong(){
		//强引用，即使内存溢出，垃圾回收也不会回收此对象。new 就是一个强引用
		byte[] b = new byte[1024*1024*10];
	}
	
	/**
	 * 2）软引用（SoftReference）
	 *    
	 *    内存不够的时候，才会被垃圾回收器所回收
	 * 
	 */
	@Test
	public  void testSoft(){
		ReferenceObject stroRef = new ReferenceObject();
		//采取软引用存储
		SoftReference<ReferenceObject>  softRef = new SoftReference<ReferenceObject>(stroRef);
		//强引用失效（如果存在强引用，垃圾回收器是不会回收的，我们很难观察到效果。）
		stroRef = null; 
		System.out.println(softRef.get());
		System.gc();
		System.out.println(softRef.get());  //没有回收，因为内存足够
		byte[] b = new byte[1024*1024*10];
		System.gc();    //可以观察到有回收
	}
	
	/**
	 * 3）弱引用（SoftReference）
	 *    
	 *    只要运行垃圾回收，就会被回收
	 * 
	 */
	@Test
	public  void testWeak(){
		ReferenceObject stroRef = new ReferenceObject();
		//采取软引用存储
		WeakReference<ReferenceObject>  softRef = new WeakReference<ReferenceObject>(stroRef);
		//强引用失效（如果存在强引用，垃圾回收器是不会回收的，我们很难观察到效果。）
		stroRef = null; 
		System.out.println(softRef.get());
		System.gc();     //观察到已经被回收
	}
	
	/**
	 * 3）虚引用（PhantomReference）
	 *    
	 *    虚引用就相当于没有引用，这种引用刚创建就会被回收，程序中基本不用
	 *  所以这里不做详细说明。
	 * 
	 */
   
}
