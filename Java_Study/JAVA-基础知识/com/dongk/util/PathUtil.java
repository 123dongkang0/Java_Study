package com.dongk.util;

import java.io.File;

/**
 * Copyright (C), 2017-11-03
 * Author : dongk
 * Version : 1.0, 
 * First complete date : 2017-11-03
 * Description : 路径问题工具类
 * Others :
 */
public class PathUtil {
	
	/**
	 * 文件存储跟目录 
	 */
	private static final String FILE_ROOT = Config.getProperty("upload.tomcat.fileroot");
	/**
	 * tomcat虚拟目录 
	 */
	private static final String TOMCAT_VIRTUAL_PATH = Config.getProperty("upload.tomcat.virtualpath");

	/**
	 * Copyright (C), 2017-11-03
	 * Author : dongk
	 * Version : 1.0, 
	 * First complete date : 2017-11-03
	 * Description : 根据"虚拟路径"获取"绝对路径"
	 * Others :
	 * @param:虚拟路径
	 * @return: 绝对路径
	 */
	public static String getPath(String fileVirtualPath) {
		return    FILE_ROOT
                + fileVirtualPath.substring(fileVirtualPath.lastIndexOf(TOMCAT_VIRTUAL_PATH) + TOMCAT_VIRTUAL_PATH.length());
	}
    
	/**
	 * Copyright (C), 2017-11-03
	 * Author : dongk
	 * Version : 1.0, 
	 * First complete date : 2017-11-03
	 * Description : 根据 "绝对路径" 获取 "虚拟路径"
	 * Others :
	 * @param:绝对路径
	 * @return: 虚拟路径
	 */
	public static String getVirtualPath(String filePath) {
		return   TOMCAT_VIRTUAL_PATH 
                + File.separator
                + filePath.substring(FILE_ROOT.length());
	}

}
