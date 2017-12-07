package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.10 ͨ����� 
 */
public class Example010 {
  public static void main(String args[]){
	  /*===================1=================================*/
	  Fruit[] fruit = new Apple[10];
	  fruit[0] = new Apple();
	  fruit[1] = new Jonathan();
	  
	  /*
	   * �����ڲ��ᱨ�����б������͵���ҪĿ��֮һ���ǽ�
	   * ���ִ��������뵽������ 
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
	  //����ͨ������
	  //List<Fruit> flist = new ArrayList<Apple>();
	  
	  //��ʱ������Ҫ����������֮�佨��ĳ������ת�͹�ϵ��������ͨ���������ġ�
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




