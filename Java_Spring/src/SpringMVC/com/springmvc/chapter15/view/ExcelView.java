package com.springmvc.chapter15.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelView extends AbstractXlsView {

	// �ļ���
	private String fileName = null;

	// ������ͼ�Զ���ӿ�
	private ExcelExportService excelExpService = null;

	// ���췽��1
	public ExcelView(ExcelExportService excelExpService) {
		this.excelExpService = excelExpService;
	}

	// ���췽��2
	public ExcelView(String viewName, ExcelExportService excelExpService) {
		this.setBeanName(viewName);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ExcelExportService getExcelExpService() {
		return excelExpService;
	}

	public void setExcelExpService(ExcelExportService excelExpService) {
		this.excelExpService = excelExpService;
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// û���Զ���ӿ�
		if (excelExpService == null) {
			throw new RuntimeException("��������ӿڲ���Ϊnull����");
		}
		// �ļ�����Ϊ�գ�Ϊ����ʹ������·���е��ַ�����Ϊ�ļ���
		if (!StringUtils.isEmpty(fileName)) {
			// �����ַ�ת��
			String reqCharset = request.getCharacterEncoding();
			reqCharset = reqCharset == null ? "UTF-8" : reqCharset;
			fileName = new String(fileName.getBytes(reqCharset), "ISO8859-1");
			// ���������ļ���
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		}
		// �ص��ӿڷ�����ʹ���Զ�������Excel�ĵ�
		excelExpService.makeWorkBook(model, workbook);
	}

}