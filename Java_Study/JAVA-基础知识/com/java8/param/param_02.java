package com.java8.param;

import java.util.ArrayList;
import java.util.List;

import com.java8.model.Apple;

/**
* <b>Description:第二章：通过行为参数化传递代码</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java8.param
* <br><b>ClassName:</b> param_02
* <br><b>Date:</b> 2018年3月7日 上午11:52:50
*/
public class param_02 {
   
	
	/**
	* <b>Description:2.2 行为参数化
	*     根据Apple的某些属性（比如它是绿色的吗？ 重量超过150克吗？）来返回一个boolean值；
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年3月7日 上午11:53:25
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	* <p>在之后的学习中我们可以通过Lambda表达式替代这种方式</p>
	*/
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				 result.add(apple);
			}
		}
		return result;
	}
	
}

interface ApplePredicate{
	boolean test(Apple apple);
}

//仅仅选出重的苹果
class AppleHeavyWeightPredicate implements ApplePredicate{
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}

//仅仅选出绿的苹果
class AppleGreenColorPredicate implements ApplePredicate{
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}