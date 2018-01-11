<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>
		<meta charset="utf-8" />
		<title>MultiImageDialog Examples</title>
		<link rel="stylesheet" href=themes/default/default.css" />
		<script src="kindeditor-all-min.js"></script>
		<script src="lang/zh-CN.js"></script>
		<script>
			KindEditor.ready(function(K) {
				var editor = K.editor({
					allowFileManager : true
				});
				K('#J_selectImage').click(function() {
					editor.loadPlugin('multiimage', function() {
						editor.plugin.multiImageDialog({
							clickFn : function(urlList) {
								var div = K('#J_imageView');
								div.html('');
								K.each(urlList, function(i, data) {
									div.append('<img src="' + data.url + '">');
								});
								editor.hideDialog();
							}
						});
					});
				});
			});
		</script>
	</head>
	<body>
		<input type="button" id="J_selectImage" value="批量上传" />
		<div id="J_imageView"></div>
	</body>
</html>
