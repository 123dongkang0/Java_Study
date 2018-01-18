// JavaScript Document
html='';

html+=' <div id="uploader-wrapper"  style="display:none; " >';
html+='     <div id="uploader-container">';
html+=' 	    <!--头部，相册选择和格式选择-->';
html+='		    <div id="uploader-uploader">';
html+='         	<div class="uploader-queueList">';
html+='             	<div id="uploader-dndArea" class="placeholder">';
html+='                 </div>';
html+='             </div>';
html+='             <div id="uploader-data" style="display:none; "></div>';
html+='             <!-- 状态栏 -->';
html+='             <div class="statusBar">';
html+='             	<div class="progress">';
html+='                 	<span class="text">0%</span>';
html+='                 	<span class="percentage"></span>';
html+='                 </div>';
html+='                 <!-- 文件信息 -->';
html+='                 <div class="info"></div>';
html+='                 <div class="btns">';
html+='                 	<div id="uploader-filePicker2"></div><div class="uploadBtn">开始上传</div>';
html+=' 				</div>';
html+='             </div>';
html+='        </div>';
html+='    </div>';
html+=' </div>';

document.write(html);