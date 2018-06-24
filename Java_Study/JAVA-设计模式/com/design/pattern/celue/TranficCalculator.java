package com.design.pattern.celue;

/**
 *  »·¾³Context½ÇÉ«
 */
class TranficCalculator{
	
	public CalculateStrategy strategy;
	
	public TranficCalculator(){}
	
	public void setCalculateStrategy(CalculateStrategy strategy){
		this.strategy = strategy;
	}
	
	public int calculatePrice(int distance){
		return strategy.calculatePrice(distance);
	}
}
