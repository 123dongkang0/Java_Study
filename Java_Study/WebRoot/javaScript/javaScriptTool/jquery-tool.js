
/******************************************************************************
  
  基于jquery的一些工具函数
******************************************************************************/
(function($) {
  $.jqueryTool = {
    /**
     *文件上传校验
	 *@param elementId : 文件输入框的ID
	 *@param fileType : 文件类型(必须是正则表达式)
	 * 
	 */	  
    fileuploadvalidate:function(options) { 
       var elementValue = $("#" + options.elementId).val();
       if(elementValue.length==0){
    		 return "请选择需要上传的文件！！";
       }
       if(!options.fileType.test(elementValue)){
           return "文件类型错误，请重新选择！";
        }
       return "1";
    },
    /**
     *文件上传
	 *@param elementId : 文件输入框的ID
	 *@param url : 上传地址
	 * 
	 */	  
    fileupload:function(options) {   //文件上传，并返回相应的字符串
    	
    	$("#dialog-modal").dialog({
			height: 140,
			modal: true,
			open: function (event, ui) {   //隐藏默认的关闭按钮
				$(".ui-dialog-titlebar-close", $(this).parent()).hide();
			}
		});
    	
    	$.ajaxFileUpload({
    		url : options.url,
    		secureuri : false,
    		fileElementId : options.elementId,
    		dataType : 'json',
    		success : function(data, status) {
    			$("#dialog-modal").dialog("close");
    			return data;
    		},
    		error : function(data, status, e) {
    			$("#dialog-modal").dialog("close");
    			return {
    				      "result" : "0",
    				      "info" : "文件上传失败！" + e,
    				      "data" : "[]"
    			        }
    		}
    	});
    	return false;
   },
   /**
    *将数据复制到输入框中
	*@param data  : 需要复制的数据
	*@param map : data 和 表单中 name的对应关系
    */	  
   fillelementstext:function(options) {
	   for(prop in options.map){
		   var element = document.getElementsByName(prop);
		   if(element.length != 1){  //说明是radio
			   for(var i = 0 ; i < element.length; i++){
					if(element[i].value == data[map[prop]]){
						element[i].checked= true;
					}
				}
		   }else{
			   element[0].value = data[map[prop]];
		   }
	   }
   }
  }
})(jQuery);

