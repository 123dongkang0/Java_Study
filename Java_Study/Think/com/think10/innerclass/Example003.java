package com.think10.innerclass;

/**
 *10.3 ʹ��.this��.new 
 *    
 *    
 */
public class Example003 {
   public static void main(String args[]){
	   DotThis dt = new DotThis();
	   DotThis.Inner dti = dt.inner();
	   dti.outer().f();
	   
	   DotNew dn = new DotNew();
	   DotNew.Inner dni = dn.new Inner();
	   System.out.println(dni.toString());
	   
   }
}

/**
 * .this : ���ɶ��ⲿ���������á�
 */
class DotThis{
	void f(){
		System.out.println("DotThis.f()");
	}
	
	public class Inner{
		public DotThis outer(){
			return DotThis.this;
		}
	}
	
	public Inner inner(){
		return new Inner();
	}
}
/**
 * .new ��֪�����Ķ���ȥ����ĳ���ڲ���Ķ��� 
 */

class DotNew{
	public class Inner{
		
	}
}

