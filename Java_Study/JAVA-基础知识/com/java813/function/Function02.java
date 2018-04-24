package com.java813.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Function02 {
    
	/**
	* <b>Description:
	*      13.2.4 ����ʽ���ʵս��
	*            ��{1��4��9}���Ӽ�����List<Integer>���ʾ���������Ӽ�����
	*         {1,4,9} ��{1,4}��{1,9}��{4,9}��{1}��{4}��{9}��{}(�Ӽ�ʹ��List<List<Integer>>��ʾ)   
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��4��24�� ����11:26:41
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		List<Integer> complete = Arrays.asList(1,4,9);
		
	}
	
	static List<List<Integer>> subsets(List<Integer> list){
		if(list.isEmpty())
		{
			List<List<Integer>> ans = new ArrayList<>();
			ans.add(Collections.emptyList());
			return ans;
		}
		Integer first = list.get(0);
		List<Integer> rest = list.subList(1, list.size());
		
		List<List<Integer>> subans = subsets(rest);
		//�𰸵�����һ����subans2,��subans��ÿ��Ԫ��ǰ���first
		List<List<Integer>> subans2 = insertAll(first,subans);  
		return concat(subans,subans2);
	}
	
}
