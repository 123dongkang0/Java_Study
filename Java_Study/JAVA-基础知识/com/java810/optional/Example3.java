package com.java810.optional;

import java.util.Optional;

import org.junit.Test;

import com.java8.model.Car;
import com.java8.model.Insurance;
import com.java8.model.Person;

public class Example3 {
	 /**
	 *  10.3.1 ����Optional����
	 *  
	 *  1.����һ���յ�Optional
	 */
	Optional<Car>  optCar = Optional.empty(); 
	
	Car car = new Car();
	/**
	 *  2.����һ���ǿ�ֵ����Optional
	 */
	Optional<Car> optCar1 = Optional.of(car);
	
	/**
	 *  2.�ɽ���null��Optional
	 */
	Optional<Car> optCar2 = Optional.ofNullable(car);
	
	
	/**
	* <b>Description:
	*      10.3.2 ʹ��map��optional��������ȡ��ת��ֵ
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��4�� ����11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Insurance insurance = new Insurance();
		insurance.setName("̫ƽ���գ���");
		//Insurance insurance = null;
		
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> name = optInsurance.map(Insurance :: getName);
		System.out.println(name.get());
		
	}
	
	/**
	* <b>Description:
	*      10.3.3 ʹ��flatMap����Option����
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��4�� ����11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		Insurance insurance = new Insurance();
		insurance.setName("̫ƽ���գ���");
		
		Car car = new Car();
		car.setInsurance(Optional.ofNullable(insurance));
		
		Person person = new Person();
		person.setCar(Optional.ofNullable(car));
		
		Optional<Person> opt = Optional.ofNullable(person);
		String name = opt.flatMap(Person :: getCar)
				                    .flatMap(Car :: getInsurance)
				                    .map(Insurance :: getName).orElse("Unknown");
		System.out.println(name);
		
	}
	
	/**
	* <b>Description:
	*    10.3.5 ����Optional ��������
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��5�� ����9:31:31
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	
	/**
	 * �ṩһ��null ��ȫ�İ汾 ��
	 */
	public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		//���ַ����ͷǿ��ж�û��ʲô���𣬲�������
//		if(person.isPresent() && car.isPresent()) {
//			return Optional.of(findCheapestInsurance(person.get(),car.get()));
//		}else {
//			return Optional.empty();
//		}
		return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
	}
	
	/**
	 * �ҳ���������ֵ person car������˵ı��չ�˾
	 */
	public Insurance findCheapestInsurance(Person person, Car car) {
		//��ͬ�ı��չ�˾�ṩ�Ĳ�ѯ����
		//�Ա����е�����
		Insurance cheapestInsurance = new Insurance();
		cheapestInsurance.setName("�й�����");
		return cheapestInsurance;
	}
	
	/**
	* <b>Description:
	*    10.3.6 ʹ��filter�޳��ض���ֵ
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018��6��5�� ����9:31:31
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
    public void test04() {
    	Insurance insurance = new Insurance();
    	insurance.setName("Cambridge-Insurance");
    	//java8 ֮ǰ
    	if(insurance != null && "Cambridge-Insurance".equals(insurance.getName()))
    		System.out.println("ok");
    	
    	//java8
    	Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
    	optInsurance.filter(insur -> "Cambridge-Insurance".equals(insur.getName()))
    	        .ifPresent(x -> System.out.println("ok"));
    }
}
