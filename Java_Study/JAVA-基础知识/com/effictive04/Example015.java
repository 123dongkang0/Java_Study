package com.effictive04;

import java.math.BigInteger;

/**
 * ��15����ʹ�ɱ�����С�� 
 * 
 *  String��BigInteger��BigDecimal�ȶ��ǲ��ɱ���.
 *  
 *  �ŵ㣺���ɱ������̰߳�ȫ��
 */
public class Example015 {
   public static void main(String args[]){
	   
	   //�������Թ����ɱ�����������Թ��������ڲ�����Ϣ����
	   BigInteger bi = new BigInteger("254");
	   System.out.println(bi.negate());
   }
}

/**
 * ���ɱ��������ѭ�����5������
 * 
 * 1.���ṩ�κο����޸Ķ���״̬�ķ�����
 * 
 * 2.��֤�಻�ᱻ��չ��
 * 
 * 3.ʹ���е�����final�ġ�
 * 
 * 4.ʹ���е�����˽�еġ�
 * 
 * 5.ȷ�������κοɱ�����Ļ�����ʡ�
 * 
 */
 final class Complex{
	 
	 private final double re;
	 private final double im;
	 
	 /**
	  *����Ƶ��ʹ�õ���ֵ���������óɹ��еľ�̬final�������磺 
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
  * Ϊ��ȷ�����ɱ��ԣ�����Բ�Ը���������໯������final���ַ���֮�⡣
  * ����һ�ָ������ķ���������һ�㡣
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
 
