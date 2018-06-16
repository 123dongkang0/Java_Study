package com.dongk.thread.base.sync003;

/**
 * ��������ͬ�����첽����
 * @author alienware
 *
 */
public class MyObject {

	public synchronized void method1(){
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/** synchronized */
	public void method2(){
			System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		
		final MyObject mo = new MyObject();
		
		/**
		 * ������
		 * t1�߳��ȳ���object�����Lock����t2�߳̿������첽�ķ�ʽ���ö����еķ�synchronized���εķ���
		 * t1�߳��ȳ���object�����Lock����t2�߳���������ʱ����ö����е�ͬ����synchronized����������ȴ���Ҳ����ͬ��
		 */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				mo.method2();
			}
		},"t2");
		
		t1.start();
		t2.start();
		
	}
	
}
