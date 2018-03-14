package com.itextpdf.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dongk.util.JsonConvertUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
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
	        
	        Document document = new Document(PageSize.A4);
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        document.open();
	        
	        XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
	        worker.parseXHtml(writer, 
	        		          document, 
	        		          new ByteArrayInputStream(htmlStream.toByteArray()), 
	        		          null, 
	        		          Charset.forName("UTF-8"), 
	        		          new AsianFont());
	        
	        document.close();
	        
	        return relativeAll;
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "";
    }
    
    private static class AsianFont extends XMLWorkerFontProvider{
		@Override
		public Font getFont(String fontname, String encoding, boolean embedded, float size, int style,BaseColor color) {
            return new Font(CHINESE_FONT, 12, Font.NORMAL);
		}
    }
    
    /**
    * <b>Description:得到文件相对路径。</b><br> 
    * @Note
    * <b>Author:dongk</b>
    * <br><b>Date:</b> 2018年3月14日 上午9:28:27
    * <br><b>Version:</b> 1.0
    * <br><b>param:</b>
    * <br><b>return:</b>返回生成的相对路径。
    */
    public static String getFilePath() {
    	String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()) + (int)(Math.random()*9000+1000) + ".pdf";
  		return  FILE_RELATIVE + File.separator + fileName;
    }
    
    /**
    * <b>Description:创建Document对象，并且打开。</b><br> 
    * @Note
    * <b>Author:dongk</b>
    * <br><b>Date:</b> 2018年3月14日 上午9:24:48
    * <br><b>Version:</b> 1.0
    * <br><b>param:filePath：文件路径(相对)</b>
    * <br><b>return:</b>
    */
    public static Document  createDocument(String filePath) throws IOException, DocumentException {
    	String  filePathAll = FILE_ROOT + File.separator + filePath;
    	
    	Document document = new Document();
    	PdfWriter.getInstance(document, new FileOutputStream(filePathAll));
    	document.open();
    	
    	return document;
    }
    
    public static void closeDocument(Document document) {
    	document.close();
    }
    
    public static final String FONT_POSITION = "C:\\Windows\\Fonts\\STZHONGS.TTF";    //字体的位置
    
    /**
    * <b>Description:增加标题。</b><br> 
    * @Note
    * <b>Author:dongk</b>
    * <br><b>Date:</b> 2018年3月14日 上午9:38:54
    * <br><b>Version:</b> 1.0
    * <br><b>param:</b>
    * <br><b>return:</b>
    */
    public static void addTitle(Document doucment, String title) throws DocumentException {
    	Font chapterFont = FontFactory.getFont(FONT_POSITION, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    	chapterFont.setSize(18);   
    	
    	Chunk chunk = new Chunk(title,chapterFont);
    	
    	Paragraph paragraph = new Paragraph(chunk);
    	paragraph.setAlignment(1);   //段落居中对齐
    	
    	Chapter chapter = new Chapter(paragraph, 1);
    	chapter.setNumberDepth(0);
    	
    	doucment.add(chapter);
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
        
        List loves = new ArrayList<Hobby>();
        Hobby love1 = new Hobby();
        love1.setLevel("6");
        love1.setName("basketball");
        Hobby love2 = new Hobby();
        love2.setLevel("8");
        love2.setName("足球");
        loves.add(love1);
        loves.add(love2);
        root.put("loves", loves);
        
    	createPdfByHtml(root,"D:\\upload","tgs_test.html");
    	
//    	try {
//			Document document = createDocument(getFilePath());
//			addTitle(document,"船员名单");
//			closeDocument(document);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
    }
}

