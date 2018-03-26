package com.dongk.util;

import java.io.File;


/**
* <b>Description:�����ļ��ϴ������صȲ�����ʱ�򣬶�·���Ĵ�������</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> dyck
* <br><b>PackageName:</b> com.pub.framework.util
* <br><b>ClassName: FilePathUtil</b> FilePathUtil
* <br><b>Date:</b> 2018-3-19 ����9:09:43
*/
public class FilePathUtil {
	
	/**
	 * �ļ��洢��Ŀ¼ 
	 */
	public static final String FILE_ROOT = Config.getProperty("file.root");
	/**
	 * tomcat����Ŀ¼ 
	 */
	public static final String FILE_VIRTUAL = Config.getProperty("file.virtual");
	/**
	 * �ļ�����Ŀ¼
	 */
	public static final String FILE_CACHE = Config.getProperty("file.cache");
	/**
	 * �ļ��ָ��
	 */
	public static final String SEPARATOR = "/";
	
	
	/**
	* <b>Description:���ַ����е��ַ�"\\"���滻��File.</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����9:44:18
	* <br><b>Version:</b> 1.0
	* <br><b>param:ԭʼ�����ַ���</b>
	* <br><b>return:</b>
	*/
	public static String replaceDelimited(String path){
		return path.replace("\\", SEPARATOR);
	} 
	
	/**
	* <b>Description:�������·���õ����Ե�·��</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����10:28:05
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getActualPath(String path){
	    return FILE_ROOT + 	SEPARATOR + path;
	}
	
	/**
	* <b>Description:�������·���õ�����·��</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����10:30:43
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getVirtualPath(String path){
		return FILE_VIRTUAL + SEPARATOR + path;
	}
	
	/**
	* <b>Description:����ʵ��·���õ�����·��</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����10:31:42
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getActualPathByv(String path){
		return path.replaceFirst(FILE_VIRTUAL, FILE_ROOT);
	}
	
	/**
	* <b>Description:��������·���õ�ʵ��·��</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����10:34:52
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static String getVirtualPathBya(String path){
		return path.replaceFirst(FILE_ROOT, FILE_VIRTUAL);
	}
	
	/**
	* <b>Description:�ж�Ŀ¼�Ƿ�Ϊ����Ŀ¼</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018-3-19 ����10:35:39
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static boolean isCache(String path){
		return path.contains(FILE_ROOT + SEPARATOR + FILE_CACHE);
	}
	
}
