package com.design.pattern.observer;

public class Main {

	 public static void main(String args[]) {
		 try {
			 WeatherData weateher = new WeatherData();
			 CurrentConditionsDisplay current = new CurrentConditionsDisplay(weateher);
			 
			 weateher.setMeasurements(80, 65, 30.4f);
			 Thread.sleep(1000);
			 
			 weateher.setMeasurements(70, 55, 32.4f);
			 Thread.sleep(1000);
			 
			 weateher.setMeasurements(84, 62, 34.4f);
			 Thread.sleep(1000);
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
