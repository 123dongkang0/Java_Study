package com.design.pattern.observer;

/**
* <b>Description:
*      �۲���֮һ
*         ��ʾ��ǰ����������  
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> CurrentConditionsDisplay
* <br><b>Date:</b> 2018��5��17�� ����10:40:49
*/
public class CurrentConditionsDisplay implements Observer, DisplayElement{
	
	private float temperature;
	private float humidity;
	private Subject weatherData;   //��������

	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
       System.out.println("CurrentConditionsDisplay : { �¶� ��" + temperature
    		                                        +  "ʪ�� ��" + humidity
    		                                        + " }");		
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
	}

}
