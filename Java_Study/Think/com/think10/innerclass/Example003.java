package com.think10.innerclass;

/**
 *10.3 使用.this与.new 
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
 * .this : 生成对外部类对象的引用。
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
 * .new 告知其它的对象，去创建某个内部类的对象 
 */

class DotNew{
	public class Inner{
		
	}
}

