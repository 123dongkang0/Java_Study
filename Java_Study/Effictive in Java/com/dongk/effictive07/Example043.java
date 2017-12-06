package com.dongk.effictive07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ��43���������㳤�ȵ�������߼��ϣ�������null
 * 
 *   ʹ�÷���null�ķ�����ʱ��ÿ�ζ���Ҫ���ǿ��жϡ����������׳���(Ҳ�������Ǵ���null)��
 * 
 *  
 */
public class Example043 {

	private final List<String> inStock = new ArrayList<String>();
	
	private static final String[] EMPTY_CHEESE_ARRAY = new String[0];
	
	public String[] getInStock(){
		return inStock.toArray(EMPTY_CHEESE_ARRAY);
	}
	
	/**
	  *  1������Collections����ר�����List,Set,Map�Ŀյ�ʵ�֡��磺
     *       Collections.emptyList()
     *       Collections.emptySet();
     *       Collections.emptyMap();
	  */
	public List<String>  getcheeseList(){
		if(inStock.isEmpty()){
			return Collections.emptyList();
		}else{
			return inStock;
		}
	}
}
