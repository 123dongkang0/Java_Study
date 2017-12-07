package com.dongk.struts2.util.logging;


public class Log4j2Logger implements Logger{
	
    private org.apache.log4j.Logger log;
	
	public Log4j2Logger(org.apache.log4j.Logger log){
		this.log = log;
	}

	public void trace(String msg, String... args) {
       log.trace(LoggerUtils.format(msg, args));		
	}
	public void trace(String msg, Object... args) {
		log.trace(LoggerUtils.format(msg, args));
	}
	public void trace(String msg, Throwable ex, String... args) {
		log.trace(LoggerUtils.format(msg, args),ex);
	}
	public boolean isTraceEnabled() {
		return log.isTraceEnabled();
	}

	public void debug(String msg, String... args) {
		log.debug(LoggerUtils.format(msg, args));
	}
	public void debug(String msg, Object... args) {
		log.debug(LoggerUtils.format(msg, args));
	}
	public void debug(String msg, Throwable ex, String... args) {
		log.debug(LoggerUtils.format(msg, args),ex);
	}
	public boolean isDebugEnabled() {
		return log.isDebugEnabled();
	}
	
	public void info(String msg, String... args) {
		log.info(LoggerUtils.format(msg, args));
	}
	public void info(String msg, Throwable ex, String... args) {
		log.info(LoggerUtils.format(msg, args),ex);
	}
	public boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}
	
	public void warn(String msg, String... args) {
		log.warn(LoggerUtils.format(msg, args));
	}
	public void warn(String msg, Object... args) {
		log.warn(LoggerUtils.format(msg, args));
	}
	public void warn(String msg, Throwable ex, String... args) {
		log.warn(LoggerUtils.format(msg, args),ex);
	}
	public boolean isWarnEnabled() {
		return log.isInfoEnabled();
	}

	public void error(String msg, String... args) {
		log.error(LoggerUtils.format(msg, args));
	}
	public void error(String msg, Object... args) {
		log.error(LoggerUtils.format(msg, args));
	}
	public void error(String msg, Throwable ex, String... args) {
		log.error(LoggerUtils.format(msg, args),ex);
	}
	public boolean isErrorEnabled() {
		return log.isDebugEnabled();
	}

	public void fatal(String msg, String... args) {
		log.fatal(LoggerUtils.format(msg, args));
	}
	public void fatal(String msg, Throwable ex, String... args) {
		log.fatal(LoggerUtils.format(msg, args),ex);
	}
	public boolean isFatalEnabled() {
		return log.isDebugEnabled();
	}
}
