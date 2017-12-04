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
	return this.rank.toString() + this.suit.toString();
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
		    temp = deck[i],
		    deck[i] = deck[r],
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