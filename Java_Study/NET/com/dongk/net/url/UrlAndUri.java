package com.dongk.net.url;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 *  ��JDK1.5��ʼ��
 *  
 *  java.net����ͳһ��Դ��λ��
 *  
 *  (uniform resource locator URL)
 *  
 *  ��ͳһ��Դ��ʶ��
 *  
 *  (uniform resource identifier URI)
 *  
 *  ���˷ǳ���ȷ�����֡�
 *  
 * ��1��URI�Ǹ�����ľ䷨�ṹ������ָ����ʶWeb��Դ���ַ����ĸ�����ͬ���֡� URL��URI��һ��������
 *      �������˶�λWeb��Դ���㹻��Ϣ������URI�����磺
 *      
 *      mailto��cay@horstman.com 
 *      
 *      �����ڶ�λ������Ϊ���ݸñ�ʶ���޷���λ�κ���Դ
 *      
 *  (2) URI ��ͳһ��Դ��ʶ������ URL ��ͳһ��Դ��λ������ˣ���ͳ��˵��ÿ�� URL ���� URI��
 *      ����һ��ÿ�� URI ���� URL��������Ϊ URI ������һ�����࣬��ͳһ��Դ���� (URN)����������Դ����ָ����ζ�λ��Դ��
 *      ����� mailto��news �� isbn URI ���� URN ��ʾ����
 *      
 *      URI �� URL �����ϵĲ�ͬ��ӳ�ڴ���� URL ��Ĳ�ͬ�С�
 *    
 *      �����ʵ�������� RFC 2396 ������﷨�����ϵ�һ�� URI ���á�URI �����Ǿ��Եģ�Ҳ��������Եġ�
 *      �� URI �ַ�������һ���﷨���н���������������ָ���ķ���������У���������������У�ִ�в��ң�Ҳ�����������ڷ��������������
 *      ����ԡ���ϣ�����Լ��Ƚ϶��ϸ�ظ���ʵ�����ַ����ݽ��ж��塣���仰˵��һ�� URI ʵ����һ��֧���﷨�����ϵġ������ڷ����ıȽϡ�
 *      �淶������������Ի�����Ľṹ���ַ�����ࡣ
 *    
 *      ��Ϊ���գ�URL ���ʵ�������� URL ���﷨��ɲ����Լ���������������Դ�������Ϣ��URL �����Ǿ��Եģ���������ʼ��ָ��һ��������
 *      URL �ַ��������䷽�����н�����ͨ����Ϊ URL ����һ�����������ʵ�����޷�Ϊδ�ṩ�������ķ�������һ�� URL ʵ����
 *      ����Ժ͹�ϣ���������ڷ����������� Internet ��ַ������У���û�ж���Ƚϡ����仰˵��URL ��һ���ṹ���ַ�����
 *      ��֧�ֽ������﷨�����Լ����������ʹ򿪵�ָ����Դ������֮������� I/O ������
 *      
 *      ��Java����У�URI�಻�����κη�����Դ�ķ�������Ψһ�����þ��ǽ�����
 *      
 *      �෴���ǣ�URL����Դ�һ��������Դ������
 *      
 *      ���URL��ֻ����������Щ Java���֪������δ����ģʽ��
 *      
 *      ����http����https����ftp���������ļ�ϵͳ(file��)����Jar�ļ�(jar��)��
 *      
 *      URI��Uniform Resource Identifierͨ����Դ��־����
 *      Web�Ͽ��õ�ÿ����Դ��HTML�ĵ���ͼ����ƵƬ�Ρ� ����ȶ���һ����URI����λ��URIһ�����������
 *      (1)������Դ����������;
 *      (2)�����Դ��������;
 *      (3)��Դ��������ƣ���·����ʾ������ǿ������Դ��
 *      
 *      
 *      URL��Uniform Resource Locationͳһ��Դ��λ����
 *      URL��Internet������������Ϣ��Դ���ַ�������Ҫ���ڸ���WWW�ͻ�����ͷ����������ϣ��ر���������Mosaic��
 *      ����URL������һ��ͳһ�ĸ�ʽ������������Ϣ��Դ�������ļ����������ĵ�ַ��Ŀ¼�ȡ�
 *      URLһ�����������
 *      (1)Э��(���Ϊ����ʽ);
 *      (2)���и���Դ������IP��ַ(��ʱҲ�����˿ں�);
 *      (3)������Դ�ľ����ַ����Ŀ¼���ļ�����;
 *      
 *      Ӧ�ã�
 *      
 *      һ  �� URI
 *      
 *      ������JDK��sun��˾�ṩ�ļ���HttpServerʵ����
 *      public void handle��final HttpExchange exchange��throws Exception�����У�
 *      ����exchange��������õ�����Http�����URI����
 *      ps��
 *      
 *      http://127.0.0.1:8080/cmd_helloworld/?name=guowuxin
 *      
 *      ��ʱURI uri = exchange.getRequestURI������
 *      ͨ��uri�����õ����ӵĸ��������ݣ�
 *      uri.getPath����  --------------------> /cmd_helloworld   ע����б��
 *      uri.getQuery����----------------------> name=guowuxin
 *      
 *      ��Ȼ�����post������������������body����
 *      
 *     ���� URL 
 *     
 *     ����˵�ˣ�URL ��һ���ṹ���ַ�������֧�ֽ������﷨�����Լ����������ʹ򿪵�ָ����Դ������֮������� I/O ������
 *     
 *     ��Ҫ�ģ�URL���������Խ����﷨�������㣬�����Բ������������Ҵ�ָ����Դ�����ӽ�������IO������
 *     
 *     ����URL���������Ҫ����
 *       
 *     openStream() �� �򿪵��� URL �����Ӳ�����һ�����ڴӸ����Ӷ���� InputStream��
 *     
 *     openConnection()��  ����һ�� URLConnection ��������ʾ�� URL ��
 *     
 *     �����õ�Զ�̶�������ӡ�
 *  
 *     URL url = new URL("http://www.baidu.com");
 *     InputStream in = url.openStream();
 *     ByteArrayOutputStream output = new ByteArrayOutputStream();
 *     byte[] buffer = new byte[1024];
 *     int len = -1;
 *     while ((len = in.read(buffer)) != -1)
 *     {
 *        output.write(buffer, 0, len);
 *     }
 *     System.err.println(new String(output.toByteArray()));
 *      
 *     ����ĳ���ͨ��openStream()������ȡ����URL��ȡ�����������Ӷ���ȡ��Ӧ���ݣ�ps��Ӧ�����ǹ��˵���Ӧͷ�˵ġ�
 *     
 *     openConnection()�����Ϳ���getOutputStream�����Լ� getInputStream()��
 *     ���Ը����Ľ���request��response
 *       
 */
public class UrlAndUri {
    public static void main(String args[]) throws Exception{
    	URL url = new URL("http://www.baidu.com");
    	InputStream in = url.openStream();
    	ByteArrayOutputStream output = new ByteArrayOutputStream();
    	byte[] buffer = new byte[1024];
    	int len = -1;
    	while ((len = in.read(buffer)) != -1)
    	{
           output.write(buffer, 0, len);
    	}
    	System.err.println(new String(output.toByteArray()));
    }
}
