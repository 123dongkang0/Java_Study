package com.design.pattern.daili;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{
	
	/**
	* <b>Description:
	*    ����CGlib�������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��24�� ����1:21:00
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public Object getProxy(Class clas) {
		//CGLIB enhancer ��ǿ�����
		Enhancer enhancer = new Enhancer();
		//������ǿ����
		enhancer.setSuperclass(clas);
		//��������߼�����Ϊ��ǰ����Ҫ��ǰ����ʵ�� Methodinterceptor ����
		enhancer.setCallback(this);
		//���ɲ����ش������
		return enhancer.create();
	}

	/*�����߼�����
	* @param proxy �������
	* @param method ����
	* @param args ��������
	* @param methodProxy ��������
	* @return �����߼�����
	*�� throws Throwable �쳣
	*/
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("�ڵ�����ʵ����֮ǰ�ķ���");
		Object obj= methodProxy.invokeSuper(proxy, args);
		System.out.println("�ڵ�����ʵ����֮��ķ���");
		return obj ;
	}

}
