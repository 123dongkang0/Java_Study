package com.dongk.thread.base.conn008;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 2016.03.18(����)
 * ����������ѧϰ���ʹ��CountDownLatch�࣬this is versatile tool of synchronized
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
 *    CountDownLatch��һ���ǳ����͵�Ӧ�ó����ǣ���һ��������Ҫ����ִ�У�������Ҫ�ȵ�����������ִ����Ϻ�ſ��Լ�������ִ�С�
 *    
 *    �������������Ҫ��������ִ�е��������һ��CountDownLatch�����await()����������������ִ�����Լ�����������ͬһ��CountDownLatch�����ϵ�countDown()������
 *    
 *    �������await()����������һֱ�����ȴ���ֱ�����CountDownLatch����ļ���ֵ����0Ϊֹ��
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
	private VideoReference videoReference; //�μӵ���Ƶ����
	
	private String name;//�μ��ߵ�����
	
	public Participant(VideoReference videoReference,String name){
		  this.videoReference = videoReference;
		  this.name = name;
	}

	@Override
	public void run() {
		//���ȵ�һ��ʱ��
        long duration = (long) (Math.random() * 10);	
        try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		videoReference.arrive(name);
	}
}


