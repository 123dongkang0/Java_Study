package com.point.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import org.junit.Test;

/**
 *  Java��������
 *  
 *  1)������JVM�������С
 *      ��Сֵ�� -Xms5M
 *      ���ֵ�� -Xmx10M
 *      
 *  2��������һ��ʹ���ڻ���
 *  
 */
public class FourReference {
	/**
	 *��1��ǿ���ã�StrongReference��
	 */
	@Test
	public  void testStrong(){
		//ǿ���ã���ʹ�ڴ��������������Ҳ������մ˶���new ����һ��ǿ����
		byte[] b = new byte[1024*1024*10];
	}
	
	/**
	 * 2�������ã�SoftReference��
	 *    
	 *    �ڴ治����ʱ�򣬲Żᱻ����������������
	 * 
	 */
	@Test
	public  void testSoft(){
		ReferenceObject stroRef = new ReferenceObject();
		//��ȡ�����ô洢
		SoftReference<ReferenceObject>  softRef = new SoftReference<ReferenceObject>(stroRef);
		//ǿ����ʧЧ���������ǿ���ã������������ǲ�����յģ����Ǻ��ѹ۲쵽Ч������
		stroRef = null; 
		System.out.println(softRef.get());
		System.gc();
		System.out.println(softRef.get());  //û�л��գ���Ϊ�ڴ��㹻
		byte[] b = new byte[1024*1024*10];
		System.gc();    //���Թ۲쵽�л���
	}
	
	/**
	 * 3�������ã�SoftReference��
	 *    
	 *    ֻҪ�����������գ��ͻᱻ����
	 * 
	 */
	@Test
	public  void testWeak(){
		ReferenceObject stroRef = new ReferenceObject();
		//��ȡ�����ô洢
		WeakReference<ReferenceObject>  softRef = new WeakReference<ReferenceObject>(stroRef);
		//ǿ����ʧЧ���������ǿ���ã������������ǲ�����յģ����Ǻ��ѹ۲쵽Ч������
		stroRef = null; 
		System.out.println(softRef.get());
		System.gc();     //�۲쵽�Ѿ�������
	}
	
	/**
	 * 3�������ã�PhantomReference��
	 *    
	 *    �����þ��൱��û�����ã��������øմ����ͻᱻ���գ������л�������
	 *  �������ﲻ����ϸ˵����
	 * 
	 */
   
}
