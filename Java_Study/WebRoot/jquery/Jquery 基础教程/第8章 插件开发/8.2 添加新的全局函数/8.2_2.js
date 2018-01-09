
/******************************************************************************
  $.sum()
  //使用命名空间隔离函数。
******************************************************************************/
(function($) {
  $.mathUtils = {
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
        return $.mathUtils.sum(array) / array.length;
      }
      return '';
    }
  };
})(jQuery);


/******************************************************************************
  调用代码：效果和8.2.js一样
******************************************************************************/
$(document).ready(function() {
  var $inventory = $('#inventory tbody');
  var quantities = $inventory.find('td:nth-child(2)')
  .map(function(index, qty) {
    return $(qty).text();
  }).get();

  var prices = $inventory.find('td:nth-child(3)')
  .map(function(index, qty) {
    return $(qty).text();
  }).get();

  var sum = $.mathUtils.sum(quantities);
  var average = $.mathUtils.average(prices);
  $('#sum').find('td:nth-child(2)').text(sum);
  $('#average').find('td:nth-child(3)').text(average.toFixed(2));
});

