package com.dongk.struts2.util;

public class ClassLoaderUtil {
	
	/**
	 *ʹ�ô��������������һ���ࡣ
	 *<p/>
	 *   it will try to load the class in the following order;
	 *   ʹ������Ĵ����������ࣺ
	 *   
	 *   <ul>
	 *        <li>Thread.currentThread().getContextClassLoader()</li>
	 *        <li>Class.forName()</li>
	 *        <li> ClassLoaderUtil.class.getClassLoader()</li>
	 *        <li>callingClass.getClassLoader()</li>
	 *   </ul>
	 * @param className The name of the class to load
	 * @param callingClass The class object of the calling object
	 */
	public static Class loadClass(String className, Class callingClass) throws ClassNotFoundException{
		try{
			return Thread.currentThread().getContextClassLoader().loadClass(className);
		}catch(ClassNotFoundException e){
			try{
				return Class.forName(className);
			}catch(ClassNotFoundException ex){
				try{
					return ClassLoaderUtil.class.getClassLoader().loadClass(className);
				}catch(ClassNotFoundException exc){
					return callingClass.getClassLoader().loadClass(className);
				}
			}
		}
	}

}
