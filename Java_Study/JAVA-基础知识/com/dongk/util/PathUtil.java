package com.dongk.util;

import java.io.File;

/**
 * Copyright (C), 2017-11-03
 * Author : dongk
 * Version : 1.0, 
 * First complete date : 2017-11-03
 * Description : ·�����⹤����
 * Others :
 */
public class PathUtil {
	
	/**
	 * �ļ��洢��Ŀ¼ 
	 */
	private static final String FILE_ROOT = Config.getProperty("upload.tomcat.fileroot");
	/**
	 * tomcat����Ŀ¼ 
	 */
	private static final String TOMCAT_VIRTUAL_PATH = Config.getProperty("upload.tomcat.virtualpath");

	/**
	 * Copyright (C), 2017-11-03
	 * Author : dongk
	 * Version : 1.0, 
	 * First complete date : 2017-11-03
	 * Description : ����"����·��"��ȡ"����·��"
	 * Others :
	 * @param:����·��
	 * @return: ����·��
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
	 * Description : ���� "����·��" ��ȡ "����·��"
	 * Others :
	 * @param:����·��
	 * @return: ����·��
	 */
	public static String getVirtualPath(String filePath) {
		return   TOMCAT_VIRTUAL_PATH 
                + File.separator
                + filePath.substring(FILE_ROOT.length());
	}

}
