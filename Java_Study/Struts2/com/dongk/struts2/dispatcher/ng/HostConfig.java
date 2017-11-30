package com.dongk.struts2.dispatcher.ng;

import java.util.Iterator;

import javax.servlet.ServletContext;

/**
 * Abstraction for host configuration information such as init params or the servlet context. 
 * ��������������Ϣ�������ʼ������������Servlet Context.
 */
public interface HostConfig {
    
	/**
	 * @param key   The parameter key.
	 * @return value  The parameter value.
	 */
	String getInitParameter(String key);
	
	/**
	 *@return A list of parameter names. 
	 */
	Iterator<String> getInitParameterNames();
	
	/**
	 *@return The Servlet context 
	 */
	ServletContext getServletContext();
}
