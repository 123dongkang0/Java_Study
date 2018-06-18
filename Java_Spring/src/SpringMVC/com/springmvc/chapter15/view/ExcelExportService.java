package com.springmvc.chapter15.view;

import java.util.Map;
import org.apache.poi.ss.usermodel.Workbook;
public interface ExcelExportService {
	
	/***
	 *  ����exel�ļ�����
	 * @param model ����ģ��
	 * @param workbook excel workbook
	 */
	public void makeWorkBook(Map<String, Object> model, Workbook workbook);

}