package com.think10.innerclass;

/**
 * 10.2�ڲ���ӵ���ⲿ��������з���Ȩ�� 
 * 
 *    ��������ģ�
 *            ���ڲ��ഴ����ʱ��,�ڲ������ض������ܵĲ���һ��ָ����Χ��������á�
 */
public class Example002 {
   public static void main(String args[]){
	   Sequence sequence = new Sequence(10);
	   for(int i=0; i<10; i++){
		   sequence.add(Integer.toString(i));
	   }
	   
	   Selector selector = sequence.selector();
	   while(!selector.end()){
		   System.out.print(selector.current() + " ");
		   selector.next();
	   }
	   
	   System.out.println();
	   
	   ReverseSelector reverseSelector = sequence.reverseSelector();
	   while(!reverseSelector.first()){
		   System.out.print(reverseSelector.current() + " ");
		   reverseSelector.after();
	   }
   }
}

interface Selector{
	boolean end();
	Object current();
	void next();
}

interface ReverseSelector{
	boolean first();
	Object current();
	void after();
}

class Sequence{
	private Object[] items;
	private int next = 0;
	
	public Sequence(int size){
		items = new Object[size];
	}
	
	public void add(Object x){
	   if(next < items.length){
		    items[next++] = x;
	   }	
	}
	
    private class SequenceSelector implements Selector{
    	private int i = 0;

		public boolean end() {
			return i == items.length;
		}
		
		public Object current() {
			return items[i];
		}

		public void next() {
			if(i < items.length){
				i++;
			}
		}
    	
    }
    
    private class SequenceReverseSelector implements ReverseSelector{
    	private int i = items.length - 1;

		public boolean first() {
			return i == -1;
		}

		public Object current() {
			return items[i];
		}

		public void after() {
           if(i >= 0){
        	   i--;
           }			
		}
    	
    }
    
    public Selector selector(){
    	return new SequenceSelector();
    }
    
    public SequenceReverseSelector reverseSelector(){
    	return new SequenceReverseSelector();
    }
    
	
}