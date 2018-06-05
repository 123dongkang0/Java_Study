package com.java810.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.junit.Test;

import com.dongk.util.OptionalUtil;

/**
* <b>Description:
*     10.4 使用Optional 的实战实例
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java810.optional
* <br><b>ClassName:</b> Example4
* <br><b>Date:</b> 2018年6月5日 上午9:57:25
*/
public class Example4 {
    
	/**
	* <b>Description:
	*      10.4.1 用Optional封装可能为null的值
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月4日 上午11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Map<String, Object> map = new HashMap<String, Object>();
		//对map get方法返回值进行封装
		Optional<Object> value = Optional.ofNullable(map.get("RETURN NULL"));
	}
	
	
	/**
	* <b>Description:
	*      10.4.2 异常与Optional的对比
	*      
	*        强烈建议封装Optional工具类 
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月4日 上午11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		
		String numberStr = "120";
		Optional<Integer>  number =  OptionalUtil.stringToInt(numberStr);
	}
	
	/**
	* <b>Description:
	*      10.4.3 把所有的内容整合起来
	*      
	*      读取的值为整数，则返回， 否则，返回0
	*      
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月4日 上午11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test03() {
		Properties props = new Properties();
		props.setProperty("a", "5");
		props.setProperty("b", "true");
		props.setProperty("c", "properties");
		
		//java8之前
		System.out.println(readDuration(props,"c"));
		
		//java8
		System.out.println(readDurationOfJava8(props,"c"));
		
	}
	
	public int readDuration(Properties props, String name) {
		String value = props.getProperty(name);
		if(value != null) {
			try{
				int i = Integer.parseInt(value);
				if(i > 0)
					return i;
			}catch(NumberFormatException ex) {
				
			}
		}
		return 0;
	}
	
	public int readDurationOfJava8(Properties props, String name) {
		Optional<String> value = Optional.ofNullable(props.getProperty(name));
		return value.flatMap(pro -> OptionalUtil.stringToInt(pro))
				    .filter(num -> num >0).orElse(0);
	}
	
}
