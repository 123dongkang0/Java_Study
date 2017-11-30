package com.dongk.spring.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceUtils {
	
	public static URI toURI(URL url) throws URISyntaxException{
		return toURI(url.toString());
	}

	private static URI toURI(String location) throws URISyntaxException {
		return new URI(StringUtils.replace(location, " ", "%20"));
	}

}
