/*
 * 页面列表操作, jQuery plugin
 * 使用方法
 * $("#listPage").subListTable({
		"prefix" : "billLists",指定提交数据列表名
		"displayIndex" : true,是否显示序号 默认false
		"displayField" : "GNo",显示序号名称，指定名称，会在第一列添加input hidden元素
		"trClass" : "trListContent"
	});
	默认参数见最后声明
 */
(function($) {
"use strict";

var methods = {
		/**
		 * 初始化
		 * @returns {Boolean}
		 */
  init : function() {
    var $thisDiv = $(this),
    options = $.extend({}, $.subListTable, arguments[0]),
  //只取第一个class为options.listTable的对象
    listTable = $(this).find("."+options.listTableClass).first(),
  //只取第一个class为options.editTable的对象
    editTable = $(this).find("."+options.editTableClass).first()
    ;

    //listTable下的需要编辑提交的行选择器，有编辑或删除按钮的行，或者需要计数的行，选中
    options.trSelector = "tr:has(."+options.editTrClass+", ."+options.deleteTrClass+"), tr."+options.countTrClass;
    options.listTable = listTable;
    options.editTable = editTable;

  //如果不存在列表区域，直接返回
    if($(listTable).length <= 0) return false;

    if(!options.prefix) {
    	alert("请指定列表前缀，即提交属性名[prefix]！");
    	return false;
    }
    //初始化列表区域按钮
    listTable.find(options.trSelector)
    .each( function (i, subTr) {//初始化每条记录对应按钮事件
      var $this = $(subTr);
      var index = options.index++;
      $this.attr("index",index);//添加index属性
      //给隐藏域名称添加前缀，如果没有前缀的话
      $this.find("input[type='hidden']:not([name^='"+options.prefix+"'])").each(function(i, value) {
    	  var name = $(value).attr("name");
    	  $(value).attr("name", options.prefix+"["+index+"]."+name);
      });
      $this.find("input."+options.editTrClass).click(
    		  {"options": options, "listTable": listTable, "editTable": editTable, "subTr": $this},
    		  methods._editHandle);
      $this.find("input."+options.deleteTrClass).click(
    		  {"options": options, "listTable": listTable, "subTr": $this},
    		  methods._deleteHandle);
    });
    
  //如果不存在编辑录入区域，直接返回
    if($(editTable).length > 0) {
    	//初始化编辑区域按钮
    	editTable.find("input."+options.addTrClass).click(function() {//点击添加按钮，添加行记录
    		var validateOptions = $.extend(true,{},$thisDiv.data('jqv'),{"eventTrigger.event": "click","eventTrigger.element":$(this)})
    		if($thisDiv.validationEngine && 
    				!$thisDiv.validationEngine("validate", validateOptions)) {
    			return false; //如果有表单验证，且验证失败，直接返回false
    		}
    		//添加数据前执行阻断方法，返回true通过
    		if(window.doAddBefore) {
    			var before = doAddBefore(editTable, options.index)
    			if(before != undefined && !before) {
    				return false;
    			}
    		}
    		var thisButton = $(this),
    		index = thisButton.attr("index"),
    		subTr;
    		if(index) {
    			//修改行记录数据
    			subTr = listTable.find("tr[index=\""+index+"\"]:first");
    			
    			editTable.find("input[type=\"hidden\"],input[type=\"text\"],select,textarea")
    			.each(function(i, ele) {
    				var thisText = $(ele), name = thisText.attr("name"),
    				hiddenInput = subTr.find("input[name$=\"."+name+"\"]"),
    				subTd = hiddenInput.parent(),
    				hasButton = subTd.find("input").filter(":button").length > 0 ? true : false;
    				if(ele.nodeName.toLowerCase() == "select") {
    					if(methods._isEmpty(ele.options) || ele.options.length <= 0) {
    						return;
    					}
    					var text = ele.options[ele.selectedIndex].text,
    					value = ele.options[ele.selectedIndex].value;
    					hiddenInput.val(value);
    					if(!hasButton) {
    						subTd.html(text);
    						hiddenInput.appendTo(subTd);
    					}
    				} else {
    					hiddenInput.val(thisText.val());
    					if(!hasButton) {
    						subTd.html(thisText.val());
    						hiddenInput.appendTo(subTd);
    					}
    				}
    				thisText.val("");
    			});
    			
    			listTable.find("input."+options.editTrClass+",input."+options.deleteTrClass)
    			.prop("disabled", false);//修改完数据后，所有编辑，删除按钮都启用
    			
    			thisButton.removeAttr("index");
    		} else {
    			subTr = methods._addOneTr.call($thisDiv);//添加行记录
    		}
    		//添加数据执行方法
    		if(window.doAddAfter) {
    			doAddAfter(subTr);
    		}
    	});
    	
    	editTable.find("input."+options.cancelTrClass).click(function() {//点击取消按钮，取消修改
    		//取消操作前执行阻断方法，返回true通过
    		if(window.doCancelBefore) {
    			var before = doCancelBefore(editTable);
    			if(before != undefined && !before) {
    				return false;
    			}
    		}
    		//取消修改后，所有编辑，删除按钮都启用
    		listTable.find("input."+options.editTrClass+",input."+options.deleteTrClass)
    		.prop("disabled", false);
    		//移除添加按钮上的index属性
    		editTable.find("input."+options.addTrClass).removeAttr("index");
    		//所有元素都清空
    		editTable.find("input[type=\"hidden\"],input[type=\"text\"],select,textarea")
    		.each(function(i, ele) {
    			$(ele).val("");
    		});
    		//取消后执行方法
    		if(window.doCancelAfter) {
    			doCancelAfter(editTable);
    		}
    	});
    	$thisDiv.bind("clearTr", {"options": options, "listTable": listTable, "editTable": editTable}, methods._clearHandle);
    }
    //保存参数
    if(!$thisDiv.data("options")) {
    	$thisDiv.data("options", options);
    }
  },
  /**
   * 添加新记录行
   * @param datas
   * @returns
   */
  addOneTr : function(datas) {
    return methods._addOneTr.call(this, datas);
  },
  /**
   * 添加行记录，将编辑区域数据添加行列表区
   * @param datas
   * @returns
   */
  _addOneTr : function(dataObj) {
	  var datas = dataObj || {},
	  options = $(this).data("options"),
	  listTable = options.listTable,
	  editTable = options.editTable,
	  //记录索引
	  index = options.index++,
	  trStr = "";
	  
	  if($.isEmptyObject(datas)) {
		  editTable.find("input[type=\"hidden\"],input[type=\"text\"],select,textarea")
		  .each(function(i, ele) {
			  var thisText = $(ele);
			  if(ele.nodeName.toLowerCase() == "select" && ele.options && ele.options.length > 0) {
				  var index = ele.selectedIndex;
				  datas[thisText.attr("name")+"_"] = ele.options[index].text;
			  }
			  datas[thisText.attr("name")] = thisText.val();
			  thisText.val("");
		  });
	  }
   
    trStr = "<tr class='"+options.trClass+"' index='"+index+"'>";
   
    if(options.displayIndex) {//是否需要记录序号
    	trStr += "<td class="+options.tdClass+">"+(index + 1);
    	if(options.displayField) {
    		trStr += "<input type='hidden' name='"+options.prefix+"["+index+"]."+options.displayField+
            "' value='"+(index + 1)+"'/>";
    		if(datas[options.displayField]) {
    			delete datas[options.displayField];
    		}
    	}
    	trStr += "</td>";
    }
    $(listTable).find("tr:first td[name^='title_']").each(function(i, td) {
      var name = $(td).attr("name"),
      keyname = name.substr(name.indexOf("_")+1);
      if(!(options.displayIndex && keyname == options.displayField)) {
    	  trStr += "<td class="+options.tdClass+">"+methods._emptyReplace(datas[keyname+"_"] ? datas[keyname+"_"] : datas[keyname])
    	  +"<input type='hidden' name='"+options.prefix+"["+index+"]."+keyname+
    	  "' value='"+methods._emptyReplace(datas[keyname])+"'/></td>";
      }
   
      delete datas[keyname];//去掉已经添加的数据
    });
    trStr += "<td align=\"center\">";
   if(options.addEditButton) {
	   trStr += "<input type=\"button\" class=\"short_button "+options.editTrClass+"\" value=\"编辑\" />";
   }
   if(options.addDeleteButton) {
	   trStr += "<input type=\"button\" class=\"short_button "+options.deleteTrClass+"\" value=\"删除\" />";
   }
    //将所有隐藏字段放于最后TD
    for(var key in datas) {
      trStr += "<input type='hidden' name='"+options.prefix+"["+index+"]."+key+"' value='"
        +methods._emptyReplace(datas[key])+"' />";
        delete datas[key];//去掉已经添加的数据
    }
    trStr += "</td></tr>";
    var $thisTr = $(trStr).appendTo(listTable);
    $thisTr.find("input."+options.editTrClass).click(
  		  {"options": options, "listTable": listTable, "editTable": editTable, "subTr": $thisTr},
  		  methods._editHandle);
    $thisTr.find("input."+options.deleteTrClass).click(
  		  {"options": options, "listTable": listTable, "subTr": $thisTr},
  		  methods._deleteHandle);
   
    return $thisTr;
  },
  /**
   * 点击编辑按钮，修改行记录
   * @param event
   * @returns {Boolean}
   */
  _editHandle : function(event) {
	    if(window.doEditBefore) {
	    	var before = doEditBefore(event.data.subTr);
	    	if(before != undefined && !before) {
	    		return false;
	    	}
	    }
	  event.data.listTable.find("input."+event.data.options.editTrClass+",input."+event.data.options.deleteTrClass)
	  .prop("disabled", true);//修改当前数据时，所有编辑，删除按钮都禁用
	  event.data.editTable.find("input."+event.data.options.addTrClass)
	  .attr("index", event.data.subTr.attr("index"));//添加索引
    methods._reEdit.call(event.data.editTable, event.data.subTr);
    if(window.doEditAfter) {
    	doEditAfter(event.data.subTr);
    }
    return;
  },
  /**
   * 点击删除按钮，删除当前记录
   * @param event
   * @returns {Boolean}
   */
  _deleteHandle : function(event) {
	  if(confirm("您确定要删除该条记录吗？"))
	    {
		    if(window.doDeleteBefore) {
		    	var before = doDeleteBefore(event.data.subTr);
		    	if(before != undefined && !before) {
		    		return false;
		    	}
		    }
		  event.data.subTr.nextAll("tr").each(function(i, subTr) {//所有当前Tr后的Tr都重置索引
			  var index = $(subTr).attr("index") - 1;
			  $(subTr).attr("index",index).find("input[type=\"hidden\"]").each(function() {
				  var $this = $(this);
				  var name = $this.attr("name");
				  name = name.replace(/\[\d+\]/g,"["+index+"]");
				  $this.attr("name",name);
			  });
			  if(event.data.options.displayIndex) {//是否需要记录序号
				  var td = $(subTr).find("td:first");
				  if(event.data.options.displayField) {
					  var hiddenInput = td.find("input");
					  td.html(index + 1);
					  hiddenInput.val(index + 1);
					  hiddenInput.appendTo(td);
				  } else {
					  td.html(index + 1);
				  }
			  }
		  });
		  
		  methods._removeTr.call(event.data.listTable, event.data.subTr);
		  
		  //索引减一
		  event.data.options.index--;
		  
		  if(window.doDeleteAfter) {
			  doDeleteAfter(event.data.subTr);
	    	}
	    }
      return true;
    },
    /**
     * 清除所有列表TR元素，不包括表头行
     * @param listTable
     */
    _clearHandle : function(event) {
    	//索引置0
    	event.data.options.index = 0;
    	event.data.listTable.find("tr").slice(1).each(function(index, value) {
    		$(this).remove();
    	});
    },
    
    /**
     * 删除行
     * @param subTr
     * @returns {Boolean}
     */
  _removeTr : function(subTr) {
    $(subTr).remove();
    return false;
  },
  /**
   * 编辑行数据
   * 将数据复制到编辑区
   * @param subTr
   * @returns {Boolean}
   */
  _reEdit : function(subTr) {
    $(this).find("input[type='text'],input[type='hidden'],select,textarea")
    .each(function(index,value) {
      var hiddenValue = $(subTr).find("input[name$='."+$(value).attr("name")+"']").val();
      $(value).val(hiddenValue);
    });
    return false;
  },
  /**
   * 判断是否是空对象
   * @param target
   */
  _isEmpty : function(target) {
  	if(target == null || target == undefined) {
  		return true;
  	}
  	if(typeof target == "string" && target == "") {
  		return true;
  	} else if(typeof target == "number" || typeof target == "function") {
  		return false;
  	} else if(typeof target == "object") {
  		if($.isEmptyObject(target)) {
  			return $.isPlainObject(target);
  		}
  		return false;
  	}
  	return false;
  	
  },
  /**
   * 空值替换
   * @param target
   * @param replace
   * @returns
   */
  _emptyReplace : function(target, replace) {
  	if(!replace) {
  		replace = "";
  	}
  	if(methods._isEmpty(target)) {
  		return replace;
  	}
  	return target;
  }

};
$.fn.subListTable = function() {
  var method = arguments[0],
  methodParam = arguments[1] || {},
  options = arguments[2] || {};
 
  if(typeof method == 'object') {
	  return methods.init.call(this, method);
  } else if(typeof(method) == 'string' && method.charAt(0) != '_' && methods[method]) {
	//保存参数,初始化
	    if(!$(this).data("options") && options.needInit) {
	    	methods.init.call(this, options);
	    }
	  return methods[method].call(this, methodParam);
  } else {
	  $.error('Method ' + method + ' does not exist in this toolkit');
  }
};
//添加默认参数
$.subListTable = {
	//行记录索引，从0开始
	index : 0,
    listTableClass : "listTable",//列表table的class默认值
    editTableClass : "editTable",//编辑table的class默认值
    editTrClass : "editTr",//列表行最后的编辑按钮class值
    deleteTrClass : "deleteTr",//列表行最后的删除按钮class值
    cancelTrClass : "cancelTr",//编辑table后的取消按钮class值
    countTrClass : "countTr",//需要计数的class值
    addTrClass : "addTr",//编辑table后的添加按钮class值
    addDeleteButton: true,//添加删除按钮
    addEditButton:true,//添加编辑按钮
    trClass : "",//
    tdClass : "",//
    displayIndex : false,//
    displayField : undefined//
};
})(jQuery);