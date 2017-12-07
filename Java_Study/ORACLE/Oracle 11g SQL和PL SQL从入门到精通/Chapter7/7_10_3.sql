/**
 * 7.10.3 正则表达式样式修饰符
 */
 
 /* 3. n 用 "." 匹配任意值
  *  ORACLE 中 CHR(10) 表示换行
  */
 select 
   'a' || CHR(10) || 'd',
   REGEXP_SUBSTR('a' || CHR(10) || 'd', 'a.d',1,1,'n'),
   REGEXP_SUBSTR('a' || CHR(10) || 'd', 'a.d',1,1)
 from dual
 
 /* 4. m 多行搜索
  *  ORACLE 中 CHR(10) 表示换行
  */
 select 
   'ab' || CHR(10) || 'ac',
   REGEXP_SUBSTR('ab' || CHR(10) || 'ac', '^a.',1,2,'m'),
   REGEXP_SUBSTR('ab' || CHR(10) || 'ac', '^a',1,2)
 from dual
 
  /* 5. x 忽略空格符
  *  
  */
 select 
   REGEXP_SUBSTR('abcd', '^a b c d',1,1,'x'),
   REGEXP_SUBSTR('abcd', '^a b c d',1,1)
 from dual
