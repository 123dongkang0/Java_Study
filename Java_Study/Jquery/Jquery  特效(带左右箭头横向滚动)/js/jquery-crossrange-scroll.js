
/******************************************************************************
  .crossrange_scroll()
  
  @author dongk
  @date 2017-11-15
  @Description 实现图片横滚效果
  @param
     scrollobj:要移动的对象,
     viewedSiz:可视的宽度,默认为移动对象外层的宽度
     unitlen:移动单位的宽度，默认为<li></li>的宽度
     unitdisplayed:可视的单元数，必填项
     numtoMove:要移动的单位个数，必填项
     loop:"cycle" //循环滚动            不传入则不循环滚动;
     
******************************************************************************/
(function($){
	
	$.fn.crossrange_scroll=function(settings){
		settings=$.extend({},$.fn.crossrange_scroll.sn.defaults,settings);
		this.each(function(){
			var scrollobj=settings.scrollobj ? $(this).find(settings.scrollobj) : $(this).find("ul"),
				viewedSize=settings.viewedSiz ||  scrollobj.parent().width(),
			    scrollunits=scrollobj.find("li"),  //需要移动的<li></li>元素
			    unitlen=settings.unitlen || scrollunits.eq(0).outerWidth(),
			    unitdisplayed=settings.unitdisplayed, //可视的单元数
			    numtoMove=settings.numtoMove > unitdisplayed ? unitdisplayed : settings.numtoMove,
			    scrollobjSize=scrollunits.length * unitlen,
			    offset=0,
			    offsetnow=0,
			    movelength=unitlen * numtoMove;
			    pos="left",
			    moving=false, //是否移动?
			    btnright=$(this).find("a.aright"),
			    btnleft=$(this).find("a.aleft");
			    
		    btnright.unbind("click");
			btnleft.unbind("click");	
			
			scrollobj.css("left","0px");
			
			if(scrollobjSize > viewedSize ){
				btnleft.addClass("agrayleft");
				offset=scrollobjSize-viewedSize;
				btnright.removeClass("agrayright");
			}else{
				btnleft.addClass("agrayleft");
				btnright.addClass("agrayright");
			}
			
			btnleft.click(function(){
				
				if($(this).is("[class*='agrayleft']")){return false;}
				
				if(!moving){
					moving=true;
					offsetnow-=movelength
					if(offsetnow>unitlen*unitdisplayed-viewedSize){
						$.fn.crossrange_scroll.sn.animate(scrollobj,-offsetnow,settings.speed,function(){moving=false;});
					}else{
						$.fn.crossrange_scroll.sn.animate(scrollobj,0,settings.speed,function(){moving=false;});
						offsetnow=0;
						$(this).addClass("agrayleft");
					}
					btnright.removeClass("agrayright");
				}
				
				return false;
			});
			
			btnright.click(function(){
				if($(this).is("[class*='agrayright']")){return false;}
				
				if(!moving){
					moving=true;
					offsetnow+=movelength;
					if(offsetnow<offset-(unitlen*unitdisplayed-viewedSize)){
						$.fn.crossrange_scroll.sn.animate(scrollobj,-offsetnow,settings.speed,function(){moving=false;});
					}else{
						$.fn.crossrange_scroll.sn.animate(scrollobj,-offset,settings.speed,function(){moving=false;});
						offsetnow=offset;
						$(this).addClass("agrayright");
					}
					btnleft.removeClass("agrayleft");
				}
				return false;
			});
			
		});
	}
	
	$.fn.crossrange_scroll.sn={
	    defaults:{
	    	speed:500
	    },
	    animate:function(obj,w,speed,callback){
	    	obj.animate({
				left:w
			},speed,"swing",callback);
	    }
	}
	
})(jQuery);
