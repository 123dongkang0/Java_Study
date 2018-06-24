package com.design.pattern.daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler{
	
	//��ʵ����
	private Object target;
    
	//������ʵ����ʹ������Ĺ�ϵ�������ش������
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				                       target.getClass().getInterfaces(), 
				                       this);
	}
	
    /*
	 *��ǰ�������߼�
	 * @param proxy �������
	 * param method ��ǰ���ȷ���
	 * @param args ��ǰ��������
	 * @return ����������
	 * @throws Throwable �쳣
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("�ڵ�����ʵ����֮ǰ�ķ���");
		Object obj= method .invoke(target , args);
		System.out.println("�ڵ�����ʵ����֮��ķ���");
		return obj ;
	}

}
