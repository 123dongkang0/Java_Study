
/******************************************************************************
  
  ����jquery��һЩ���ߺ���
******************************************************************************/
(function($) {
  $.jqueryTool = {
    /**
     *�ļ��ϴ�
     *@param: prefix : struts��̨���ղ�����
     *@param: fileType : �ļ�����
     *@param: elementId : չʾ����Id
     */
     webUploader:function(prefix, elementId){
        uploader.addButton({
           id: '#uploader-filePicker2',
           label: '���'
        });
        $("#uploader-dndArea").removeClass( 'element-invisible' );
        $("#uploader-wrapper").dialog({
           height:630,
           width:800,
           modal:true,
           close: function( event, ui ) {
        	   $(".filelist").html("");
        	   $("#" + elementId).html($("#uploader-data").html());
        	   $("#uploader-data").find("a").each(function(i){
        		   $('<input name="' + prefix + '[' + i + '].filePath" type="hidden" value="' + $(this).attr('href') + '">').appendTo($("#" + elementId));
        		   $('<input name="' + prefix + '[' + i + '].fileName" type="hidden" value="' + $(this).text() + '">').appendTo($("#" + elementId));
        	   });
        	   $("#uploader-data").html("");
           }
       });
     },
    /**
     *����DIV����ʾ������
	 *@param name : ����Ԫ��id
	 *@param options : ֵ��DIV��Id�Ķ�Ӧ��ϵ
	 * 
	 */	  
    showControl:function(name,options) { 
       var element = document.getElementsByName(name);
	   for(var i = 0 ; i < element.length; i++){
			if(element[i].checked){
				if(options[element[i].value]){
					$("#" + options[element[i].value] ).show();
				}
			}else{
				if(options[element[i].value]){
					$("#" + options[element[i].value] ).hide();
				}
			}
		}
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
   },
   /**
    * �Ƿ�Ϊnull��У��
    */
   validateisnull:function(options){
	   for(prop in options){
		   var element = document.getElementsByName(prop);
		   if(element.length != 1){  //˵����radio
			   var validate =false;
			   for(var i = 0 ; i < element.length; i++){
					if(element[i].checked){
						validate = true;
					}
				}
			   if(!validate){
				   alert(options[prop]);
				   return false;
			   }
		   }else{
			   if(element[0].value <= 0){
				   alert(options[prop]);
				   return false;
			   }
		   }
	  }
	  return true;
   }
  }
})(jQuery);

