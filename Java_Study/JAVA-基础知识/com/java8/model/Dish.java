package com.java8.model;

public class Dish {
    
	public enum Type{ MEAT, FISH, OTHER }
	
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	
	public Dish(
			String name,
			boolean vegetarianm,
			int calories,
			Type type
			) {
		this.name = name;
		this.vegetarian = vegetarianm;
		this.calories = calories;
		this.type = type;
		
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

    

	
}
