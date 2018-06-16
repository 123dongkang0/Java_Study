package com.dongk.thread.base.coll013;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Wangmin implements Delayed {  
    
    private String name;  
    //���֤  
    private String id;  
    //��ֹʱ��  
    private long endTime;  
    //����ʱ�乤����
    private TimeUnit timeUnit = TimeUnit.SECONDS;
      
    public Wangmin(String name,String id,long endTime){  
        this.name=name;  
        this.id=id;  
        this.endTime = endTime;  
    }  
      
    public String getName(){  
        return this.name;  
    }  
      
    public String getId(){  
        return this.id;  
    }  
      
    /** 
     * �����ж��Ƿ��˽�ֹʱ�� 
     */  
    @Override  
    public long getDelay(TimeUnit unit) { 
        //return unit.convert(endTime, TimeUnit.MILLISECONDS) - unit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    	return endTime - System.currentTimeMillis();
    }  
  
    /** 
     * �໥���������� 
     */  
    @Override  
    public int compareTo(Delayed delayed) {  
    	Wangmin w = (Wangmin)delayed;  
        return this.getDelay(this.timeUnit) - w.getDelay(this.timeUnit) > 0 ? 1:0;  
    }  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}  