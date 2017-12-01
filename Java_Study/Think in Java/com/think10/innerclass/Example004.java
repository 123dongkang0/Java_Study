package com.think10.innerclass;

/**
 *10.4 �ڲ���������ת��
 *   ˽�л��ڲ��࣬���Ժܺõ�����ʵ��ϸ�ڡ�
 */
public class Example004 {
  public static void main(String args[]){
	  Parcel4 p = new Parcel4();
	  Contents c = p.contents();
	  Destination d = p.destination("Tasmania");
	  
	  //���ǷǷ��ģ���Ϊ�ڲ��� PContents �� private
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
	 *ֻ��Parcel4����������ܷ����� 
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

