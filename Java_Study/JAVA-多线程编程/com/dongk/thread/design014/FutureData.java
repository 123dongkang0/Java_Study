package com.dongk.thread.design014;

public class FutureData implements Data{

	private RealData realData ;
	
	private boolean isReady = false;
	
	public synchronized void setRealData(RealData realData) {
		//����Ѿ�װ������ˣ���ֱ�ӷ���
		if(isReady){
			return;
		}
		//���ûװ�أ�����װ����ʵ����
		this.realData = realData;
		isReady = true;
		//����֪ͨ
		notify();
	}
	
	@Override
	public synchronized String getRequest() {
		//���ûװ�غ� �����һֱ��������״̬
		while(!isReady){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//װ�غ�ֱ�ӻ�ȡ���ݼ���
		return this.realData.getRequest();
	}


}
