/*
 * ҳ���б����, jQuery plugin
 * ʹ�÷���
 * $("#listPage").subListTable({
		"prefix" : "billLists",ָ���ύ�����б���
		"displayIndex" : true,�Ƿ���ʾ��� Ĭ��false
		"displayField" : "GNo",��ʾ������ƣ�ָ�����ƣ����ڵ�һ�����input hiddenԪ��
		"trClass" : "trListContent"
	});
	Ĭ�ϲ������������
 */
(function($) {
"use strict";

var methods = {
		/**
		 * ��ʼ��
		 * @returns {Boolean}
		 */
  init : function() {
    var $thisDiv = $(this),
    options = $.extend({}, $.subListTable, arguments[0]),
  //ֻȡ��һ��classΪoptions.listTable�Ķ���
    listTable = $(this).find("."+options.listTableClass).first(),
  //ֻȡ��һ��classΪoptions.editTable�Ķ���
    editTable = $(this).find("."+options.editTableClass).first()
    ;

    //listTable�µ���Ҫ�༭�ύ����ѡ�������б༭��ɾ����ť���У�������Ҫ�������У�ѡ��
    options.trSelector = "tr:has(."+options.editTrClass+", ."+options.deleteTrClass+"), tr."+options.countTrClass;
    options.listTable = listTable;
    options.editTable = editTable;

  //����������б�����ֱ�ӷ���
    if($(listTable).length <= 0) return false;

    if(!options.prefix) {
    	alert("��ָ���б�ǰ׺�����ύ������[prefix]��");
    	return false;
    }
    //��ʼ���б�����ť
    listTable.find(options.trSelector)
    .each( function (i, subTr) {//��ʼ��ÿ����¼��Ӧ��ť�¼�
      var $this = $(subTr);
      var index = options.index++;
      $this.attr("index",index);//���index����
      //���������������ǰ׺�����û��ǰ׺�Ļ�
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
    
  //��������ڱ༭¼������ֱ�ӷ���
    if($(editTable).length > 0) {
    	//��ʼ���༭����ť
    	editTable.find("input."+options.addTrClass).click(function() {//�����Ӱ�ť������м�¼
    		var validateOptions = $.extend(true,{},$thisDiv.data('jqv'),{"eventTrigger.event": "click","eventTrigger.element":$(this)})
    		if($thisDiv.validationEngine && 
    				!$thisDiv.validationEngine("validate", validateOptions)) {
    			return false; //����б���֤������֤ʧ�ܣ�ֱ�ӷ���false
    		}
    		//�������ǰִ����Ϸ���������trueͨ��
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
    			//�޸��м�¼����
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
    			.prop("disabled", false);//�޸������ݺ����б༭��ɾ����ť������
    			
    			thisButton.removeAttr("index");
    		} else {
    			subTr = methods._addOneTr.call($thisDiv);//����м�¼
    		}
    		//�������ִ�з���
    		if(window.doAddAfter) {
    			doAddAfter(subTr);
    		}
    	});
    	
    	editTable.find("input."+options.cancelTrClass).click(function() {//���ȡ����ť��ȡ���޸�
    		//ȡ������ǰִ����Ϸ���������trueͨ��
    		if(window.doCancelBefore) {
    			var before = doCancelBefore(editTable);
    			if(before != undefined && !before) {
    				return false;
    			}
    		}
    		//ȡ���޸ĺ����б༭��ɾ����ť������
    		listTable.find("input."+options.editTrClass+",input."+options.deleteTrClass)
    		.prop("disabled", false);
    		//�Ƴ���Ӱ�ť�ϵ�index����
    		editTable.find("input."+options.addTrClass).removeAttr("index");
    		//����Ԫ�ض����
    		editTable.find("input[type=\"hidden\"],input[type=\"text\"],select,textarea")
    		.each(function(i, ele) {
    			$(ele).val("");
    		});
    		//ȡ����ִ�з���
    		if(window.doCancelAfter) {
    			doCancelAfter(editTable);
    		}
    	});
    	$thisDiv.bind("clearTr", {"options": options, "listTable": listTable, "editTable": editTable}, methods._clearHandle);
    }
    //�������
    if(!$thisDiv.data("options")) {
    	$thisDiv.data("options", options);
    }
  },
  /**
   * ����¼�¼��
   * @param datas
   * @returns
   */
  addOneTr : function(datas) {
    return methods._addOneTr.call(this, datas);
  },
  /**
   * ����м�¼�����༭��������������б���
   * @param datas
   * @returns
   */
  _addOneTr : function(dataObj) {
	  var datas = dataObj || {},
	  options = $(this).data("options"),
	  listTable = options.listTable,
	  editTable = options.editTable,
	  //��¼����
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
   
    if(options.displayIndex) {//�Ƿ���Ҫ��¼���
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
   
      delete datas[keyname];//ȥ���Ѿ���ӵ�����
    });
    trStr += "<td align=\"center\">";
   if(options.addEditButton) {
	   trStr += "<input type=\"button\" class=\"short_button "+options.editTrClass+"\" value=\"�༭\" />";
   }
   if(options.addDeleteButton) {
	   trStr += "<input type=\"button\" class=\"short_button "+options.deleteTrClass+"\" value=\"ɾ��\" />";
   }
    //�����������ֶη������TD
    for(var key in datas) {
      trStr += "<input type='hidden' name='"+options.prefix+"["+index+"]."+key+"' value='"
        +methods._emptyReplace(datas[key])+"' />";
        delete datas[key];//ȥ���Ѿ���ӵ�����
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
   * ����༭��ť���޸��м�¼
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
	  .prop("disabled", true);//�޸ĵ�ǰ����ʱ�����б༭��ɾ����ť������
	  event.data.editTable.find("input."+event.data.options.addTrClass)
	  .attr("index", event.data.subTr.attr("index"));//�������
    methods._reEdit.call(event.data.editTable, event.data.subTr);
    if(window.doEditAfter) {
    	doEditAfter(event.data.subTr);
    }
    return;
  },
  /**
   * ���ɾ����ť��ɾ����ǰ��¼
   * @param event
   * @returns {Boolean}
   */
  _deleteHandle : function(event) {
	  if(confirm("��ȷ��Ҫɾ��������¼��"))
	    {
		    if(window.doDeleteBefore) {
		    	var before = doDeleteBefore(event.data.subTr);
		    	if(before != undefined && !before) {
		    		return false;
		    	}
		    }
		  event.data.subTr.nextAll("tr").each(function(i, subTr) {//���е�ǰTr���Tr����������
			  var index = $(subTr).attr("index") - 1;
			  $(subTr).attr("index",index).find("input[type=\"hidden\"]").each(function() {
				  var $this = $(this);
				  var name = $this.attr("name");
				  name = name.replace(/\[\d+\]/g,"["+index+"]");
				  $this.attr("name",name);
			  });
			  if(event.data.options.displayIndex) {//�Ƿ���Ҫ��¼���
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
		  
		  //������һ
		  event.data.options.index--;
		  
		  if(window.doDeleteAfter) {
			  doDeleteAfter(event.data.subTr);
	    	}
	    }
      return true;
    },
    /**
     * ��������б�TRԪ�أ���������ͷ��
     * @param listTable
     */
    _clearHandle : function(event) {
    	//������0
    	event.data.options.index = 0;
    	event.data.listTable.find("tr").slice(1).each(function(index, value) {
    		$(this).remove();
    	});
    },
    
    /**
     * ɾ����
     * @param subTr
     * @returns {Boolean}
     */
  _removeTr : function(subTr) {
    $(subTr).remove();
    return false;
  },
  /**
   * �༭������
   * �����ݸ��Ƶ��༭��
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
   * �ж��Ƿ��ǿն���
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
   * ��ֵ�滻
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
	//�������,��ʼ��
	    if(!$(this).data("options") && options.needInit) {
	    	methods.init.call(this, options);
	    }
	  return methods[method].call(this, methodParam);
  } else {
	  $.error('Method ' + method + ' does not exist in this toolkit');
  }
};
//���Ĭ�ϲ���
$.subListTable = {
	//�м�¼��������0��ʼ
	index : 0,
    listTableClass : "listTable",//�б�table��classĬ��ֵ
    editTableClass : "editTable",//�༭table��classĬ��ֵ
    editTrClass : "editTr",//�б������ı༭��ťclassֵ
    deleteTrClass : "deleteTr",//�б�������ɾ����ťclassֵ
    cancelTrClass : "cancelTr",//�༭table���ȡ����ťclassֵ
    countTrClass : "countTr",//��Ҫ������classֵ
    addTrClass : "addTr",//�༭table�����Ӱ�ťclassֵ
    addDeleteButton: true,//���ɾ����ť
    addEditButton:true,//��ӱ༭��ť
    trClass : "",//
    tdClass : "",//
    displayIndex : false,//
    displayField : undefined//
};
})(jQuery);