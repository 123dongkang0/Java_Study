package com.design.pattern.celue;

public class CeLueMain {
    
	//���������㹫����������ָ��·�̺�����Ҫ��Ʊ�ۣ�
	public static void main(String args[]) {
		 TranficCalculator calculator = new TranficCalculator();
          //���ü������
          calculator.setCalculateStrategy(new BusStrategy());
          //����۸�
           System.out.println("��������12����ļ۸�" + calculator.calculatePrice(12));
	}
}
