
/******************************************************************************
  .shadow()
  ΪԪ�ؿ����ͶӰЧ��.
  �������κβ���
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
  ���ô˲��.
******************************************************************************/
$(document).ready(function() {
  $('h1').shadow();
});
