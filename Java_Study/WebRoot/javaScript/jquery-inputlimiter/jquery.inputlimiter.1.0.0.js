/*
 * jQuery Input Limiter plugin 1.0.0
 * @author dongk
 */

(function ($) {
	$.fn.inputlimiter = function (options) {
		var opts = $.extend({}, $.fn.inputlimiter.defaults, options),
			$elements = $(this);
		
		var inputlimiterKeyup = function (e) {
			var $this = $(this),
				count = counter($this.val());
			if (count > opts.limit) {
				$this.val(truncater($this.val()));
			}
		},

		inputlimiterKeypress = function (e) {
			var count = counter($(this).val());
			if (count > opts.limit) {
				var modifierKeyPressed = e.ctrlKey || e.altKey || e.metaKey;
				if (!modifierKeyPressed && (e.which >= 32 && e.which <= 122) && this.selectionStart === this.selectionEnd) {
					return false;
				}
			}
		},

		inputlimiterBlur = function () {
			var $this = $(this);
				count = counter($this.val());
			if (count > opts.limit) {
				$this.val(truncater($this.val()));
			}
		},

		counter = function (value) {
			var count = value.replace(/[^\u0000-\u00ff]/g,"SS").length;
			return count;
		},

		truncater = function (value) {
			if(!value) return "";  
		    if(opts.limit <= 0) return "";  
		    var templen = 0;  
		    for(var i = 0; i < value.length; i++){  
		        if(value.charCodeAt(i) > 255){  
		            templen+=2;  
		        }else{  
		            templen++;
		        }  
		        if(templen == opts.limit){  
		            return value.substring(0,i+1);  
		        }else if(templen > opts.limit){  
		            return value.substring(0,i);  
		        }  
		    }  
		    return value;  
		};

		$(this).each(function (i) {
			var $this = $(this);
			$this.unbind('.inputlimiter');
			$this.bind('keyup.inputlimiter', inputlimiterKeyup);
			$this.bind('keypress.inputlimiter', inputlimiterKeypress);
			$this.bind('blur.inputlimiter', inputlimiterBlur);
		});
	};

	$.fn.inputlimiter.defaults = {
		limit: 255
	};

})(jQuery);
