package com.java803.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Test;

/**
* <b>Description:
*     3.6 方法引用？
*     
*      方法引用可以被看作仅仅调用特定方法的Lambda的一种快捷写法。
*  它的基本思想是，如果一个Lambda代表的只是“直接调用这个方法”，那最好还是用名称来调用它，
*  而不是去描述如何调用它。
*  
*     方法引用就是Lambda表达式的快捷写法
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018年4月13日 上午9:59:42
*/
public class Lambda06 {
    
	@Test
	public void test01(){
		
		List<String> str = Arrays.asList("a","E","A","D","E");
		str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		
		str.forEach(System.out :: println);
	}
	
}
