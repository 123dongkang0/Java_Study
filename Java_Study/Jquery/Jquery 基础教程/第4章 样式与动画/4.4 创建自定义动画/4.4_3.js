$(document).ready(function() {
	
	/**
	 * 一次给多个属性添加动画效果
	 *  点击按钮改变字体的大小
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
