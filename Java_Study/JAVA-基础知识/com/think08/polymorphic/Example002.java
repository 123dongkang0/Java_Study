package com.think08.polymorphic;

import java.util.Random;

import org.junit.Test;

/**
 * 8.2 转机 
 *    我们可以看到，编译器无法知道Shape引用指向Circle、Square或Triangle对象？
 *  为了解决这个问题，java引入了动态绑定的概念。
 *  
 *   1）动态绑定：有叫做后期绑定
 *      在运行时根据对象的类型进行绑定。
 *      Java中除了static方法和final方法(private方法属于final方法）之外，其它所有的方法都是动态绑定的
 *      
 *   2）我们可以直观的看到，通过向上转型，程序可以获得非常好的扩展性
 */
public class Example002 {
    
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	@Test
	public void testShpaes(){
		Shape[] s = new Shape[9];
		for(int i=0; i<s.length; i++)
			s[i] = gen.next();
		for(Shape shp : s)
			shp.draw();
	}
}

/**
 * 1)、在这里我们来观察一个集合形状的例子
 *                Shape
 *       __________________________
 *      |           |              |
 *  Circle() 圆     Square() 正方形      Triangle() 三角形        
 */
 
class Shape{
	//绘制
	public void draw(){}
	//清除
	public void erase(){}   
}

class Circle extends Shape{
	public void draw(){
		 System.out.println("Circle.draw()");
	}
	public void erase(){
		 System.out.println("Circle.erase()");
	}   
}

class Square extends Shape{
	public void draw(){
		 System.out.println("Square.draw()");
	}
	public void erase(){
		 System.out.println("Square.erase()");
	}   
}

class Triangle extends Shape{
	public void draw(){
		 System.out.println("Triangle.draw()");
	}
	public void erase(){
		 System.out.println("Triangle.erase()");
	}   
}


class RandomShapeGenerator{
	private Random rand = new Random(47);
	public  Shape next(){
		//向上转型是在这里发生的
		switch(rand.nextInt(3)){
		  default:
		  case 0 : return new Circle();
		  case 1 : return new Square();
		  case 2 : return new Triangle();
		}
	}
}