package com.point.reference;

import java.lang.ref.SoftReference;

import org.junit.Test;

/**
 *  Java四种引用
 *  
 *
 *   （
 *   
 */
public class FourReference {
	/**
	 *（1）强引用（StrongReference）
     *       强引用是使用最普遍的引用。如果一个对象具有强引用，那垃圾回收器绝不会回收它。
     *   当内存空间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足的问题。
     *   强引用其实也就是我们平时A a = new A()这个意思。 
	 */
	
	
	/**
	 * 2）软引用（SoftReference）
	 *       软引用（soft reference）在强度上弱于强引用，通过类SoftReference来表示。
	 *   它的作用是告诉垃圾回收器，程序中的哪些对象是不那么重要，当内存不足的时候是可以被暂时回收的。
	 *   当JVM中的内存不足的时候，垃圾回收器会释放那些只被软引用所指向的对象。如果全部释放完这些对象之后，
	 *   内存还不足，才会抛出OutOfMemory错误。软引用非常适合于创建缓存。当系统内存不足的时候，
	 *   缓存中的内容是可以被释放的。
	 *       
	 *       比如考虑一个图像编辑器的程序。该程序会把图像文件的全部内容都读取到内存中，以方便进行处理。
	 *    而用户也可以同时打开多个文件。当同时打开的文件过多的时候，就可能造成内存不足。
	 *    如果使用软引用来指向图像文件内容的话，垃圾回收器就可以在必要的时候回收掉这些内存。
	 * 
	 * 
	 */
	@Test
	public void testSoftReference(){
		SoftReference<byte[]> dataRef = new SoftReference<byte[]>(referent)
	}
	
   
}
