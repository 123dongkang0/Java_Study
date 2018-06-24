#一、什么是策略模式
策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。策略模式使得算法可以在不影响到客户端的情况下发生变化。

#二、策略模式的结构
策略模式是对算法的包装，是把使用算法的责任和算法本身分割开来，委派给不同的对象管理。策略模式通常把一个系列的算法包装到一系列的策略类里面，作为一个抽象策略类的子类。用一句话来说，就是：“准备一组算法，并将每一个算法封装起来，使得它们可以互换”。下面就以一个示意性的实现讲解策略模式实例的结构。

这个模式涉及到三个角色：

**1. 环境(Context)角色：持有一个Strategy的引用。**
**2. 抽象策略(Strategy)角色：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。**
**3. 具体策略(ConcreteStrategy)角色：包装了相关的算法或行为。**

#三、策略模式的使用场景
**1.针对同一种问题有多种处理方式、仅仅是具体行为有差别。**
**2. 需要安全的封装多种同一类型的操作时。**
**3. 出现同一抽象类有多个子类，而又需要使用if-else或者switch-case来选择具体子类时**

场景：计算公交车、地铁指定路程后所需要的票价；
下面的例子使用了策略模式、非策略模式这两种不同的实现方式；

##3.1 使用非策略模式
```
/**
 * 第21条：使用函数对象表示策略
 *   函数对象主要的作用就是实现策略模式
 */
public class Example0021 {
   public static void main(String args[]){
	   System.out.println(new PriceCalculator().calculator(12, 1));
   }
}


class PriceCalculator{
	
	private static final int BUS = 1;          //公交车类型  
	private static final int SUBWAY = 2;       //地铁类型
	
	/**
	 * 起步价10元；
	 * 超过10公里后，按照每公里2元计算
	 */
	private int busPrice(int distance){
		int extraDistance = distance - 10,
		    price = extraDistance<=0?10:(10 + extraDistance *2);
		return price;
		
	}
	
	private int subwayPrice(int distance){
		if(distance <= 6){
			return 3;
		}else if(distance > 6 && distance <= 12){
			return 4;
		}else if(distance > 12 && distance <= 22){
			return 5;
		}else{
			return 6;
		}
	}
	
	/**
	 * 根据类型来计算相应的价格 
	 */
	public int calculator(int distance, int type){
		if(type == BUS){
			return busPrice(distance);
		}else{
			return subwayPrice(distance);
		}
	}
	
}
```

如果新添加一种出租车的计算价格，需要添加相应的代码。可见上面的代码耦合性较高，每当增加新的交通工具类型的时候，需要不断的修改大量的代码，下面使用策略模式重构。

##3.2 使用策略模式
```
public class Example0021 {
   public static void main(String args[]){
	   TranficCalculator calculator = new TranficCalculator();
       //设置计算策略
       calculator.setCalculateStrategy(new BusStrategy());
       //计算价格
       System.out.println("公交车乘12公里的价格：" + calculator.calculatePrice(12));
   }
}

/**
 *抽象价格计算接口 
 */
interface CalculateStrategy{
	int calculatePrice(int distance);
}

/**
 *公交车计算策略 
 */
class BusStrategy implements CalculateStrategy{

	public int calculatePrice(int distance) {
		int extraDistance = distance - 10,
		    price = extraDistance<=0?10:(10 + extraDistance *2);
		return price;
	}
	
}

/**
 *地铁计算策略 
 */
class SubwayStrategy implements CalculateStrategy{

	public int calculatePrice(int distance) {
		if(distance <= 6){
			return 3;
		}else if(distance > 6 && distance <= 12){
			return 4;
		}else if(distance > 12 && distance <= 22){
			return 5;
		}else{
			return 6;
		}
	}
	
}

/**
 *  环境Context角色
 */
class TranficCalculator{
	
	public CalculateStrategy strategy;
	
	public TranficCalculator(){}
	
	public void setCalculateStrategy(CalculateStrategy strategy){
		this.strategy = strategy;
	}
	
	public int calculatePrice(int distance){
		return strategy.calculatePrice(distance);
	}
}
``` 
这样即使需要添加出租车的价格计算，只需要简单的新建一个类，让其继承自CalculateStrategy接口并实现其中的方法即可

优点：

1. 结构清晰明了、使用简单直观;
2. 耦合度相对较低，扩展方便;
3. 操作封装因为更为测地、数据更为安全;

缺点：

1. 子类增多;