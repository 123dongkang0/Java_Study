package com.springmvc.chapter15.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.chapter15.validator.TransactionValidator;
import com.springmvc.chapter15.pojo.Transaction;

@Controller
@RequestMapping("/validate")
public class ValidateController {

	@RequestMapping("/annotation")
	public ModelAndView annotationValidate(@Valid Transaction trans, Errors errors) {
		// �Ƿ���ڴ���
		if (errors.hasErrors()) {
			// ��ȡ������Ϣ
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError error : errorList) {
				// ��ӡ�ֶδ�����Ϣ
				System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	@InitBinder
	public void initBinder(DataBinder binder) {
		// ���ݰ���������֤��
		binder.setValidator(new TransactionValidator());
	}

	@RequestMapping("/validator")
	public ModelAndView validator(@Valid Transaction trans, Errors errors) {
		// �Ƿ���ڴ���
		if (errors.hasErrors()) {
			// ��ȡ������Ϣ
			List<FieldError> errorList = errors.getFieldErrors();
			for (FieldError error : errorList) {
				// ��ӡ�ֶδ�����Ϣ
				System.err.println("fied :" + error.getField() + "\t" + "msg:" + error.getDefaultMessage());
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
