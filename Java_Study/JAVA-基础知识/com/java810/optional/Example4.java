package com.java810.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.junit.Test;

import com.dongk.util.OptionalUtil;

/**
* <b>Description:
*     10.4 ʹ��Optional ��ʵսʵ��
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java810.optional
* <br><b>ClassName:</b> Example4
* <br><b>Date:</b> 2018��6��5�� ����9:57:25
*/
public class Example4 {
    
	/**
	* <b>Description:
	*      10.4.1 ��Optional��װ����Ϊnull��ֵ
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��4�� ����11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Map<String, Object> map = new HashMap<String, Object>();
		//��map get��������ֵ���з�װ
		Optional<Object> value = Optional.ofNullable(map.get("RETURN NULL"));
	}
	
	
	/**
	* <b>Description:
	*      10.4.2 �쳣��Optional�ĶԱ�
	*      
	*        ǿ�ҽ����װOptional������ 
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��4�� ����11:17:54
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
	*      10.4.3 �����е�������������
	*      
	*      ��ȡ��ֵΪ�������򷵻أ� ���򣬷���0
	*      
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��4�� ����11:17:54
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
		
		//java8֮ǰ
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
