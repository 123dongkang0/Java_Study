/*
 * jQuery Input Limiter plugin 1.0.0
 * @author dongk
 */

(function ($) {
	$.fn.numbercheck = function (options) {
		var opts = $.extend({}, $.fn.numbercheck.defaults, options),
			$elements = $(this);
		
		var numbercheckBlur = function (e) {
			
			var numberFormat=/^(0|([1-9][0-9]*))(\.[0-9]*)?$/,
			    numReg,  
			    value = $elements.val().trim(),  
		        strValueTemp, 
		        strInt, 
		        strDec; 
			
		    try{         
				numReg =/[\-]/;  
		        strValueTemp = value.replace(numReg, "");  
		        numReg =/[\+]/;  
		        strValueTemp = strValueTemp.replace(numReg, "");  
		        if(value!=""){
		        	if(!numberFormat.test(value)){
		        		alert("��������ȷ�����ָ�ʽ��");
		        		$elements.val("").focus();
		        		return false;
		        	}
			        //����  
			        if(opts.prec==0){  
			            if(strValueTemp.indexOf(".") > 0 ){  
							alert("�������Ϊ�������ͣ�"); 
							$elements.val("").focus();
							return false;     
						}
					}
					if(strValueTemp.indexOf(".") < 0 ){
						if(opts.len!=0 && strValueTemp.length >( opts.len - opts.prec)){
							alert("����λ���ܳ���"+ (opts.len - opts.prec) +"λ��");
							$elements.val(strValueTemp.substr(0,(opts.len - opts.prec))).focus();
							return false;
						}
					}else{
						var validatePass = true;
						
						strInt = strValueTemp.substr( 0, strValueTemp.indexOf(".") );
						if(strInt.length >( opts.len - opts.prec)){
							alert("����λ���ܳ���"+ (opts.len - opts.prec) +"λ��");
							strInt = strInt.substr(0,(opts.len - opts.prec));
							validatePass = false;
						}  
						
						strDec = strValueTemp.substr( (strValueTemp.indexOf(".")+1), strValueTemp.length );
						if(strDec.length > opts.prec){
							alert("С��λ���ܳ���"+  opts.prec +"λ��");
							strDec  = strDec.substr(0,opts.prec);
							validatePass = false;
						}
						if(!validatePass){
							$elements.val(strInt + "." + strDec).focus();
							return false;
						}
					}
					return true;
		        }
			}catch(e){
				alert(e);
				return false;
			}  
		};

		$(this).each(function (i) {
			var $this = $(this);
			$this.unbind('.numbercheck');
			$this.bind('blur.numbercheck', numbercheckBlur);
		});
	};

	$.fn.numbercheck.defaults = {
		len: 8,    //�ܳ���
		prec: 0    //����(С��������λ��)
	};

})(jQuery);
