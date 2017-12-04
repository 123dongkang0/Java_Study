[TOC]

###Arguments 对象
arguments 是一个对应于传递给函数的参数的类数组对象。

**1）、语法**

```
arguments
```

**2）、描述**

arguments对象是所有（非箭头）函数中都可用的局部变量。你可以使用arguments对象在函数中引用函数的参数。此对象包含传递给函数的每个参数的条目，第一个条目的索引从0开始。例如，如果一个函数传递了三个参数，你可以以如下方式引用他们：

```
arguments[0]
arguments[1]
arguments[2]
```
**3）、示例**
  ```
function argumentsTest(){
    for(var i=0; i<arguments.length; i++){
        console.log(arguments[i]);
    }
}

argumentsTest("HelloJavaScript", "2017-12-01");
```



###Array.prototype.splice()
splice() 方法通过删除现有元素和/或添加新元素来更改一个数组的内容。

** 1）、语法 **
```
array.splice(start)
array.splice(start, deleteCount) 
array.splice(start, deleteCount, item1, item2, ...)

```
** 2）、参数 **

**`start`**
指定修改的开始位置（从0计数）。如果超出了数组的长度，则从数组末尾开始添加内容；如果是负值，则表示从数组末位开始的第几位（从1计数）；若只使用start参数而不使用deleteCount、item，如：array.splice(start) ，表示删除[start，end]的元素。

**`deleteCount 可选`**
整数，表示要移除的数组元素的个数。如果 deleteCount 是 0，则不移除元素。这种情况下，至少应添加一个新元素。如果 deleteCount 大于start 之后的元素的总数，则从 start 后面的元素都将被删除（含第 start 位）。如果deleteCount被省略，则其相当于(arr.length - start)。

**`item1, item2, ... 可选`**
要添加进数组的元素,从start 位置开始。如果不指定，则 splice() 将只删除数组元素。

** 3）、返回值 **
由被删除的元素组成的一个数组。如果只删除了一个元素，则返回只包含一个元素的数组。如果没有删除元素，则返回空数组。


** 4）、示例 **
```
var myFish = ["angel","clown","mandarin","surgeon"];

/**
 * 从第2位开始删除0个元素，插入 "drum"
 * 返回值："[]" - 表示没有被删除的元素
 */
var removed = myFish.splice(2, 0, "drum");
//["angel", "clown", "drum", "mandarin", "surgeon"]
console.log(myFish);  


/**
 * 从第3位开始删除1个元素
 * 返回值："[mandarin]" - 表示被删除的元素
 */
removed = myFish.splice(3, 1);
//["angel", "clown", "drum", "surgeon"]
console.log(myFish);  

/**
 * 从第 2 位开始删除 1 个元素，然后插入 "trumpet"
 * 返回值："[drum]" - 表示被删除的元素
 */
removed = myFish.splice(2, 1,"trumpet");
//["angel", "clown", "trumpet", "surgeon"]
console.log(myFish); 

/**
 * 从第1位开始删除其后所有即[1，end]的元素
 * 返回值："["clown", "trumpet", "surgeon"]" - 表示被删除的元素
 */
removed = myFish.splice(1);
//["angel"]
console.log(myFish); 
```



###Function.prototype.call()


call() 方法调用一个函数, 其具有一个指定的this值和分别地提供的参数(参数的列表)。

<font color="red">注意：该方法的作用和 apply() 方法类似，只有一个区别，就是call()方法接受的是若干个参数的列表，而apply()方法接受的是一个包含多个参数的数组。</font>

**1）、语法**
```
fun.call(thisArg, arg1, arg2, ...)
```

**2）、参数**

**`thisArg`**

在fun函数运行时指定的this值。需要注意的是，指定的this值并不一定是该函数执行时真正的this值，如果这个函数处于非严格模式下，则指定为null和undefined的this值会自动指向全局对象(浏览器中就是window对象)，同时值为原始值(数字，字符串，布尔值)的this会指向该原始值的自动包装对象。

**`arg1, arg2, ...`**

指定的参数列表。

**3）、返回值**

返回值是你调用的方法的返回值，若该方法没有返回值，则返回undefined。

**4）、示例**

**4.1 使用call方法调用父构造函数**

 在一个子构造函数中，你可以通过调用父构造函数的 call 方法来实现继承，类似于Java中的写法。下例中，使用 Food 和 Toy 构造函数创建的对象实例都会拥有在 Product 构造函数中添加的 name 属性和 price 属性,但 category 属性是在各自的构造函数中定义的。
```

function Product(name,price){
	this.name = name;
	this.price = price;
	
	if(price < 0){
		throw RangeError("Cannot create product " + 
				         this.name + " with a negative price.");
	}
}

function Food(name, price){
	Product.call(this,name,price);
	this.category = "food";
}

function Toy(name, price){
	Product.call(this,name,price);
	this.category = 'toy';
}

var fun = new Toy("fun",40);
var cheese = new Food("cheese",-2);
```

**4.2  使用call方法调用匿名函数**

在下例中的for循环体内，我们创建了一个匿名函数，然后通过调用该函数的call方法，将每个数组元素作为指定的this值执行了那个匿名函数。这个匿名函数的主要目的是给每个数组元素对象添加一个print方法，这个print方法可以打印出各元素在数组中的正确索引号。当然，这里不是必须得让数组元素作为this值传入那个匿名函数（普通参数就可以），目的是为了演示call的用法。
```

var animals = [
               {speciel:"Lion",name:"King"},
               {speciel:"Whale",name:"Fail"}
              ];

for(var i=0; i<animals.length; i++){
	(
    function(i){
    	this.print = function(){
    		console.log("#" + i + " " + this.speciel + ": " + this.name);
    	}
    	this.print();
    }
	).call(animals[i], i);
}
```
**4.3  使用call方法调用函数并且指定上下文的'this'**
在下面的例子中，当调用 greet 方法的时候，该方法的 this 值会绑定到 i 对象。
```
function greet() {
  var reply = [this.person, 'Is An Awesome', this.role].join(' ');
  console.log(reply);
}

var i = {
  person: 'Douglas Crockford', role: 'Javascript Developer'
};

greet.call(i); // Douglas Crockford Is An Awesome Javascript Developer
```


###Function.prototype.apply()


apply() 方法调用一个函数, 其具有一个指定的this值，以及作为一个数组（或类似数组的对象）提供的参数。

<font color="red">注意：call()方法的作用和 apply() 方法类似，只有一个区别，就是 call()方法接受的是若干个参数的列表，而apply()方法接受的是一个包含多个参数的数组。</font>

**1）、语法**
```
fun.apply(thisArg, [argsArray])
```

**2）、参数**

**`thisArg`**

在 fun 函数运行时指定的 this 值。需要注意的是，指定的 this 值并不一定是该函数执行时真正的 this 值，如果这个函数处于非严格模式下，则指定为 null 或 undefined 时会自动指向全局对象（浏览器中就是window对象），同时值为原始值（数字，字符串，布尔值）的 this 会指向该原始值的自动包装对象。

**`argsArray`**

一个数组或者类数组对象，其中的数组元素将作为单独的参数传给 fun 函数。如果该参数的值为null 或 undefined，则表示不需要传入任何参数。


**3）、示例**
```
//定义一个人类
function Person(name,age){
    this.name = name;
    this.age = age;
}

//定义一个学生类
function Student(name,age,grade){
    Person.apply(this,arguments);
    this.grade = grade;
}

var stu = new Student("张三",22,"一年级")
console.log("name: " + stu.name + ",age: " + stu.age + ",grade: " + stu.grade);
```

###Object.prototype.hasOwnProperty()
hasOwnProperty() 方法会返回一个布尔值，指示对象自身属性中是否具有指定的属性

**1）、语法**
```
obj.hasOwnProperty(prop)
```
**2）、参数**

**`prop`**
要检测的属性  字符串 名称或者 Symbol。

**3）、返回值**

用来判断某个对象是否含有指定的属性的 Boolean 。

**4）、描述**

所有继承了 Object 的对象都会继承到 hasOwnProperty 方法。这个方法可以用来检测一个对象是否含有特定的自身属性；和 in 运算符不同，该方法会忽略掉那些从原型链上继承到的属性。

**5）、示例**
  <font color="red">hasOwnProperty 方法判断属性是否存在</font>
 ```
var o = new Object();
o.prop = "exists";

function change(){
	o.newProp = o.prop;
	delete o.prop;
}

console.log(o.hasOwnProperty("prop"));        //返回true
change();
console.log(o.hasOwnProperty("prop"));       //返回false
console.log(o.hasOwnProperty("newProp"));    //返回true
```

<font color="red">自身属性与继承属性</font>
```
o = new Object();
o.prop = 'exists';
console.log(o.hasOwnProperty('prop'));             // 返回 true
console.log(o.hasOwnProperty('toString'));         // 返回 false
console.log(o.hasOwnProperty('hasOwnProperty'));   // 返回 false
```
