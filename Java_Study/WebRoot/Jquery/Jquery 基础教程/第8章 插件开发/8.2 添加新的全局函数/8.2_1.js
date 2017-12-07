
/******************************************************************************
  $.sum()
  //方式二 ：扩展JQUERY全局函数(使用$.extend())。
******************************************************************************/
(function($) {
  $.extend({
    sum: function(array) {
      var total = 0;

      $.each(array, function(index, value) {
        value = $.trim(value);
        value = parseFloat(value) || 0;

        total += value;
      });
      return total;
    },
    average: function(array) {
      if ($.isArray(array)) {
        return $.sum(array) / array.length;
      }
      return '';
    }
  });
})(jQuery);

