package com.dongk.thread.design016;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable{
	
	//共享缓存�?
	private BlockingQueue<Data> queue;
	//多线程间是否启动变量，有强制从主内存中刷新的功能。即时返回线程的状�??
	private volatile boolean isRunning = true;
	//id生成�?
	private static AtomicInteger count = new AtomicInteger();
	//随机对象
	private static Random r = new Random(); 
	
	public Provider(BlockingQueue queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		while(isRunning){
			try {
				//随机休眠0 - 1000 毫秒 表示获取数据(产生数据的�?�时) 
				Thread.sleep(r.nextInt(1000));
				//获取的数据进行累�?...
				int id = count.incrementAndGet();
				//比如通过�?个getData方法获取�?
				Data data = new Data(Integer.toString(id), "数据" + id);
				System.out.println("当前线程:" + Thread.currentThread().getName() + ", 获取了数据，id�?:" + id + ", 进行装载到公共缓冲区�?...");
				if(!this.queue.offer(data, 2, TimeUnit.SECONDS)){
					System.out.println("提交缓冲区数据失�?....");
					//do something... 比如重新提交
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		this.isRunning = false;
	}
	
}
