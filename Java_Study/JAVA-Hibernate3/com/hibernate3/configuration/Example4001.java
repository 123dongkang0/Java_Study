package com.hibernate3.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * ������ ����
 * 
 *    4.1 �ɱ�̵����÷�ʽ
 */
public class Example4001 {
   
	@Test
    public void testConfiguration(){
		 //1.Configurationʵ����һ�������ڼ�Ķ���һ��SessionFactory����������ͻᱻ����
    	 Configuration cfg  = new Configuration()
    	           .addResource("")
    	           .addResource("")
    	           .setProperty("", "")
    	           .setProperty("", "")
    	           .setProperty("", "");
    	 
    	 //2.���session�����������е��߳�������Hibernate���������SessionFactoryʵ�������ʹ�ö�����ݿ�Ӧ����˵������
    	 SessionFactory sessions = cfg.buildSessionFactory();
    	 
    	 //3.����Hibernate���Ե����ֺ����嶼��org.hibernate.cfg.Environment�ж���
    	
    }
	
	
    
}
