package com.java804.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*        4.1 流是什么？
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream01
* <br><b>Date:</b> 2018年4月12日 下午2:38:07
*/
public class Stream01 {

	/**
	* <b>Description:筛选能量最低的菜，JAVA7中这样操作</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年4月12日 下午2:39:22
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		List<Dish> menu = StreamConstant.menu;
				
		Collections.sort(menu,new Comparator<Dish>() {
			public int compare(Dish d1, Dish d2) {
				return Long.compare(d1.getCalories(), d2.getCalories());
			}
		});
		
		List<String>  dishNmaes = new ArrayList<String>();
		for(Dish d:menu) {
			dishNmaes.add(d.getName());
		}
		
		for(String name : dishNmaes) {
			System.out.println(name);
		}
	}
	
}
