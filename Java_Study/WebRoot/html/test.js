o = new Object();
o.prop = 'exists';
console.log(o.hasOwnProperty('prop'));             // ���� true
console.log(o.hasOwnProperty('toString'));         // ���� false
console.log(o.hasOwnProperty('hasOwnProperty'));   // ���� false
