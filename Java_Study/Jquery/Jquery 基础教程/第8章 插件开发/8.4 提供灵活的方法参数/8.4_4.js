
/******************************************************************************
  .shadow()
  为元素块添加投影效果.
  8.4.4 可定制的默认值
******************************************************************************/
(function($) {
  $.fn.shadow = function(opts) {
    var options = $.extend({}, $.fn.shadow.defaults, opts);

    return this.each(function() {
      var $originalElement = $(this);
      for (var i = 0; i < options.copies; i++) {
        var offset = options.copyOffset(i);
        $originalElement
          .clone()
          .css({
            position: 'absolute',
            left: $originalElement.offset().left + offset.x,
            top: $originalElement.offset().top + offset.y,
            margin: 0,
            zIndex: -1,
            opacity: options.opacity
          })
          .appendTo('body');
      }
    });
  };

  $.fn.shadow.defaults = {
    copies: 5,
    opacity: 0.1,
    copyOffset: function(index) {
      return {x: index, y: index};
    }
  };
})(jQuery);


/******************************************************************************
  End plugin code; begin custom script code.
******************************************************************************/
$(document).ready(function() {
  $.fn.shadow.defaults.copies = 10;
  $('h1').shadow({
    copyOffset: function(index) {
      return {x: -index, y: index};
    }
  });
});
