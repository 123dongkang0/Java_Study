$(document).ready(function() {
	
	/**
	 * һ�θ����������Ӷ���Ч��
	 *  �����ť�ı�����Ĵ�С
	 */
	 $('div.label').click(function() {
	    var paraWidth = $('div.speech p').outerWidth();
	    var $switcher = $(this).parent();
	    var switcherWidth = $switcher.outerWidth();
	    $switcher.animate({
	      borderWidth: '5px',
	      left: paraWidth - switcherWidth,
	      height: '+=20px'
	    }, 'slow');
	  });
	
});
