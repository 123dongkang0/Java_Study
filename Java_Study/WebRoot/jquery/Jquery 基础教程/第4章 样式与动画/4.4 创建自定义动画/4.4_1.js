$(document).ready(function() {
	
	/**
	 * һ�θ����������Ӷ���Ч��
	 * ��4.4.js�Ļ����ϣ�����һ�����뵭����Ч��
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
