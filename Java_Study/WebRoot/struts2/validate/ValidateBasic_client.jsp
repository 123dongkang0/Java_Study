<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户端验证</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

	<div>
		<h1>客户端验证</h1>
	</div>
	
	<div>
		<div>
			<div>
	
				<p>
					&nbsp;&nbsp;struts2的客户端验证只需要加入validate="true"就可以了，其它地方和BasicValidate一模一样。
					点击提交按钮则提示配置的内容。
					
					访问地址：http://localhost:8080/Java_Study/struts2/validate/ValidateBasic_client.jsp
	
				<p/>
	
				<s:form method="post" action="validate/basicAction_inputBasicValidatePage.action" validate="true">
					<s:textfield label="Name" name="name"/>
					<s:textfield label="Age" name="age"/>
					<s:textfield label="Favorite color" name="answer"/>
					<s:submit />
				</s:form>
			</div>
		</div>
	</div>
	
  </body>
</html>
