package com.dongk.util.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dongk.util.PathUtil;


/**
 * Copyright (C), 2017-10-20
 * Author : dongk
 * Version : 1.0, 
 * First complete date : 2017-10-20
 * Description : 文件下载Servlet
 * Others :
 */
public class FileDownServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(FileDownServlet.class);
	
	/**
	 * request content_type 
	 */
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	/**
	 * response 返回的 context_type 
	 */
	private static final String RESPONSE_CONTENT_TYPE = "application/x-msdownload";
	/**
	 * 文件名称
	 */
	private static final String FILE_NAME = "name";
	/**
	 * 文件路径 
	 */
	private static final String FILE_PATH = "filePath";
	
	

	public void init() throws ServletException {}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {

		try {
			response.setContentType(CONTENT_TYPE);
			
			/**
			 * 对中文乱码问题的处理
			 * JAVA在网络传输中使用的编码是"ISO-8859-1"，故在输出时需要进行转化
			 */
			String filePath = new String(request.getParameter(FILE_PATH).getBytes("iso-8859-1"), "GBK");
			String fileName = request.getParameter(FILE_NAME);
			if (null != fileName && !"".equals(fileName)) {
				fileName = new String(fileName.getBytes("iso-8859-1"), "GBK");
			} else {
				fileName = "download";
			}
	

			File file = new File(PathUtil.getPath(filePath));
			
			response.setContentType(RESPONSE_CONTENT_TYPE);
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", 
					           "attachment;filename=" + new String(getFileName(fileName,filePath).getBytes("GBK"), "iso-8859-1")
					           );
	
			if (!file.exists()) 
			{
				response.sendRedirect("jsp/errors/error500.jsp");
			}
			else 
			{
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream buff = new BufferedInputStream(fis);
				
				byte[] b = new byte[1024];         //相当于我们的缓存
				int k = 0;                         //该值用于计算当前实际下载了多少字节
				OutputStream myout = response.getOutputStream();
				while (-1 != (k = buff.read(b, 0, b.length))) {
					myout.write(b, 0, k);
				}
				myout.flush();
				myout.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
		    log.error(sw.toString());
		    response.sendRedirect("jsp/errors/error500.jsp");
		}
	}
    
	/**
	 * Function : getFileName;           
	 * Author : dongk Version : 1.0, First complete date : 2017年10月20日 
	 * Description : 根据fileName和filePath得到完整的fileName
	 * Params :
	 * @param 
	 * @return:     如果fileName缺少后缀(如.txt)，则补全，否则直接返回fileName
	 */
	private  String getFileName(String fileName, String filePath){
		String fileNameSuffix = fileName.lastIndexOf(".")==-1?"":fileName.substring(fileName.lastIndexOf("."));
		String filePathSuffix = filePath.substring(filePath.lastIndexOf("."));
		if(fileNameSuffix.equals(filePathSuffix)){
			return fileName;
		}else{
			return fileName + filePathSuffix;
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {}

}