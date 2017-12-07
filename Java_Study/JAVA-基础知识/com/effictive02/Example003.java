package com.effictive02;

/**
 * ��3������˽�й���������ö������ǿ��Singleton���� 
 */
public class Example003 {
  public static void main(String args[]){
	  
  }
}


/**
 * ��һ�ַ��� (����ͨ��������ƴ����ڶ���ʵ������)
 */
class Elvis{
	public static final Elvis INSTANCE = new Elvis();
    private Elvis(){}
    public void leaveTheBuilding(){}
}


/**
 * �ڶ��ַ��������г�Ա�Ǿ�̬�������� 
 */
class Elvis2{
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2(){}
	public static Elvis2 getInstance(){return INSTANCE;}
	public void leaveTheBuilding(){}
}

/**
 * ��ѷ��� 
 */
enum Elivis{
	INSTANCE;
	public void leaveTheBuilding(){}
}