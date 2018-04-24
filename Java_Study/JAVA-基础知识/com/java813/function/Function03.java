package com.java813.function;

import java.util.stream.LongStream;

/**
* <b>Description:
*        13.3 �ݹ�͵���   
* </b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.java813.function
* <br><b>ClassName:</b> Function03
* <br><b>Date:</b> 2018��4��24�� ����2:17:26
*/
public class Function03 {
    
	//ʹ�õ����İ취��׳�
	static int factorialIterative(int n) {
    	 int sum = 1;
    	 for(int i=1; i<=n; i++) {
    		 sum *= i;
    	 }
    	 return sum;
     }
	
	//ʹ�õݹ�İ취��׳�
	static int factorialRecursion(int n) {
		if(n == 0)
		   return 1;
		return n * factorialRecursion(n - 1);
	}
	
	static long factorialStreams(long n) {
		return LongStream.range(1, n)
				         .reduce(1,(long a, long b) -> a*b);
	}
}
