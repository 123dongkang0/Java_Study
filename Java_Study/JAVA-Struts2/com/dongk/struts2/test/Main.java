package com.dongk.struts2.test;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
      public static void main(String args[]){
		Person p = new Person();
         changStr(p);
         System.out.println(p.str);
      }
      
      public static void changStr(Person p){
    	 // p = new Person();
    	 p.str = "bb";
      }
}

class Person{
	public String str = "aa";
}
