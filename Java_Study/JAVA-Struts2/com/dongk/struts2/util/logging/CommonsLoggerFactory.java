package com.dongk.struts2.util.logging;

import org.apache.commons.logging.LogFactory;

public class CommonsLoggerFactory extends LoggerFactory{
	
	@Override
	protected Logger getLoggerImpl(Class<?> cls) {
		return new CommonsLogger(LogFactory.getLog(cls));
	}
	
	@Override
	protected Logger getLoggerImpl(String name) {
		return new CommonsLogger(LogFactory.getLog(name));
	}

}
