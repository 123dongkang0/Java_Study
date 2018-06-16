package com.dongk.thread.base.conn008;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 2016.03.18(董康)
 * 这里我们来学习如何使用CountDownLatch类，this is versatile tool of synchronized
 * 
 * */
public class TestCountDownlatch {
   public static void main(String args[]){
	   VideoReference video = new VideoReference(9);
	   Thread threadVideo = new Thread(video);
	   threadVideo.start();
	   
	   for(int i=0; i<9; i++){
		   Participant participant = new Participant(video, "par" + i);
		   Thread threadParticipant = new Thread(participant);
		   threadParticipant.start();
	   }
   }
}

/**
 *    1.
 *    CountDownLatch的一个非常典型的应用场景是：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行。
 *    
 *    假如我们这个想要继续往下执行的任务调用一个CountDownLatch对象的await()方法，其他的任务执行完自己的任务后调用同一个CountDownLatch对象上的countDown()方法，
 *    
 *    这个调用await()方法的任务将一直阻塞等待，直到这个CountDownLatch对象的计数值减到0为止。
 * 
 **/

class VideoReference implements Runnable{
	private CountDownLatch count;
	public VideoReference(Integer num){
		count = new CountDownLatch(num);
	}
	
	public synchronized void arrive(String name){
		count.countDown();
		System.out.println(name + "  has arrive!  no arrive (" + count.getCount() + ")" );
	}

	@Override
	public void run() {
         System.out.println("Initialized VideoRenference : " + count.getCount());
         
         try {
			count.await();
			System.out.println("VideoReference: All Participant has com !!");
			System.out.println("VideoReference: Let we start!!");
		 } catch (InterruptedException e) {
			e.printStackTrace();
		 }
	
	}
	
	
}

class Participant implements Runnable{
	private VideoReference videoReference; //参加的视频会议
	
	private String name;//参加者的姓名
	
	public Participant(VideoReference videoReference,String name){
		  this.videoReference = videoReference;
		  this.name = name;
	}

	@Override
	public void run() {
		//首先等一段时间
        long duration = (long) (Math.random() * 10);	
        try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		videoReference.arrive(name);
	}
}


