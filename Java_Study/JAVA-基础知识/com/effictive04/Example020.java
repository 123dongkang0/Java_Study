package com.effictive04;

/**
 * ��20���� �������ڱ�ǩ�� 
 */
public class Example020 {
  public static void main(String args[]){
	  
  }
}

/**
 * һ���ȿ��Ա�ʾ��Բ�ֿ��Ա�ʾ���ε��� 
 * ��ǩ������߳������׳�����Ч�ʵ��¡�
 */
class Figure{
	
	enum Shape{RECTRANGLE, CIRCLE};
	
	final Shape shape;
	
	double length;
	double width;
	
	double radius;
	
	public Figure(double radius){
		shape = Shape.CIRCLE;
		this.radius = radius;
	}
	
	public Figure(double length,double width){
		shape = Shape.RECTRANGLE;
		this.length = length;
		this.width = width;
	}
	
	double area(){
		switch(shape){
		    case RECTRANGLE : return length * width;
		    case CIRCLE: return Math.PI * (radius + radius);
		    default:
		    	throw new AssertionError();
		}
	}
}

/**
 * ʹ�ò�����滻��ǩ�� 
 */
abstract class Figure2{
	abstract double area();
}

class Circle extends Figure2{
    
	public final double radius;
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	double area() {
		return Math.PI * (radius + radius);
	}
	
}

class Rectangle extends Figure2{
    
	public final double length;
	public final double width;
	
	public Rectangle(double length,double width){
		this.length = length;
		this.width = width;
	}
	
	double area() {
		return length * width;
	}
	
}