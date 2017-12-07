package com.dongk.struts2.dispatcher.ng;

import java.util.Iterator;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * Host Configuration that wraps FilterConfig. 
 */
public class FilterHostConfig implements HostConfig{
	
	private FilterConfig config;
	
	public FilterHostConfig(FilterConfig config){
		this.config = config;
	}

	public String getInitParameter(String key) {
		return config.getInitParameter(key);
	}

	public Iterator<String> getInitParameterNames() {
		return null;
	}

	public ServletContext getServletContext() {
		return config.getServletContext();
	}

}
