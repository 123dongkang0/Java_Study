package com.design.pattern.daili;


public class TestJdkProxy {
	
	public static void main(String args[]) {
		JdkProxyExample jdk = new JdkProxyExample();
		//°ó¶¨¹ØÏµ
		HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
	    proxy.sayHelloWorld();
	}
}
