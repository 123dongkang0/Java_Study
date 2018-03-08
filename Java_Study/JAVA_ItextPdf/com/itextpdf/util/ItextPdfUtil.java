package com.itextpdf.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.dongk.util.JsonConvertUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import net.sf.json.JSONObject;

public class ItextPdfUtil {
	
	private static final BaseFont CHINESE_FONT = initChineseFont();
	
	public static BaseFont initChineseFont() {
		try {
			return BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
   /**
    * <b>Description:根据PDF模板生成PDF文件</b><br> 
    * @Note
    * <b>Author:dongk</b>
    * <br><b>Date:</b> 2018年3月8日 上午10:52:45
    * <br><b>Version:</b> 1.0
    * <br><b>param:{templatePath:模板文件路径，}</b>
    * <br><b>return:生成的PDF的文件路径。</b>
    */
    public static String createPdfByTemplete(JSONObject data, String templatePath){
    	PdfReader reader = null;
    	PdfStamper stamper = null;
		try {
			reader = new PdfReader(FILE_ROOT + File.separator  + templatePath);
			
			String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000) + ".pdf",
	    		   relativeAll = FILE_RELATIVE + File.separator + fileName,
	    		   filePath = FILE_ROOT + File.separator + relativeAll;
			
		    stamper = new PdfStamper(reader, new FileOutputStream(filePath));
		    
		    AcroFields form = stamper.getAcroFields();
	    	java.util.Iterator<String> it = form.getFields().keySet().iterator();  
	        while (it.hasNext()) {  
	            String name = it.next().toString();  
	            form.setFieldProperty(name, "textfont", CHINESE_FONT, null);
	            form.setField(name, JsonConvertUtil.get(data, name)); 
	        }
	        
	       stamper.setFormFlattening(true);//设置pdf为不可编辑  
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stamper.close();
			 } catch (DocumentException e) {
				e.printStackTrace();
			 } catch (IOException e) {
				e.printStackTrace();
			 }
			reader.close();
		}
    	  
    	  return "";
    }
    
    private static final Configuration cfg = new Configuration();
    
    private static final String FILE_ROOT = "D:\\upload";
    private static final String FILE_RELATIVE = "itextPdf";
    
    static {
	    cfg.setDefaultEncoding("UTF-8");
	    
	    if (!new File(FILE_ROOT + File.separator + FILE_RELATIVE).exists() && !new File(FILE_ROOT + File.separator + FILE_RELATIVE).isDirectory()) {
			new File(FILE_ROOT + File.separator + FILE_RELATIVE).mkdirs();
		}
    }
    
    /**
     * <b>Description:根据html模板生成PDF文件</b><br> 
     * @Note
     * <b>Author:dongk</b>
     * <br><b>Date:</b> 2018年3月8日 上午10:52:45
     * <br><b>Version:</b> 1.0
     * <br><b>param:{data:数据；templatePath:模板文件路径; templateName:模板文件文件名称。}</b>
     * <br><b>return:生成的PDF的文件路径。</b>
     */
    public static String createPdfByHtml(Map data, String templatePath, String templateName) {
    	try {
    		String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000) + ".pdf",
    		       relativeAll = FILE_RELATIVE + File.separator + fileName,
    		       filePath = FILE_ROOT + File.separator + relativeAll;
    		
			cfg.setDirectoryForTemplateLoading(new File(templatePath));
	        Template temp = cfg.getTemplate(templateName);
	        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
	        temp.process(data, new OutputStreamWriter(htmlStream,"UTF-8"));
	        
	        Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        document.open();
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,new ByteArrayInputStream(htmlStream.toByteArray()));
	        document.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    }
    
    public static void main(String args[]) {
    	//1. pdf模板
//    	JSONObject data = new JSONObject();
//    	data.put("declarPort", "大铲湾检验检疫局fsasfdafda大铲湾检验检疫局大铲湾检验检疫局");
//    	data.put("ciqOrgno", "大铲湾检验检疫局");
//    	createPdfByTemplete(data, "tgs_enterprise.pdf");
    	
    	//html模板
    	Map root = new HashMap();
        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        root.put("latestProduct", latest);
        
    	createPdfByHtml(root,"D:\\upload","tgs_test.html");
    }
}

