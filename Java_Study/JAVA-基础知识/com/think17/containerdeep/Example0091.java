package com.think17.containerdeep;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 17.9.1 理解hashCode() 
 */
public class Example0091 {
   public static void main(String args[]){
   }
}

/**
 * 在这里使用一对ArrayList实现一个Map 
 */
class SlowMap<K,V> extends AbstractMap<K, V>{
	
	private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    
    public V put(K key, V value){
       V oldValue = get(key);
       if(!keys.contains(key)){
    	   keys.add(key);
    	   values.add(value);
       }else{
    	   values.set(keys.indexOf(key), value);
       }
       return oldValue;
    }
    
    public V get(Object key){
    	if(!keys.contains(key)){
    		return null;
    	}else{
    		return values.get(keys.indexOf(key));
    	}
    }
    
    public Set<Map.Entry<K, V>> entrySet(){
    	 Set<Map.Entry<K, V>>  set = new HashSet<Map.Entry<K,V>>();
    	 Iterator<K> ki = keys.iterator();
    	 Iterator<V> vi = values.iterator();
    	 while(ki.hasNext()){
    		 set.add(new MapEntry<K, V>(ki.next(),vi.next()) );
    	 }
    	 return set;
    }
    
}

class MapEntry<K,V> implements Map.Entry<K, V>{
	private K key;
	private V value;
	public MapEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	public K getKey() { return key;}
	public V getValue() {return value;}
	public V setValue(V v) {
		V result = value;
		value = v;
		return result;
	}
	public int hashCode(){
		return (key==null?0:key.hashCode()) ^
			   (value==null?0:value.hashCode());
	}
	
	public boolean equals(Object o){
		if(!(o instanceof MapEntry)){
			return false;
		}else{
			MapEntry me = (MapEntry) o;
			return 
				   ( 
				     key==null?me.getKey()==null:key.equals(me.getKey())
				    )
				    &&
				    ( 
				      value==null?me.getKey()==null:value.equals(me.getValue())
				     );
			
		}
	}
	
	
}
