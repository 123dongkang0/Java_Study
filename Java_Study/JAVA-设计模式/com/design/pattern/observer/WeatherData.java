package com.design.pattern.observer;

import java.util.ArrayList;

/**
* <b>Description:
*     天气主题，实现主题接口
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> WeatherData
* <br><b>Date:</b> 2018年5月17日 上午10:28:47
*/
public class WeatherData implements Subject{
	
	private ArrayList<Observer> observers;   //观察者
	
	private float temperature;        //温度
	private float humidity;           //湿度
	private float pressure;           //气压
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
        for(Observer obs : observers) {
        	obs.update(temperature, humidity, pressure);
        }		
	}
	
	public void setMeasurements(float temperature,float humidity,float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObserver();
	}

}
