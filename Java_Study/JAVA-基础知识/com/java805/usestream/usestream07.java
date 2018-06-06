package com.java805.usestream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

/**
* <b>Description:
* 
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream07
* <br><b>Date:</b> 2018��6��6�� ����11:17:39
*/
public class usestream07 {
   
	/**
	* <b>Description:
	*   5.7.1 ��ֵ������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����12:12:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "in ", "Action.");
	}
	
	
	/**
	* <b>Description:
	*   5.7.2 �����鴴����
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����12:12:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		int[] numbers = {2,3,7,11,13};
		IntStream stream = Arrays.stream(numbers);
	}
	
	/**
	* <b>Description:
	*   5.7.3 ���ļ�������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����12:12:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test03() {
		try(
			Stream<String>	lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())
	    ){
			
		}catch(IOException e) {
	    }
		
	}
	
	/**
	* <b>Description:
	*   5.7.4 �ɺ���������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����12:12:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test04() {
	  //����һ��ż����
       Stream.iterate(0, n -> n+2)
          .limit(10)
          .forEach(System.out :: println);
       
       //ʹ��iterate����쳲���������Ԫ���е�ǰ20��Ԫ��
       Stream.iterate(new int[] {0,1},
    		          t -> new int[]{t[1], t[0] + t[1]})
               .limit(10)
               .map(t -> t[0])
               .forEach(System.out :: println);
       
       /**
        *   ��iterate�������ƣ�generate����Ҳ�����㰴������һ����������
        * ��generate�������ζ�ÿ�������ɵ�ֵӦ�ú����ġ�������һ��Supplier<T>���͵�Lambda�ṩ�µ�ֵ��
        **/
       Stream.generate(Math :: random)
          .limit(5)
          .forEach(System.out :: println);
	}
}
