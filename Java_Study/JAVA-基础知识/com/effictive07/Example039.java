package com.effictive07;

import java.util.Date;

import org.junit.Test;

/**
 * ��39���� ��Ҫʱ���б����Կ����� 
 *    
 *    1. ��Ҫע����ǣ�������������Ҫ�����Կ�����ֻ���ڱ�Ҫ��ʱ����б����Կ���
 */
public class Example039 {
    
	/**
	 * �������ƻ����ɱ��Լ������ ,
	 * 
	 */
	@Test
	public void testPeriod(){
		Date start = new Date();
		Date end = new Date();
		Period p = new Period(start, end);
		end.setYear(78);
	}
	
	
	
}

/**
 * 1��������������ƿ��Ա�ʾһ�β��ɱ��ʱ������ ,
 * Ȼ��Date�౾����ǿɱ�ģ���˺�����Υ��Լ������
 * 
 */
final class Period{
	private final Date start;
	private final Date end;
	
	public Period(Date start, Date end){
		if(start.compareTo(end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
		
		this.start = start;
		this.end = end;
	}
	
	public Date start(){
		return start;
	}
	
	public Date end(){
		return end;
	}
}

/**
 * ��� �����Կ���
 */
final class Period1{
	private final Date start;
	private final Date end;
	
	public Period1(Date start, Date end){
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		//��Ч�Լ���ڿ���֮����
		if(this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(this.start + " after " + this.end);
		
	}
	
	public Date start(){
		return new Date(start.getTime());      //����ֵҲ��Ҫ���б����Կ���
	}
	
	public Date end(){
		return new Date(end.getTime());         //����ֵҲ��Ҫ���б����Կ���
	}
}
