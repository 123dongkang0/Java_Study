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
* <br><b>Date:</b> 2018年6月6日 上午11:17:39
*/
public class usestream07 {
   
	/**
	* <b>Description:
	*   5.7.1 又值创建流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 下午12:12:51
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
	*   5.7.2 由数组创建流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 下午12:12:51
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
	*   5.7.3 由文件生成流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 下午12:12:51
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
	*   5.7.4 由函数生成流
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 下午12:12:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test04() {
	  //创建一个偶数流
       Stream.iterate(0, n -> n+2)
          .limit(10)
          .forEach(System.out :: println);
       
       //使用iterate生成斐波那契数列元祖中的前20个元素
       Stream.iterate(new int[] {0,1},
    		          t -> new int[]{t[1], t[0] + t[1]})
               .limit(10)
               .map(t -> t[0])
               .forEach(System.out :: println);
       
       /**
        *   与iterate方法类似，generate方法也可让你按需生成一个无限流。
        * 但generate不是依次对每个新生成的值应用函数的。它接受一个Supplier<T>类型的Lambda提供新的值。
        **/
       Stream.generate(Math :: random)
          .limit(5)
          .forEach(System.out :: println);
	}
}
