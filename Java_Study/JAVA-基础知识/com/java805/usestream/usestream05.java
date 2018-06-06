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
*    5.5 ����ʵ��
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java805.usestream
* <br><b>ClassName:</b> usestream05
* <br><b>Date:</b> 2018��6��6�� ����9:36:27
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
	*     ��1��:�ҳ�2011�귢�������н��ף��������׶����򣨴ӵ͵��ߣ���
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��2��: ����Ա������Щ��ͬ�ĳ��й�������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��3��:�������������ڽ��ŵĽ���Ա��������������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��4��:�������н���Ա�������ַ���������ĸ˳������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��5��: ��û�н���Ա�������������ģ�
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��6��:��ӡ�����ڽ��ŵĽ���Ա�����н��׶
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��7��:���н����У���ߵĽ��׶��Ƕ��٣�
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
	*     ��8��:�ҵ����׶���С�Ľ��ס�
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��6�� ����9:37:30
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
