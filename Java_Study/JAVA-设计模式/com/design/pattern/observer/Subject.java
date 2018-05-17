package com.design.pattern.observer;

/**
* <b>Description:
*     观察者模式：
*          主题接口
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.design.pattern.observer
* <br><b>ClassName:</b> Subject
* <br><b>Date:</b> 2018年5月17日 上午10:23:53
*/
public interface Subject {
	
	/**
	* <b>Description:
	*     注册观察者
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年5月17日 上午10:24:51
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void registerObserver(Observer o);
	/**
	* <b>Description:
	*    移除观察者
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年5月17日 上午10:25:06
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void removeObserver(Observer o);
	/**
	* <b>Description:
	*      登录观察者
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年5月17日 上午10:25:20
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public void notifyObserver();

}
