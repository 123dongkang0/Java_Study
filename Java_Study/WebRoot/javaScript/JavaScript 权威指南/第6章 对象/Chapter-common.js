

var book = {
		"main title" : "JavaScript",
		"sub-titile" : "The Definitive Guide",
		"for " : "all audiences",
		 author : {
			 firstname: "David",
			 surname: "Flanagan"
		 }
    };

function inherit(p){
	if(p == null) throw TypeError();
	if(Object.create)
		return Object.create(p);
	
	var t = typeof p;
	if(t !== "object" && t !== "function") throw TypeError();
	function f() {};
	f.prototype = p;
	return new f();
	
}

