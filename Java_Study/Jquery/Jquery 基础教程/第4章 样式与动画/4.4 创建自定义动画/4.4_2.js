$(document).ready(function() {
	
	/**
	 * 一次给多个属性添加动画效果
	 *  点击按钮改变字体的大小
	 */
	  var $speech = $('div.speech');
	  var defaultSize = $speech.css('fontSize');
	  $('#switcher button').click(function() {
	    var num = parseFloat($speech.css('fontSize'));
	    switch (this.id) {
	      case 'switcher-large':
	        num *= 1.4;
	        break;
	      case 'switcher-small':
	        num /= 1.4;
	        break;
	      default:
	        num = parseFloat(defaultSize);
	    }
	    $speech.animate({fontSize: num + 'px'}, 'slow');
	  });
	  
});
