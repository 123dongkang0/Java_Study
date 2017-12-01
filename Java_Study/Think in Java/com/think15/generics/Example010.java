package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.10 通配符？ 
 */
public class Example010 {
  public static void main(String args[]){
	  /*===================1=================================*/
	  Fruit[] fruit = new Apple[10];
	  fruit[0] = new Apple();
	  fruit[1] = new Jonathan();
	  
	  /*
	   * 编译期不会报错，运行报错，泛型的主要目的之一就是将
	   * 这种错误检测移入到编译期 
	   */
	  try{
		  fruit[0] = new Fruit();
	  }catch(Exception e){
		  System.out.println(e);
	  }
	  
	  try{
		  fruit[0] = new Orange();
	  }catch(Exception e){
		  System.out.println(e);
	  }
	  
	  /*===================2=================================*/
	  //不能通过编译
	  //List<Fruit> flist = new ArrayList<Apple>();
	  
	  //有时候你想要在两个类型之间建立某种向上转型关系，这正是通配符所允许的。
      List<? extends Fruit> flist = new ArrayList<Apple>();
     // flist.add(new Apple());
     // flist.add(new Fruit());
     // flist.add(new Object());
      Fruit f = flist.get(0);
  
  }
}


class Fruit{}

class Apple extends Fruit{}
class Jonathan extends Apple{}

class Orange extends Fruit{}




