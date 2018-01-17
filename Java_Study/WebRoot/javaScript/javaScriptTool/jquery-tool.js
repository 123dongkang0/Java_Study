
/******************************************************************************
  
  基于jquery的一些工具函数
******************************************************************************/
(function($) {
  $.jqueryTool = {
    /**
     *控制DIV的显示和隐藏
	 *@param name : 控制元素id
	 *@param options : 值和DIV的Id的对应关系
	 * 
	 */	  
    showControl:function(name,options) { 
       var element = document.getElementsByName(prop);
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
   },
   /**
    * 是否为null的校验
    */
   validateisnull:function(options){
	   for(prop in options){
		   var element = document.getElementsByName(prop);
		   if(element.length != 1){  //说明是radio
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

