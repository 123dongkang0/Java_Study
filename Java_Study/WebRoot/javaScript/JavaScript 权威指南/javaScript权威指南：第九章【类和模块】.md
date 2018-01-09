#第九章 类和模块



JavaScript中也可以定义对象的类，让每个对象都共享某些属性。在JavaScript中，类的实现是基于原型继承机制的，如果两个实例对象都从同一个原型对象上继承了属性，我们说它们是同一个类的实例。



##9.2 类和构造函数

下面创建一个Range范围类

```



/**

 * 这是一个构造函数

 * 构造函数的命名方式一般是用大写字母开头，而普通函数一般使用小写字母开头

 */

function Range(from,to){

	this.from = from;   //表示开始位置

	this.to = to;       //表示结束位置

}



Range.prototype = {

	//吐过X在范围之内，则返回true,否则返回false

	includes: function(x){

	  return this.from <= x && x <= this.to;  	 

	},

	

	//遍历

	foreach: function(f){

		for(var x = Math.ceil(this.from); x <= this.to; x++){

			f(x);

		}

	},

	

	//用字符串打印

	toString: function(){

		return "(" + this.from + "," + this.to +  ")";

	}

}



var r = new Range(1,3);

console.log(r.includes(2));



console.log("=============================");

r.foreach(console.log);



console.log("=============================");

console.log(r.toString());





```



原型对象是类的唯一标识：当且仅当两个对象继承自同一个原型对象时，它们才是属于同一个类的实例。而构造函数不能作为类的标识，两个构造函数prototype属性可能指向同一个原型对象。那么这两个构造函数创建的实例是属于同一个类的。



**r instanceof Range  //如果r继承自Range.prototype， 则返回true**



**1）、constructor属性**

每个JavaScript对象都自动拥有一个prototype属性，这个属性的值是一个对象，这个对象包含唯一一个不可枚举的属性constructor。constructor属性的值是一个函数对象。

```

var F = function(){}

var p = F.prototype;

var c = p.constructor;

c === F;        //true：对于任意函数F.prototype.constructor==F

```

上面定义的类Range使用它自身重新定义的Range.prototype对象，因此不包含有constructor属性，我们可以通过下面的方式来修正这个问题：

```

Range.prototype.includes = function(x){

	    return this.from <= x && x <= this.to;  	 

       };

       

Range.prototype.foreach = function(f){

		for(var x = Math.ceil(this.from); x <= this.to; x++){

			f(x);

		}  	 

       }; 

       

Range.prototype.toString = function(){

	    return "(" + this.from + "," + this.to +  ")";

      };    

```





##9.3 JavaScript类的扩充

JavaScript对象从其原型继承属性，如果创建对象之后原型的属性发生变化，也会影响到继承这个原型的所有的实例对象。这意味着我们可以通过原型对象来进行扩展。

```

//如果ES5的String.trim()方法不存在的话，就定义它

String.prototype.trim = String.prototype.trim || function(){

	                        if(!this) return this;        //空字符串不做任何处理

	                        return this.replace(/(^\s*)|(\s*$)/g,"");   //使用正则表达式进行空格替换

                         }

```



##9.4 类和类型

本节介绍3中检测任意对象的类的技术：instanceof运算符、constructor属性和typeof。



###9.4.1 instanceof运算符

```



function Person(){}



var p = new Person();

console.log(p instanceof Person);   //true

```



###9.4.2 constructor属性

```



function typeAndValue(x){

	if(x == null) return "";

	switch(x.constructor){

	  case Number : return "Number:" + x;

	  case String : return "String:" + x;

	  case Date: return "Date:" + x;

	}

		

}



var number = 120;

var str = "Hello JavaScript;";

console.log(typeAndValue(number));   //Number:120

console.log(typeAndValue(str));      //String:Hello JavaScript;



```

在JavaScript中并非所有的对象都包含constructor属性。



###9.4.3 typeof

js中的typeof用来检查一个变量的数据类型，它返回的是一个字符串。不同类型变量经typeof运算符后返回的值如下：

|        类型          |          结果           |
|-----------------|-------------------|
|   Undefined     |    "undefined"    |
|   Null               |     "object "         |
|   Boolean         |    "boolean"        |
|   Number        |     "number"        |
|   String            |     "string"           |
|   函数对象        |      "function"      |
|   任何其他对象  |     "object"          |

下面再来说一说null和undefined的区别：



1. Null ：表示一个尚不存在的对象，表示一个对象的占位符，意思是这里将来会是一个对象，而现在该对象还没有创建。

2. Undefined：表示一个还未定义（声明）或者定义了还没有初始化的变量（对象）。



这里要注意，如果一个变量尚未声明，使用if语句检测该变量会报错，而使用typeof将会返回undefined。undefined和null的布尔值都是false。因此，未声明的变量应该用typeof来检测，而不是直接使用if语句。 

```



// All constructor functions while instantiated with 'new' keyword will always be typeof 'object'

var str = new String('String');

var num = new Number(100);



typeof str; // It will return 'object'

typeof num; // It will return 'object'



// But there is a exception in case of Function constructor of Javascript



var func = new Function();



typeof func; // It will return 'function'

```



typeof还有一个常见的用法就是检查某个变量是否存在，例如浏览器支不支持某个对象。举个例子，在《JavaScript高级程序设计》中有一段跨浏览器生成XMLHttpRequest对象的代码。

```



function createXHR(){

    if(typeof XMLHttpRequest !="undefined"){ 

        return new XMLHttpRequest();

    }else if(typeof ActiveXObject !="undefined"){ //for IE5,6

        return new ActiveXObject("Microsoft.XMLHTTP");

    }

}

```



这里的XMLHttpRequest和ActiveXObject都是window下的全局变量，是一个构造函数（typeof检测返回function），如果浏览器支持的话，即该变量存在，直接使用if(window.XMLHttpRequest)可返回true，但是如果浏览器不支持，直接使用if检测一个未定义的变量就会抛出 ReferenceError，而使用typeof则会返回undefined，不会报错。



##9.5 JavaScript中的面向对象技术

到目前为止，我们讨论了JavaScript中类的基础常识：原型对象、构造函数、instanceof运算符等等。本节将目光转向一些实际的例子（尽管这些不是基础知识），包括如何利用JavaScript中的类进行编程。



###9.5.1 一个例子：集合类

集合（set)是一种数据结构，用以表示非重复值得无需集合。集合的基础方法包括添加值、检测值是否在集合中。
```

/**
 * Set.js 值得任意集合
 * 
 */
function Set(){              //构造函数
	this.values = {};        //保存集合数据
	this.n = 0;              //集合中值得个数
	this.add.apply(this,arguments);
};

Set.prototype.add = function(){
	for(var i=0; i<arguments.length; i++){
		var val = arguments[i];
		var str = Set._v2s(val);    //转换成字符串
		if(!this.values.hasOwnProperty(str)){  //如果不在集合中
			this.values[str] = val;
			this.n++;
		}
	}
	return this;       //支持链式调用
};

Set.prototype.remove = function(){
	for(var i=0; i<arguments.length; i++){
		var str = Set._v2s(arguments[i]);
		if(this.values.hasOwnProperty(str)){   //如果在集合中存在
			delete this.vaules[str];           //删除它
			this.n--;
		}
	}
	return this;      //支持链式调用
};

//如果集合包含这个值，则返回true;否则,返回false
Set.prototype.contains = function(val){
	return this.values.hasOwnProperty(Set._v2s(val));
};

//返回集合的大小
Set.prototype.size = function(){
	return this.n;
};

//遍历集合中的元素
Set.prototype.foreach = function(){
	for(var s in this.values){
		if(this.values.hasOwnProperty(s)){
			console.log(this.values[s]);    //打印到控制台
		}
	}
};

//这是一个内部函数，用以将任意JavaScript值和唯一的字符串对应起来
Set._v2s = function(val){
	switch(val){
	    case undefined : return 'u';
	    case null:       return 'n';
	    case true:       return 't';
	    case false:      return 'f';
	    default: switch(typeof val){
	         case   'number' : return '#' + val;
	         case   "string" : return '"' + val;
	         default: return '@' + objectId(val);
	    }
	}
	
	function objectId(o){
		var prop = "|**objectId**";    //私有属性，用以存放id
		if(!o.hasOwnProperty(prop))    //如果对象没有id
			o[prop] = Set._v2s.next++; //将下一个值赋值给它
		return o[prop];
	}
};

Set._v2s.next = 100;

var str = "JavaScript Hello World!!",
    num = 13,
    dateNow = new Date(),
    set = new Set(str,num,dateNow);

set.foreach();
console.log(set);




```


###9.5.2 一个例子：枚举类型
下面的例子包含一个单独函数enumeration()。但它不是一个构造函数，并没有定义一个叫做“enumeration”的类。相反，它是一个工厂方法，每次调用它都会创建并返回一个新的类，比如：
```

/**
 * 
 * @Description:创建一个新类（枚举类）
 * @Param:
 * @Result:返回一个构造函数，它标识这个新类
 */
function enumeration(namesToValues){
	
	//这个虚拟的构造函数就是返回值
	var enumeration = function(){
		throw "Can't Instantiate Enumerations";
	}
	
	//枚举值继承自这个对象
	var proto = enumeration.prototype = {
			constructor: enumeration,
			toString : function(){return this.name;},   //返回名字
			valueOf: function(){return this.value;},    //返回值
			toJson: function(){return this.name;}       //转换为Json
	};
	
	enumeration.values = [];   //用以存放枚举对象的数组
	
	//创建新类型的实例
	for(name in namesToValues){
		var e = inherit(proto);         //创建一个代表它的对象
		e.name = name;
		e.value = namesToValues[name];
		enumeration[name] = e;          //将它设置为构造函数的属性
		enumeration.values.push(e);     //将它存储到数组中
	}
	
	enumeration.foreach = function(f,c){
		for(var i=0; i<this.values.length; i++){
			f.call(c,this.values[i]);
		}
	}
	return enumeration;
}

/**
 * 通过原型继承创建一个新对象
 */
function inherit(p){
	if(p == null) throw TypeError();
	if(Object.create)
		return Object.create(p);
	var t = typeof p;
	if(t !== "object" && t !== "function") throw TypeError();
	function f(){};        //定义一个空构造函数
	f.prototype = p;       //将其原型属性设置为p
	return new f();        //使用f()创建p的继承对象
}

/**
 * 
 * 使用枚举类型表示一副扑克牌
 */
function Card(suit, rank){
	this.suit = suit;       //花色
	this.rank = rank;       //点数
}

Card.Suit = enumeration({Clubs: 1, Diamonds: 2, Hearts: 3, Spades: 4 });
Card.Rank = enumeration({
		                 Two: 2, Three: 3, Four: 4, Five: 5, Six: 6,
		                 Seven: 7, Eight: 8, Nine: 9, Ten:10,
		                 Jack: 11, Queen: 12, King: 13, Ace: 14
                       });

//定义用来描述牌面的文本
Card.prototype.toString = function(){
	return "[" + this.rank.toString() +"-" +  this.suit.toString() + "]";
}

//比较扑克牌中两张牌的大小
Card.prototype.compareTo = function(that){
	if(this.rank < that.rank) return -1;
	if(this.rank > that.rank) return 1;
	return 0;
}

//以扑克牌的玩法规则对牌进行排序
Card.orderByRank = function(a,b){return a.compareTo(b);};

//以桥牌的玩法规则对扑克牌进行排序
Card.orderBySuit = function(a,b){
	if(a.suit < b.suit) return -1;
	if(a.suit > b.suit) return 1;
	if(a.rank < b.rank) return -1;
	if(a.rank > b.rank) return 1;
	return 0;
};

//定义用以表示一副标准扑克牌的类
function Deck(){
	var cards = this.cards = [];    //一副牌就是由牌组成的数组
	Card.Suit.foreach(function(s){
		                  Card.Rank.foreach(function(r){
		                	  cards.push(new Card(s,r));
		                  });
	                  });
};

//洗牌的方法：重新洗牌并返回洗好的牌
Deck.prototype.shuffle = function(){
	var deck = this.cards,
	    len = deck.length;
	for(var i = len - 1; i > 0; i--){
		var r = Math.floor(Math.random() * (i + 1)),
		    temp = deck[i];
	    deck[i] = deck[r];
		deck[r] = temp;
	}
	return this;
};

//发牌的方法：返回牌的数组
Deck.prototype.deal = function(n){
	if(this.cards.length < n) throw "Out of cards";
	return this.cards.splice(this.cards.length - n,n);
}


//创建一副新的扑克牌，洗牌并发牌
var deck = (new Deck()).shuffle();
var hand = deck.deal(13).sort(Card.orderBySuit);
for(var card in hand){
	console.log(hand[card].toString());
}

```



