package com.dongk.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

/**
* <b>Description: �����JavaScript ztree ����Ĺ�����</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.dongk.util
* <br><b>ClassName:</b> ZtreeUtil
* <br><b>Date:</b> 2018��4��5�� ����1:24:41
*/
public class ZtreeUtil {
	
	/**
	* <b>Description:����ZtreeBean</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��4��5�� ����1:44:02
	* <br><b>Version:</b> 1.0
	* <br><b>param:datas ��Ҫת��������</b>
	* <br><b>param:checked  ѡ�е����Լ���</b>
	* <br><b>return:</b>
	*/
	public static List<ZtreeBean> generatorZtreeBean(List<Map<String, Object>> datas, List<Map<String, Object>> checked)  throws Exception{
		
		if(datas==null) 
			return Collections.EMPTY_LIST;
		
		List<ZtreeBean> beans = new ArrayList<ZtreeBean>();
		for(Map<String, Object> data : datas) {
			ZtreeBean bean = otherToZtreeBean(data,otherToString(checked));
			beans.add(bean);
		}
		return parentCheck(beans);
		
	}
	
	public static List<ZtreeBean> parentCheck(List<ZtreeBean> beans) {
		if(beans==null) 
			return Collections.EMPTY_LIST;
		
		for(ZtreeBean beanOut : beans) {
			for(ZtreeBean beanIn : beans) {
			    if(beanOut.getId().equals(beanIn.getpId()) && beanIn.isChecked()) {
			    	beanOut.setChecked(true);
			    	continue;
			    }	   
			}   
		}
		
		return beans;
	}
	
	
	private static  List<String> otherToString( List<Map<String, Object>> checked) throws Exception{
		if(checked==null) 
			return Collections.EMPTY_LIST;
		
		List<String> strs = new ArrayList<String>();
		for(Map<String, Object> e : checked) {
			strs.add(StringUtils.dataToString(e.get("id")));
		}
		return strs;
	}
	
	/**
	* <b>Description:����������ת����ZtreeBean</b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��4��5�� ����1:49:45
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	private  static ZtreeBean otherToZtreeBean(Map<String, Object> t, List<String> checked) throws Exception{
		ZtreeBean bean = new ZtreeBean();
		bean.setId(StringUtils.dataToString(t.get("id")));
		bean.setpId(StringUtils.dataToString(t.get("pId")));
		bean.setName(StringUtils.dataToString(t.get("name")));
		bean.setValue(StringUtils.dataToString(t.get("value")));
		bean.setOpen(true);
		if(checked.contains(bean.getId()))
			bean.setChecked(true);
		else
			bean.setChecked(false);
		return bean;
	}
	
	
}
