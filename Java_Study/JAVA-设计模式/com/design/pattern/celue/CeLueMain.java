package com.design.pattern.celue;

public class CeLueMain {
    
	//场景：计算公交车、地铁指定路程后所需要的票价；
	public static void main(String args[]) {
		 TranficCalculator calculator = new TranficCalculator();
          //设置计算策略
          calculator.setCalculateStrategy(new BusStrategy());
          //计算价格
           System.out.println("公交车乘12公里的价格：" + calculator.calculatePrice(12));
	}
}
