package com.dongk.util;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
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
	
	private static final int START_ROW = 1;    //开始的行数
	
	
	public static String getJsonStr(String filaName, POIParseJsonBean[] cellProperties, int dateFormat) throws Exception {
		
		JSONObject   resultJson = new JSONObject();
		boolean isValidate = true;                //校验是否通过
		String info = "";
        JSONArray arryJson = new JSONArray();
        
	    Workbook wb = readFile(filaName);
	    Sheet sheet = wb.getSheetAt(USE_SHEET);
        int rowNum = sheet.getLastRowNum();
        for(int i=START_ROW; (i<=rowNum && isValidate) ; i++ ){
        	Row r = sheet.getRow(i);
            if (r == null) {
               continue;
            }else{
            	JSONObject objectJson = new JSONObject();
                 for (int cn = 0; cn < cellProperties.length; cn++) {
                     Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
                     
                     POIParseJsonBean bean = cellProperties[cn];
                     String cellStr = "";
                    
                     if (c == null) {
                    
                     } else {
                    	 cellStr = getCellString(c,dateFormat);
                     }
                     
                     String validateStr = bean.getValidateType().validate(cellStr,bean.getValidateCondition(),false);
                	 if("1".equals(validateStr)){  //校验成功
                		 objectJson.put(bean.getKeyName(), cellStr);
                	 }else{
                		 info = "第" + (i + 1) + "行，第" + (cn + 1) + "列；" + validateStr;
                		 isValidate = false;
                		 break;
                	 }
                     
                 }
                 arryJson.add(objectJson);
            }
        }
        
        resultJson.put("result", isValidate ? "1" : "0");
        resultJson.put("info", info);
        resultJson.put("data", isValidate ? arryJson.toString() : "[]");
        
        
		return resultJson.toString();
	}
	
    private final static Map<Integer, String> dateFormatType = new HashMap<Integer, String>();
	
	static{
		dateFormatType.put(1, "yyyy-MM-dd");   
		dateFormatType.put(2, "yyyy-MM-dd HH:mm:ss");  
	}
	
	private static String getCellString(Cell cell, int dateFormat){
		 String cellStr = "";
		 switch (cell.getCellType()) {
	         case Cell.CELL_TYPE_STRING:
	        	  cellStr = cell.getRichStringCellValue().getString();
	              break;
	         case Cell.CELL_TYPE_NUMERIC:
	              if (DateUtil.isCellDateFormatted(cell)) {
	            	  SimpleDateFormat sdf=new SimpleDateFormat(dateFormatType.get(dateFormat));  
	            	  cellStr =  sdf.format(cell.getDateCellValue());
	              } else {
	            	  if(cell.getNumericCellValue() % 1 == 0){  //整数
	            		  cellStr = String.valueOf(new Double(cell.getNumericCellValue()).intValue());
	            	  }else{            //非整数
	            		  cellStr = String.valueOf(cell.getNumericCellValue());
	            	  }
	              }
	              break;
	         case Cell.CELL_TYPE_BOOLEAN:
	        	  cellStr = String.valueOf(cell.getBooleanCellValue());
	              break;
	         case Cell.CELL_TYPE_FORMULA:
	        	  cellStr = cell.getCellFormula();
	              break;
	         default:
	        	  cellStr = "";
	     }
		 return cellStr;
	}
    
	public static void main(String args[]){
		try {
			POIParseJsonBean[] cellProperties = {
			               new POIParseJsonBean("name",POIParseJsonValidate.NO_VALIDATE,null,false),
			               new POIParseJsonBean("age",POIParseJsonValidate.NUMBER_VALIDATE,new String[]{"2","0"},false),
			               new POIParseJsonBean("address",POIParseJsonValidate.NO_VALIDATE,null,true),
			               new POIParseJsonBean("birthday",POIParseJsonValidate.DATE_VALIDATE,new String[]{"2"},false),
			               new POIParseJsonBean("isHome",POIParseJsonValidate.NO_VALIDATE,null,false)
			                   };
			System.out.println(getJsonStr("D:\\POIParseTest.xlsx",cellProperties,2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}
