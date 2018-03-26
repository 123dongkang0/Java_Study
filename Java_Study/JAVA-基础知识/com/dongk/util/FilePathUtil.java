package com.dongk.util;

import java.io.File;


/**
* <b>Description:进行文件上传、下载等操作的时候，对路径的处理工具类</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> dyck
* <br><b>PackageName:</b> com.pub.framework.util
* <br><b>ClassName: FilePathUtil</b> FilePathUtil
* <br><b>Date:</b> 2018-3-19 上午9:09:43
*/
public class FilePathUtil {
	
	/**
	 * 文件存储根目录 
	 */
	public static final String FILE_ROOT = Config.getProperty("file.root");
	/**
	 * tomcat虚拟目录 
	 */
	public static final String FILE_VIRTUAL = Config.getProperty("file.virtual");
	/**
	 * 文件缓存目录
	 */
	public static final String FILE_CACHE = Config.getProperty("file.cache");
	/**
	 * 文件分割符
	 */
	public static final String SEPARATOR = "/";
	
	
	/**
	* <b>Description:将字符串中的字符"\\"等替换成File.</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午9:44:18
	* <br><b>Version:</b> 1.0
	* <br><b>param:原始输入字符串</b>
	* <br><b>return:</b>
	*/
	public static String replaceDelimited(String path){
		return path.replace("\\", SEPARATOR);
	} 
	
	/**
	* <b>Description:根据相对路径得到绝对的路径</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午10:28:05
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getActualPath(String path){
	    return FILE_ROOT + 	SEPARATOR + path;
	}
	
	/**
	* <b>Description:根据相对路径得到虚拟路径</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午10:30:43
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getVirtualPath(String path){
		return FILE_VIRTUAL + SEPARATOR + path;
	}
	
	/**
	* <b>Description:根据实际路径得到虚拟路径</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午10:31:42
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getActualPathByv(String path){
		return path.replaceFirst(FILE_VIRTUAL, FILE_ROOT);
	}
	
	/**
	* <b>Description:根据虚拟路径得到实际路径</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午10:34:52
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getVirtualPathBya(String path){
		return path.replaceFirst(FILE_ROOT, FILE_VIRTUAL);
	}
	
	/**
	* <b>Description:判断目录是否为缓存目录</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 上午10:35:39
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static boolean isCache(String path){
		return path.contains(FILE_ROOT + SEPARATOR + FILE_CACHE);
	}
	
}
