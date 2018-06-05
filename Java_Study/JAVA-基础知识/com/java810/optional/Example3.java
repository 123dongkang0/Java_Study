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
	
	/**
	* <b>Description:
	*    10.3.5 两个Optional 对象的组合
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月5日 上午9:31:31
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	
	/**
	 * 提供一个null 安全的版本 ，
	 */
	public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
		//这种方法和非空判断没有什么区别，不够优雅
//		if(person.isPresent() && car.isPresent()) {
//			return Optional.of(findCheapestInsurance(person.get(),car.get()));
//		}else {
//			return Optional.empty();
//		}
		return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
	}
	
	/**
	 * 找出满足输入值 person car的最便宜的保险公司
	 */
	public Insurance findCheapestInsurance(Person person, Car car) {
		//不同的保险公司提供的查询服务
		//对比所有的数据
		Insurance cheapestInsurance = new Insurance();
		cheapestInsurance.setName("中国人寿");
		return cheapestInsurance;
	}
	
	/**
	* <b>Description:
	*    10.3.6 使用filter剔除特定的值
	* </b><br> 
	* @Note
	* <b>Author:dongk</b>
	* <br><b>Date:</b> 2018年6月5日 上午9:31:31
	* <br><b>Version:</b> 1.0
	* <br><b>param:</b>
	* <br><b>return:</b>
	*/
	@Test
    public void test04() {
    	Insurance insurance = new Insurance();
    	insurance.setName("Cambridge-Insurance");
    	//java8 之前
    	if(insurance != null && "Cambridge-Insurance".equals(insurance.getName()))
    		System.out.println("ok");
    	
    	//java8
    	Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
    	optInsurance.filter(insur -> "Cambridge-Insurance".equals(insur.getName()))
    	        .ifPresent(x -> System.out.println("ok"));
    }
}
