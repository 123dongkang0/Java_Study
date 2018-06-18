package com.springmvc.chapter15.pojo;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Transaction {
	// ��Ʒ���
	@NotNull // ����Ϊ��
	private Long productId;

	// �û����
	@NotNull // ����Ϊ��
	private Long userId;

	// ��������
	@Future // ֻ���ǽ���������
	@DateTimeFormat(pattern = "yyyy-MM-dd") // ���ڸ�ʽ��ת��
	@NotNull // ����Ϊ��
	private Date date;

	// �۸�
	@NotNull // ����Ϊ��
	@DecimalMin(value = "0.1") // ��Сֵ0.1Ԫ
	private Double price;

	// ����
	@Min(1) // ��СֵΪ1
	@Max(100) // ���ֵ
	@NotNull // ����Ϊ��
	private Integer quantity;

	// ���׽��
	@NotNull // ����Ϊ��
	@DecimalMax("500000.00") // �����Ϊ5��Ԫ
	@DecimalMin("1.00") // ��С���׽��1Ԫ
	private Double amount;

	// �ʼ�
	@Pattern(// ����ʽ
			regexp = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@"
					+ "([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$",
			// �Զ�����Ϣ��ʾ
			message = "�������ʼ���ʽ")
	private String email;

	// ��ע
	@Size(min = 0, max = 256) // 0��255���ַ�
	private String note;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
