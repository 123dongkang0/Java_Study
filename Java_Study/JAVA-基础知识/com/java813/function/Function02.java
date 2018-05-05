package com.java813.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Function02 {
    
	/**
	* <b>Description:
	*      13.2.4 函数式编程实战：
	*            求{1，4，9}的子集（用List<Integer>标表示），它的子集包括
	*         {1,4,9} 、{1,4}、{1,9}、{4,9}、{1}、{4}、{9}、{}(子集使用List<List<Integer>>表示)   
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年4月24日 上午11:26:41
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
		//答案的另外一半是subans2,在subans的每个元素前面加first
		List<List<Integer>> subans2 = insertAll(first,subans);  
		return concat(subans,subans2);
	}
	
}
