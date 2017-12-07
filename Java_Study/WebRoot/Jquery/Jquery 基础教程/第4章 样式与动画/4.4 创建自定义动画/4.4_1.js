$(document).ready(function() {
	
	/**
	 * 一次给多个属性添加动画效果
	 * 在4.4.js的基础上，增加一个淡入淡出的效果
	 */
	var $firstPara = $('p').eq(1);
	  $firstPara.hide();
	  $('a.more').click(function(event) {
	    event.preventDefault();
	    $firstPara.animate({
	      opacity: 'toggle',
	      height: 'toggle'
	    }, 'slow');
	    var $link = $(this);
	    if ($link.text() == 'read more') {
	      $link.text('read less');
	    } else {
	      $link.text('read more');
	    }
	  });
	  
});
