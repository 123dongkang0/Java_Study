package com.think15.generics;

import java.util.Date;

/**
 * 15.15 混型
 *   1.什么是混型？
 *      混合多种类的能力{可以将特性和行为一致的应用到多个类上，因此，当你修改某一个特性或者行为的时候。
 *                     就会应用在混型所有的类上面。}
 *   
 *   2.混型如何实现？
 *   
 */
public class Example015 {
   public static void main(String args[]){
	   Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
	   mixin1.set("test string 1");
	   mixin2.set("test string 2");
	   System.out.println(mixin1.get() + " " + mixin1.getStamp() + " " + mixin1.getSerialNumber());
	   System.out.println(mixin2.get() + " " + mixin2.getStamp() + " " + mixin2.getSerialNumber());
   }
}


/**
 * 》1.和接口混合 
 */
/**
 * 时间戳 
 */
interface TimeStamped{long getStamp();}
class TimeStampedImp implements TimeStamped{
	private static long timestamp;
	public TimeStampedImp(){
		timestamp = new Date().getTime();
	}
	public long getStamp() {
		return timestamp;
	}
}

/**
 * 数字戳 
 */
interface SerialNumbered{long getSerialNumber();}
class SerialNumberedImp implements SerialNumbered{
    private static long count = 1;
    private final static long serialNumber = count++;
	public long getSerialNumber() {
		return serialNumber;
	}
}

interface Basic{
	public void set(String val);
	public String get();
}
class BasicImp implements Basic{
    private String value;
	public void set(String val) {
         value = val;
	}
	public String get() {
		return value;
	}
}

class Mixin extends BasicImp implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberedImp();
	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}
	public long getStamp() {
		return timeStamp.getStamp();
	}
}