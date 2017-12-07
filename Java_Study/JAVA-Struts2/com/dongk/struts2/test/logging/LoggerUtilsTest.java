package com.dongk.struts2.test.logging;

import org.junit.Test;

import com.dongk.struts2.util.logging.LoggerUtils;


public class LoggerUtilsTest {
      
	@Test
	public void formatTest(){
		System.out.println(LoggerUtils.format("foo #1 #0", "tiger0", "tiger1"));
		
		System.out.println(LoggerUtils.format("foo #A# ###", "tiger0", "tiger1"));
	}
}
