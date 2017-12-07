package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.12.3 参数协变：
 * 
 *    1.什么是参数协变？
 *      逆变、协变描述类型转换之间的关系。
 *      
 *      在介绍逆变、协变之前，必须先了解Liskov原则：
 *         所有子类必须能够透明的使用其父类(基类)的方法。
 *         
 *      使用  A、B 表示类型
 *           f(.) 表示类型转换
 *           < 表示继承关系（A<B 表示B是A的父类）
 *      
 *      f(.)是逆变的， 当 A<B的时候有  f(B)<f(A)成立 ;
 *      f(.)是协变的， 当 A<B的时候有  f(A)<f(B)成立 ;
 *      
 *    2.参数斜边的作用？
 */
public class Example0123 {
    public static void main(String args[]){
    	//1.数组，令f(A) = [A], 容易证明数组是协变的
    	Number[] a = new Integer[3];
    	  
    	//2.泛型的逆变、协变
    	//2.1 泛型的逆变由Super实现
    	List<? super Integer> list1 = new ArrayList<Number>();
    	//2.2泛型的协变由extends实现
    	List<? extends Number> list2 = new ArrayList<Integer>();
    	
    }
}


/**
 * 协变返回类型
 */
class Base{}
class Dervied extends Base{}

interface OrdinaryGetter{
	Base get();
}
interface DerviedGetter extends OrdinaryGetter{
	@Override
	Dervied get();
}

class CovariantReturnType{
	void test(DerviedGetter t){
		Dervied dervied = t.get();    //返回的是子类的类型
	}
}

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter>{}

class GenericReturnType{
	void test(Getter getter){
		Getter getter2 = getter.get();
	}
}

