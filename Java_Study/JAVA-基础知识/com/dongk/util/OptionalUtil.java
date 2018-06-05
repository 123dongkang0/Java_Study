package com.dongk.util;

import java.util.Optional;

public class OptionalUtil {
	
	public static Optional<Integer> stringToInt(String s){
		try {
			return Optional.of(Integer.parseInt(s));
		}catch(Exception ex) {
			return Optional.empty();
		}
	}

}
