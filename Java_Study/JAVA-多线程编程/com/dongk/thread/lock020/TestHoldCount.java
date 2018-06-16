package com.dongk.thread.lock020;

import java.util.concurrent.locks.ReentrantLock;
/**
 * lock.getHoldCount()������ֻ���ڵ�ǰ�����߳��ڲ�ʹ�ã������������߳���ʹ��
 * ��ô�ҿ�����m1������ȥ����m2������ͬʱm1������m2����������lock�������� ���Խ��holdCount������
 *
 */
public class TestHoldCount {

	//������
	private ReentrantLock lock = new ReentrantLock();
	
	public void m1(){
		try {
			lock.lock();
			System.out.println("����m1������holdCount��Ϊ��" + lock.getHoldCount());
			
			//����m2����
			m2();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void m2(){
		try {
			lock.lock();
			System.out.println("����m2������holdCount��Ϊ��" + lock.getHoldCount());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	
	public static void main(String[] args) {
		TestHoldCount thc = new TestHoldCount();
		thc.m1();
	}
}
