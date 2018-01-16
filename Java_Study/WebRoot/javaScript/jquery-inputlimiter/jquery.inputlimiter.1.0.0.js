/*
 * jQuery Input Limiter plugin 1.3.1
 * http://rustyjeans.com/jquery-plugins/input-limiter/
 *
 * Copyright (c) 2009 Russel Fones <russel@rustyjeans.com>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
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
