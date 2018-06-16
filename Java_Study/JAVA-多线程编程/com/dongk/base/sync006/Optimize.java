package com.dongk.base.sync006;

/**
 * ʹ��synchronized������С�������ȣ��������
 * @author alienware
 *
 */
public class Optimize {

	public void doLongTimeTask(){
		try {
			
			System.out.println("��ǰ�߳̿�ʼ��" + Thread.currentThread().getName() + 
					", ����ִ��һ���ϳ�ʱ���ҵ������������ݲ���Ҫͬ��");
			Thread.sleep(2000);
			
			synchronized(this){
				System.out.println("��ǰ�̣߳�" + Thread.currentThread().getName() + 
					", ִ��ͬ������飬����ͬ���������в���");
				Thread.sleep(1000);
			}
			System.out.println("��ǰ�߳̽�����" + Thread.currentThread().getName() +
					", ִ�����");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final Optimize otz = new Optimize();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				otz.doLongTimeTask();
			}
		},"t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				otz.doLongTimeTask();
			}
		},"t2");
		t1.start();
		t2.start();
		
	}
	
	
}
