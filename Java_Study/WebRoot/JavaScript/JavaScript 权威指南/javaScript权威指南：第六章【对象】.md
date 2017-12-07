#第六章 对象
除了字符串、数字、true、false、null和undefined之外，JavaScript中的值都是对象；尽管字符串、数字和布尔值不是对象，但它们的行为和不可变的对象非常相似。

1）、JavaScript对象划分；

**1. 内置对象：如数组、函数、日期和正则表达式都属于内置对象；**
**2. 宿主对象：由JavaScript解释器所嵌入的宿主环境(如Web浏览器)定义的。如HTMLElement对象等；**
**3. 自定义对象：由运行中的JavaScript代码创建的对象；**

2）、JavaScript属性的划分；

**1. 自有属性：直接在对象中定义的属性；**
**2. 继承属性：是在对象的原型中定义的属性；**

##6.1 创建对象
可以通过对象直接量、关键字new、Object.create()函数来创建JavaScript对象。

###6.1.1 对象直接量
```
var empty = {};                           //没有任何属性的对象
var point = {x:0, y:0};                   //两个属性
var point2 = {x:point.x, y:point.y+1};    //更加复杂的值

var book = {
	"mainTitle" : "JavaScript",
	"subTitle" : "The Definitive Guide",
	"for" : "all audiences",
	author:{
		filename:"David",
		surname:"Flanagan"
	}
};
```

###6.1.2 通过new创建对象
new运算符创建并初始化一个新对象，关键字new后跟一个函数调用。这里的函数被称作构造函数，构造函数用以初始化一个新创建的对象。JavaScript语言核心中的原始类型都包含内置构造函数。例如：
```
var o = new Object();                      //创建一个空对象，和{}一样
var a = new Array();                       //创建一个空数组，和[]一样
var d = new Date();                        //创建一个表示当前时间的Date对象
```
###6.1.3 原型
每一个Javacript对象(null除外)都和另一个对象相关联。”另一个“对象就是我们熟知的原型，每一个对象都从原型继承属性。

通过对象直接量创建的对象都具有同一个原型对象—Object.prototype; 通过new Array()创建的对象的原型就是Array.prototype.

###6.1.4 Object.create()
