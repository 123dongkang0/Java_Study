package com.effictive02;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * ��1���������þ�̬�����������湹���� 
 */
public class Example001 {
     public static void main(String args[]){
    	 
    	 //�����ģ�ʹ�ô����ø��ӵļ��
    	 //Map<String,List<String>> m = new HashMap<String, List<String>>();
     }
}

interface Service{
	
}

interface Provider{
	Service newService();
}

class Services{
	private Services(){}
	
	private static final Map<String,Provider> providers = new ConcurrentHashMap<String, Provider>();
	
	public static final String DEFAULT_PROVIDER_NAME = "<def>";
	
	public static void registerDefaultProvider(Provider p){
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}
	
	public static Service newInstance(){
		return NewInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service NewInstance(String name) {
		Provider p = providers.get(name);
		if(p == null){
			throw new IllegalArgumentException("No provider registered with name:" + name);
		}else{
			return p.newService();
		}
	}
	
	
}