package com.java8.model;

import java.util.Arrays;
import java.util.List;

import com.java8.model.Dish;

public class StreamConstant {

	//≤ÀÎ»¡–±Ì
	public static List<Dish> menu = Arrays.asList(
			   new Dish("pork", false, 800, Dish.Type.MEAT), 
			   new Dish("beef", false, 700, Dish.Type.MEAT), 
			   new Dish("chicken", false, 400, Dish.Type.MEAT), 
			   new Dish("french fries", true, 530, Dish.Type.OTHER), 
			   new Dish("rice", true, 350, Dish.Type.OTHER), 
			   new Dish("season fruit", true, 120, Dish.Type.OTHER), 
			   new Dish("pizza", true, 550, Dish.Type.OTHER), 
			   new Dish("prawns", false, 300, Dish.Type.FISH), 
			   new Dish("salmon", false, 450, Dish.Type.FISH)
			);
	
	public  static List<Apple> inventory = Arrays.asList(
			   new Apple(85, "red"),
			   new Apple(56, "deep red"),
			   new Apple(98, "deep green"),
			   new Apple(298, "yellow")
			);
}
