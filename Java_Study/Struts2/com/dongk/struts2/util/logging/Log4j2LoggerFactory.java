package com.dongk.struts2.util.logging;

public class Log4j2LoggerFactory extends LoggerFactory {
   
	@Override
    protected Logger getLoggerImpl(Class<?> cls) {
        return new Log4j2Logger(org.apache.log4j.LogManager.getLogger(cls));
    }

    @Override
    protected Logger getLoggerImpl(String name) {
        return new Log4j2Logger(org.apache.log4j.LogManager.getLogger(name));
    }

}
