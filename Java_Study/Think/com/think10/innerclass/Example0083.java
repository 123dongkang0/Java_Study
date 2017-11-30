package com.think10.innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 *10.8.2 �ڲ�������ƿ��
 *    
 *    Ӧ�ó����ܣ���������Խ��ĳЩ�ض������һ�����һ���࣬
 *  Ҫ����ĳ��Ӧ�ó����ܣ�ͨ���̳�һ�����߶���࣬���Ҹ���ĳЩ������
 *    
 */
public class Example0083 {
   public static void main(String args[]){
	   GreenhouseControls gc = new GreenhouseControls();
	   gc.addEvent(gc.new Bell(900));
	   Event[] eventList={
			   gc.new ThermostatNight(0),
			   gc.new LightOn(200),
			   gc.new LightOff(400),
			   gc.new WaterOn(600),
			   gc.new LightOff(800),
			   gc.new ThermostatDay(1400)
	   };
	   gc.addEvent(gc.new Restart(2000, eventList));
	   gc.addEvent(new GreenhouseControls.Terminate(10000000));
	   gc.run();
   }
}

abstract class Event{
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime){
		this.delayTime = delayTime;
	    start();
	}
	public void start(){
		eventTime = System.nanoTime() + delayTime;
	}
	public boolean ready(){
		return System.nanoTime() >= eventTime;
	}
	public abstract void action();
}

class Controller{
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c){
		eventList.add(c);
	}
	public void run(){
		while(eventList.size()>0){
			for(Event e : new ArrayList<Event>(eventList)){
				if(e.ready()){
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
}

class GreenhouseControls extends Controller{
	/*
	 *�ƵĿ��ؿ��� 
	 */
	private boolean light = false;
	public class LightOn extends Event{
		public LightOn(long delayTime){
			super(delayTime);
		}
		public void action() {
			light = true;
		}
		public String toString(){
			return "Greehouse light is on";
		}
	}
	public class LightOff extends Event{
		public LightOff(long delayTime){
			super(delayTime);
		}
		public void action() {
			light = false;
		}
		public String toString(){
			return "Greehouse light is off";
		}
	}
	
	/*
	 *ˮ�Ŀ��ؿ��� 
	 */
	private boolean water = false;
	public class WaterOn extends Event{
		public WaterOn(long delayTime){
			super(delayTime);
		}
		public void action() {
			water = true;
		}
		public String toString(){
			return "Greehouse water is on";
		}
	}
	public class WaterOff extends Event{
		public WaterOff(long delayTime){
			super(delayTime);
		}
		public void action() {
			water = false;
		}
		public String toString(){
			return "Greehouse water is off";
		}
	}
	
	/*
	 *�¶ȵ��ڿ��� 
	 */
	private String thermostat = "Day";
	public class ThermostatNight extends Event{
		public ThermostatNight(long delayTime){
			super(delayTime);
		}
		public void action() {
			thermostat = "Night";
		}
		public String toString(){
			return "Thermostat on night setting!";
		}
	}
	public class ThermostatDay extends Event{
		public ThermostatDay(long delayTime){
			super(delayTime);
		}
		public void action() {
			thermostat = "Day";
		}
		public String toString(){
			return "Thermostat on day setting!";
		}
	}
	
	/*
	 *���� 
	 */
	public class Bell extends Event{
		public Bell(long delayTime){
			super(delayTime);
		}
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString(){
			return "Bing!";
		}
	}
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList){
			super(delayTime);
			this.eventList = eventList;
			for(Event e : eventList){
				addEvent(e);
			}
		}
		public void action() {
			for(Event e: eventList){
				e.start();  //����ÿһ���¼�
				addEvent(e);
			}
			start(); //�������ʱ��
			addEvent(this);
		}
		public String toString(){
			return "Restarting System";
		}
	}
	
	public static class Terminate extends Event{
        public Terminate(long delayTime){
        	super(delayTime);
        }
		public void action() {
			System.exit(0);
		}
		public String toString(){
			return "Terminating";
		}
	}
}