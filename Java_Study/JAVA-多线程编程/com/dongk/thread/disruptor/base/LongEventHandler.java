package com.dongk.thread.disruptor.base;

import com.lmax.disruptor.EventHandler;

//���ǻ���Ҫһ���¼������ߣ�Ҳ����һ���¼�������������¼��������򵥵ذ��¼��д洢�����ݴ�ӡ���նˣ�
public class LongEventHandler implements EventHandler<LongEvent>  {

	@Override
	public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
		System.out.println(longEvent.getValue()); 		
	}

}
