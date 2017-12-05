package com.dongk.effictive08;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * 第46条： for-each 循环优先于传统的for循环 
 * 
 * 1.在对多个集合进行嵌套式迭代时，for-each 循环相对于传统for循环的这种优势
 *   更加明显。
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
		 * i.next() 调用4次之后，抛出java.util.NoSuchElementException异常。
		 * （并不是你想象的 4 * 13种组合）
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
	 * 要解决 testFor() 中出现的问题，只需要使用For-each循环即可以解决。
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
