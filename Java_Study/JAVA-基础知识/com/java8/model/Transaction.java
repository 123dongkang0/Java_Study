package com.java8.model;

/**
* <b>Description:
*    交易
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java8.model
* <br><b>ClassName:</b> Transaction
* <br><b>Date:</b> 2018年6月6日 上午9:45:44
*/
public class Transaction {
   
	private final Traders trader;
    private final int year;
    private final int value;
    
    public Transaction(Traders trader, int year, int value) {
    	this.trader = trader;
    	this.year = year;
    	this.value = value;
    }

	public Traders getTrader() {
		return trader;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}
    
	public String toString(){ 
		 return "{" + this.trader + ", " + 
		 "year: "+this.year+", " + 
		 "value:" + this.value +"}"; 
		 } 
}
