$(document).ready(function() {
  var $firstPara = $('p').eq(1);
  $firstPara.hide();
  $('a.more').click(function(event) {
    event.preventDefault();
    //���԰����ԵĶ���ֵ����Ϊ "show"��"hide" �� "toggle"��
    $firstPara.animate({height: 'toggle'}, 'slow');
    var $link = $(this);
    if ($link.text() == 'read more') {
      $link.text('read less');
    } else {
      $link.text('read more');
    }
  });
});
