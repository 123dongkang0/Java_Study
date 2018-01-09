$(document).ready(function() {
	
	/**
	 * һ�θ����������Ӷ���Ч��
	 *  �����ť�ı�����Ĵ�С
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
