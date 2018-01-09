
/******************************************************************************
  .shadow()
  为元素块添加投影效果.
  接收两个参数 
    copies：投影数量
    opacity：透明度
******************************************************************************/
(function($) {
  $.fn.shadow = function(options) {
    return this.each(function() {
      var $originalElement = $(this);
      for (var i = 0; i < options.copies; i++) {
        $originalElement
          .clone()
          .css({
            position: 'absolute',
            left: $originalElement.offset().left + i,
            top: $originalElement.offset().top + i,
            margin: 0,
            zIndex: -1,
            opacity: options.opacity
          })
          .appendTo('body');
      }
    });
  };
})(jQuery);


/******************************************************************************
  
******************************************************************************/
$(document).ready(function() {
  $('h1').shadow({
    copies: 13,
    opacity: 0.25
  });
});
