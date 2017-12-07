/**
 * 7.10 正则表达式
     》使用一下字符表示正则表达式
       .元字符：用于指定搜索算法；
       .文本：用于指定要搜索的字符;
 */
 
 /**
 * 7.10.1 正则表达式函数
     1.REGEXP_LIKE(expression,pattern)
 */
 /* 用于检索以 S 开始的所有雇员名及其工资*/
 SELECT ENAME,SAL FROM EMP WHERE REGEXP_LIKE(ENAME,'^S');
 
 /* 2. REGEXP_INSTR(
                    source_string
                    ,pattern
                    [,position
                    [,occurrence
                    [,return_option
                    [,match_parameter]
                    ]
                    ]
                    ]
                    )
  *    
  *    用于返回子串在字符串中的起始位置。
  *    source_string ：指定源字符串。
  *    pattern : 用于指定源字符串。
  *    position(可选) : 用于指定开始位置,则默认为1，这是字符串中的第一个位置。。
  *    occurrence(可选) : 用于指定第n次出现的子串,如果省略，默认为1。
  *    return_option(可选) : 指定Oracle返回的位置：
  *       如果指定0 ，那么Oracle将返回出现的第一个字符的位置。这是默认的。
  *       如果指定1 ，则Oracle返回字符之后发生的位置。
  *    match_parameter(可选)：用于指定样式匹配修饰符。
  */
 /* 包含字符 E 的雇员名，以及E的位置 */
 SELECT ENAME,REGEXP_INSTR(ENAME,'E') position   FROM EMP
 WHERE REGEXP_LIKE(ENAME,'E');
 
 /*
  * 下面这个例子给出一个字符串， 
  *       “1”为开始位置 
  *       “2”是搜索第二个匹配的，
  *       ”0”是return_option 返回出现的第一个字符位置
  *       “c”是区分大小写 ，
  *   所以将返回13
  */
 SELECT REGEXP_INSTR ('my is itMyhome', 'm', 1, 2, 0, 'c') position FROM dual; 
 
 /* 3. REGEXP_REPLACE(
                    source_string
                    ,pattern
                    [,replace_string
                    [,position
                    [,occurrence
                    [,match_parameter]
                    ]
                    ]
                    ]
                    )
  *    
  *    用于返回子串在字符串中的起始位置。
  *    source_string ：指定源字符串。
  *    pattern : 用于指定源字符串。
  *    replace_string(可选) : 用于指定替换串
  *    position(可选) : 用于指定开始位置,则默认为1，这是字符串中的第一个位置。。
  *    occurrence(可选) : 用于指定第n次出现的子串,如果省略，默认为1。
  *    match_parameter(可选)：用于指定样式匹配修饰符。
  */
  /* 下面显示包含S的雇员名，以及替换后的雇员名(首字母大写，其它字符小写) */
 SELECT ENAME,REGEXP_REPLACE(ENAME,'[[:upper:]]+',INITCAP(ENAME)) replace
 FROM EMP WHERE REGEXP_LIKE(ENAME,'S');
 
 
