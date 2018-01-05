package com.dongk.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class POIParseUtil {
	
	private static Workbook readFile(String fileName) throws Exception {
		
		FileInputStream fis = null;
		Workbook wb;
		try{
			fis = new FileInputStream(fileName);
			wb = WorkbookFactory.create(fis);
		}catch(Exception ie){
			throw ie;
		}finally{
			fis.close();
		}
		return wb;
		
	}
	
	private static final int USE_SHEET = 0;    //使用第几个Sheet
	
	
	public static String getJsonStr(String filaName) throws Exception {
	    Workbook wb = readFile(filaName);
	    Sheet sheet = wb.getSheetAt(USE_SHEET);
        int rowNum = sheet.getLastRowNum();
        
        
        
		return "";
	}
    
	public static void main(String args[]){
		try {
			readFile("aa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}
