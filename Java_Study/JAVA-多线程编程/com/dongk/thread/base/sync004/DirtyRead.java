package com.dongk.thread.base.sync004;
/**
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 * @author alienware
 * 数据库特性
 * 原子性 A
 * 一致性 C: 一致性读(oracle undo概念)
 *      客户端A ：9点查询 某一行某一列的数据为 100;
 *		客户端B : 9点05分修改此值为200，并且commit;
 *      客户端A得到的数据是多少？
 *           是100，因为ORACLE数据库会从undo中读取旧值100，或者抛出snaptooold异常(块太旧)；但是决不会
 *	     返回200；这充分体现了oracle的一致性读的特性；
 * 隔离性 I
 * 持久性 D
 *
 */
public class DirtyRead {

	private String username = "bjsxt";
	private String password = "123";
	
	public synchronized void setValue(String username, String password){
		this.username = username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}
	
	public void getValue(){
		System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
	}
	
	
	public static void main(String[] args) throws Exception{
		
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("z3", "456");		
			}
		});
		t1.start();
		Thread.sleep(1000);
		
		dr.getValue();
	}
	
	
	
}
