package com.think17.containerdeep;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 17.6 Set�ʹ洢˳�� 
 * 
 *  Set
 *    �ӿڣ� Set�ӿڲ�ά��Ԫ�ص�˳��
 *    
 *  HashSet
 *    Ϊ�˿��ٲ��Ҷ���Ƶ�Set������HashSet��Ԫ�ر��붨��hashCode();
 *    
 *  TreeSet
 *    ���ִ����Set, �ײ������ṹ�� ʹ�������Դ�SET����ȡ��������С�Ԫ�ر���ʵ��
 *  Comparable�ӿڡ�
 *  
 *  LinkedHashSet 
 *    ����HashSet�Ĳ�ѯ�ٶȣ����ڲ�ʹ������ά��Ԫ�ص�˳�򣨲���Ĵ��򣩡���ʹ�õ���������
 *  Set��ʱ�򡣽���ᰴ��Ԫ�ز���Ĵ�������ʾ��Ԫ��Ҳ���붨��hashCode()������
 *  
 */

/**
 * 
 * ���û��������������ƣ�����Ӧ������ʹ��HashSet����Ϊ�����ٶȷ���������Ż�
 * 
 */
public class Example006 {
	
	static <T> void test(Set<T> set, Class<T> type){
		TypesForSets.fill(set, type);
		TypesForSets.fill(set, type);  //�ظ�����
		TypesForSets.fill(set, type);  
		System.out.println(set);
	}
   
	@Test
	public void testSet(){
		test(new HashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);
		
		test(new HashSet<SetType>(), SetType.class); //���ζ��ܲ���
		test(new HashSet<TreeType>(), TreeType.class); 
		
		test(new LinkedHashSet<SetType>(), SetType.class); //���ζ��ܲ���
		test(new LinkedHashSet<TreeType>(), TreeType.class); 
		
		try{
			test(new TreeSet<SetType>(), SetType.class); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try{
			test(new TreeSet<HashType>(), HashType.class); 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

class SetType{
	int i;
	public SetType(int n){ i=n; }
	public boolean equals(Object o){
		return o instanceof SetType && (i == ((SetType)o).i);
	}
	public String toString(){
		return Integer.toString(i);
	}
}

class HashType extends SetType{

	public HashType(int n) {
		super(n);
	}
	
	public int hashCode(){return i;}
}

class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int n) {
		super(n);
	}

	public int compareTo(TreeType arg) {
		return (arg.i < i ? -1 : (arg.i == i ? 0 : 1 ));
	}
	
}

class TypesForSets{
	static <T> Set<T> fill(Set<T> set, Class<T> type){
		try{
			for(int i=0; i<10; i++){
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		}catch(Exception e){
			throw new RuntimeException();
		}
		return set;
	}
}

