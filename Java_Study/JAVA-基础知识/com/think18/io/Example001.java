package com.think18.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 18.1 File类 
 * 
 *   1）、JAVA I/O系统为什么会有如此多的类？
 *     
 *     1.1）为了解决各种I/O源（文件、网络连接等）比较多样的情况。
 *     1.2）为了用多种多样的方式和I/O源进行通信（顺序、随机存取、缓冲、二进制、按字符、按行、按字）。
 */

/**
 * 18.1.1 目录列表器（目录过滤器）
 *     
 *       显示符合条件的File对象。
 * 
 */
public class Example001 {
   
	@Test
	public void testDirFilter(){
		File path = new File("D://");
		String[] list = path.list(new DirFilter("^M.*$"));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
		
	}
	
	/**
	 *  2)、将DirFilter使用匿名内部类改写一下，这样程序会变得更小
	 */
	@Test
	public void test02(){
		File path = new File("D://");
		String[] list = path.list(new FilenameFilter() {
			private Pattern pattern = Pattern.compile("^M.*$");
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		});
	}
}

class DirFilter implements FilenameFilter{
     
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
	
}


