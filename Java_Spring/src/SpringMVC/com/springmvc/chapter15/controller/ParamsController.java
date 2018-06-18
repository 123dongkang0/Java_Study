package com.springmvc.chapter15.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.spingmvc.chapter15.service.RoleService;
import com.springmvc.chapter15.pojo.Role;
import com.springmvc.chapter15.pojo.RoleParams;


@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@RequestMapping("/commonParams")
	public ModelAndView commonParams(String roleName, String note) {
	    System.out.println("roleName =>" + roleName);
	    System.out.println("note =>" + note);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	
	@RequestMapping("/commonParamPojo")
	public ModelAndView commonParamPojo(RoleParams roleParams) {
	    System.out.println("roleName =>" + roleParams.getRoleName());
	    System.out.println("note =>" + roleParams.getNote());
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	
	@RequestMapping("/requestParam")
	//ʹ��@RequestParam("role_name")ָ��ӳ��HTTP��������
	public ModelAndView requestParam(@RequestParam("role_name") String roleName, String note) {
		System.out.println("roleName =>" + roleName);
	    System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("index");
	    return mv;
	}
	
	
	//ע���ɫ�������
	@Autowired
	RoleService roleService;

	//{id}�������һ������
	@RequestMapping("/getRole/{id}")
	//ע��@PathVariable��ʾ��URL�������ַ�л�ȡ����
	public ModelAndView pathVariable(@PathVariable("id") Long id)  {
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		//������ģ��
		mv.addObject(role);
		//����ΪJSON��ͼ
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/findRoles")
	public ModelAndView findRoles(@RequestBody RoleParams roleParams) {
		List<Role> roleList = roleService.findRoles(roleParams);
		ModelAndView mv = new ModelAndView();
		//��ģ��
		mv.addObject(roleList);
		//����ΪJSON��ͼ
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/deleteRoles")
	public ModelAndView deleteRoles(@RequestBody List<Long> idList) {
		ModelAndView mv = new ModelAndView();
		//ɾ����ɫ
		int total = roleService.deleteRoles(idList);
		//����ͼ
		mv.addObject("total", total);
		//JSON��ͼ
	    mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/addRoles")
	public ModelAndView addRoles(@RequestBody List<Role> roleList) {
		ModelAndView mv = new ModelAndView();
		//ɾ����ɫ
		int total = roleService.insertRoles(roleList);
		//����ͼ
		mv.addObject("total", total);
		//JSON��ͼ
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/commonParamPojo2")
	public ModelAndView commonParamPojo2(String roleName, String note) {
		System.out.println("roleName =>" + roleName);
		System.out.println("note =>" + note);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
}
