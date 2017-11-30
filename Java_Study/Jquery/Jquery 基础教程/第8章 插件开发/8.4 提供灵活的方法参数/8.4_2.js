
/******************************************************************************
  .shadow()
  ΪԪ�ؿ����ͶӰЧ��.
  ����Ĭ�ϲ���ֵ
******************************************************************************/
(function($) {
  $.fn.shadow = function(opts) {
    var defaults = {
      copies: 5,
      opacity: 0.1
    };
    var options = $.extend(defaults, opts);

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
  });
});
