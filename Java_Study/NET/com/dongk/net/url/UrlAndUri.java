package com.dongk.net.url;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 *  从JDK1.5开始，
 *  
 *  java.net包对统一资源定位符
 *  
 *  (uniform resource locator URL)
 *  
 *  和统一资源标识符
 *  
 *  (uniform resource identifier URI)
 *  
 *  作了非常明确的区分。
 *  
 * （1）URI是个纯粹的句法结构，用于指定标识Web资源的字符串的各个不同部分。 URL是URI的一个特例，
 *      它包含了定位Web资源的足够信息。其他URI，比如：
 *      
 *      mailto：cay@horstman.com 
 *      
 *      则不属于定位符，因为根据该标识符无法定位任何资源
 *      
 *  (2) URI 是统一资源标识符，而 URL 是统一资源定位符。因此，笼统地说，每个 URL 都是 URI，
 *      但不一定每个 URI 都是 URL。这是因为 URI 还包括一个子类，即统一资源名称 (URN)，它命名资源但不指定如何定位资源。
 *      上面的 mailto、news 和 isbn URI 都是 URN 的示例。
 *      
 *      URI 和 URL 概念上的不同反映在此类和 URL 类的不同中。
 *    
 *      此类的实例代表由 RFC 2396 定义的语法意义上的一个 URI 引用。URI 可以是绝对的，也可以是相对的。
 *      对 URI 字符串按照一般语法进行解析，不考虑它所指定的方案（如果有）不对主机（如果有）执行查找，也不构造依赖于方案的流处理程序。
 *      相等性、哈希计算以及比较都严格地根据实例的字符内容进行定义。换句话说，一个 URI 实例和一个支持语法意义上的、依赖于方案的比较、
 *      规范化、解析和相对化计算的结构化字符串差不多。
 *    
 *      作为对照，URL 类的实例代表了 URL 的语法组成部分以及访问它描述的资源所需的信息。URL 必须是绝对的，即它必须始终指定一个方案。
 *      URL 字符串按照其方案进行解析。通常会为 URL 建立一个流处理程序，实际上无法为未提供处理程序的方案创建一个 URL 实例。
 *      相等性和哈希计算依赖于方案和主机的 Internet 地址（如果有）；没有定义比较。换句话说，URL 是一个结构化字符串，
 *      它支持解析的语法运算以及查找主机和打开到指定资源的连接之类的网络 I/O 操作。
 *      
 *      在Java类库中，URI类不包含任何访问资源的方法，它唯一的作用就是解析。
 *      
 *      相反的是，URL类可以打开一个到达资源的流。
 *      
 *      因此URL类只能作用于那些 Java类库知道该如何处理的模式，
 *      
 *      例如http：，https：，ftp：，本地文件系统(file：)，和Jar文件(jar：)。
 *      
 *      URI—Uniform Resource Identifier通用资源标志符。
 *      Web上可用的每种资源如HTML文档、图像、视频片段、 程序等都是一个来URI来定位的URI一般由三部组成
 *      (1)访问资源的命名机制;
 *      (2)存放资源的主机名;
 *      (3)资源自身的名称，由路径表示，着重强调于资源。
 *      
 *      
 *      URL—Uniform Resource Location统一资源定位符。
 *      URL是Internet上用来描述信息资源的字符串，主要用在各种WWW客户程序和服务器程序上，特别是著名的Mosaic。
 *      采用URL可以用一种统一的格式来描述各种信息资源，包括文件、服务器的地址和目录等。
 *      URL一般由三部组成
 *      (1)协议(或称为服务方式);
 *      (2)存有该资源的主机IP地址(有时也包括端口号);
 *      (3)主机资源的具体地址。如目录和文件名等;
 *      
 *      应用：
 *      
 *      一  、 URI
 *      
 *      比如在JDK中sun公司提供的简易HttpServer实现中
 *      public void handle（final HttpExchange exchange）throws Exception方法中，
 *      根据exchange对象可以拿到访问Http请求的URI对象，
 *      ps：
 *      
 *      http://127.0.0.1:8080/cmd_helloworld/?name=guowuxin
 *      
 *      此时URI uri = exchange.getRequestURI（）；
 *      通过uri可以拿到连接的各部分内容：
 *      uri.getPath（）  --------------------> /cmd_helloworld   注意有斜杠
 *      uri.getQuery（）----------------------> name=guowuxin
 *      
 *      当然如果是post请求，请求内容在请求body当中
 *      
 *     二、 URL 
 *     
 *     上面说了，URL 是一个结构化字符串，它支持解析的语法运算以及查找主机和打开到指定资源的连接之类的网络 I/O 操作。
 *     
 *     重要的，URL不仅仅可以进行语法解析运算，还可以查找主机，并且打开指定资源的连接进行网络IO操作。
 *     
 *     介绍URL类的两个重要方法
 *       
 *     openStream() ： 打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。
 *     
 *     openConnection()：  返回一个 URLConnection 对象，它表示到 URL 。
 *     
 *     所引用的远程对象的连接。
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
 *     上面的程序通过openStream()方法获取访问URL获取的输入流，从而读取响应内容，ps响应内容是过滤掉响应头了的。
 *     
 *     openConnection()方法就可以getOutputStream（）以及 getInputStream()，
 *     可以更灵活的进行request和response
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
