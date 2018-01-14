package com.dongk.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Config {

	private static Log log;

	private static Properties props = getProperties();

	private static Config instance = null;

	// 通过单例模式获得Properties实例
	private static synchronized Properties getProperties() {
		if (instance == null) {
			instance = new Config();
		}
		return instance.loadConfig();
	}

	/**
	 * 解析config.properties文件
	 * 
	 * @return Properties
	 */
	private Properties loadConfig() {
		Properties p = new Properties();
		try {
			InputStream is = this.getClass().getResourceAsStream("/config.properties");
			p.load(is);
			is.close();
		} catch (Exception ex) {
			log.error("读config文件出错！", ex);
		}
		return p;
	}
	
	public Config() {
		log = LogFactory.getLog(getClass().getName());
	}

	public static String getProperty(String key) {
		Object obj = props.get(key);
		if (obj == null) {
			return null;
		} else {
			return obj.toString();
		}
	}

	public static String getProperty(String key, String defaultValue) {
		Object obj = props.get(key);
		if (obj != null) {
			return obj.toString();
		} else {
			return defaultValue;
		}
	}

	public static String getProperty(String key, String defaultValue, String encoding) {
		Object obj = props.get(key);
		if (obj != null) {
			String value = obj.toString();
			String newValue = null;

			try {
				newValue = new String(value.getBytes(encoding), "GBK");
			} catch (UnsupportedEncodingException ex) {
				log.error("convert encoding", ex);
				newValue = defaultValue;
			}

			return newValue;
		} else {
			return defaultValue;
		}
	}

}