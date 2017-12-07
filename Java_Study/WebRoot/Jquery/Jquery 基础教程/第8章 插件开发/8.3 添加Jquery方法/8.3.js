
/******************************************************************************
  ���󷽷��������ġ���this
  .swapClass()
  class1��class2�����滻
******************************************************************************/
(function($) {
  //���ַ�ʽ���table�е�����tr����Ӱ��
  //���������.swqpClass1()
  $.fn.swapClass = function(class1, class2) {
    if (this.hasClass(class1)) {
      this.removeClass(class1).addClass(class2);
    }
    else if (this.hasClass(class2)) {
      this.removeClass(class2).addClass(class1);
    }
  };
  
  $.fn.swapClass1 = function(class1, class2) {
    this.each(function() {
      var $element = $(this);
      if ($element.hasClass(class1)) {
        $element.removeClass(class1).addClass(class2);
      }
      else if ($element.hasClass(class2)) {
        $element.removeClass(class2).addClass(class1);
      }
    });
  };
  
})(jQuery);


/******************************************************************************
  
******************************************************************************/
$(document).ready(function() {
  $('table').click(function() {
    $('tr').swapClass1('one', 'two');
  });
});
