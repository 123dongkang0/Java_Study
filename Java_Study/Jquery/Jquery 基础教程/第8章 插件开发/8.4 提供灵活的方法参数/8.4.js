
/******************************************************************************
  .shadow()
  为元素块添加投影效果.
  不接受任何参数
******************************************************************************/
(function($) {
  $.fn.shadow = function() {
    return this.each(function() {
      var $originalElement = $(this);
      for (var i = 0; i < 5; i++) {
        $originalElement
          .clone()
          .css({
            position: 'absolute',
            left: $originalElement.offset().left + i,
            top: $originalElement.offset().top + i,
            margin: 0,
            zIndex: -1,
            opacity: 0.1
          })
          .appendTo('body');
      }
    });
  };
})(jQuery);


/******************************************************************************
  调用此插件.
******************************************************************************/
$(document).ready(function() {
  $('h1').shadow();
});
