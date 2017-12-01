package com.think10.innerclass;

/**
 *10.1 �����ڲ��� 
 */
public class Example001 {
   public static void main(String args[]){
	   Parcel1 p = new Parcel1();
	   p.ship("11");
   }
}

class Parcel1{
	
	class Contents {
		private int i = 11;
		public int value(){return i;}
	}
	
	class Destination{
		private String label;
		Destination(String whereTo){
			label = whereTo;
		}
		String readLabel(){return label;}
	}
	
	public void ship(String dest){
		Contents c = new Contents();
		Destination d = new Destination(dest);
		
		System.out.println(d.readLabel());
	}
}

/**
 *���������Ƚϵ�һ�ָ��ӵ��� 
 *  �ⲿ��ӵ��һ���������÷�������һ��ָ���ڲ�������ã�����to() �� context() ������
 */
class Parcel2{
	
	class Contents {
		private int i = 11;
		public int value(){return i;}
	}
	
	class Destination{
		private String label;
		Destination(String whereTo){
			label = whereTo;
		}
		String readLabel(){return label;}
	}
	
	public Destination to(String s){
		return new Destination(s);
	}
	
	public Contents contents(){
		return new Contents();
	}
	
	public void ship(String dest){
		Contents c = contents();
		Destination d = to(dest);
		
		System.out.println(d.readLabel());
	}
}
