
/******************************************************************************
  
  ����jquery��һЩ���ߺ���
******************************************************************************/
(function($) {
  $.jqueryTool = {
    /**
     *�ļ��ϴ�У��
	 *@param elementId : �ļ�������ID
	 *@param fileType : �ļ�����(������������ʽ)
	 * 
	 */	  
    fileuploadvalidate:function(options) { 
       var elementValue = $("#" + options.elementId).val();
       if(elementValue.length==0){
    		 return "��ѡ����Ҫ�ϴ����ļ�����";
       }
       if(!options.fileType.test(elementValue)){
           return "�ļ����ʹ���������ѡ��";
        }
       return "1";
    },
    /**
     *�ļ��ϴ�
	 *@param elementId : �ļ�������ID
	 *@param url : �ϴ���ַ
	 * 
	 */	  
    fileupload:function(options) {   //�ļ��ϴ�����������Ӧ���ַ���
    	
    	$("#dialog-modal").dialog({
			height: 140,
			modal: true,
			open: function (event, ui) {   //����Ĭ�ϵĹرհ�ť
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
    				      "info" : "�ļ��ϴ�ʧ�ܣ�" + e,
    				      "data" : "[]"
    			        }
    		}
    	});
    	return false;
   },
   /**
    *�����ݸ��Ƶ��������
	*@param data  : ��Ҫ���Ƶ�����
	*@param map : data �� ���� name�Ķ�Ӧ��ϵ
    */	  
   fillelementstext:function(options) {
	   for(prop in options.map){
		   var element = document.getElementsByName(prop);
		   if(element.length != 1){  //˵����radio
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

