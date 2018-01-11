<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>kindeditord文件上传工具</title>
    
	<!-- 文件上传工具类 -->
	<link rel="stylesheet" href="themes/default/default.css" />
	<link rel="stylesheet" href="plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor-all-min.js"></script>
	<script charset="utf-8" src="lang/zh-CN.js"></script>
	<script charset="utf-8" src="plugins/code/prettify.js"></script>

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
