<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'webuploader_demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    
    <link rel="stylesheet" type="text/css" href="javaScript/webuploader/webuploader.css">
    <link rel="stylesheet" href="scripts/jquery-ui-1.10.4.custom/development-bundle/themes/base/jquery.ui.all.css">
    
    <script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="scripts/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js" ></script>
    <script type="text/javascript" src="javaScript/webuploader/webuploader.js"></script>
    
    <style>
	    .tool-uploader-item{  
		    width: 100%;  
		    height: 70px;  
		    border-radius: 3px;
		    background-color: fafafa;
		    border:1px solid #eeeded;
		} 
		
		.tool-uploader-filename{ 
		   font-size:14px;
		   font-family: "Arial","Microsoft YaHei","黑体","宋体",sans-serif;
		 }
		 
		 .tool-uploader-message{ 
		   width: 100%;  
		   height: 10px;  
		   font-size:12px;
		   font-family: "Arial","Microsoft YaHei","黑体","宋体",sans-serif;
		   color: red;
		 }
	 </style>
  </head>
  
  <body>
  
    <div id="uploader">
	    <!--用来存放文件信息-->
	    <div id="thelist">
	    </div>
	    <div class="btns">
	        <div id="picker">选择文件</div>
	        <button id="ctlBtn" class="btn btn-default">开始上传</button>
	    </div>
	 </div>
	 
	 <script>
	    
	 var $list = $('#thelist'),
         $btn = $('#ctlBtn'),
         state = 'pending',
         uploader;
     
	   var uploader = WebUploader.create({
		    swf:'javaScript/webuploader/Uploader.swf',   
		    server: 'FileUploadServlet',  // 文件接收服务端。
		    pick: '#picker',   // 选择文件的按钮。可选。   内部根据当前运行是创建，可能是input元素，也可能是flash.
		    resize: false      // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		});
	   
	   uploader.on( 'fileQueued', function( file ) {
		   $list.append( '<div id="' + file.id + '" class="tool-uploader-item">'
				       + '<h4 class="tool-uploader-filename">' + file.name + '</h4>' 
				       + '<p class="tool-uploader-message">等待上传...</p>' 
				       + '</div>' 
				       + '<br/>');
		});
	   
	   $btn.on( 'click', function() {
	        if ( state === 'uploading' ) {
	            uploader.stop();
	        } else {
	            uploader.upload();
	        }
	    });
	   
	   // 文件上传过程中创建进度条实时显示。
	   uploader.on( 'uploadProgress', function( file, percentage ) {
		   var $message = $( '#'+file.id ).find('p.tool-uploader-message');
		   $message.text('');
		   $message.progressbar({value: false}).find( '.ui-progressbar-value' ).css({'background': '#00b7ee'});
	   });
	   
	   uploader.on( 'uploadSuccess', function( file ) {
		   var $message = $( '#'+file.id ).find('p.tool-uploader-message');
		   $message.text('已上传');
		});

		uploader.on( 'uploadError', function( file ) {
			var $message = $( '#'+file.id ).find('p.tool-uploader-message');
			$message.text('上传出错');
		});

		uploader.on( 'uploadComplete', function( file ) {
			var $message = $( '#'+file.id ).find('p.tool-uploader-message');
			$message.progressbar( "destroy" );
		});
		
	 </script>
	 
  </body>
  
</html>
