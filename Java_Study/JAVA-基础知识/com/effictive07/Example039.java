package com.effictive07;

import java.util.Date;

/**
 * 第39条： 必要时进行保护性拷贝。 
 */
public class Example039 {

}

/**
 * 下面的类声称可以表示一段不可变的时间周期 
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
