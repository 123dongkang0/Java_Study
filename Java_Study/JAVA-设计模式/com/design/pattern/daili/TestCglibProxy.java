package com.design.pattern.daili;


public class TestCglibProxy {
	
	public static void main(String args[]) {
		CglibProxyExample cglib = new CglibProxyExample();
		//�󶨹�ϵ
		ReflectImpl proxy = (ReflectImpl) cglib.getProxy(ReflectImpl.class);
	    proxy.notice();;
	}
}
