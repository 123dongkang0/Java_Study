package com.design.pattern.observer;

/**
* <b>Description:
*     �۲���ģʽ��
*          ����ӿ�
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> Subject
* <br><b>Date:</b> 2018��5��17�� ����10:23:53
*/
public interface Subject {
	
	/**
	* <b>Description:
	*     ע��۲���
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��5��17�� ����10:24:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void registerObserver(Observer o);
	/**
	* <b>Description:
	*    �Ƴ��۲���
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��5��17�� ����10:25:06
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void removeObserver(Observer o);
	/**
	* <b>Description:
	*      ��¼�۲���
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��5��17�� ����10:25:20
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void notifyObserver();

}
