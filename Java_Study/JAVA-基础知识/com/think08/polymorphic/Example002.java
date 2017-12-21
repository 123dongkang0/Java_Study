package com.think08.polymorphic;

import java.util.Random;

import org.junit.Test;

/**
 * 8.2 ת�� 
 *    ���ǿ��Կ������������޷�֪��Shape����ָ��Circle��Square��Triangle����
 *  Ϊ�˽��������⣬java�����˶�̬�󶨵ĸ��
 *  
 *   1����̬�󶨣��н������ڰ�
 *      ������ʱ���ݶ�������ͽ��а󶨡�
 *      Java�г���static������final����(private��������final������֮�⣬�������еķ������Ƕ�̬�󶨵�
 *      
 *   2�����ǿ���ֱ�۵Ŀ�����ͨ������ת�ͣ�������Ի�÷ǳ��õ���չ��
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
 * 1)���������������۲�һ��������״������
 *                Shape
 *       __________________________
 *      |           |              |
 *  Circle() Բ     Square() ������      Triangle() ������        
 */
 
class Shape{
	//����
	public void draw(){}
	//���
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
		//����ת���������﷢����
		switch(rand.nextInt(3)){
		  default:
		  case 0 : return new Circle();
		  case 1 : return new Square();
		  case 2 : return new Triangle();
		}
	}
}