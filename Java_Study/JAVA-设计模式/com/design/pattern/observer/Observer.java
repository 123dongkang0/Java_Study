package com.design.pattern.observer;

/**
* <b>Description:
*     �۲���ģʽ��
*          �۲��߽ӿ�
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> Observer
* <br><b>Date:</b> 2018��5��17�� ����10:26:17
*/
public interface Observer {
   public void update(float temp, float humidity, float pressure);
}
