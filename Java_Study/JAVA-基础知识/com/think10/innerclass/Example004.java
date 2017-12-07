package com.think10.innerclass;

/**
 *10.4 内部类与向上转型
 *   私有化内部类，可以很好的隐藏实现细节。
 */
public class Example004 {
  public static void main(String args[]){
	  Parcel4 p = new Parcel4();
	  Contents c = p.contents();
	  Destination d = p.destination("Tasmania");
	  
	  //这是非法的，因为内部类 PContents 是 private
	  //Parcel4.PContents pc = p.new PContents();
  }
}

interface Destination{
	String readLabel();
}

interface Contents{
	int value();
}

class Parcel4{
	
	/**
	 *只有Parcel4和其子类才能访问它 
	 */
	protected class PDestination implements Destination{
		private String label;
		
		private PDestination(String whereTo){
			label = whereTo;
		}
		
		public String readLabel() {
			return label;
		}
	}
	
	private class PContents implements Contents{
		private int i = 11;

		public int value() {
			return i;
		}
	}
	
	public Destination destination(String s){
		return new PDestination(s);
	}
	
	public Contents contents(){
		return new PContents();
	}
}

