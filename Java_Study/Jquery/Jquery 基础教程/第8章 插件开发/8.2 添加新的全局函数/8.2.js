
/******************************************************************************
  $.sum()
  //方式一 ：扩展JQUERY全局函数
******************************************************************************/
(function($) {
  $.sum = function(array) {
    var total = 0;

    $.each(array, function(index, value) {
      value = $.trim(value);
      value = parseFloat(value) || 0;

      total += value;
    });
    return total;
  };
  
  //求平均数
  $.average = function(array) {
    if ($.isArray(array)) {
      return $.sum(array) / array.length;
    }
    return '';
  };
	  
})(jQuery);


/******************************************************************************
 
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

  var sum = $.sum(quantities);
  $('#sum').find('td:nth-child(2)').text(sum);
  
  var average = $.average(prices);
  $('#average').find('td:nth-child(3)').text(average.toFixed(2));
});
