
/******************************************************************************
  
  ����jquery��һЩ���ߺ���
******************************************************************************/
(function($) {
  $.jqueryTool = {
    /**
     *����DIV����ʾ������
	 *@param showId : ��ʾ��Ԫ�ص�id
	 *@param all : ����Ԫ�ص�id(��һ������)
	 * 
	 */	  
    showControl:function(showId,all) { 
    	for(id in all){
    		if(all[id] == showId){
    			$("#" + all[id] ).show();
    		}else{
    			$("#" + all[id] ).hide();
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

