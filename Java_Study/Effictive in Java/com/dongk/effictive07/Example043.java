package com.dongk.effictive07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第43条：返回零长度的数组或者集合，而不是null
 * 
 *   使用返回null的方法的时候，每次都需要做非空判断。这样很容易出错(也许你忘记处理null)。
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
	  *  1）、在Collections中有专门针对List,Set,Map的空的实现。如：
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
