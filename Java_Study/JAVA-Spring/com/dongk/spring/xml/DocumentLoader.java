package com.dongk.spring.xml;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * 加载一个XML文档的接口
 * 
 *@author Dongk
 *@see  DefaultDocumentLoader
 */
public interface DocumentLoader {
    
	/**
	 * 根据提供的资源,加载一个XML文档
	 * 
	 *@author Dongk
	 *@param inputSource : 文档加载的来源
	 *@param entityResolver : 实体解析器
	 *@param errorHandler : 报告文档加载过程中出现的错误
	 *@param validationMode: 验证模式
	 *@param namespaceAware: 是否支持XML名称空间
	 *@return Document文档
	 */
	Document loadDocument(
            InputSource inputSource, EntityResolver entityResolver,
            ErrorHandler errorHandler,int validationMode, boolean  namespaceAware
			) 
			throws Exception;
}
