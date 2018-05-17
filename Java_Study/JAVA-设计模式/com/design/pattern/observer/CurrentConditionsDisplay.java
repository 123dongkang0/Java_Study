package com.design.pattern.observer;

/**
* <b>Description:
*      观察者之一
*         显示当前的天气数据  
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> CurrentConditionsDisplay
* <br><b>Date:</b> 2018年5月17日 上午10:40:49
*/
public class CurrentConditionsDisplay implements Observer, DisplayElement{
	
	private float temperature;
	private float humidity;
	private Subject weatherData;   //天气主题

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
       System.out.println("CurrentConditionsDisplay : { 温度 ：" + temperature
    		                                        +  "湿度 ：" + humidity
    		                                        + " }");		
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
	}

}
