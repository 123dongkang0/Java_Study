package com.struts2.validate;

import com.opensymphony.xwork2.ActionSupport;

public class ValidateBasicAction extends ActionSupport {
	private static final long serialVersionUID = -7505437345373234225L;

	String name;
	int age;
	String answer;
    
	/**
	 *  http://localhost:8080/Java_Study/validate/basicAction_inputBasicValidatePage.action
	 */
	/**
	 * 验证不通过，自动返回 "input" 
	 */
	public String inputBasicValidatePage(){
		System.out.println("name : " + name);
	   return "success";	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
