package com.dongk.util;

/**
* <b>Description:相对于JavaScript ztree 插件的Bean</b><br> 
* @author:dongk
* @version 1.0
* @Note
* <b>ProjectName:</b> Java_Study
* <br><b>PackageName:</b> com.dongk.util
* <br><b>ClassName:</b> ZtreeBean
* <br><b>Date:</b> 2018年4月5日 下午1:21:20
*/
public class ZtreeBean {
	
	private String id;
	private String pId;
	private boolean open;
	private String icon;
	private String name;
	private String value;
	private boolean checked;
	
	public ZtreeBean() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
}
