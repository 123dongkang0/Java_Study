package com.java804.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.java8.model.Dish;
import com.java8.model.StreamConstant;


/**
* <b>Description:
*      5.2 映射
*      一个非常常见的数据处理套路就是从某些对象中选择信息。比如在SQL里，你可以从表中选
*    择一列。Stream API也通过map和flatMap方法提供了类似的工具。
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream02
* <br><b>Date:</b> 2018年4月12日 下午5:43:21
*/
public class usestream02 {

	/**
	 * 5.2.1 对流中的每一个元素应用函数
	 *    
	 *     map函数会接收一个函数作为参数。这个函数会被应用到每个元素上，
	 *  并将其映射成一个新的元素。
	 *  
	 *  下面的代码把方法引用Dish :: getName 传给map方法，来提取流中菜肴的名称。
	 */
	@Test
	public void test01() {
		
		/**
		 * 因为getName方法返回的是一个String,所以map方法输出的流的类型就是Stream<String> 
		 */
		List<String> dishNames = StreamConstant.menu
				     .stream()
				     .map(Dish :: getName)
				     .collect(Collectors.toList());
		dishNames.forEach(d -> System.out.println(d));
	}
	
	/**
	 * 给定一个单词列表，想要返回另外一个列表，显示每个单词中的几个字母。应该怎么操作了？
	 * 
	 * 
	 */
	@Test
	public void test02() {
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		List<Integer> wordLength = words.stream()
				             .map(String :: length)
				             .collect(Collectors.toList());
		wordLength.forEach(d -> System.out.println(d));
	}
	
	/**
	 * 得到每个菜的菜名的长度 
	 */
	@Test
	public void test03() {
	    List<Integer> menuLength = StreamConstant.menu
	    		             .stream()
	    		             .map(Dish :: getName)
	    		             .map(String :: length)
	    		             .collect(Collectors.toList());
	    menuLength.forEach(d -> System.out.println(d));
	}
	
	/**
	 * 
	 * 5.2.2 流的扁平化
	 *     
	 *      给定一张单词表，列出里面各不相同的字符？
	 *      
	 *      可以使用flatMap来解决这个问题。
	 */
    @Test
    public void test04() {
          String[] arrayOfWords = {"GoodBye","World"};
          Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
          streamOfWords.forEach(System.out :: println);
                   
          List<String> words = Arrays.asList("GoodBye", "World");
          /*
           * 下面这种方式不能够解决这个问题，
           * 因为d.split("") 返回的是一个 String[] 
           */
          List<String[]> collect = words.stream()
		          .map(d -> d.split(""))
		          .collect(Collectors.toList());
    }

	
}
