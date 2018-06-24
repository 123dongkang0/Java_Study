package com.design.pattern.celue;

/**
 *公交车计算策略 
 */
class BusStrategy implements CalculateStrategy{

	public int calculatePrice(int distance) {
		int extraDistance = distance - 10,
		    price = extraDistance<=0?10:(10 + extraDistance *2);
		return price;
	}
	
}
