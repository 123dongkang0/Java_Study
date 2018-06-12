package com.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//ע��@Controller��ʾ����һ��������
@Controller("myController")
@RequestMapping("/myController")
public class MyController {
     
	 @RequestMapping("/index")
	 public ModelAndView index() {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("index");
		 return mv;
	 }
}
