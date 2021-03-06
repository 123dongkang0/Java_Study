package com.java805.usestream;

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
          
          /**
           * 2.使用flatMap来解决这个问题 
           */
          List<String> collect2 = words.stream()
	          .map(w -> w.split(""))
	          .flatMap(Arrays :: stream)  //将各个生成流扁平化为单个流
	          .distinct()
	          .collect(Collectors.toList());
          collect2.forEach(d -> System.out.println(d));
    }
    
    /**
     * 返回一个数组的平方值 
     */
    @Test
    public void test05() {
    	List<Integer>   datas = Arrays.asList(1,2,3,4,5);
    	List<Integer> suqare = datas.stream()
					    	.map(d -> d * d)
					    	.collect(Collectors.toList());
    	suqare.forEach(d -> System.out.println(d));
    }
    
    /**
     *     给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
     *  该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。 
     */
    @Test
    public void test06() {
    	List<Integer>   data1 = Arrays.asList(1,2,3);
    	List<Integer>   data2 = Arrays.asList(3,4);
    	
    	List<Integer[]> collect = data1.stream()
    	.flatMap(x -> {
    		return data2.stream().map(y -> {
    			return new Integer[] {x,y};
    		});
    	}).collect(Collectors.toList());
    	
    	collect.forEach(d -> System.out.println(d[0] + "," + d[1]));
    }

	
}
