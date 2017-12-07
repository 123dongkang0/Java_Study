package com.dongk.struts2.util.logging;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * Creates loggers.
 *   Static accessor will lazily try to decide on the best factory if none specified.
 *   如果没有指定，静态存取器将决定使用最好的工厂。 
 * 
 */
public abstract class LoggerFactory {
	
	private static final ReadWriteLock lock = new ReentrantReadWriteLock();
	private static LoggerFactory factory;
	
	private static final List<loggerClass> loggers = new LinkedList(){
		{
			add(new loggerClass<CommonsLoggerFactory>("org.apache.commons.logging.LogFactory",CommonsLoggerFactory.class));
			add(new loggerClass<Slf4jLoggerFactory>("org.slf4j.LoggerFactory",Slf4jLoggerFactory.class));
			add(new loggerClass<Log4j2LoggerFactory>("org.apache.log4j.LogManager",Log4j2LoggerFactory.class));
		}
	};
	
	public static void setLoggerFactory(LoggerFactory factory){
		lock.writeLock().lock();
		try{
			LoggerFactory.factory = factory;
		}finally{
			lock.writeLock().unlock();
		}
	}
	
	protected static LoggerFactory getLoggerFactory(){
		lock.readLock().lock();
		try{
			if(factory != null){
				return factory;
			}
		}finally{
			lock.readLock().lock();
		}
		lock.writeLock().lock();
		try{
			if(factory == null){
				createLoggerFactory();
			}
			return factory;
		}finally{
			lock.writeLock().unlock();
		}
	}
	
	private static void createLoggerFactory(){
		String userLoggerFactory = System.getProperty("userLoggerFactory");
		if(userLoggerFactory != null){
			try {
				Class clazz = Class.forName(userLoggerFactory);
				factory = (LoggerFactory) clazz.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("System property was no defined of userLoggerFactory.");
			}
		}else{
			//
			for(loggerClass logger : loggers){
				if(logger.isSupported()){
					factory = logger.createInstance();
					break;
				}
			}
		}
	}
	
    
	protected abstract Logger getLoggerImpl(Class<?> cls);

    protected abstract Logger getLoggerImpl(String name);
    
	private static class loggerClass<T extends LoggerFactory>{
		private final String loggerClazzName;
		private final Class<T> loggerImplClazz;
		
		public loggerClass(String loggerClazzName, Class<T> loggerImplClazz){
			this.loggerClazzName = loggerClazzName;
			this.loggerImplClazz = loggerImplClazz;
		}
		
		public boolean isSupported(){
		   try{
			   Class.forName(loggerClazzName);
			   return true;
		   }catch(ClassNotFoundException ignore){
			   return false;
		   }
		}
		
		public LoggerFactory createInstance(){
			try{
				return loggerImplClazz.newInstance();
			}catch(Exception e){
				 throw new RuntimeException("LoggerFactory.loggerClass 出现异常！");
			}
		}
		
		
	}
}
