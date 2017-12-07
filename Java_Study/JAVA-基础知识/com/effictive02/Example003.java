package com.effictive02;

/**
 * 第3条：用私有构造器或者枚举类型强化Singleton属性 
 */
public class Example003 {
  public static void main(String args[]){
	  
  }
}


/**
 * 第一种方法 (可以通过反射机制创建第二个实例出来)
 */
class Elvis{
	public static final Elvis INSTANCE = new Elvis();
    private Elvis(){}
    public void leaveTheBuilding(){}
}


/**
 * 第二种方法，共有成员是静态工厂方法 
 */
class Elvis2{
	private static final Elvis2 INSTANCE = new Elvis2();
	private Elvis2(){}
	public static Elvis2 getInstance(){return INSTANCE;}
	public void leaveTheBuilding(){}
}

/**
 * 最佳方法 
 */
enum Elivis{
	INSTANCE;
	public void leaveTheBuilding(){}
}