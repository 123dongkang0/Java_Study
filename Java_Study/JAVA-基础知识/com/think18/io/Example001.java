package com.think18.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 18.1 File�� 
 * 
 *   1����JAVA I/OϵͳΪʲô������˶���ࣿ
 *     
 *     1.1��Ϊ�˽������I/OԴ���ļ����������ӵȣ��Ƚ϶����������
 *     1.2��Ϊ���ö��ֶ����ķ�ʽ��I/OԴ����ͨ�ţ�˳�������ȡ�����塢�����ơ����ַ������С����֣���
 */

/**
 * 18.1.1 Ŀ¼�б�����Ŀ¼��������
 *     
 *       ��ʾ����������File����
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
	 *  2)����DirFilterʹ�������ڲ����дһ�£�����������ø�С
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


