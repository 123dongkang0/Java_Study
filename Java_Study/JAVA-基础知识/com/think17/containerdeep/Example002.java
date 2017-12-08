package com.think17.containerdeep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.think.pub.Generator;

/**
 * 17.2 ������� 
 * 
 *    1.Collections��һЩʵ�õ�static����������ʹ�����������������
 */
public class Example002 {
    
	/**
	 * ��������ǿ�������Ĺ۲쵽������ nCopies ���� fill�����ǵ�λ�ö�ָ����ͬ��λ�� 
	 */
	@Test
	public void testFillingLists(){
		List<StringAddress> list = new ArrayList<StringAddress>(
				   // nCopies(n,T)������ָ������� n ��������ɵĲ��ɱ��б�
				   Collections.nCopies(4, new StringAddress("Hello"))
				);
		System.out.println(list);
		
		//ʹ��ָ��Ԫ���滻ָ���б��е�����Ԫ�ء�
		Collections.fill(list, new StringAddress("World!"));
		System.out.println(list);
	}
	
}


class StringAddress{
	private String s;
	public StringAddress(String s){this.s = s;}
	public String toString(){
		return super.toString() + ":" +  s + "\n";
	}
}


class CollectionData<T> extends ArrayList<T>{
	public CollectionData(Generator<T> gen , int quantity){
		for(int i=0; i<quantity; i++){
			add(gen.next());
		}
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen , int quantity){
		return new CollectionData<T>(gen, quantity);
	}
}
