package com.java805.usestream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import com.java8.model.Traders;
import com.java8.model.Transaction;

/**
* <b>Description:
*    5.5 付诸实践
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream05
* <br><b>Date:</b> 2018年6月6日 上午9:36:27
*/
public class usestream05 {
	
	public static Traders raoul = new Traders("RAOUL", "Cambridge");
	public static Traders mario = new Traders("Mario", "Milan");
	public static Traders alan = new Traders("Alan", "Cambridge");
	public static Traders brian = new Traders("Brian", "Cambridge");
	
	
    public static List<Transaction> transactions = Arrays.asList(
    		   new Transaction(brian, 2011, 300),
    		   new Transaction(raoul, 2012, 1000),
    		   new Transaction(raoul, 2011, 400),
    		   new Transaction(mario, 2012, 710),
    		   new Transaction(mario, 2012, 700),
    		   new Transaction(alan, 2012, 950)
    		);
    		
    
	/**
	* <b>Description:
	*     （1）:找出2011年发生的所有交易，并按交易额排序（从低到高）。
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
	      transactions.stream()
	          .filter(d -> d.getYear() == 2011)
	          .sorted((a,b) -> a.getValue() >= b.getValue() ? 1 : -1)
	          .collect(Collectors.toList()).forEach( System.out :: println);
		
	}
	
	/**
	* <b>Description:
	*     （2）: 交易员都在哪些不同的城市工作过？
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		transactions.stream().map(t -> t.getTrader())
		        .map(t -> t.getCity()).distinct()
		        .collect(Collectors.toList())
		        .forEach(System.out :: println);;
	}
	
	/**
	* <b>Description:
	*     （3）:查找所有来自于剑桥的交易员，并按姓名排序。
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test03() {
		transactions.stream().map(t -> t.getTrader())
		.filter(t -> t.getCity().equals("Cambridge")).sorted((a, b) -> a.getName().compareTo(b.getName()))
		.distinct()
		.collect(Collectors.toList()).forEach( System.out :: println);
	}
	
	/**
	* <b>Description:
	*     （4）:返回所有交易员的姓名字符串，按字母顺序排序。
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test04() {
		transactions.stream()
		   .map(t -> t.getTrader()).map(t -> t.getName())
		   .sorted()
		   .distinct()
		   .collect(Collectors.toList()).forEach( System.out :: println);
	}
	
	/**
	* <b>Description:
	*     （5）: 有没有交易员是在米兰工作的？
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test05() {
		Traders trader = transactions.stream()
		   .map(t -> t.getTrader())
		   .filter(t -> t.getCity().equals("Milan")).findFirst().orElse(null);
		System.out.println(trader);
	}
	
	/**
	* <b>Description:
	*     （6）:打印生活在剑桥的交易员的所有交易额。
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test06() {
		Integer sum = transactions.stream()
		.filter(t -> t.getTrader().getCity().equals("Cambridge"))
		.map(t -> t.getValue())
		.reduce(Integer :: sum)
		.orElse(0);
		System.out.println(sum);
	}
	
	/**
	* <b>Description:
	*     （7）:所有交易中，最高的交易额是多少？
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test07() {
		Optional<Integer> max = transactions.stream()
		   .map(t -> t.getValue())
		   .reduce(Integer :: max);
		System.out.println(max.orElse(0));
	}
	
	/**
	* <b>Description:
	*     （8）:找到交易额最小的交易。
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月6日 上午9:37:30
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test08() {
		Transaction transa = transactions.stream()
		  .sorted((a,b) -> a.getValue() >= b.getValue()? 1 : -1)
		  .findFirst().orElse(null);
		System.out.println(transa);
	}
	
	
}
