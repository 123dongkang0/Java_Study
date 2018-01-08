package com.dongk.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import sun.misc.BASE64Encoder;

public class FileUtils {
	
	/**
	 * 将文件转成base64 字符串
	 * @param path文件路径
	 * @return  base64字符串
	 * @throws Exception
	 */
	 public static String encodeBase64File(String pathFile) throws Exception {
		 
		 FileInputStream fin =null;  
	        BufferedInputStream bin =null;  
	        ByteArrayOutputStream baos = null;  
	        BufferedOutputStream bout =null; 
	        BASE64Encoder encoder = new sun.misc.BASE64Encoder();  
	        try {  
	            //建立读取文件的文件输出流  
	            fin = new FileInputStream(pathFile);  
	            //在文件输出流上安装节点流（更大效率读取）  
	            bin = new BufferedInputStream(fin);  
	            // 创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量  
	            baos = new ByteArrayOutputStream();  
	            //创建一个新的缓冲输出流，以将数据写入指定的底层输出流  
	            bout = new BufferedOutputStream(baos);  
	            byte[] buffer = new byte[1024];  
	            int len = bin.read(buffer);  
	            while(len != -1){  
	                bout.write(buffer, 0, len);  
	                len = bin.read(buffer);  
	            }  
	            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题  
	            bout.flush();  
	             byte[] bytes = baos.toByteArray();  
	             //sun公司的API  
	             return encoder.encodeBuffer(bytes).trim();    
	             //apache公司的API  
	             //return Base64.encodeBase64String(bytes);  
	              
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }finally{  
	            try {  
	                fin.close();  
	                bin.close();  
	                //关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException  
	                //baos.close();  
	                bout.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return null; 

	 }
	 
	 /**
	 * Function : copyFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017年07月25日 
	 * Description : 复制文件 
	 * @Params ： oldPath : 源文件路径
	 * @param     dir ：    目标文件夹路径
	 * @param    addYMD: 是否需要加年月日
	 * @return
	 */
	public static String copyFile(String oldPath, String dir, String fileName,boolean addYMD) {
		BufferedInputStream inStream =  null;
	    BufferedOutputStream fs = null;
		try {
			String newFileDir = "";
			if(addYMD){
				newFileDir = createFileDir(getDatePath(dir));
			}else{
				newFileDir = createFileDir(dir);
			}
			newFileDir = newFileDir + System.getProperty("file.separator") + fileName;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				 inStream = new BufferedInputStream(new FileInputStream(oldPath)); // 读入原文件
				 fs = new BufferedOutputStream(new FileOutputStream(newFileDir));
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
			return newFileDir;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 关闭资源
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	/**
	 * Function : 创建文件夹 ;       
	 * @param sFileDir : 文件夹路径
	 * @return 文件夹路径
	 */
	public static String createFileDir(String sFileDir) {
		File file = new File(sFileDir);

		if (!file.isDirectory()) {
			// 不存在则创建文件夹并返回文件夹路径
			try {
				// 创建文件夹
				org.apache.commons.io.FileUtils.forceMkdir(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sFileDir;
	}
	
	/**
	 * Function : 得到指定文件夹下创建年月日目录的路径String           
	 * @param path : 指定文件夹
	 * @return  在指定文件夹下加入日期信息后的路径
	 */
	public static String getDatePath(String path){
		Date date = new Date();
		return path 
			+ System.getProperty("file.separator")
			+ DateHelper.getDateFormatStr("yyyy",date)
			+ System.getProperty("file.separator") 
			+ DateHelper.getDateFormatStr( "MM",date)
			+ System.getProperty("file.separator") 
			+ DateHelper.getDateFormatStr( "dd",date);
	}
}
