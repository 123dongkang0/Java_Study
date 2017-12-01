package com.think10.innerclass;

import javax.swing.plaf.basic.BasicSliderUI.TrackListener;


/**
 *10.5 �ڷ������������ڵ��ڲ��� 
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
 * ���κ���������Ƕ��һ���ڲ��� �������Ⲣ����˵������Ĵ������������ģ�����ʵ������һ�������ˡ�
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

