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

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUtils {
	/**
	  * ���ļ�ת��base64 �ַ���
	  * @param path�ļ�·��
	  * @return  * 
	  * @throws Exception
	  */

	 public static String encodeBase64File(String pathFile) throws Exception {
		 FileInputStream fin =null;  
	        BufferedInputStream bin =null;  
	        ByteArrayOutputStream baos = null;  
	        BufferedOutputStream bout =null; 
	        BASE64Encoder encoder = new sun.misc.BASE64Encoder();  
	        try {  
	            //������ȡ�ļ����ļ������  
	            fin = new FileInputStream(pathFile);  
	            //���ļ�������ϰ�װ�ڵ���������Ч�ʶ�ȡ��  
	            bin = new BufferedInputStream(fin);  
	            // ����һ���µ� byte �����������������ָ����С�Ļ���������  
	            baos = new ByteArrayOutputStream();  
	            //����һ���µĻ�����������Խ�����д��ָ���ĵײ������  
	            bout = new BufferedOutputStream(baos);  
	            byte[] buffer = new byte[1024];  
	            int len = bin.read(buffer);  
	            while(len != -1){  
	                bout.write(buffer, 0, len);  
	                len = bin.read(buffer);  
	            }  
	            //ˢ�´��������ǿ��д�����л��������ֽڣ��������д��룬�����п���������  
	            bout.flush();  
	             byte[] bytes = baos.toByteArray();  
	             //sun��˾��API  
	             //return encoder.encodeBuffer(bytes).trim();    
	             //apache��˾��API  
	             return Base64.encodeBase64String(bytes);  
	              
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }finally{  
	            try {  
	                fin.close();  
	                bin.close();  
	                //�ر� ByteArrayOutputStream ��Ч�������еķ����ڹرմ������Կɱ����ã�����������κ� IOException  
	                //baos.close();  
	                bout.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        return null; 

	 }
	 

	 /**
	* <b>Description:��base64����ת�����ļ�</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��22�� ����11:37:04
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	public static void decoderBase64File(String base64Code, String targetPath)
	   throws Exception {
		  byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
		  FileOutputStream out = new FileOutputStream(targetPath);
		  out.write(buffer);
		  out.close();
	 }
	 
	 /**
	 * Function : copyFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017��07��25�� 
	 * Description : �����ļ� 
	 * @Params �� oldPath : Դ�ļ�·��
	 * @param     dir ��    Ŀ���ļ���·��
	 * @param    addYMD: �Ƿ���Ҫ��������
	 * @return
	 */
	public static String copyFile(String oldPath, String dir, String fileName,boolean addYMD) {
		InputStream inStream =  null;
		FileOutputStream fs = null;
		try {
			String newFileDir = "";
			if(addYMD){
				newFileDir = createFileDir(getDatePath(dir));
			}else{
				newFileDir = createFileDir(dir);
			}
			newFileDir = newFileDir + "\\" + fileName;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // �ļ�����ʱ
				 inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				 fs = new FileOutputStream(newFileDir);
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
			// �ر���Դ
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
	 * Function : copyFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017��07��25�� 
	 * Description : �����ļ��� 
	 * @return
	 */
	public static String createFileDir(String sFileDir) {
		File file = new File(sFileDir);

		if (!file.isDirectory()) {
			// �������򴴽��ļ��в������ļ���·��
			try {
				// �����ļ���
				org.apache.commons.io.FileUtils.forceMkdir(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sFileDir;
	}
	
	/**
	 * Function : delFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017��07��25�� 
	 * Description : ɾ���ļ�
	 * @return
	 */
	public static void delFile(String filePathAndName) throws Exception{
		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			java.io.File myDelFile = new java.io.File(filePath);
			myDelFile.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function : copyFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017��07��25�� 
	 * Description : �õ�ָ���ļ����´���������Ŀ¼��·��String
	 * @return
	 */
	public static String getDatePath(String path){
		Date date = new Date();
		return path 
			+ FilePathUtil.SEPARATOR
			+ DateHelper.getDateFormatStr("yyyy",date)
			+ FilePathUtil.SEPARATOR 
			+ DateHelper.getDateFormatStr( "MM",date)
			+ FilePathUtil.SEPARATOR 
			+ DateHelper.getDateFormatStr( "dd",date);
	}
}
