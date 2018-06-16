package com.dongk.thread.base.coll013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class UsePriorityBlockingQueue {

	
	public static void main(String[] args) throws Exception{
		
		
		PriorityBlockingQueue<Task> q = new PriorityBlockingQueue<Task>();
		
		Task t1 = new Task();
		t1.setId(3);
		t1.setName("idÎª3");
		Task t2 = new Task();
		t2.setId(4);
		t2.setName("idÎª4");
		Task t3 = new Task();
		t3.setId(1);
		t3.setName("idÎª1");
		
		//return this.id > task.id ? 1 : 0;
		q.add(t1);	//3
		q.add(t2);	//4
		q.add(t3);  //1
		
		// 1 3 4
		System.out.println("ÈÝÆ÷£º" + q);
		System.out.println(q.take().getId());
		System.out.println("ÈÝÆ÷£º" + q);
//		System.out.println(q.take().getId());
//		System.out.println(q.take().getId());
		

		
	}
}
