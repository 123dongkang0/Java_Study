package com.design.pattern.observer;

/**
* <b>Description:
*     观察者模式：
*          观察者接口
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> Observer
* <br><b>Date:</b> 2018年5月17日 上午10:26:17
*/
public interface Observer {
   public void update(float temp, float humidity, float pressure);
}
