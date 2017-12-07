package com.effictive04;

/**
 * 第20条： 类层次优于标签类 
 */
public class Example020 {
  public static void main(String args[]){
	  
  }
}

/**
 * 一个既可以表示椭圆又可以表示矩形的类 
 * 标签类过于冗长、容易出错且效率低下。
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
 * 使用层次类替换标签类 
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