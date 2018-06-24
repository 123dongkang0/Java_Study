package com.design.pattern.celue;

/**
 *µØÌú¼ÆËã²ßÂÔ 
 */
class SubwayStrategy implements CalculateStrategy{

	public int calculatePrice(int distance) {
		if(distance <= 6){
			return 3;
		}else if(distance > 6 && distance <= 12){
			return 4;
		}else if(distance > 12 && distance <= 22){
			return 5;
		}else{
			return 6;
		}
	}
	
}
