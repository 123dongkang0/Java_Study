package com.java8.model;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
    
}
