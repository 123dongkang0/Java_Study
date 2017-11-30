package com.think15.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 *在这里我们来使用泛型构建一个商店模型(包含走廊、货架、商品) 
 */
public class Example0061 {
  public static void main(String args[]){
	  System.out.println(new Store(4, 5, 10));
  }
}

/**
 *商品 
 */
class Produce{
	private final int id;
	private String description;
	private double price;
    
	public Produce(int id, String description, double price){
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
	public String toString(){
		return "ID:" + id + ", DESCRIPTION:" + description + ", PRICE" + price ;
	}
	
	public void priceChange(double change){
		price += change;
	}
	
	public static Generator<Produce> generator = 
			new Generator() {
		        private Random rand = new Random(47);
				public Produce next() {
					return new Produce(rand.nextInt(1000),"Test",Math.round(rand.nextDouble() * 1000.0) + 0.99);
				}
			};
	
}

/**
 *货架
 */
class Shelf extends ArrayList<Produce>{
	public Shelf(int nProducts){
		Generators.fill(this, Produce.generator, nProducts);
	}
}

/**
 *通道、走廊 
 */
class Aisle extends ArrayList<Shelf>{
	public Aisle(int nShelves, int nproducts){
		for(int i=0; i<nShelves;i++){
			add(new Shelf(nproducts));
		}
	}
}

class CheckoutStand{}

class Office{}

class Store extends ArrayList<Aisle>{
	public Store(int nAisles,int nShelves, int nproducts){
		for(int i=0; i<nAisles; i++){
			add(new Aisle(nShelves,nproducts));
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Aisle a : this){
			for(Shelf s : a){
				for(Produce p : s){
					result.append(p);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}
}

