package com.effictive04;

import java.math.BigInteger;

/**
 * 第15条：使可变性最小化 
 * 
 *  String、BigInteger、BigDecimal等都是不可变类.
 *  
 *  优点：不可变类是线程安全的
 */
public class Example015 {
   public static void main(String args[]){
	   
	   //不仅可以共享不可变对象，甚至可以共享它们内部的信息。如
	   BigInteger bi = new BigInteger("254");
	   System.out.println(bi.negate());
   }
}

/**
 * 不可变类必须遵循下面的5条规则：
 * 
 * 1.不提供任何可以修改对象状态的方法。
 * 
 * 2.保证类不会被扩展。
 * 
 * 3.使所有的域都是final的。
 * 
 * 4.使所有的域都是私有的。
 * 
 * 5.确保对于任何可变组件的互斥访问。
 * 
 */
 final class Complex{
	 
	 private final double re;
	 private final double im;
	 
	 /**
	  *对于频繁使用到的值，可以设置成共有的静态final常量，如： 
	  */
	 public static final Complex ZERO = new Complex(0, 0);
	 public static final Complex ONE  = new Complex(1,0);
	 public static final Complex I = new Complex(0,1);
	 
	 public Complex(double re, double im){
		 this.re = re;
		 this.im = im;
	 }
	 
	 public double realPart(){return re;}
	 public double imaginaryPart(){ return im;}
	 
	 public Complex add(Complex c){
		 return new Complex(re + c.re, im + c.im);
	 }
	 
	 public Complex subtract(Complex c){
		 return new Complex(re - c.re, im - c.im);
	 }
	 
	 public Complex multiply(Complex c){
		 return new Complex(re * c.re - im * c.im, 
				            re * c.im + im * c.re);
	 }
	 
	 public Complex divide(Complex c){
		 return new Complex(re * c.re + im * c.im, 
				            re * c.im - im * c.re);
	 }
	 
	 @Override
	 public boolean equals(Object o){
		 if(o == this)
			 return true;
		 if(!( o instanceof Complex))
             return false;
		 Complex c = (Complex)o;
		 return Double.compare(re, c.re) == 0 &&
				Double.compare(im, c.im) == 0;
	 }
	 
	 @Override
	 public int hashCode(){
		 int result = 17 + hashDouble(re);
		 result = 31 * result + hashDouble(im);
		 return result;
	 }

	 private int hashDouble(double val) {
		long longBits = Double.doubleToLongBits(re);
		return (int)(longBits ^ (longBits >>> 32));
	 }
	 
	 @Override
	 public String toString(){
		 return "(" + re + " , " + im + ")";
	 }
 }
 
 /**
  * 为了确定不可变性，类绝对不愿徐自身被子类化。除了final这种方法之外。
  * 还有一种更加灵活的方法做到这一点。
  */
 class Complex2{
	 private final double re;
	 private final double im;
	 
	 private Complex2(double re, double im){
		 this.re = re;
		 this.im = im;
	 }
	 
	 public static Complex2 valueOf(double re, double im){
		 return new Complex2(re, im);
	 }
	 
	 public static Complex2 valueOfPolar(double r, double theta){
		 return new Complex2(r * Math.cos(theta),
				             r * Math.sin(theta));
	 }
 }
 
