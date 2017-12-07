$(document).ready(function() {
  var $firstPara = $('p').eq(1);
  $firstPara.hide();
  $('a.more').click(function(event) {
    event.preventDefault();
    //可以把属性的动画值设置为 "show"、"hide" 或 "toggle"：
    $firstPara.animate({height: 'toggle'}, 'slow');
    var $link = $(this);
    if ($link.text() == 'read more') {
      $link.text('read less');
    } else {
      $link.text('read more');
    }
  });
});
