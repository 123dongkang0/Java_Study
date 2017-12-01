package com.think15.generics;

import java.util.Date;

/**
 * 15.15 ����
 *   1.ʲô�ǻ��ͣ�
 *      ��϶����������{���Խ����Ժ���Ϊһ�µ�Ӧ�õ�������ϣ���ˣ������޸�ĳһ�����Ի�����Ϊ��ʱ��
 *                     �ͻ�Ӧ���ڻ������е������档}
 *   
 *   2.�������ʵ�֣�
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
 * ��1.�ͽӿڻ�� 
 */
/**
 * ʱ��� 
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
 * ���ִ� 
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