package com.think10.innerclass;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;


/**
 *10.5 在方法和作用域内的内部类 
 */
public class Example005 {
    public static void main(String args[]){
    	Parcel5 p5 = new Parcel5();
    	Destination d = p5.destination("Tasmania");
    	
    	Parcel6 p6 = new Parcel6();
    	p6.track();
    }
}

class Parcel5{
	public Destination destination(String s){
		class pDestination implements Destination{
			private String label;
			public pDestination(String whereTo){
				label = whereTo;
			}
			public String readLabel() {
				return label;
			}
		}

		return new pDestination(s);
	}
}

/**
 * 在任何作用域中嵌入一个内部类 ，但是这并不是说明该类的创建是有条件的，它其实与别的类一起编译过了。
 */

class Parcel6{
	private void internalTracking(boolean b){
		if(b){
			class TrackingSlip{
				 private String id;
				 TrackingSlip(String s){
					 id =s;
				 }
				 String getSlip(){
					 return id;
				 }
			}
			
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
	}
	
	public void track(){
		internalTracking(true);
	}
}

