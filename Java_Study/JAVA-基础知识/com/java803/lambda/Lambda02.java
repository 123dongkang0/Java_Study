package com.java803.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
* <b>Description:3.3 把Lambda付诸实践：环绕执行模式。</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda02
* <br><b>Date:</b> 2018年4月1日 下午2:16:43
*/
public class Lambda02 {
	
	@Test
	public void test01() {
		try {
			String onLine = processFile((BufferedReader br) -> br.readLine());
			String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
			
			System.out.println(onLine);
			System.out.println(twoLines);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String processFile(BufferedReaderProcessor p )throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("E:\\vss\\data.txt"))){ //这种写法不用去关闭流
			return p.priccess(br);
		}
	}
}

@FunctionalInterface
interface BufferedReaderProcessor{
	String priccess(BufferedReader b) throws IOException;
}
