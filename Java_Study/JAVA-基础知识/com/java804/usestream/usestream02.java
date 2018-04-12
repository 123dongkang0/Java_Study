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
*      5.2 ӳ��
*      һ���ǳ����������ݴ�����·���Ǵ�ĳЩ������ѡ����Ϣ��������SQL�����Դӱ���ѡ
*    ��һ�С�Stream APIҲͨ��map��flatMap�����ṩ�����ƵĹ��ߡ�
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java804.usestream
* <br><b>ClassName:</b> usestream02
* <br><b>Date:</b> 2018��4��12�� ����5:43:21
*/
public class usestream02 {

	/**
	 * 5.2.1 �����е�ÿһ��Ԫ��Ӧ�ú���
	 *    
	 *     map���������һ��������Ϊ��������������ᱻӦ�õ�ÿ��Ԫ���ϣ�
	 *  ������ӳ���һ���µ�Ԫ�ء�
	 *  
	 *  ����Ĵ���ѷ�������Dish :: getName ����map����������ȡ���в��ȵ����ơ�
	 */
	@Test
	public void test01() {
		
		/**
		 * ��ΪgetName�������ص���һ��String,����map����������������;���Stream<String> 
		 */
		List<String> dishNames = StreamConstant.menu
				     .stream()
				     .map(Dish :: getName)
				     .collect(Collectors.toList());
		dishNames.forEach(d -> System.out.println(d));
	}
	
	/**
	 * ����һ�������б���Ҫ��������һ���б���ʾÿ�������еļ�����ĸ��Ӧ����ô�����ˣ�
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
	 * �õ�ÿ���˵Ĳ����ĳ��� 
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
	 * 5.2.2 ���ı�ƽ��
	 *     
	 *      ����һ�ŵ��ʱ��г����������ͬ���ַ���
	 *      
	 *      ����ʹ��flatMap�����������⡣
	 */
    @Test
    public void test04() {
          String[] arrayOfWords = {"GoodBye","World"};
          Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
          streamOfWords.forEach(System.out :: println);
                   
          List<String> words = Arrays.asList("GoodBye", "World");
          /*
           * �������ַ�ʽ���ܹ����������⣬
           * ��Ϊd.split("") ���ص���һ�� String[] 
           */
          List<String[]> collect = words.stream()
		          .map(d -> d.split(""))
		          .collect(Collectors.toList());
    }

	
}
