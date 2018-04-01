package com.java803.lambda;

import java.util.Comparator;

import org.junit.Test;

import com.java8.model.Apple;

/**
* <b>Description: ������ Lambda ���ʽ
*         ���µ�����˼·���ǽ������һ��һ��д������ࡢ�����Ĵ��롣
*      
*   3.1 Lambda ���п���      
*      Lamdba���ʽ�� ��ʾ�ɴ��ݵ�����������һ�ַ�ʽ����û�����ƣ��������в����б�
*   �������塢�������ͣ����׳����쳣�б�
*         
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda01
* <br><b>Date:</b> 2018��4��1�� ����1:39:20
*/
public class Lambda01 {
	
	/**
	 * 3.2 �������Լ����ʹ��Lambda���ʽ ��
	 *      �ں���ʽ�ӿ���ʹ��Lambda���ʽ��
	 *      
	 *      3.2.1 ʲô�Ǻ���ʽ�ӿڣ�
	 *          ֻ�Ƕ�����һ�����󷽷��Ľӿڣ� Runable ����һ������ʽ�ӿ�
	 */
	@Test
	public void test01() {
		Runnable r1 = () -> System.out.println("Hello World Lambda!!");
		process(r1);
	}
	
	public static void process(Runnable r) {
		r.run();
	}
	
	
	
}
      
	
