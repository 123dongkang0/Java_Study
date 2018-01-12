<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
 <base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title>MultiImageDialog Examples</title>
		<link rel="stylesheet" href="javaScript/kindEditor/themes/default/default.css" />
		<script src="javaScript/kindEditor/kindeditor-all-min.js"></script>
		<script src="javaScript/kindEditor/lang/zh-CN.js"></script>
		<script src="scripts/jquery-1.8.3.js"></script>
		<script>
		   
		var contextPath= "${pageContext.request.contextPath}";
		var uploadUrl = contextPath + "/FileUploadServlet";
		   var editor;
			KindEditor.ready(function(K) {
				editor = K.editor({
					allowFileManager : true,
					uploadJson:uploadUrl,
					imageSizeLimit : '500KB'
				});
			});
			
			
		</script>
	</head>
	<body>
		<input type="button" id="J_selectImage" value="批量上传" />
		<div id="J_imageView"></div>
	</body>
	<script>
		$("#J_selectImage").click(function() {
			editor.loadPlugin('multiimage', function() {
				editor.plugin.multiImageDialog({
					clickFn : function(urlList) {
						var div = $("#J_imageView");
						div.html("");
						K.each(urlList, function(i, data) {
							div.append("<img src='" + data.url + "'>");
						});
						editor.hideDialog();
					}
				});
			});
		 });
	</script>
</html>
