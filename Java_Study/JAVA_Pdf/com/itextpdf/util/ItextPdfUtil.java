package com.itextpdf.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.dongk.util.Config;
import com.dongk.util.FilePathUtil;
import com.dongk.util.JsonConvertUtil;
import com.dongk.util.StringUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

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
    * @Note 会和 xalan.jar包冲突
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
			reader = new PdfReader(templatePath);
			
			String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000) + ".pdf",
	    		   relativeAll = FILE_RELATIVE + FilePathUtil.SEPARATOR + fileName,
	    		   filePath = FILE_ROOT + FilePathUtil.SEPARATOR + relativeAll;
			
		    stamper = new PdfStamper(reader, new FileOutputStream(filePath));
		    
		    AcroFields form = stamper.getAcroFields();
	    	java.util.Iterator<String> it = form.getFields().keySet().iterator();  
	        while (it.hasNext()) {  
	            String name = it.next().toString();  
	            form.setFieldProperty(name, "textfont", CHINESE_FONT, null);
	            form.setField(name, StringUtils.dataToString(JsonConvertUtil.get(data, name))); 
	        }
	        
	       stamper.setFormFlattening(true);//设置pdf为不可编辑  
	       
	       return relativeAll;
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
    
    private static final String FILE_ROOT = Config.getProperty("file.root");
    private static final String FILE_RELATIVE = "itextPdf";
    
    static {
	    cfg.setDefaultEncoding("UTF-8");
	    
	    if (!new File(FILE_ROOT + FilePathUtil.SEPARATOR + FILE_RELATIVE).exists() && !new File(FILE_ROOT + FilePathUtil.SEPARATOR + FILE_RELATIVE).isDirectory()) {
			new File(FILE_ROOT + FilePathUtil.SEPARATOR + FILE_RELATIVE).mkdirs();
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
    	
    	String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000),
    		   pdfName =  fileName + ".pdf",
    		   htmlName = fileName + ".html",
 		       relativePath = FILE_RELATIVE + FilePathUtil.SEPARATOR,
 		       pdfPath = FILE_ROOT + FilePathUtil.SEPARATOR + relativePath + FilePathUtil.SEPARATOR + pdfName,
 		       htmlPath = FILE_ROOT + FilePathUtil.SEPARATOR + relativePath + FilePathUtil.SEPARATOR + htmlName;
    	
    	OutputStream pdfOs = null,
			         htmlOs = null;
    	
    	try {
    	    pdfOs = new FileOutputStream(pdfPath);
	        htmlOs = new FileOutputStream(htmlPath);
    	
			cfg.setDirectoryForTemplateLoading(new File(templatePath));
	        Template temp = cfg.getTemplate(templateName);
	        temp.process(data, new OutputStreamWriter(htmlOs,"UTF-8"));

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(new File(htmlPath).toURI().toURL().toString());
            ITextFontResolver fontResolver = renderer.getFontResolver();        
            fontResolver.addFont(templatePath + FilePathUtil.SEPARATOR + "simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  /// 宋体  
            renderer.layout();
            renderer.createPDF(pdfOs);
	        
	        return relativePath + pdfName;
	        
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pdfOs.close();
				htmlOs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	return "";
    }
    
}

