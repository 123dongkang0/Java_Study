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
*     3.6 �������ã�
*     
*      �������ÿ��Ա��������������ض�������Lambda��һ�ֿ��д����
*  ���Ļ���˼���ǣ����һ��Lambda�����ֻ�ǡ�ֱ�ӵ������������������û�������������������
*  ������ȥ������ε�������
*  
*     �������þ���Lambda���ʽ�Ŀ��д��
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java803.lambda
* <br><b>ClassName:</b> Lambda04
* <br><b>Date:</b> 2018��4��13�� ����9:59:42
*/
public class Lambda06 {
    
	@Test
	public void test01(){
		
		List<String> str = Arrays.asList("a","E","A","D","E");
		str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		
		str.forEach(System.out :: println);
	}
	
}
