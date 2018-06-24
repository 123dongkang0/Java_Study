package com.design.pattern.daili;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyExample implements MethodInterceptor{
	
	/**
	* <b>Description:
	*    生成CGlib代理对象
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月24日 下午1:21:00
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public Object getProxy(Class clas) {
		//CGLIB enhancer 增强类对象
		Enhancer enhancer = new Enhancer();
		//设置增强类型
		enhancer.setSuperclass(clas);
		//定义代理逻辑对象为当前对象，要求当前对象实现 Methodinterceptor 方法
		enhancer.setCallback(this);
		//生成并返回代理对象
		return enhancer.create();
	}

	/*代理逻辑方法
	* @param proxy 代理对象
	* @param method 方法
	* @param args 方法参数
	* @param methodProxy 方法代理
	* @return 代理逻辑返回
	*＠ throws Throwable 异常
	*/
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("在调度真实对象之前的服务");
		Object obj= methodProxy.invokeSuper(proxy, args);
		System.out.println("在调度真实对象之后的服务");
		return obj ;
	}

}
