package com.effictive02;
/**
 *第2条：遇到多个构造器参数的时候需要考虑构造器。
 * 
 */
public class Example002 {
   public static void main(String args[]){
	   NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).
			                     calories(100).sodium(35).carbohydrate(27).build();
   }
}

class NutritionFacts{
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	public static class Builder{
		//必须的参数
	    private final int servingSize;
	    private final int servings;
	    
	    //可选择的参数-初始化默认值
	    private  int calories = 0;
		private  int fat = 0;
		private  int sodium = 0;
		private  int carbohydrate = 0;
		
		public Builder(int servingSize,int servings){
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val){
			calories = val;
			return this;
		}
		public Builder fat(int val){
			fat = val;
			return this;
		}
		public Builder sodium(int val){
			sodium = val;
			return this;
		}
		public Builder carbohydrate(int val){
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder){
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}

/**
 *使用抽象 
 */
interface Builder<T>{
	public T build();
}


