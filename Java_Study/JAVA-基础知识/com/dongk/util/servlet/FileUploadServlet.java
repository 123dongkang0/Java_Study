package com.dongk.util.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.dongk.util.Config;
import com.dongk.util.PathUtil;

public class FileUploadServlet extends HttpServlet {

	private static Logger log = Logger.getLogger(FileUploadServlet.class);
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=GBK");
		PrintWriter out = response.getWriter();
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("GBK");
		try {
			List items = upload.parseRequest(request);
			if (null != items) {
				Iterator itr = items.iterator();
				while (itr.hasNext()) {
					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {
						continue;
					} else {
						out.write(uploadCache(item));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			log.error(sw.toString());
			String jsonMsg = getError("上传出错，请与管理员联系！");
			out.write(jsonMsg);
		}finally{
			out.flush();
			out.close();
		}
	}
	
	/**
	 * 上传至缓存目录
	 * @param item
	 * @return
	 * @throws Exception
	 */
	private String uploadCache(FileItem item) throws Exception{
		String oldFileName = getFileName(item.getName());         //旧的文件名
		String newFileName = generateFileName(item.getName());    //新的文件名
		String filePath = Config.getProperty("upload.cache.dir") + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date());
    	if (!new File(filePath).exists() && !new File(filePath).isDirectory()) {
			new File(filePath).mkdirs();
		}
		File savedFile = new File(filePath, newFileName);         //上传的文件存入缓存文件夹中
		item.write(savedFile);
		return getNormal(PathUtil.getVirtualPath(filePath + File.separator + newFileName), oldFileName);
	}
	
	private static String getFileName(String filePath) {
		return FilenameUtils.getName(filePath);
	}
	
	private static String generateFileName(String fileName) {
		String newFileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000);
		String prefix = FilenameUtils.getExtension(fileName);
		if (prefix != null && !"".equals(prefix)) {
			newFileName += "." + prefix;
		}
		return newFileName;
	}
	
	private static String getNormal(String url, String fileName) {
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", url);
		obj.put("name", fileName);
		return obj.toString();
	}

	private static String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}

}