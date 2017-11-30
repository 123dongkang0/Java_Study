package com.think15.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 15.12.3 ����Э�䣺
 * 
 *    1.ʲô�ǲ���Э�䣿
 *      ��䡢Э����������ת��֮��Ĺ�ϵ��
 *      
 *      �ڽ�����䡢Э��֮ǰ���������˽�Liskovԭ��
 *         ������������ܹ�͸����ʹ���丸��(����)�ķ�����
 *         
 *      ʹ��  A��B ��ʾ����
 *           f(.) ��ʾ����ת��
 *           < ��ʾ�̳й�ϵ��A<B ��ʾB��A�ĸ��ࣩ
 *      
 *      f(.)�����ģ� �� A<B��ʱ����  f(B)<f(A)���� ;
 *      f(.)��Э��ģ� �� A<B��ʱ����  f(A)<f(B)���� ;
 *      
 *    2.����б�ߵ����ã�
 */
public class Example0123 {
    public static void main(String args[]){
    	//1.���飬��f(A) = [A], ����֤��������Э���
    	Number[] a = new Integer[3];
    	  
    	//2.���͵���䡢Э��
    	//2.1 ���͵������Superʵ��
    	List<? super Integer> list1 = new ArrayList<Number>();
    	//2.2���͵�Э����extendsʵ��
    	List<? extends Number> list2 = new ArrayList<Integer>();
    	
    }
}


/**
 * Э�䷵������
 */
class Base{}
class Dervied extends Base{}

interface OrdinaryGetter{
	Base get();
}
interface DerviedGetter extends OrdinaryGetter{
	@Override
	Dervied get();
}

class CovariantReturnType{
	void test(DerviedGetter t){
		Dervied dervied = t.get();    //���ص������������
	}
}

interface GenericGetter<T extends GenericGetter<T>>{
	T get();
}

interface Getter extends GenericGetter<Getter>{}

class GenericReturnType{
	void test(Getter getter){
		Getter getter2 = getter.get();
	}
}

