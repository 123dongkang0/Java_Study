package com.think10.innerclass;

/**
 *10.1 创建内部类 
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
 *这种情况相比较第一种更加典型 
 *  外部类拥有一个方法，该方法返回一个指向内部类的引用，就像to() 和 context() 那样子
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
