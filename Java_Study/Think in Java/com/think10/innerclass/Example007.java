package com.think10.innerclass;

import org.junit.Test;

import com.think10.innerclass.ClassInInterface.ClassInInterfaceException;

/**
 *10.7 Ƕ���� ��
 *  �ڲ�������Ϊstatic,�����Ƕ���࣬
 */
public class Example007 {
	
   @Test
   public void testParcel11(){
	   Contents c = Parcel11.contents();
	   Destination d = Parcel11.destination("Tasmania");
   }
   
   @Test
   public void testImpClassInInterface(){
	   ImpClassInInterface ici = new ImpClassInInterface();
	   try {
			ici.getValue();
	   }catch (ClassInInterfaceException e) {
			e.printStackTrace();
	   }
   }
   
}

/**
 *  ����ڲ��಻��Ҫ�����ⲿ������ԣ��ͽ��ڲ�������ΪStaitac
 *  
 *  1��������Ƕ������󣬲�����Ҫ��Χ�����
 *  2����Ƕ���಻�ܷ��ʷǾ�̬��Χ�����ԡ�
 */
class Parcel11{
	
	private static class ParcelContents implements Contents{
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destination{
		private String label;
		private ParcelDestination(String whereTo){
			label = whereTo;
		}
		public String readLabel() {
			return label;
		}
		public static void f(){}
		static int x = 10;
		static class AnotherLevel{
			public static void f(){}
			static int x = 10;
		}
	}
	
	public static Destination destination(String s){
		return new ParcelDestination(s);
	}
	
	public static Contents contents(){
		return new ParcelContents();
	}
}

/**
 * 10.7.1 �ӿ��ڲ���
 *   ��������£������ڽӿ��ڲ������κδ��룬����Ƕ���������Ϊ�ӿڵ�һ���֡�
 *   
 *   1�����ӿ��е��κ��඼��public �� static ��
 */
interface ClassInInterface{
	
	int getValue() throws ClassInInterfaceException;
	
	class ClassInInterfaceException extends java.lang.Exception{
		public ClassInInterfaceException(String msg){
			super(msg);
		}
	}
	
}

class ImpClassInInterface implements ClassInInterface{

	public int getValue() throws ClassInInterfaceException {
		throw  new ClassInInterfaceException("ClassInInterface has exception!!");
	}
	
}

