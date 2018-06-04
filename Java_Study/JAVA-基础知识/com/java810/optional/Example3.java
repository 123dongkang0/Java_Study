package com.java810.optional;

import java.util.Optional;

import org.junit.Test;

import com.java8.model.Car;
import com.java8.model.Insurance;
import com.java8.model.Person;

public class Example3 {
	 /**
	 *  10.3.1 创建Optional对象
	 *  
	 *  1.声明一个空的Optional
	 */
	Optional<Car>  optCar = Optional.empty(); 
	
	Car car = new Car();
	/**
	 *  2.根据一个非空值创建Optional
	 */
	Optional<Car> optCar1 = Optional.of(car);
	
	/**
	 *  2.可接受null的Optional
	 */
	Optional<Car> optCar2 = Optional.ofNullable(car);
	
	
	/**
	* <b>Description:
	*      10.3.2 使用map从optional对象中提取和转换值
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月4日 上午11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test01() {
		Insurance insurance = new Insurance();
		insurance.setName("太平洋保险！！");
		//Insurance insurance = null;
		
		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
		Optional<String> name = optInsurance.map(Insurance :: getName);
		System.out.println(name.get());
		
	}
	
	/**
	* <b>Description:
	*      10.3.3 使用flatMap连接Option对象
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月4日 上午11:17:54
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
	public void test02() {
		Insurance insurance = new Insurance();
		insurance.setName("太平洋保险！！");
		
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
