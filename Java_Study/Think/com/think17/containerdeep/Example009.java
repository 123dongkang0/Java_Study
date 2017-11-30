package com.think17.containerdeep;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *17.9 散列与散列码
 *  Object.equals()只是对角对象的地址。
 */
public class Example009 {
   public static void main(String args[]) throws Exception{
	   SpringDetector.detectSpring(Groundhog.class);
	   SpringDetector.detectSpring(Groundhog2.class);
   }
}

/**
 * 在这里，我们使用一个天气预报系统为例，来进行说明。
 * 创建HashMap类，使用Groundhog做key、使用Prediction做value
 *    Groundhog(土拨鼠)
 *    Prediction(预报)  
 */
class Groundhog{
	protected int number;
	public Groundhog(int n){
		number = n;
	}
	public String toString(){
		return "Groundhog # " + number;
	}
}

/**
 * 必须重载hashCode() 和 equals方法。 
 */
class Groundhog2 extends Groundhog{
	public Groundhog2(int n) {super(n);}
	public int hashCode(){return number;};
	public boolean equals(Object o){
		return o instanceof Groundhog2 && (number ==((Groundhog2)o).number);
	}
	
}


class Prediction{
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;
	public String toString(){
		if(shadow){
			return "Six more weeks of Winter";
		}else{
			return "Early Spring";
		}
	}
}


class SpringDetector{
	public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog,Prediction> map = new HashMap<Groundhog,Prediction>();
		for(int i=0; i<10; i++){
			map.put(ghog.newInstance(i), new Prediction());
		}
		System.out.println(" map = " + map);
		Groundhog gh = ghog.newInstance(3);
		System.out.println(" Looking up prediction for " + gh);
		if(map.containsKey(gh)){
			System.out.println(map.get(gh));
		}else{
			System.out.println("Key not found : " + gh);
		}
	}
}



