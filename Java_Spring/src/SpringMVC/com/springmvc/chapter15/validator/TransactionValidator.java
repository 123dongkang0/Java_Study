package com.springmvc.chapter15.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springmvc.chapter15.pojo.Transaction;


public class TransactionValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		//�ж���֤�Ƿ�ΪTransaction�������������ж�[�޸�Ϊ����֤]
		return Transaction.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Transaction trans = (Transaction) target;
		//���׽��ͼ۸�������Ĳ��
		double dis = trans.getAmount() - (trans.getPrice() * trans.getQuantity());
		//���������0.01������Ϊҵ�����
		if (Math.abs(dis) > 0.01) {
			//���������Ϣ
			errors.rejectValue("amount", null, "���׽��͹���������۸�ƥ��");
		}
	}
}
