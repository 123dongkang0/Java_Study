
/**
 *  7.10.2 正则表达式字符样式。
 */
 CREATE TABLE POSIX_EXAMPLE(string VARCHAR2(20));
 INSERT INTO POSIX_EXAMPLE VALUES('abb');
 INSERT INTO POSIX_EXAMPLE VALUES('acb');
 INSERT INTO POSIX_EXAMPLE VALUES('adb');
 
 SELECT * FROM POSIX_EXAMPLE;
 
 /* 1. "." 
  *   可以匹配任何单个字符。
  */
 SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a.b');
 
 /*
  * 2. "+"
  *    出现1次或者多次。
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'b+');
  
  /*
  * 3. "?"
  *    出现0次或者1次。
  *    如：abc ac 与样式 ab?c 匹配
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'ab?c');
  
  /*
  * 4. "*"
  *    出现0次或者多次。
  *    如：ac abc abbc 与样式 ab*c 匹配
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'ab*c');
  
  /*
  * 5. "{m,}"
  *    至少出现 m 次。
  *    如：aa aaa 与样式 a{2,} 匹配
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a{2,}');
  
  /*
  * 6. "{m,n}"
  *    至少出现 m 次,但是不超过n次。
  *    如：aaa 与样式 a{3,4}匹配，但是字符串a、aa与该样式不匹配
  */
  SELECT * FROM POSIX_EXAMPLE where regexp_like(string,'a{3,4}');
