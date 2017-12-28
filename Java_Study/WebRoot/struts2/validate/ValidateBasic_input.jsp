<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Struts2 Showcase - Validation - Basic</title>
    
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
		<h1>Basic validation Example</h1>
	</div>
	
	<div>
		<div>
			<div>
	
				<p>
					<b>What is your favorite color?</b>
	
				<p/>
	
				<s:form method="post" action="validate/basicAction_inputBasicValidatePage.action">
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
