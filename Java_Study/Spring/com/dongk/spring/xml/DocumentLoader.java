package com.dongk.spring.xml;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * ����һ��XML�ĵ��Ľӿ�
 * 
 *@author Dongk
 *@see  DefaultDocumentLoader
 */
public interface DocumentLoader {
    
	/**
	 * �����ṩ����Դ,����һ��XML�ĵ�
	 * 
	 *@author Dongk
	 *@param inputSource : �ĵ����ص���Դ
	 *@param entityResolver : ʵ�������
	 *@param errorHandler : �����ĵ����ع����г��ֵĴ���
	 *@param validationMode: ��֤ģʽ
	 *@param namespaceAware: �Ƿ�֧��XML���ƿռ�
	 *@return Document�ĵ�
	 */
	Document loadDocument(
            InputSource inputSource, EntityResolver entityResolver,
            ErrorHandler errorHandler,int validationMode, boolean  namespaceAware
			) 
			throws Exception;
}
