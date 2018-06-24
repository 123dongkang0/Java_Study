package com.dongk.datatype;

import org.junit.Test;

public class DataType001 {
    
	/**
	 *  ��������������������ʱ��Java�ͻ�����Զ���������ת����
	 *     1.�������ͼ��ݡ�
	 *     2.Ŀ�����ʹ���Դ���͡�
	 * 
	 */
	@Test
	public void test01() {
		
		//1.Ҫ������Ч��typeֵ��int�������ǹ��ģ����Ի��Զ�ת��
		byte a = 8;
		int b = a;
		//char c = a; ���߲�����
		System.out.println(b);
		
	}
	
	/**
	 *  ǿ��ת�������ݵ��������͡�
	 *   intת��Ϊbyte
	 */
	@Test
	public void test02() {
		
		//1.int ת��Ϊbyte
		int a = 257;
		byte b = (byte)a;  //���Ϊ1,257/256(byte�ķ�Χ)������
		System.out.println(b);
		System.out.println(1257 % 256);
		
	}
	
	/**
	 *  ǿ��ת�������ݵ��������͡�
	 *   doubleת��Ϊbyte
	 */
	@Test
	public void test03() {
		
		//doubleת��Ϊbyte
		double a = 27.344;
		byte b = (byte)a;  //����С������
		System.out.println(b);
		
	}
	
	/**
	 *  ǿ��ת�������ݵ��������͡�
	 *   doubleת��Ϊint
	 */
	@Test
	public void test04() {
		
		//doubleת��Ϊint
		double a = 27.344;
		int b = (int)a;  //����С������
		System.out.println(b);
		
	}
}
