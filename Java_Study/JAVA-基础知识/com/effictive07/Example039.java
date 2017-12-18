package com.effictive07;

import java.util.Date;

/**
 * ��39���� ��Ҫʱ���б����Կ����� 
 */
public class Example039 {

}

/**
 * ����������ƿ��Ա�ʾһ�β��ɱ��ʱ������ 
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
