package com.think15.generics;

import java.awt.Color;

/**
 * 15.9 �߽� 
 */
public class Example009 {
   public static void main(String args[]){
	   Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
	   solid.color();
	   solid.getY();
	   solid.weight();
   }
}

/**
 * �߽�Ļ���Ҫ�� 
 */
interface HasColor{
	java.awt.Color getColor();
}

class Colored<T extends HasColor>{
	T item;
	
	Colored(T item){
		this.item = item;
	}
	
	T getItem(){return item;}
	
	java.awt.Color color(){
		return item.getColor();
	}
}

class Dimension{public int x, y, z;}

/**
 * �ظ��ı߽� 
 */
class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	
	ColoredDimension(T item){ this.item = item; }
	
	T getItem(){return item; }
	
	java.awt.Color color(){return item.getColor();}
	
	int getX(){return item.x;}
	
	int getY(){return item.y;}
	
	int getZ(){return item.z;}
} 


interface Weight{int weight();}

class Solid<T extends Dimension & HasColor & Weight>{
	T item;
	
	Solid(T item){
		this.item = item;
	}
	
	T getItem(){return item;}
	
    java.awt.Color color(){return item.getColor();}
	
	int getX(){return item.x;}
	
	int getY(){return item.y;}
	
	int getZ(){return item.z;}
	
	int weight(){return item.weight();}
	
}

class Bounded extends Dimension implements HasColor, Weight{
	public int weight() {
		return 0;
	}
	public Color getColor() {
		return null;
	}
}

/**
 *�ڼ̳е�ÿ���������ӱ߽����� 
 */

class HoldItem<T>{
	T item;
	HoldItem(T item){this.item = item;}
	T getItem(){return item;}
}

class Colored2<T extends HasColor> extends HoldItem<T>{
	Colored2(T item) {
		super(item);
	}
	java.awt.Color color(){ return item.getColor();};
}

class ColoredDimension2<T extends Dimension & HasColor> extends Colored2<T>{
	ColoredDimension2(T item) {
		super(item);
	}
    int getX(){return item.x;}
	int getY(){return item.y;}
	int getZ(){return item.z;}
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T>{
	Solid2(T item) {
		super(item);
	}
	int weight(){return item.weight();}
}
