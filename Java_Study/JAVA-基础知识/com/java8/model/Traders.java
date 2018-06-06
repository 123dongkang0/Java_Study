package com.java8.model;

/**
* <b>Description:
*    交易员
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java8.model
* <br><b>ClassName:</b> Traders
* <br><b>Date:</b> 2018年6月6日 上午9:42:34
*/
public class Traders {
        
	  private final String name;
	  private final String city;
	  
	  public Traders (String name, String city) {
		  this.name = name;
		  this.city = city;
	  }

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Trader:" + this.name + "  in " + this.city;
	}
	  
	  
}
