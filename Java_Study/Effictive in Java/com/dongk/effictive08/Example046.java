package com.dongk.effictive08;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * ��46���� for-each ѭ�������ڴ�ͳ��forѭ�� 
 * 
 * 1.�ڶԶ�����Ͻ���Ƕ��ʽ����ʱ��for-each ѭ������ڴ�ͳforѭ������������
 *   �������ԡ�
 */
public class Example046 {
     
	/**
	 * 
	 */
	enum Suit{CLUB, DIAMOND, HEART, SPACE}
	enum Rank{ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
		      NINE, TEN, JACK, QUEEN, KING}
	Collection<Suit> suits = Arrays.asList(Suit.values());
	Collection<Rank> ranks = Arrays.asList(Rank.values());
	
	@Test
	public void testFor(){
		/**
		 * i.next() ����4��֮���׳�java.util.NoSuchElementException�쳣��
		 * ��������������� 4 * 13����ϣ�
		 */
		try{
			for(Iterator<Suit> i = suits.iterator(); i.hasNext();)
				for(Iterator<Rank> j = ranks.iterator(); j.hasNext();)
					System.out.println(i.next() + ":" +  j.next());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Ҫ��� testFor() �г��ֵ����⣬ֻ��Ҫʹ��For-eachѭ�������Խ����
	 */
	@Test
	public void testForeach(){
		try{
			for(Suit suit : suits )
				for(Rank rank : ranks)
					System.out.println(suit + ":" +  rank);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
