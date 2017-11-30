package com.think17.containerdeep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.9.3 覆盖hashCode()
 *    设计hashCode 时最重要的因素就是无论何时同一个对象调用hashCode都应该生成同样的值。
 */
public class Example0093 {
   public static void main(String args[]){
	   //String的hashCode明显是基于String的内容的
	   String[] hellos = "Hello Hello".split(" ");
	   System.out.println(hellos[0].hashCode());
	   System.out.println(hellos[1].hashCode());
	   
	   //
	   Map<CountedString,Integer> map = new HashMap<CountedString, Integer>();
	   CountedString[] cs = new CountedString[5];
	   for(int i=0; i<cs.length; i++){
		   cs[i] = new CountedString("hi ");
		   map.put(cs[i], i);
	   }
	   System.out.println(map);
	   for(CountedString cstring : cs){
		   System.out.println("Looking up" + cstring);
		   System.out.println(map.get(cstring));
	   }
    }
}


class CountedString{
	private static List<String> created = new ArrayList<String>();
	private String s;
	private int id = 0;
	
	public CountedString(String str){
		s = str;
		created.add(s);
		for(String s2 : created){
			if(s2.equals(s)){
				id++;
			}
		}
	}
	
	public String toString(){
		return "String:" + s + " id: " + id + " hashCode(): " + hashCode();
	}
	
	public int hashCode(){
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}
	
	public boolean equals(Object o){
		return o instanceof CountedString &&
			   s.equals(((CountedString)o).s) &&
			   id == ((CountedString)o).id;
	}
}