package com.point.reference;

public class ReferenceObject {
     
	public String toString(){
		return "ReferenceObject toString ...";
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("ReferenceObject finalize ...");
	}
	
}
