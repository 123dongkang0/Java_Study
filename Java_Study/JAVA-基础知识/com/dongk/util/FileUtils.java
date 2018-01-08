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
	 * ���ļ�ת��base64 �ַ���
	 * @param path�ļ�·��
	 * @return  base64�ַ���
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
	             return encoder.encodeBuffer(bytes).trim();    
	             //apache��˾��API  
	             //return Base64.encodeBase64String(bytes);  
	              
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
	 * Function : copyFile;           
	 * Author : dongk Version : 1.0, First complete date : 2017��07��25�� 
	 * Description : �����ļ� 
	 * @Params �� oldPath : Դ�ļ�·��
	 * @param     dir ��    Ŀ���ļ���·��
	 * @param    addYMD: �Ƿ���Ҫ��������
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
			if (oldfile.exists()) { // �ļ�����ʱ
				 inStream = new BufferedInputStream(new FileInputStream(oldPath)); // ����ԭ�ļ�
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
	 * Function : �����ļ��� ;       
	 * @param sFileDir : �ļ���·��
	 * @return �ļ���·��
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
	 * Function : �õ�ָ���ļ����´���������Ŀ¼��·��String           
	 * @param path : ָ���ļ���
	 * @return  ��ָ���ļ����¼���������Ϣ���·��
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
