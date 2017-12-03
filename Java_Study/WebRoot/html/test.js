/**
 * 
 * @Description:����һ�����ࣨö���ࣩ
 * @Param:
 * @Result:����һ�����캯��������ʶ�������
 */
function enumeration(namesToValues){
	
	//�������Ĺ��캯�����Ƿ���ֵ
	var enumeration = function(){
		throw "Can't Instantiate Enumerations";
	}
	
	//ö��ֵ�̳����������
	var proto = enumeration.prototype = {
			constructor: enumeration,
			toString : function(){return this.name;},   //��������
			valueOf: function(){return this.value;},    //����ֵ
			toJson: function(){return this.name;}       //ת��ΪJson
	};
	
	enumeration.values = [];   //���Դ��ö�ٶ��������
	
	//���������͵�ʵ��
	for(name in namesToValues){
		var e = inherit(proto);         //����һ���������Ķ���
		e.name = name;
		e.value = namesToValues[name];
		enumeration[name] = e;          //��������Ϊ���캯��������
		enumeration.values.push(e);     //�����洢��������
	}
	
	enumeration.foreach = function(f,c){
		for(var i=0; i<this.values.length; i++){
			f.call(c,this.values[i]);
		}
	}
	return enumeration;
}

/**
 * ͨ��ԭ�ͼ̳д���һ���¶���
 */
function inherit(p){
	if(p == null) throw TypeError();
	if(Object.create)
		return Object.create(p);
	var t = typeof p;
	if(t !== "object" && t !== "function") throw TypeError();
	function f(){};        //����һ���չ��캯��
	f.prototype = p;       //����ԭ����������Ϊp
	return new f();        //ʹ��f()����p�ļ̳ж���
}

/**
 * 
 * ʹ��ö�����ͱ�ʾһ���˿���
 */
function Card(suit, rank){
	this.suit = suit;       //��ɫ
	this.rank = rank;       //����
}

Card.Suit = enumeration({Clubs: 1, Diamonds: 2, Hearts: 3, Spades: 4 });
Card.Rank = enumeration({
		                 Two: 2, Three: 3, Four: 4, Five: 5, Six: 6,
		                 Seven: 7, Eight: 8, Nine: 9, Ten:10,
		                 Jack: 11, Queen: 12, King: 13, Ace: 14
                       });

//������������������ı�
Card.prototype.toString = function(){
	return this.rank.toString() + this.suit.toString();
}

//�Ƚ��˿����������ƵĴ�С
Card.prototype.compareTo = function(that){
	if(this.rank < that.rank) return -1;
	if(this.rank > that.rank) return 1;
	return 0;
}

//���˿��Ƶ��淨������ƽ�������
Card.orderByRank = function(a,b){return a.compareTo(b);};

//�����Ƶ��淨������˿��ƽ�������
Card.orderBySuit = function(a,b){
	if(a.suit < b.suit) return -1;
	if(a.suit > b.suit) return 1;
	if(a.rank < b.rank) return -1;
	if(a.rank > b.rank) return 1;
	return 0;
};

//�������Ա�ʾһ����׼�˿��Ƶ���
function Deck(){
	var cards = this.cards = [];    //һ���ƾ���������ɵ�����
	Card.Suit.foreach(function(s){
		                  Card.Rank.foreach(function(r){
		                	  cards.push(new Card(s,r));
		                  });
	                  });
};

//ϴ�Ƶķ���������ϴ�Ʋ�����ϴ�õ���
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

//���Ƶķ����������Ƶ�����
Deck.prototype.deal = function(n){
	if(this.cards.length < n) throw "Out of cards";
	return this.cards.splice(this.cards.length - n,n);
}


//����һ���µ��˿��ƣ�ϴ�Ʋ�����
var deck = (new Deck()).shuffle();
var hand = deck.deal(13).sort(Card.orderBySuit);