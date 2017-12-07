
/******************************************************************************
  8.4.3 �ص�����
  .shadow()
  ΪԪ�ؿ����ͶӰЧ��.�û������Զ���ͶӰ������ı���λ��
******************************************************************************/
(function($) {
  $.fn.shadow = function(opts) {
    var defaults = {
      copies: 5,
      opacity: 0.1,
      copyOffset: function(index) {
        return {x: index, y: index};
      }
    };
    var options = $.extend(defaults, opts);

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
})(jQuery);


/******************************************************************************
  End plugin code; begin custom script code.
******************************************************************************/
$(document).ready(function() {
  $('h1').shadow({
    copyOffset: function(index) {
      return {x: -index, y: -2 * index};
    }
  });
});
