package com.effictive07;

import java.util.Date;

import org.junit.Test;

/**
 * 第39条： 必要时进行保护性拷贝。 
 *    
 *    1. 需要注意的是，并不是总是需要保护性拷贝，只是在必要的时候进行保护性拷贝
 */
public class Example039 {
    
	/**
	 * 这样会破坏不可变的约束条件 ,
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
 * 1）、下面的类声称可以表示一段不可变的时间周期 ,
 * 然而Date类本身就是可变的，因此很容易违反约束条件
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
 * 添加 保护性拷贝
 */
final class Period1{
	private final Date start;
	private final Date end;
	
	public Period1(Date start, Date end){
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		
		//有效性检查在拷贝之后做
		if(this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(this.start + " after " + this.end);
		
	}
	
	public Date start(){
		return new Date(start.getTime());      //返回值也需要进行保护性拷贝
	}
	
	public Date end(){
		return new Date(end.getTime());         //返回值也需要进行保护性拷贝
	}
}
