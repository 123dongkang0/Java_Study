package com.java8.param;

import java.util.ArrayList;
import java.util.List;

import com.java8.model.Apple;

/**
* <b>Description:�ڶ��£�ͨ����Ϊ���������ݴ���</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java8.param
* <br><b>ClassName:</b> param_02
* <br><b>Date:</b> 2018��3��7�� ����11:52:50
*/
public class param_02 {
   
	
	/**
	* <b>Description:2.2 ��Ϊ������
	*     ����Apple��ĳЩ���ԣ�����������ɫ���� ��������150���𣿣�������һ��booleanֵ��
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��3��7�� ����11:53:25
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	* <p>��֮���ѧϰ�����ǿ���ͨ��Lambda���ʽ������ַ�ʽ</p>
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

//����ѡ���ص�ƻ��
class AppleHeavyWeightPredicate implements ApplePredicate{
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}

//����ѡ���̵�ƻ��
class AppleGreenColorPredicate implements ApplePredicate{
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}
}