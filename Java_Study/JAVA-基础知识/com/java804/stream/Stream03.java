package com.java804.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.transform.ToListResultTransformer;
import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;

/**
* <b>Description:
*        4.3 流与集合
*        
*          1.流和集合有什么区别？
*             1.1 集合 ： Java8中的集合就像是存在DVD上的电影（集合中保存了数据结构现在拥有的所有值-每个元素的值都得先算出来才能加到集合中）。
*             1.2 流   ： Java8 中的流就像用在线的流媒体看电影（和视频流一样，只有在需要的时候才会计算值）
*        
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.stream
* <br><b>ClassName:</b> Stream03
* <br><b>Date:</b> 2018年4月12日 下午2:38:07
*/
public class Stream03 {
    
	/**
	 * 4.3.1 流只能遍历一次
	 * 
	 *  小面的操作会产生流已经被消耗的异常。
	 */
	@Test
	public void test01() {
		List<String> title = Arrays.asList("JAVA 8","IN","Action");
		Stream<String> s = title.stream();
		s.forEach(System.out :: println);
		s.forEach(System.out :: println);
	}
	
	/**
	 * 4.3.2  流和集合的另一个区别是他们的迭代方式
	 *   集合：外部迭代；
	 *   流 ： 内部迭代；
	 */
	@Test
	public void test02() {
		List<String> names = StreamConstant.menu
				              .stream()
				              .map(Dish :: getName)
				              .collect(Collectors.toList());
	}
}
