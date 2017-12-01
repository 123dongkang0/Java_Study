o = new Object();
o.prop = 'exists';
console.log(o.hasOwnProperty('prop'));             // ·µ»Ø true
console.log(o.hasOwnProperty('toString'));         // ·µ»Ø false
console.log(o.hasOwnProperty('hasOwnProperty'));   // ·µ»Ø false
