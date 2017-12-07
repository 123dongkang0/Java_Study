package com.effictive03;

import java.awt.Color;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第8条：覆盖equals时请遵守通用约定 
 */
public class Example008 {
  public static void main(String args[]){
	  CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
	  String s = "polish";
	  //这显然违反了对称性
	  System.out.println(cis.equals(s));
	  System.out.println(s.equals(cis));
	  
	  //=======创建一个普通点和一个有色点============================
	  System.out.println("==========================================");
	  Point p = new Point(1, 2);
	  ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
	 
	  System.out.println("==============================");
	  
	  ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
	  Point p4 = new Point(1, 2);
	  ColorPoint p5 = new ColorPoint(1, 2, Color.RED);
	  //这显然违反了传递性
	  System.out.println(p3.equals(p4));
	  System.out.println(p4.equals(p5));
	  System.out.println(p3.equals(p5));
	  
	  Point p6 = new Point(1, 2);
	  CounterPoint p7 = new CounterPoint(1, 2);
	  System.out.println("========================");
	  System.out.println(p7 instanceof Point);
	  System.out.println(p6.getClass());
	  System.out.println(p7.getClass());
  }
}

/**
 * 对称性 ：下面举一个反例
 *   实现一个区分大小写的字符串
 */
final class CaseInsensitiveString{
	private final String s;
	
	public CaseInsensitiveString(String s){
	  if(s == null)
		  throw new NullPointerException();
	  this.s = s;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
		if(o instanceof String)
			return s.equalsIgnoreCase((String)o);
		return false;
	}
}

/**
 * 传递性 
 */
class Point{
   private final int x;
   private final int y;
   
   public Point(int x, int y){
	   this.x = x;
	   this.y = y;
   }
   
   /**
    * 编写一个方法，检验某个整值点是否在单位圆内
    */
   private static final Set<Point> unitCircle;
   static{
	   unitCircle = new HashSet<Point>();
	   unitCircle.add(new Point(1, 0));
	   unitCircle.add(new Point(0, 1));
	   unitCircle.add(new Point(-1, 0));
	   unitCircle.add(new Point(0, -1));
   }
   
   public static boolean onUnitCircle(Point p){
	   return unitCircle.contains(p);
   }
   
   @Override
   public boolean equals(Object o){
	   if(!(o instanceof Point))
		   return false;
	   Point p = (Point)o;
	   return p.x == x && p.y == y;
   }
}

/**
 * 扩展Point类，为一个点添加颜色信息：
 */
class ColorPoint extends Point{
    
	private final Color color;
    
	public ColorPoint(int x, int y, Color color) {
		super(x, y);
        this.color = color;
	}
	
    @Override
    /* 第一种写法
    public boolean equals(Object o){
	   if(!(o instanceof ColorPoint))
		   return false;
	   Point p = (Point)o;
	   return super.equals(o)&& ((ColorPoint)o).color == color;
    }
	*/
    public boolean equals(Object o){
 	   if(!(o instanceof Point))
 		   return false;

       
 	   //如果是一个普通点，和Point激进型比较
 	   if(!(o instanceof ColorPoint)){
 		   return o.equals(this);
 	   }
 	   
 	   //如果是一个有颜色的点，进行全方位的比较
 	   return super.equals(o)&& ((ColorPoint)o).color == color;
     }
	
}

class CounterPoint extends Point{
	private static final AtomicInteger counter = new AtomicInteger();
	
	public CounterPoint(int x, int y){
		super(x, y);
		counter.incrementAndGet();
	}
	
	public int numberCreated(){
		return counter.get();
	}
}
/**
 * 里氏替换原则：一个类型的任何重要的属性也将适用于它的子类型 
 */


