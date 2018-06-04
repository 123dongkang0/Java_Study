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
}
