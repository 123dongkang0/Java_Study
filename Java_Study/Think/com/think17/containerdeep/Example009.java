package com.think17.containerdeep;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *17.9 ɢ����ɢ����
 *  Object.equals()ֻ�ǶԽǶ���ĵ�ַ��
 */
public class Example009 {
   public static void main(String args[]) throws Exception{
	   SpringDetector.detectSpring(Groundhog.class);
	   SpringDetector.detectSpring(Groundhog2.class);
   }
}

/**
 * ���������ʹ��һ������Ԥ��ϵͳΪ����������˵����
 * ����HashMap�࣬ʹ��Groundhog��key��ʹ��Prediction��value
 *    Groundhog(������)
 *    Prediction(Ԥ��)  
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
 * ��������hashCode() �� equals������ 
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



