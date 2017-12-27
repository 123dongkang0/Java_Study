package com.think17.containerdeep;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * 17.9.2 为速度而散列 
 *  
 *   散列的价值在于速度：散列使得查询得以快速进行
 */
public class Example0092 {
  public static void main(String args[]){
	  SimpleHashMap<String, String> strMap = new SimpleHashMap<String, String>();
	  strMap.put("aa", "dongk");
	  System.out.println(strMap.get("aa"));
  }
}

class SimpleHashMap<K,V> extends AbstractMap<K, V>{
    
	static final int SIZE = 997;
	LinkedList<MapEntry<K,V>> [] buckets = new LinkedList[SIZE];
	
	public V put(K Key, V value){
		V oldValue = null;
		int index = Math.abs(Key.hashCode()) % SIZE;
		if(buckets[index] == null){
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		}
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		MapEntry<K,V> pair = new MapEntry<K,V>(Key, value);
		boolean found = false;
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		while(it.hasNext()){
			MapEntry<K,V> iPair = it.next();
			if(iPair.getKey().equals(Key)){
				oldValue = iPair.getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if(!found){
			buckets[index].add(pair);
		}
		return oldValue;
	}
	
	public V get(Object key){
	   int index = Math.abs(key.hashCode())%SIZE;
	   if(buckets[index] == null ) return null;
	   for(MapEntry<K,V> iPair : buckets[index]){
		   if(iPair.getKey().equals(key)){
			   return iPair.getValue();
		   }
	   }
	   return null;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets){
			for(MapEntry<K,V> mpair : bucket){
				set.add(mpair);
			}
		}
		return set;
	}
	
}