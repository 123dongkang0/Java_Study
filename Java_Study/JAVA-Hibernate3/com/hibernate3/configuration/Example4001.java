package com.hibernate3.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 第四章 配置
 * 
 *    4.1 可编程的配置方式
 */
public class Example4001 {
   
	@Test
    public void testConfiguration(){
		 //1.Configuration实例是一个启动期间的对象，一旦SessionFactory创建完成它就会被丢弃
    	 Configuration cfg  = new Configuration()
    	           .addResource("")
    	           .addResource("")
    	           .setProperty("", "")
    	           .setProperty("", "")
    	           .setProperty("", "");
    	 
    	 //2.这个session工厂将被所有的线程所共享，Hibernate允许创建多个SessionFactory实例，这对使用多个数据库应用来说很有用
    	 SessionFactory sessions = cfg.buildSessionFactory();
    	 
    	 //3.所有Hibernate属性的名字和语义都在org.hibernate.cfg.Environment中定义
    	
    }
	
	
    
}
