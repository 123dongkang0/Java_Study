package com.springmvc.chapter15.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.springmvc.chapter15.view.ExcelExportService;
import com.springmvc.chapter15.view.ExcelView;
import com.spingmvc.chapter15.service.RoleService;
import com.springmvc.chapter15.pojo.PageParams;
import com.springmvc.chapter15.pojo.Role;
import com.springmvc.chapter15.pojo.RoleParams;


@Controller
@RequestMapping("/role")
public class RoleController {
	
	
	@Autowired
	private RoleService roleService = null; 
	
	@RequestMapping("/showRoleJsonInfo")
	public ModelAndView showRoleJsonInfo(Long id, String roleName, String note) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("id", id);
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		return mv;
	}
	
	@RequestMapping("/addRole")
	//ModelΪ�ض�������ģ�ͣ�Spring MVC���Զ���ʼ����
	public String addRole(Model model, String roleName, String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		//�����ɫ�󣬻�����ɫ���
		roleService.insertRole(role);
		//���ض�������ģ��
		model.addAttribute("roleName", roleName);
		model.addAttribute("note", note);
		model.addAttribute("id", role.getId());
		return "redirect:./showRoleJsonInfo.do";
	}
	
	@RequestMapping("/addRole2")
	//ModelAndView����Spring MVC���Զ���ʼ����
	public ModelAndView addRole2(ModelAndView mv, String roleName, String note) {
		Role role = new Role();
		role.setRoleName(roleName);
		role.setNote(note);
		//�����ɫ�󣬻�����ɫ���
		roleService.insertRole(role);
		//���ض�������ģ��
		mv.addObject("roleName", roleName);
		mv.addObject("note", note);
		mv.addObject("id", role.getId());
		mv.setViewName("redirect:./showRoleJsonInfo.do");
		return mv;
	}
	
	
	@RequestMapping("/showRoleJsonInfo2")
	public ModelAndView showRoleJsonInfo(Role role) {
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
	
	@RequestMapping("/addRole3")
	//RedirectAttribute����Spring MVC���Զ���ʼ����
	public String addRole3(RedirectAttributes ra, Role role) {
		//�����ɫ�󣬻�����ɫ���
		roleService.insertRole(role);
		//���ض�������ģ��
		ra.addFlashAttribute("role", role);
		return "redirect:./showRoleJsonInfo2.do";
	}
	
	
	@RequestMapping("/getRole")
	public ModelAndView getRole(Long id) {
		Role role = roleService.getRole(id);
		ModelAndView mv = new ModelAndView();
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
	
	
	@RequestMapping(value = "/getRoleByModelMap", method = RequestMethod.GET)
	public ModelAndView getRoleByModelMap(@RequestParam("id") Long id, ModelMap modelMap) {
	    Role role = roleService.getRole(id);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("roleDetails");
	    modelMap.addAttribute("role", role);
	    return mv;
	}

	@RequestMapping(value = "/getRoleByModel", method = RequestMethod.GET)
	public ModelAndView getRoleByModel(@RequestParam("id") Long id, Model model) {
	    Role role = roleService.getRole(id);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("roleDetails");
	    model.addAttribute("role", role);
	    return mv;
	}

	@RequestMapping(value = "/getRoleByMv", method = RequestMethod.GET)
	public ModelAndView getRoleByMv(@RequestParam("id") Long id, ModelAndView mv) {
	    Role role = roleService.getRole(id);
	    mv.setViewName("roleDetails");
	    mv.addObject("role", role);
	    return mv;
	}
	
	
	@RequestMapping(value = "/getRoleForJson", method = RequestMethod.GET)
	public ModelAndView getRoleForJson(@RequestParam("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Role role = roleService.getRole(id);
		mv.setView(new MappingJackson2JsonView());
		mv.addObject("role", role);
		return mv;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(@RequestParam("id") Long id, ModelMap model) {
	    Role role = roleService.getRole(id);
	    model.addAttribute("role", role);
	    return "roleDetails";
	}
	
	@RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView export() {
		//ģ�ͺ���ͼ
		ModelAndView mv = new ModelAndView();
		//Excel��ͼ���������Զ��嵼���ӿ�
		ExcelView ev = new ExcelView(exportService());	
		//�ļ���
		ev.setFileName("���н�ɫ.xlsx");
		//����SQL��̨����
		RoleParams roleParams = new RoleParams();
		//����1����
		PageParams page = new PageParams();
		page.setStart(0);
		page.setLimit(10000);
		roleParams.setPageParams(page);
		//��ѯ
		List<Role> roleList = roleService.findRoles(roleParams); 
		//��������ģ��
		mv.addObject("roleList", roleList);
		mv.setView(ev);
		return mv;
	}

	@SuppressWarnings({ "unchecked"})
	private ExcelExportService exportService() {
		//ʹ��Lambda���ʽ�Զ��嵼��excel����
		return (Map<String, Object> model, Workbook workbook) -> {
			//��ȡ�û��б�
			List<Role> roleList = (List<Role>) model.get("roleList");
			//����Sheet
			Sheet sheet= workbook.createSheet("���н�ɫ");
			//���ر���
			Row title = sheet.createRow(0);
			title.createCell(0).setCellValue("���");
			title.createCell(1).setCellValue("����");
			title.createCell(2).setCellValue("��ע");
			//������ɫ�б�����һ���е�����
			for (int i=0; i<roleList.size(); i++) {
				Role role = roleList.get(i);
				int rowIdx = i + 1;
				Row row = sheet.createRow(rowIdx);
				row.createCell(0).setCellValue(role.getId());
				row.createCell(1).setCellValue(role.getRoleName());
				row.createCell(2).setCellValue(role.getNote());
			}
	    };
	}
}
